package sod.games.pipeline.pipes;

import sod.games.pipeline.Direction;
import sod.games.pipeline.sewerage.Stream;

public interface LogicPipe {
	public void rotate();
	public void randomRotate();
	public boolean directStream(Stream flow);
	public PipeType getType();
	public Direction getDirection();
}
