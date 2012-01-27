package sod.games.pipeline.animation;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Paint;

public class AnimationLayersManager {

	private List<AnimationLayer> layers;


	public AnimationLayersManager() {
		layers = new ArrayList<AnimationLayer>();
	}

	public void addLayer(int rows, int columns) {
		layers.add(new AnimationLayer(rows, columns));
	}

	public AnimationLayer getLayer(int deep) {
		if (deep > layers.size()-1)
			return null;
		
		return layers.get(deep);
	}

	public void putAnimatedItem(int row, int column, Animation[] animations) {
		for (int i = 0 ; i < animations.length; ++i){
			getLayer(i).putAnimation(row, column, animations[i]);
		}

	}
	
	public void setTilePosition(int x, int y, int positionX, int positionY){
		for (AnimationLayer layer : layers)
			layer.setItemPosition(x, y, positionX, positionY);
	}
	
	public void setTilePosition(int x, int y, int positionX, int positionY, int deep){
		layers.get(deep).setItemPosition(x, y, positionX, positionY);
	}
	
	public void rotateItem(int x, int y, int angle){
		for (AnimationLayer layer : layers)
			layer.rotateItem(x, y, angle);
	}
	
	public void rotateItem(int x, int y, int angle, int deep){
		layers.get(deep).rotateItem(x, y, angle);
	}
	
	public void draw(Canvas c, Paint paint){
		for (AnimationLayer layer : layers)
			layer.draw(c, paint);
	}

}
