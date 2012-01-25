package sod.games.pipeline;

import sod.games.pipeline.pipes.Direction;
import sod.games.pipeline.pipes.Pipe;
import sod.games.pipeline.pipes.PipeType;
import sod.games.pipeline.pipes.Tap;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	static private boolean D = true;
	static private String TAG = "MainActivity";
	
	ImageView view;
	Pipe pipe;
	ImageManager imageManager;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = new ImageView(this);
		setContentView(view);
		view.setBackgroundColor(Color.WHITE);
		imageManager = new ImageManager(getResources());
		pipe = new Tap();
		view.setImageBitmap(imageManager.getDirectedPipeTexture(pipe.getType(), pipe.getDirection()));
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	if (event.getAction() == MotionEvent.ACTION_DOWN){
			pipe.rotate();
			view.setImageBitmap(imageManager.getDirectedPipeTexture(pipe.getType(), pipe.getDirection()));
	}
	return true;
	}
	
	
}