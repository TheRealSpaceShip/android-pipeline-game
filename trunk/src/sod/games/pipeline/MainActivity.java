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
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	static private boolean D = true;
	static private String TAG = "MainActivity";

	SewerageView view;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		view = new SewerageView(this);
		setContentView(view);
	}
}