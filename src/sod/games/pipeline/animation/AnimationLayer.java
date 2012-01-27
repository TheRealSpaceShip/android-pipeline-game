package sod.games.pipeline.animation;

import android.graphics.Canvas;
import android.graphics.Paint;

public class AnimationLayer {
	private Animation[][] layer;
	private int wTiles;
	private int hTiles;

	public AnimationLayer(int w, int h) {
		wTiles = w;
		hTiles = h;
		layer = new Animation[w][h];
	}

	public Animation[][] getLayer() {
		return layer;
	}

	public void setLayer(Animation[][] layer) {
		this.layer = layer;
	}

	public void putAnimation(int x, int y, Animation animation) {
		layer[x][y] = animation;
	}

	public void setItemPosition(int x, int y, int positionX, int positionY) {
		if (layer[x][y] != null)
			layer[x][y].move(positionX, positionY);
	}

	public void rotateItem(int x, int y, float angle) {
		if (layer[x][y] != null)
			layer[x][y].rotate(angle);
	}

	public void draw(Canvas c, Paint paint) {
		for (Animation[] animations : layer)
			for (Animation animation : animations) {
				if (animation != null)
					animation.draw(c, paint);
			}
	}
	
	public void update(int x, int y){
		if(layer[x][y]!= null)
			layer[x][y].update();
	}

	public boolean isEnded(int x, int y) {
		if(x < wTiles && x >= 0 && y <hTiles &&  y>= 0 && layer[x][y]!= null)
			return layer[x][y].isEnd();
		return true;
	}
}
