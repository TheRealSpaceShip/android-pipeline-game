package sod.games.pipeline.pipes;

import java.util.ArrayList;
import java.util.Random;

abstract class BasePipe implements Pipe {
	protected ArrayList<Pair<Side, Side>> connectors;
	protected Side pipeDirection = Side.North;
	protected int[] position;

	protected BasePipe() {
		connectors = new ArrayList<Pair<Side, Side>>();
		position = new int[]{-1,-1};
	}
	
	protected BasePipe(int[] position_) {
		connectors = new ArrayList<Pair<Side, Side>>();
		position = position_;
	}

	@Override
	public ArrayList<Pair<Side, Side>> getConnectors() {

		return connectors;
	}

	@Override
	public void rotate() {
		for (Pair<Side, Side> connector : connectors) {
			connector.setFirst(cwRotate(connector.getFirst()));
			connector.setSecond(cwRotate(connector.getSecond()));
		}
		pipeDirection = cwRotate(pipeDirection);
	}

	@Override
	public boolean directFlow(Stream stream) {
		Side comeFrom = stream.comeFrom();
		for (Pair<Side, Side> connector : connectors) {
			if (connector.getFirst() == comeFrom) {
				stream.setDirection(connector.getSecond());
				return true;
			} else if (connector.getSecond() == comeFrom) {
				stream.setDirection(connector.getFirst());
				return true;
			}
		}
		return false;
	}

	private Side cwRotate(Side side) {
		switch (side) {
		case North:
			return Side.East;
		case East:
			return Side.South;
		case South:
			return Side.West;
		case West:
			return Side.North;
		}
		return null;
	}

	@Override
	public void randomRotate() {
		Random rand = new Random();
		int rRotate = rand.nextInt() % 4;

		for (; rRotate > 0; --rRotate) {
			rotate();
		}
	}
	
	public int[] getPosition(){
		return position;
	}
	
	public PipeType getType() {return null;};

}
