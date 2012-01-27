package sod.games.pipeline.animation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

public class Animation {
	private Bitmap src;
	private int frameCount;
	private int frameNumber;
	private int positionX;
	private int positionY;
	private int frameWidth;
	private int frameHeight;
	private int rowFrames;
	private int columnFrames;
	private Rect srcRect;
	private Rect dstRect;
	private float angle;
	private boolean repeat;
	private boolean end;



	public Animation(Bitmap src, int frameWidth, int frameHeight,
			int frameNumber, int positionX, int positionY, float angle, boolean repeat) {
		this.src = src;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.frameNumber = frameNumber;
		this.positionX = positionX;
		this.positionY = positionY;
		this.frameCount = 0;
		this.srcRect = new Rect(0, 0, frameWidth, frameHeight);
		this.dstRect = new Rect(positionX - frameWidth / 2, positionY
				- frameHeight / 2, positionX + frameWidth / 2, positionY
				+ frameHeight / 2);
		this.angle = angle;

		this.rowFrames = src.getWidth() / frameWidth;
		this.columnFrames = src.getHeight() / frameHeight;
		this.repeat = repeat;
		this.end = false;

	}

	public void update() {
		if (end) return;
		frameCount++;
		
		if (frameCount >= frameNumber) {
			if (repeat)
				frameCount = 0;
			else {
				end = true;
				return;
			}
		}
		int y = frameCount / rowFrames;
		int x = frameCount - rowFrames * y;
		
		srcRect.set(x*frameWidth, y*frameHeight,(x+1)*frameWidth ,(y+1)*frameHeight);
	}

	public void move(int x, int y) {
		positionX = x;
		positionY = y;
		dstRect.set(positionX - frameWidth / 2, positionY
				- frameHeight / 2, positionX + frameWidth / 2, positionY
				+ frameHeight / 2);
	}

	public void draw(Canvas c, Paint paint) {
		c.save();
		c.rotate(angle, dstRect.exactCenterX(), dstRect.exactCenterY());
		c.drawBitmap(src, srcRect, dstRect, paint);
		c.restore();
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}
	
	public void rotate (float angle){
		this.angle+= angle;
	}
	
	public void setAngle(float angle){
		this.angle = angle;
	}

	public boolean isEnd() {
		return end;
	}
}
