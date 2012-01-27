package sod.games.pipeline.pipes;

import sod.games.pipeline.Direction;
import sod.games.pipeline.ImageManager;
import sod.games.pipeline.animation.Animation;
import sod.games.pipeline.sewerage.Stream;
import android.graphics.Bitmap;

public class DoubleCornerPipe extends BasePipe {
	static private boolean D = true;
	static private String TAG = "DoubleCornerPipe";
	
	private BasePipe topPipe;
	private BasePipe bottomPipe;
	
	public DoubleCornerPipe(){
		topPipe = new CornerPipe();
		bottomPipe = new CornerPipe();
		bottomPipe.rotate();
		bottomPipe.rotate();
	}
	
	@Override
	public void rotate() {
		topPipe.rotate();
		bottomPipe.rotate();
	}

	@Override
	public boolean directStream(Stream stream) {
		return topPipe.directStream(stream) || bottomPipe.directStream(stream);
	}

	@Override
	public Direction getDirection() {
		return topPipe.getDirection();
	}
	
	
	@Override
	public PipeType getType() {
		return PipeType.DoubleCorner;
	}
	
	@Override
	public Animation[] getAnimations() {
		return new Animation[]{topPipe.getAnimations()[0], bottomPipe.getAnimations()[0]};
	}
}
