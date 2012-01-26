package sod.games.pipeline.pipes;

import sod.games.pipeline.ImageManager;
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
	public Bitmap getCurrentFrame() {
		return ImageManager.overlay2Bitmaps(bottomPipe.getCurrentFrame(),
				topPipe.getCurrentFrame());
	}

}
