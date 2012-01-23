package sod.games.pipeline.pipes;

public enum Side {
	North,
	East,
	South,
	West;
	
	public static Side cwRotate( Side side){
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
	
	public static Side ccwRotate( Side side){
		switch (side) {
		case North:
			return Side.West;
		case East:
			return Side.North;
		case South:
			return Side.East;
		case West:
			return Side.South;
		}
		return null;
	}
	
}
