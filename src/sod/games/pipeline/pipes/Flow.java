package sod.games.pipeline.pipes;

public class Flow {
	private Side direction;
	
	public Side comeFrom(){
		switch(direction){
		case North:
			return Side.South;
		case South:
			return Side.North;
		case West:
			return Side.East;
		case East :
			return Side.West;
		}
		return null;
	}

	public void setDirection(Side direction_){
		direction = direction_;
	}
	
}
