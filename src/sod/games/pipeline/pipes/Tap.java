package sod.games.pipeline.pipes;

public class Tap extends BasePipe {

	static private boolean D = true;
	static private String TAG = "Tap";
	@Override
	public boolean directStream(Stream stream) {
		stream.setDirection(pipeDirection);
		return true;
	}

	@Override
	public PipeType getType() {
		return PipeType.Tap;
	}
}
