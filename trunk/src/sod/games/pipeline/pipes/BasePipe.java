package sod.games.pipeline.pipes;

import java.util.ArrayList;
import java.util.Random;

import android.util.Log;

abstract class BasePipe implements Pipe {

	private static boolean D = true;
	private static String TAG = "BasePipe";

	protected ArrayList<Pair<Side, Side>> connectors;
	protected Side pipeDirection = Side.North;

	protected BasePipe() {
		connectors = new ArrayList<Pair<Side, Side>>();
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
	public boolean directStream(Stream stream) {
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

	abstract public PipeType getType();

	@Override
	public Side getDirection() {
		return pipeDirection;
	};

}
