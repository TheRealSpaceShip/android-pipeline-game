package sod.games.pipeline;

public enum Direction {
	North, East, South, West;

	public static Direction cwRotate(Direction side) {
		switch (side) {
		case North:
			return Direction.East;
		case East:
			return Direction.South;
		case South:
			return Direction.West;
		case West:
			return Direction.North;
		}
		return null;
	}

	public static Direction ccwRotate(Direction side) {
		switch (side) {
		case North:
			return Direction.West;
		case East:
			return Direction.North;
		case South:
			return Direction.East;
		case West:
			return Direction.South;
		}
		return null;
	}

	public static float getAngle(Direction direction) {
		switch (direction) {
		case North:
			return 0;
		case East:
			return 90;
		case South:
			return 180;
		case West:
			return 270;
		}
		return 0;
	}

	@Override
	public String toString() {
		return super.toString().substring(0, 1);
	}

}
