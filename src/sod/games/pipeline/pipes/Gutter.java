package sod.games.pipeline.pipes;

public class Gutter extends BasePipe {
	static private boolean D = true;
	static private String TAG = "Gutter";
	@Override
	public boolean directStream(Stream stream) {
		return (stream.comeFrom() == pipeDirection);
	}
	
	@Override
	public PipeType getType() {
		return PipeType.Gutter;
	}
	

}
