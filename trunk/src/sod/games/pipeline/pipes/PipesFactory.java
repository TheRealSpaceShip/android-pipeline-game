package sod.games.pipeline.pipes;

public class PipesFactory {
	private static PipesFactory instance;
	private PipesFactory() {}
	
	
	public PipesFactory getInstance(){
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

}
