package sod.games.pipeline.pipes;

public class CrossPipe extends BasePipe {
	static private boolean D = true;
	static private String TAG = "CornerPipe";
	private Pipe topPipe;
	private Pipe bottomPipe;
	public CrossPipe(){
		topPipe = new LinePipe();
		bottomPipe = new LinePipe();
		bottomPipe.rotate();
	}
	
	@Override
	public PipeType getType() {
		return PipeType.Cross;
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
	
	
}
