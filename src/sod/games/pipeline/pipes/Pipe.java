package sod.games.pipeline.pipes;

public interface Pipe {
	public void rotate();
	public void randomRotate();
	public boolean directStream(Stream flow);
	public PipeType getType();
	public Direction getDirection();
}
