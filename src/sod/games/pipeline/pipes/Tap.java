package sod.games.pipeline.pipes;


public class Tap extends BasePipe {

	@Override
	public boolean directFlow(Stream stream) {
		stream.setDirection(pipeDirection);
		return true;
	}

	@Override
	public PipeType getType() {
		return PipeType.Tap;
	}
}
