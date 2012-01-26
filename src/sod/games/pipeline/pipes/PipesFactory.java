package sod.games.pipeline.pipes;

import java.util.Random;

import android.util.Log;

public class PipesFactory {
	static private boolean D = true;
	static private String TAG = "PipesFactory";
	private static PipesFactory instance;

	private PipesFactory() {
	}

	static public PipesFactory getInstance() {
		if (instance == null) {
			instance = new PipesFactory();
		}
		return instance;
	}

	public BasePipe createPipe(PipeType type) {
		switch (type) {
		case Corner:
			return new CornerPipe();
		case Line:
			return new LinePipe();
		case Cross:
			return new CrossPipe();
		case DoubleCorner:
			return new DoubleCornerPipe();

		default:
			return null;
		}
	}

	public BasePipe createRandomPipe() {
		Random rand = new Random();
		BasePipe newPipe;
		int rInt = (4 + rand.nextInt(4)) % 4;

		switch (rInt) {
		case 0:
			newPipe = new CornerPipe();
			break;
		case 1:
			newPipe = new LinePipe();
			break;
		case 2:
			newPipe = new CrossPipe();
			break;
		case 3:
			newPipe = new DoubleCornerPipe();
			break;
		default:
			newPipe = null;
		}
		Log.i(TAG,"createRandomPipe() is called. Returning value = "+newPipe.toString());
		return newPipe;
	}

}
