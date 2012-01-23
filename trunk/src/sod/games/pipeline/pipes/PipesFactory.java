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
	

	public Pipe createPipe(PipeType type){
		switch(type){
		case Corner:
			return new CornerPipe();
		case Line:
			return new LinePipe();
		case Cross:
			return new CrossPipe();
		case DoubleCorner:
			return new DoubleCornerPipe();
		
		default:
				return null;
		}
	}
	
	public Pipe createRandomPipe(){
		Random rand = new Random();
		int rInt = rand.nextInt() % 4;
		
		switch(rInt){
		case 0:
			return new CornerPipe();
		case 1:
			return new LinePipe();
		case 2:
			return new CrossPipe();
		case 3:
			return new DoubleCornerPipe();
		}
		
		return null;
	}

}
