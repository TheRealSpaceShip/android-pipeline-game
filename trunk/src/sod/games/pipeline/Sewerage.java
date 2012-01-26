package sod.games.pipeline;

import java.util.Random;

import sod.games.pipeline.pipes.Gutter;
import sod.games.pipeline.pipes.PipeType;
import sod.games.pipeline.pipes.Stream;
import sod.games.pipeline.pipes.PipesFactory;
import sod.games.pipeline.pipes.Pipe;
import sod.games.pipeline.pipes.Tap;

public class Sewerage {
	static private boolean D = true;
	static private String TAG = "Sewerage";
	
	private Pipe pipes[][];
	private Tap tap;
	private int tapPosition[];
	private Gutter gutter;
	private Stream stream;
	private int wPipes;
	private int hPipes;

	public Sewerage(int wPipes_, int hPipes_) {
		wPipes = wPipes_;
		hPipes = hPipes_;
		pipes = new Pipe[wPipes][hPipes];
	}

	public Pipe[][] getPipes() {
		return pipes;
	}

	public void generateRandomSewerage() {
		stream = null;
		for (int y = 0; y < hPipes; y++)
			for (int x = 0; x < wPipes; x++) {
				pipes[x][y] = PipesFactory.getInstance().createRandomPipe();
				pipes[x][y].randomRotate();
			}

		Random r = new Random();
		int x = r.nextInt(wPipes);
		int y = r.nextInt(hPipes);
		tapPosition = new int[] { x, y };
		tap = new Tap();
		pipes[x][y] = tap;
		tap.randomRotate();

		x = r.nextInt(wPipes);
		y = r.nextInt(hPipes);
		gutter = new Gutter();
		pipes[x][y] = gutter;
		gutter.randomRotate();

	}

	public GameState flowStream() {
		if (stream == null)
			stream = new Stream(tapPosition, tap.getDirection());

		boolean result = getPipe(stream.getPosition()).directStream(stream);

		if (!result)
			return GameState.LOSE;

		stream.flow();

		if (!isStreamInsideScrewerage())
			return GameState.LOSE;

		if (getPipe(stream.getPosition()).getType() == PipeType.Gutter
				&& gutter.directStream(stream))
			return GameState.WIN;

		return GameState.PROCEED;
	}

	private boolean isStreamInsideScrewerage() {
		return (0 <= stream.getPosition()[0]
				&& stream.getPosition()[0] < wPipes
				&& 0 <= stream.getPosition()[1] && stream.getPosition()[1] < hPipes);
	}

	public Pipe getPipe(int[] position_) {
		return pipes[position_[0]][position_[1]];
	}
	
	public Pipe getPipe(int x , int y) {
		return pipes[x][y];
	}

	@Override
	public String toString() {
		String str ="";
		for (int y = 0; y < hPipes; y++){
			for (int x = 0; x < wPipes; x++) {
				str+=(pipes[x][y].getType().toString()+" "+pipes[x][y].getDirection().toString()+" ");
			}
			str+="\n";
		}
		return str;
	}
}
