package sod.games.pipeline;

import sod.games.pipeline.sewerage.SewerageView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

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
		
		ImageManager.getInstance().setResourses(getResources());
		ImageManager.getInstance().loadPipeTextures();
		
		view = new SewerageView(this);
		
		setContentView(view);
	}
}