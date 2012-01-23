package sod.games.pipeline.pipes;

import android.util.Log;


public class Stream {
	static private boolean D = true;
	static private String TAG = "Stream";
	
	private Side direction;
	private int[] position;
	
	public Side comeFrom(){
		if (D) Log.i(TAG, "comeFrom() is called");
		Side direction_ = null;
		switch(direction){
		case North:
			direction_ = Side.South;
			break;
		case South:
			direction_ = Side.North;
			break;
		case West:
			direction_ = Side.East;
			break;
		case East :
			direction_ = Side.West;
			break;
		}
		if (D) Log.i(TAG, "comeFrom() is returning : "+direction_.toString());
		return direction_;
	}

	public void setDirection(Side direction_){
		if (D) Log.i(TAG, "setDirection() is called with params: direction_ = "+direction_.toString());
		direction = direction_;
	}
	
	public Stream (int[] position_ , Side direction_){
		if (D) Log.i(TAG, "Stream() is called with params: position_ = "+position_.toString()+"  direction_ = "+direction_.toString());
		position = position_;
		direction = direction_;
	}
	
	
	public void flow(){
		if (D) Log.i(TAG, "flow() is called. Position before = "+position.toString());
		switch(direction){
		case North:
			position[1] = position[1] + 1 ;
			break;
		case South:
			position[1] = position[1] - 1;
			break;
		case West:
			position[0] = position[0] - 1;
			break;
		case East :
			position[0] = position[0] + 1;
			break;
		}
		if (D) Log.i(TAG, "flow() is called. Position after = "+position.toString());
	}
	

	public int[] getPosition(){
		return position;
	}
}
