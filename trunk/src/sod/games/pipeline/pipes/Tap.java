package sod.games.pipeline.pipes;


public class Tap extends BasePipe {

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
