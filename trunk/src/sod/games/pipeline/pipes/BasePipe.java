package sod.games.pipeline.pipes;

import java.util.ArrayList;
import java.util.Random;

import android.util.Log;

abstract class BasePipe implements Pipe {

	private static boolean D = true;
	private static String TAG = "BasePipe";

	protected ArrayList<Pair<Direction, Direction>> connectors;
	protected Direction pipeDirection = Direction.North;

	protected BasePipe() {
		connectors = new ArrayList<Pair<Direction, Direction>>();
	}

	@Override
	public void rotate() {
		for (Pair<Direction, Direction> connector : connectors) {
			connector.setFirst(Direction.cwRotate(connector.getFirst()));
			connector.setSecond(Direction.cwRotate(connector.getSecond()));
		}
		pipeDirection = Direction.cwRotate(pipeDirection);
	}

	@Override
	public boolean directStream(Stream stream) {
		Direction comeFrom = stream.comeFrom();
		for (Pair<Direction, Direction> connector : connectors) {
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


	@Override
	public Direction getDirection() {
		return pipeDirection;
	};

}
