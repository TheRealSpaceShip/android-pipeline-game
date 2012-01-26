package sod.games.pipeline.pipes;

import java.util.ArrayList;
import java.util.Random;

import sod.games.pipeline.ImageManager;

import android.graphics.Bitmap;
import android.util.Log;

abstract class BasePipe implements LogicPipe, AnimatedPipe {

	private static boolean D = true;
	private static String TAG = "BasePipe";

	protected ArrayList<Direction[]> connectors;
	protected Direction pipeDirection;

	protected int frameCount;
	protected int framesNumber;
	
	protected BasePipe() {
		pipeDirection = Direction.North;
		connectors = new ArrayList<Direction[]>();
		frameCount = 0;
	}

	@Override
	public void rotate() {
		if (D) Log.i(TAG,"rotate is called");
		for (Direction[] connector : connectors) {
			Direction direction = Direction.cwRotate(connector[0]);
			connector[0] = direction;
			direction = Direction.cwRotate(connector[1]);
			connector[1] = direction;
		}
		pipeDirection = Direction.cwRotate(pipeDirection);
		if (D) Log.i(TAG,"new direction : " + pipeDirection.toString());
	}

	@Override
	public boolean directStream(Stream stream) {
		Direction comeFrom = stream.comeFrom();
		if (D) Log.i(TAG,"directStream is called. Stream comed from : "+ comeFrom + " Pipe Type - "+ getType().toString() );
		for (Direction[] connector : connectors) {
			if (connector[0] == comeFrom) {
				stream.setDirection(connector[1]);
				if (D) Log.i(TAG,"directed to "+ stream.getDirection());
				return true;
			} else if (connector[1] == comeFrom) {
				stream.setDirection(connector[0]);
				if (D) Log.i(TAG,"directed to "+ stream.getDirection());
				return true;
			}
		}
		if (D) Log.i(TAG,"No conenctors for stream");
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

	@Override
	public String toString(){
		return "PipeType : "+getType()+" Direction - "+getDirection();
	}
	
	@Override
	public int getCurrentFrameNumber() {
		return frameCount;
	}

	@Override
	public int getFramesQuantity() {
		return framesNumber;
	}

	@Override
	public void nextFrame() {
		frameCount++;
		
	}

	@Override
	public Bitmap getCurrentFrame() {
		return ImageManager.getInstance().getFrame(this, frameCount);
	}
	
	
	
}
