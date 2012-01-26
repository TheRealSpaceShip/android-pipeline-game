package sod.games.pipeline;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;

import sod.games.pipeline.pipes.AnimatedPipe;
import sod.games.pipeline.pipes.Direction;
import sod.games.pipeline.pipes.LogicPipe;
import sod.games.pipeline.pipes.PipeType;
import sod.games.pipeline.pipes.PipesFactory;

public class ImageManager {
	private HashMap<PipeType, AnimationTextureInfo> pipeAnimationTextures;
	private Resources res;
	private static  ImageManager instance;
	
	static public ImageManager getInstance(){
		if(instance == null)
			instance = new ImageManager();
		return instance;
	}
	
	public void setResourses(Resources res){
		this.res = res;
	}
	
	
	public ImageManager(){
		pipeAnimationTextures = new HashMap<PipeType, AnimationTextureInfo>(PipeType.values().length);
	}
	
	public void loadPipeTextures(){
		pipeAnimationTextures.put(PipeType.Tap, new AnimationTextureInfo(imageLoad(R.drawable.tap), getImageParams(R.drawable.tap)));
		pipeAnimationTextures.put(PipeType.Corner, new AnimationTextureInfo(imageLoad(R.drawable.corner), getImageParams(R.drawable.corner)));
		pipeAnimationTextures.put(PipeType.Cross, new AnimationTextureInfo(imageLoad(R.drawable.cross), getImageParams(R.drawable.cross)));
		pipeAnimationTextures.put(PipeType.DoubleCorner, new AnimationTextureInfo(imageLoad(R.drawable.double_corners), getImageParams(R.drawable.double_corners)));
		pipeAnimationTextures.put(PipeType.Gutter, new AnimationTextureInfo(imageLoad(R.drawable.gutter), getImageParams(R.drawable.gutter)));
		pipeAnimationTextures.put(PipeType.Line, new AnimationTextureInfo(imageLoad(R.drawable.a_line), getImageParams(R.drawable.line)));
	}
	
	private Bitmap imageLoad(int id){
		BitmapFactory.Options options = new BitmapFactory.Options();
		return BitmapFactory.decodeResource(res, id,options );
	}
	
	private Options getImageParams(int id){
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, id, options);
		return options;
	}

	public Bitmap getPipeTexture(LogicPipe pipe){
		return getFrame(pipe, 0);
	}
	
	private Matrix getRotationMatrix(Direction direction){
		Matrix matrix = new Matrix();
		matrix.reset();
		
		switch(direction){
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
	
	public Bitmap getFrame (LogicPipe pipe, int frame){
		PipeType type = pipe.getType();
		AnimationTextureInfo textureInfo = pipeAnimationTextures.get(type);
		Rect rect = textureInfo.getFrameRect(frame);
		return Bitmap.createBitmap(textureInfo.texture, rect.left  ,rect.top ,rect.right, rect.bottom, getRotationMatrix(pipe.getDirection()), false);
	}

	public AnimationTextureInfo getPipeTextureParams(PipeType type) {
		return pipeAnimationTextures.get(type);
	}

	
}
