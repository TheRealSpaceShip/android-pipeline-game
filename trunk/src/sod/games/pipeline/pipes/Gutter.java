package sod.games.pipeline.pipes;

public class Gutter extends BasePipe {

	@Override
	public boolean directFlow(Stream stream) {
		return (stream.comeFrom() == pipeDirection);
	}
	
	@Override
	public PipeType getType() {
		return PipeType.Gutter;
	}
	

}
