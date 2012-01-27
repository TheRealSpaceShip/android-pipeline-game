package sod.games.pipeline.sewerage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.util.Pair;

import sod.games.pipeline.Direction;
import sod.games.pipeline.GameState;
import sod.games.pipeline.pipes.BasePipe;
import sod.games.pipeline.pipes.Gutter;
import sod.games.pipeline.pipes.PipeType;
import sod.games.pipeline.pipes.PipesFactory;
import sod.games.pipeline.pipes.LogicPipe;
import sod.games.pipeline.pipes.StreamRoadInformation;
import sod.games.pipeline.pipes.Tap;

public class Sewerage {
	static private boolean D = true;
	static private String TAG = "Sewerage";
	
	private BasePipe pipes[][];
	private Tap tap;
	private int tapPosition[];
	private Gutter gutter;
	private int gutterPosition[];
	private Stream stream;
	private int wPipes;
	private int hPipes;
	private List<StreamRoadInformation> streamRoad;
	

	public Sewerage(int wPipes_, int hPipes_) {
		wPipes = wPipes_;
		hPipes = hPipes_;
		pipes = new BasePipe[wPipes][hPipes];
		streamRoad = new ArrayList<StreamRoadInformation>();
	}

	public LogicPipe[][] getPipes() {
		return pipes;
	}

	public void generateRandomSewerage() {
		stream = null;
		streamRoad = new ArrayList<StreamRoadInformation>();
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
		gutterPosition = new int[] { x, y };
		pipes[x][y] = gutter;
		gutter.randomRotate();

	}

	public GameState flowStream() {
		if (stream == null)
			stream = new Stream(tapPosition, tap.getDirection());

	
		boolean result = getPipe(stream.getPosition()).directStream(stream);

		if (!result)
			return GameState.LOSE;
		streamRoad.add(new StreamRoadInformation(getPipe(stream.getPosition()), stream.comeFrom(), stream.getPosition()));
		stream.flow();

		if (!isStreamInsideScrewerage())
			return GameState.LOSE;

		if (getPipe(stream.getPosition()).getType() == PipeType.Gutter
				&& gutter.directStream(stream)){
			streamRoad.add(new StreamRoadInformation(gutter, stream.comeFrom(), gutterPosition));
			return GameState.WIN;
		}
		return GameState.PROCEED;
	}

	private boolean isStreamInsideScrewerage() {
		return (0 <= stream.getPosition()[0]
				&& stream.getPosition()[0] < wPipes
				&& 0 <= stream.getPosition()[1] && stream.getPosition()[1] < hPipes);
	}

	public BasePipe getPipe(int[] position_) {
		return pipes[position_[0]][position_[1]];
	}
	
	public BasePipe getPipe(int x , int y) {
		return pipes[x][y];
	}
	
	public void setPipe(int x , int y, BasePipe pipe) {
		pipes[x][y] = pipe;
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
	
	public List<StreamRoadInformation> getStreamRoad(){
		return streamRoad;
	}
}
