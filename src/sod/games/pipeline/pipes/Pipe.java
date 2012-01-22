package sod.games.pipeline.pipes;

import java.util.ArrayList;

abstract interface Pipe {
	public ArrayList<Pair<Side, Side>> getConnectors();
	public void rotate();
	
}
