package sod.games.pipeline;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Sewerage sewerage = new Sewerage(3, 3);
        sewerage.generateRandomSewerage();
        
        
        
        setContentView(R.layout.main);
    }
}