package sod.games.pipeline.pipes;

import sod.games.pipeline.Direction;
import sod.games.pipeline.ImageManager;
import sod.games.pipeline.animation.Animation;
import sod.games.pipeline.sewerage.Stream;
import android.graphics.Bitmap;

public class CrossPipe extends BasePipe {
	static private boolean D = true;
	static private String TAG = "CornerPipe";
	private BasePipe topPipe;
	private BasePipe bottomPipe;

	public CrossPipe() {
		topPipe = new LinePipe();
		bottomPipe = new LinePipe();
		bottomPipe.rotate();
	}

	@Override
	public PipeType getType() {
		return PipeType.Cross;
	}

	@Override
	public void rotate() {
		// empty. no sense make any rotation.
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
	public Animation[] getAnimations() {
		return new Animation[]{topPipe.getAnimations()[0], bottomPipe.getAnimations()[0]};
	}

}
