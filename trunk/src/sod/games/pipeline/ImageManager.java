package sod.games.pipeline;


import java.util.HashMap;
import java.util.Map;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import sod.games.pipeline.pipes.PipeType;

public class ImageManager {
	private Resources res;
	private static ImageManager instance;
	private Map<PipeType, Bitmap> animatedTextures;
	private Map<PipeType, Options> frameOptions;

	static public ImageManager getInstance() {
		if (instance == null)
			instance = new ImageManager();
		return instance;
	}

	public void setResourses(Resources res) {
		this.res = res;
	}

	public ImageManager() {
		animatedTextures = new HashMap<PipeType, Bitmap>();
		frameOptions = new HashMap<PipeType, BitmapFactory.Options>();
		
	}

	public void loadPipeTextures() {
	animatedTextures.put(PipeType.Corner, imageLoad(R.drawable.a_corner));
	frameOptions.put(PipeType.Corner, getImageParams(R.drawable.corner));
	
	animatedTextures.put(PipeType.Gutter, imageLoad(R.drawable.a_gutter));
	frameOptions.put(PipeType.Gutter, getImageParams(R.drawable.gutter));
	
	animatedTextures.put(PipeType.Tap, imageLoad(R.drawable.tap));
	frameOptions.put(PipeType.Tap, getImageParams(R.drawable.tap));
	
	animatedTextures.put(PipeType.Line, imageLoad(R.drawable.a_line));
	frameOptions.put(PipeType.Line, getImageParams(R.drawable.line));
	}

	private Bitmap imageLoad(int id) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		return BitmapFactory.decodeResource(res, id, options);
	}

	private Options getImageParams(int id) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, id, options);
		return options;
	}


	private Matrix getRotationMatrix(Direction direction) {
		Matrix matrix = new Matrix();
		matrix.reset();

		switch (direction) {
		case North:
			matrix.setRotate(0);
			break;
		case East:
			matrix.setRotate(90);
			break;
		case South:
			matrix.setRotate(180);
			break;
		case West:
			matrix.setRotate(270);
			break;
		}
		return matrix;

	}
	private static Paint paint;

	static public Bitmap overlay2Bitmaps(Bitmap bottom, Bitmap top) {
		if (paint == null)
			paint = new Paint();
		Bitmap overlayBitmap = Bitmap.createBitmap(bottom.getWidth(),
				bottom.getHeight(), bottom.getConfig());
		Canvas c = new Canvas();
		c.setBitmap(overlayBitmap);
		c.drawBitmap(bottom, 0, 0, paint);
		c.drawBitmap(top, 0, 0, paint);
		return overlayBitmap;
	}
	
	public Bitmap getPipeBitmap(PipeType type){
		return animatedTextures.get(type);
	}
	
	public Options getFrameOptions(PipeType type){
		return frameOptions.get(type);
	}

}
