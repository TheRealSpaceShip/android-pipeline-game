package sod.games.pipeline;

import sod.games.pipeline.pipes.Pipe;
import sod.games.pipeline.pipes.PipeType;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

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

	public SewerageView(Context context) {
		super(context);

		setBackgroundColor(Color.WHITE);
		paint = new Paint();
		imageManager = new ImageManager(context.getResources());
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {

		wPipeBitmap = imageManager.getPipeTexture(PipeType.Tap).getWidth();
		hPipeBitmap = imageManager.getPipeTexture(PipeType.Tap).getHeight();
		wPipes = getWidth() / wPipeBitmap;
		hPipes = getHeight() / hPipeBitmap;

		sewerage = new Sewerage(wPipes, hPipes);
		sewerage.generateRandomSewerage();
		super.onLayout(changed, left, top, right, bottom);
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
				sewerage.flowStream();
			} else {
				sewerage.getPipe(x, y).rotate();
			}
			invalidate();
		}
		return super.onTouchEvent(event);
	}

}
