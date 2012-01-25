package sod.games.pipeline;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;

import sod.games.pipeline.pipes.Direction;
import sod.games.pipeline.pipes.PipeType;
import sod.games.pipeline.pipes.PipesFactory;

public class ImageManager {
	private HashMap<PipeType, Bitmap> pipeTextures;
	private Resources res;
	
	
	public ImageManager(Resources res){
		this.res = res;
		pipeTextures = new HashMap<PipeType, Bitmap>(PipeType.values().length);
		loadPipeTextures();
	}
	
	public void loadPipeTextures(){
		pipeTextures.put(PipeType.Tap, imageLoad(R.drawable.tap));
		pipeTextures.put(PipeType.Gutter, imageLoad(R.drawable.gutter));	
		pipeTextures.put(PipeType.Corner, imageLoad(R.drawable.corner));	
		pipeTextures.put(PipeType.DoubleCorner, imageLoad(R.drawable.double_cross));	
		pipeTextures.put(PipeType.Cross, imageLoad(R.drawable.cross));	
		pipeTextures.put(PipeType.Line, imageLoad(R.drawable.line));	
	}
	
	private Bitmap imageLoad(int id){
		BitmapFactory.Options options = new BitmapFactory.Options();
		return BitmapFactory.decodeResource(res, id,options );
	}

	public Bitmap getPipeTexture(PipeType type){
		return pipeTextures.get(type);
	}
	
	public Bitmap getDirectedPipeTexture(PipeType type, Direction direction){
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
		
		return Bitmap.createBitmap(pipeTextures.get(type), 0, 0, pipeTextures.get(type).getWidth(), pipeTextures.get(type).getHeight(), matrix, false);
	}

	
}
