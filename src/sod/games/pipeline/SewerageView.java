package sod.games.pipeline;

import java.util.concurrent.Callable;

import sod.games.pipeline.pipes.Pipe;
import sod.games.pipeline.pipes.PipeType;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.Toast;

public class SewerageView extends SurfaceView {
	static private boolean D = true;
	static private String TAG = "SewerageView";

	Sewerage sewerage;
	ImageManager imageManager;
	int wPipes;
	int hPipes;
	int wPipeBitmap;
	int hPipeBitmap;
	Paint paint;
	Context context;
	

	public SewerageView(Context context) {
		super(context);
		this.context = context;
		setBackgroundColor(Color.WHITE);
		paint = new Paint();
		imageManager = new ImageManager(context.getResources());
		wPipeBitmap = imageManager.getPipeTexture(PipeType.Tap).getWidth();
		hPipeBitmap = imageManager.getPipeTexture(PipeType.Tap).getHeight();
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		if(D) Log.i(TAG,"onLayout() is called");
//		super.onLayout(changed, left, top, right, bottom);

		wPipes = getWidth() / wPipeBitmap;
		hPipes = getHeight() / hPipeBitmap;
		
		sewerage = new Sewerage(wPipes, hPipes);
		sewerage.generateRandomSewerage();
		invalidate();
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		for (int y = 0; y < hPipes; y++) {
			for (int x = 0; x < wPipes; x++) {
				canvas.drawBitmap(imageManager.getDirectedPipeTexture(sewerage
						.getPipe(x, y).getType(), sewerage.getPipe(x, y)
						.getDirection()), x * wPipeBitmap, y * hPipeBitmap,
						paint);
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			int x = (int) event.getX() / wPipeBitmap;
			int y = (int) event.getY() / hPipeBitmap;
			
			if (D)
				Log.i(TAG, "pressed pipes[" + x + "][" + y + "]");
			
			if (sewerage.getPipe(x, y).getType() == PipeType.Tap) {
				timer.post(tick);
			} else {
				sewerage.getPipe(x, y).rotate();
			}
			invalidate();
		}
		return super.onTouchEvent(event);
	}
	
	Handler timer = new Handler();
	Runnable tick = new Runnable() {
		
		@Override
		public void run() {
			GameState state = sewerage.flowStream();
			switch(state){
			case WIN:
				win();
				break;
			case LOSE:
				lose();
				break;
			case PROCEED:
				timer.post(this);
				break;
			}
		}
	};
	
	private void lose(){
		Toast.makeText(context, "LOSER !", Toast.LENGTH_LONG).show();
		sewerage = new Sewerage(wPipes, hPipes);
		sewerage.generateRandomSewerage();
		invalidate();
	}
	
	private void win(){
		Toast.makeText(context, "WIN !", Toast.LENGTH_LONG).show();		
	}


}
