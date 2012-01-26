package sod.games.pipeline;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;

public class AnimationTextureInfo {
	public Bitmap texture;
	public int wFrames;
	public int hFrames;
	public int wFrameBitmap;
	public int hFrameBitmap;
	public int frames;

	public AnimationTextureInfo(Bitmap texture, Options singleFrame){
		this.texture = texture;
		
		wFrameBitmap = singleFrame.outWidth;
		hFrameBitmap = singleFrame.outHeight;
		
		wFrames = texture.getWidth() / wFrameBitmap;
		hFrames = texture.getHeight() / hFrameBitmap;
	}
	
	public int[] getPosition(int frameCount){
		int y = frameCount / wFrames ; 
		int x = frameCount - y;
		
		return new int[]{x,y};
	}
	
	public Rect getFrameRect(int frameCount){
		int[] left_top = getPosition(frameCount);
		return new Rect(left_top[0],left_top[1],left_top[0] + wFrameBitmap,left_top[1] + hFrameBitmap );
	}
}
