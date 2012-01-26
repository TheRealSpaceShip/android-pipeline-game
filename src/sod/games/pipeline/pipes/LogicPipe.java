package sod.games.pipeline.pipes;

public interface LogicPipe {
	public void rotate();
	public void randomRotate();
	public boolean directStream(Stream flow);
	public PipeType getType();
	public Direction getDirection();
}
