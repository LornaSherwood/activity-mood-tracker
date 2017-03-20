package example.codeclan.com.activity_mood_tracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by user on 20/03/2017.
 */

public class moodSummaryActivity extends AppCompatActivity {

    TextView runningText;
    TextView swimmingText;
    TextView cyclingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Log.d(getClass().toString(), "SummaryActivity.onCreate called");

        runningText = (TextView)findViewById(R.id.running_text);
        swimmingText = (TextView)findViewById(R.id.swimming_text);
        cyclingText = (TextView)findViewById(R.id.cycling_text);
    }


}
