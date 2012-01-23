package sod.games.pipeline;

import java.util.Random;

import sod.games.pipeline.pipes.Gutter;
import sod.games.pipeline.pipes.PipeType;
import sod.games.pipeline.pipes.Stream;
import sod.games.pipeline.pipes.PipesFactory;
import sod.games.pipeline.pipes.Pipe;
import sod.games.pipeline.pipes.Tap;

public class Sewerage {
	private Pipe pipes[][];
	private Tap tap;
	private int tapPosition[];
	private Gutter gutter;
	private Stream stream;
	private int wPipes;
	private int hPipes;

	public Sewerage(int wPipes_, int hPipes_) {
		wPipes = wPipes_;
		hPipes= hPipes_;
		pipes = new Pipe[wPipes][hPipes];
	}

	public void generateRandomSewerage() {
		for (int y = 0; y < hPipes; y++ )
			for (int x = 0; x < wPipes; x++ ) {
				pipes[x][y] = PipesFactory.getInstance().createRandomPipe(new int[]{x,y});
				pipes[x][y].randomRotate();
			}
		
		Random r = new Random();
		int x = r.nextInt(wPipes);
		int y = r.nextInt(hPipes);
		tapPosition = new int[] {x,y};
		tap = new Tap();
		pipes[x][y] = tap;
		tap.randomRotate();
		
		x = r.nextInt(wPipes);
		y = r.nextInt(hPipes);
		gutter = new Gutter();
		pipes[x][y] = gutter;
		gutter.randomRotate();
		
	}
	
	public void flowStream(){
		if (stream == null)
			stream =new Stream(tapPosition, tap.getDirection());
	
		boolean result = stream.flow(getPipe(stream.getPosition()));
		
		if (!result || !isStreamInsideScrewerage())
			lose();
		else if (getPipe(stream.getPosition()).getType() == PipeType.Gutter )
			win();
		else
			proceed();
	}
	
	private boolean isStreamInsideScrewerage(){
		return  (0 <= stream.getPosition()[0] && stream.getPosition()[0]< wPipes && 0 <= stream.getPosition()[1]&& stream.getPosition()[1]< hPipes );
	}
	public void win(){}
	public void lose(){}
	public void proceed(){}
	
	public Pipe getPipe(int[] position_){
		return pipes[position_[0]][position_[1]];
	}
}
