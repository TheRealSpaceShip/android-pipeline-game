package sod.games.pipeline;

import sod.games.pipeline.animation.Animation;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class TestingView extends View{
	Animation animation;

	public TestingView(Context context) {
		super(context);
	
	Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a_line);
	animation = new Animation(bitmap, 40, 40, 16, 20, 20,0, true);
	setBackgroundColor(Color.WHITE);
	}

Handler timer = new Handler();
Runnable tick = new Runnable() {
	
	@Override
	public void run() {
		animation.update();
		postInvalidate();
		timer.postDelayed(tick, 45);
		
	}
};


	@Override
public boolean onTouchEvent(MotionEvent event) {
	if (event.getAction() == MotionEvent.ACTION_DOWN){
		timer.removeCallbacks(tick);
		timer.post(tick);
	}
	if (event.getAction() == MotionEvent.ACTION_MOVE)
		animation.move((int)event.getX(), (int)event.getY());
	return true;
}

static Paint paint = new Paint();
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		animation.draw(canvas,paint);
		canvas.drawText("Position of animation : x = "+animation.getPositionX()+" y = "+animation.getPositionY(), 0, 10 ,paint );

	}
	
	
	
	

}
