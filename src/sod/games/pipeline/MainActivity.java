package sod.games.pipeline;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Sewerage sewerage = new Sewerage(3, 3);
		sewerage.generateRandomSewerage();
		GameState state = GameState.PROCEED;
		while (state == GameState.PROCEED)
			state = sewerage.flowStream();
		
		TextView output = (TextView)findViewById(R.id.text_output) ;
		output.setText(state.toString());
		
		
	}
}