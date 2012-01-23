package sod.games.pipeline.pipes;

import java.util.ArrayList;

public interface Pipe {
	public ArrayList<Pair<Side, Side>> getConnectors();
	public void rotate();
	public void randomRotate();
	public boolean directFlow(Stream flow);
	public PipeType getType();
}
