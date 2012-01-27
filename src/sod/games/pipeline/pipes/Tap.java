package sod.games.pipeline.pipes;

import sod.games.pipeline.sewerage.Stream;

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
