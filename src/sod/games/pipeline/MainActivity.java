package sod.games.pipeline;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
	static private boolean D = true;
	static private String TAG = "MainActivity";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
}