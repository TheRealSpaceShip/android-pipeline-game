package sod.games.pipeline.pipes;


public class Stream {
	private Side direction;
	private int[] position;
	
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
	
	public Stream (int[] position_ , Side direction_){
		position = position_;
		direction = direction_;
	}
	
	
	public void movePosition(){
		switch(direction){
		case North:
			position[1]++ ;
		case South:
			position[1]--;
		case West:
			position[0]--;
		case East :
			position[0]++;
		}
	}
	
	public boolean flow (Pipe pipe){
		if (!pipe.directFlow(this))
			movePosition();
		else
			return false;
			
		return true;
	}
	
	public int[] getPosition(){
		return position;
	}
}
