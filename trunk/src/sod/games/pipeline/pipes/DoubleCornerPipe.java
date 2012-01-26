package sod.games.pipeline.pipes;

public class DoubleCornerPipe extends BasePipe {
	static private boolean D = true;
	static private String TAG = "DoubleCornerPipe";
	
	private LogicPipe topPipe;
	private LogicPipe bottomPipe;
	
	public DoubleCornerPipe(){
		topPipe = new CornerPipe();
		bottomPipe = new CornerPipe();
		bottomPipe.rotate();
		bottomPipe.rotate();
	}
	
	@Override
	public void rotate() {
		topPipe.rotate();
		bottomPipe.rotate();
	}

	@Override
	public boolean directStream(Stream stream) {
		return topPipe.directStream(stream) || bottomPipe.directStream(stream);
	}

	@Override
	public Direction getDirection() {
		return topPipe.getDirection();
	}
	
	
	@Override
	public PipeType getType() {
		return PipeType.DoubleCorner;
	}
}
