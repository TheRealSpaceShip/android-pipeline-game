package sod.games.pipeline.pipes;

public enum Direction {
	North,
	East,
	South,
	West;
	
	public static Direction cwRotate( Direction side){
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
	
	public static Direction ccwRotate( Direction side){
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

	@Override
	public String toString() {
		return super.toString().substring(0,1);
	}
	
}
