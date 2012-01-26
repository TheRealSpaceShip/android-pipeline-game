package sod.games.pipeline.pipes;

import android.graphics.Bitmap;

public interface AnimatedPipe {
	public int getCurrentFrameNumber();
	public int getFramesQuantity();
	public void nextFrame();
	public Bitmap getFrame();
}
