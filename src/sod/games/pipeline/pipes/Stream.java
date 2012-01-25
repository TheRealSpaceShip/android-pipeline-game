package sod.games.pipeline.pipes;

import android.util.Log;


public class Stream {
	static private boolean D = true;
	static private String TAG = "Stream";
	
	private Direction direction;
	private int[] position;
	
	public Direction comeFrom(){
		if (D) Log.i(TAG, "comeFrom() is called");
		Direction direction_ = null;
		switch(direction){
		case North:
			direction_ = Direction.South;
			break;
		case South:
			direction_ = Direction.North;
			break;
		case West:
			direction_ = Direction.East;
			break;
		case East :
			direction_ = Direction.West;
			break;
		}
		if (D) Log.i(TAG, "comeFrom() is returning : "+direction_.toString());
		return direction_;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction_){
		if (D) Log.i(TAG, "setDirection() is called with params: direction_ = "+direction_.toString());
		direction = direction_;
	}
	
	public Stream (int[] position_ , Direction direction_){
		position = position_;
		direction = direction_;
		if (D) Log.i(TAG, "Stream() is called with params: position_ : ["+position[0]+"]["+position[1]+"]  direction_ = "+direction_.toString());
	}
	
	
	public void flow(){
		if (D) Log.i(TAG, "flow() is called. Position before: ["+position[0]+"]["+position[1]+"]");
		switch(direction){
		case North:
			position[1] = position[1] - 1 ;
			break;
		case South:
			position[1] = position[1] + 1;
			break;
		case West:
			position[0] = position[0] - 1;
			break;
		case East :
			position[0] = position[0] + 1;
			break;
		}
		if (D) Log.i(TAG, "flow() is called. Position after = ["+position[0]+"]["+position[1]+"]");
	}
	

	public int[] getPosition(){
		return position;
	}
}
