package sod.games.pipeline;

import sod.games.pipeline.pipes.Gutter;
import sod.games.pipeline.pipes.PipeType;
import sod.games.pipeline.pipes.Stream;
import sod.games.pipeline.pipes.PipesFactory;
import sod.games.pipeline.pipes.Pipe;
import sod.games.pipeline.pipes.Tap;

public class Sewerage {
	private Pipe pipes[][];
	private Tap tap;
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
			for (int x = 0; y < wPipes; x++ ) {
				pipes[x][y] = PipesFactory.getInstance().createRandomPipe(new int[]{x,y});
				pipes[x][y].randomRotate();
			}
	}
	
	public void flowStream(){
		if (stream == null)
			stream =new Stream(tap);
	
		boolean result = stream.flow(getPipe(stream.getPosition()));
		
		if (!result)
			lose();
		else if (getPipe(stream.getPosition()).getType() == PipeType.Gutter )
			win();
		else
			proceed();
	}
	
	public void win(){}
	public void lose(){}
	public void proceed(){}
	
	public Pipe getPipe(int[] position_){
		return pipes[position_[0]][position_[1]];
	}
}
