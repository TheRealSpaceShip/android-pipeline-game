package sod.games.pipeline.pipes;

import java.util.Random;

public class PipesFactory {
	private static PipesFactory instance;
	private PipesFactory() {}
	
	
	static public PipesFactory getInstance(){
		if(instance == null){
			instance = new PipesFactory();
		}
		return instance;
	}
	

	public Pipe createPipe(PipeType type, int[] position_){
		switch(type){
		case Corner:
			return new CornerPipe( position_);
		case Line:
			return new LinePipe(position_);
		case Cross:
			return new CrossPipe( position_);
		case DoubleCorner:
			return new DoubleCornerPipe(position_);
		
		default:
				return null;
		}
	}
	
	public Pipe createRandomPipe(int[] position_){
		Random rand = new Random();
		int rInt = rand.nextInt() % 4;
		
		switch(rInt){
		case 0:
			return new CornerPipe(position_);
		case 1:
			return new LinePipe(position_);
		case 2:
			return new CrossPipe(position_);
		case 3:
			return new DoubleCornerPipe(position_);
		}
		
		return null;
	}

}
