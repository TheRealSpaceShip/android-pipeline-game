package sod.games.pipeline.sewerage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import sod.games.pipeline.Direction;
import sod.games.pipeline.GameState;
import sod.games.pipeline.R;
import sod.games.pipeline.animation.Animation;
import sod.games.pipeline.animation.AnimationLayersManager;
import sod.games.pipeline.pipes.BasePipe;
import sod.games.pipeline.pipes.LogicPipe;
import sod.games.pipeline.pipes.PipeType;
import sod.games.pipeline.pipes.PipesFactory;
import sod.games.pipeline.pipes.StreamRoadInformation;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.Toast;

public class SewerageView extends SurfaceView {
	static private boolean D = true;
	static private String TAG = "SewerageView";

	Sewerage sewerage;
	int wPipes;
	int hPipes;
	int wPipeBitmap;
	int hPipeBitmap;
	Paint paint;
	Context context;
	AnimationLayersManager layersManager;
	GameState gameResult;

	public GameState getGameResult() {
		return gameResult;
	}

	public void setGameResult(GameState gameResult) {
		this.gameResult = gameResult;
	}

	public SewerageView(Context context) {
		super(context);
		this.context = context;
		setBackgroundColor(Color.WHITE);
		paint = new Paint();

		wPipeBitmap = 40;
		hPipeBitmap = 40;
		setBackgroundResource(R.drawable.bg_wood);

	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		if (D)
			Log.i(TAG, "onLayout() is called");
		// super.onLayout(changed, left, top, right, bottom);

		wPipes = getWidth() / wPipeBitmap;
		hPipes = getHeight() / hPipeBitmap;

		if (layersManager == null) {
			layersManager = new AnimationLayersManager();
			layersManager.addLayer(wPipes, hPipes);
			layersManager.addLayer(wPipes, hPipes);
		}
		if (sewerage == null) {
			sewerage = new Sewerage(wPipes, hPipes);
			sewerage.generateRandomSewerage();

			for (int y = 0; y < hPipes; y++) {
				for (int x = 0; x < wPipes; x++) {
					BasePipe pipe = sewerage.getPipe(x, y);
					layersManager.putAnimatedItem(x, y, pipe.getAnimations());
					layersManager.setTilePosition(x, y, x * wPipeBitmap
							+ wPipeBitmap / 2, y * hPipeBitmap + hPipeBitmap
							/ 2);
				}
			}
			invalidate();
		}
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		layersManager.draw(canvas, paint);
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
				layersManager.rotateItem(x, y, 90);
			}

			invalidate(x * wPipeBitmap, y * hPipeBitmap, (x + 1) * wPipeBitmap,
					(y + 1) * hPipeBitmap);
		}
		return super.onTouchEvent(event);
	}

	Handler timer = new Handler();
	Runnable tick = new Runnable() {

		@Override
		public void run() {
			GameState state = sewerage.flowStream();
			switch (state) {
			case WIN:
			case LOSE:
				setGameResult(state);
				startAnimation();
				break;
			case PROCEED:
				timer.post(this);
				break;
			}
		}
	};
	private List<StreamRoadInformation> animatedPipes;
	private BasePipe animatedPipe;
	
	private void lose() {
		Toast.makeText(context, "LOSER !", Toast.LENGTH_LONG).show();
		sewerage = new Sewerage(wPipes, hPipes);
		sewerage.generateRandomSewerage();
		invalidate();
	}

	protected void startAnimation() {
	animatedPipes = sewerage.getStreamRoad();
	animationTimer.post(animationTick);
	}
	
	Handler animationTimer = new Handler();
	Runnable animationTick = new Runnable() {
		@Override
		public void run() {
			boolean result = false;
		for (StreamRoadInformation info : animatedPipes){
			if (!layersManager.isEnded(info.position[0],info.position[1]))
			{
				layersManager.update(info.position[0],info.position[1]);
				postInvalidate();
				result = true;
				break;
			}
		}
		
		if (result)
			animationTimer.postDelayed(this, 45);
		else
			animationTimer.removeCallbacks(this);
		
		}
	};
	

	private void win() {
		Toast.makeText(context, "WIN !", Toast.LENGTH_LONG).show();
	}

}
