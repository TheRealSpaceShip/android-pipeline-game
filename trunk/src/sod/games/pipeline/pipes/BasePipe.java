package sod.games.pipeline.pipes;

import java.util.ArrayList;
import java.util.Random;

abstract class BasePipe implements Pipe {
	protected ArrayList<Pair<Side, Side>> connectors;
	protected Side pipeDirection = Side.North;

	protected BasePipe() {
		connectors = new ArrayList<Pair<Side, Side>>();
	}
	
	protected BasePipe(int[] position_) {
		connectors = new ArrayList<Pair<Side, Side>>();
	}

	@Override
	public ArrayList<Pair<Side, Side>> getConnectors() {

		return connectors;
	}

	@Override
	public void rotate() {
		for (Pair<Side, Side> connector : connectors) {
			connector.setFirst(Side.cwRotate(connector.getFirst()));
			connector.setSecond(Side.cwRotate(connector.getSecond()));
		}
		pipeDirection = Side.cwRotate(pipeDirection);
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

	@Override
	public void randomRotate() {
		Random rand = new Random();
		int rRotate = rand.nextInt() % 4;

		for (; rRotate > 0; --rRotate) {
			rotate();
		}
	}
	
	public PipeType getType() {return null;}

	@Override
	public Side getDirection() {
		return pipeDirection;
	};
	
	

}
