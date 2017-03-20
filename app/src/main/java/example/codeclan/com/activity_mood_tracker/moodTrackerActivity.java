package example.codeclan.com.activity_mood_tracker;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by user on 19/03/2017.
 */

public class moodTrackerActivity extends AppCompatActivity {

    Spinner sportChoice;
    EditText durationText;
    Spinner moodChoice;
    Button shakeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //call oncreate from super class
        setContentView(R.layout.activity_main); //set content view to what's in activity main
        Log.d(getClass().toString(), "onCreate called");

        sportChoice = (Spinner)findViewById(R.id.sports_spinner);
        durationText = (EditText)findViewById(R.id.duration_text);
        moodChoice = (Spinner)findViewById(R.id.mood_spinner);
        shakeButton = (Button)findViewById(R.id.submit_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sports_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sportChoice.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.mood_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moodChoice.setAdapter(adapter2);

    }



    public void onSubmitButtonClicked(View button) {
        Log.d(getClass().toString(), "onSubmitButtonClicked was called");
        Intent intent = new Intent(moodTrackerActivity.this, moodSummaryActivity.class);
        startActivity(intent);
    }




}
