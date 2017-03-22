package example.codeclan.com.activity_mood_tracker;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 * Created by user on 19/03/2017.
 */

public class MoodTrackerActivity extends AppCompatActivity {

    Spinner sportChoice;
    EditText durationText;
    Spinner moodChoice;
    Button submitButton;
    Intent intent;
    SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(getClass().toString(), "onCreate called");

        sportChoice = (Spinner)findViewById(R.id.sports_spinner);
        durationText = (EditText)findViewById(R.id.duration_text);
        moodChoice = (Spinner)findViewById(R.id.mood_spinner);
        submitButton = (Button)findViewById(R.id.submit_button);

        // get choice from sport spinner //
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sports_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sportChoice.setAdapter(adapter);

        // get choice from mood spinner //
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.mood_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moodChoice.setAdapter(adapter2);

//        mPrefs = getPreferences(MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);

    }

    public void onSubmitButtonClicked(View button) {
        Log.d(getClass().toString(), "onSubmitButtonClicked was called");


        String duration = durationText.getText().toString();
        String sport = sportChoice.getSelectedItem().toString();
        String mood = moodChoice.getSelectedItem().toString();

        int durationNum = Integer.parseInt(duration);
        int moodNum = Integer.parseInt(mood);

        ActivityRecord activityRecord = new ActivityRecord(sport, "24-03-2017", durationNum, moodNum);

        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        // get existing activity summary //

//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        String thing = sharedPreferences.getString("ActivitySummary", "");
//
//        if (thing != "") {
//
//        }


        String json = mPrefs.getString("ActivitySummary", "");


        // if not null, add activity to summary, else create new summary //
        if (json != null && !json.isEmpty()) {
            Log.d("json before new", json);
            ActivitySummary summary = new ActivitySummary();

            JsonObject summaryObject = (JsonObject) new JsonParser().parse(json);
            JsonArray summaryEntries = summaryObject.getAsJsonArray("entries");

            for (JsonElement recordElement : summaryEntries) {
                JsonObject recordObject = recordElement.getAsJsonObject();

                String retrievedSport = recordObject.get("sport").getAsString();
                String retrievedDate = recordObject.get("date").getAsString();
                int retrievedDuration = recordObject.get("duration").getAsInt();
                int retrievedScore = recordObject.get("score").getAsInt();

                ActivityRecord record = new ActivityRecord(retrievedSport, retrievedDate, retrievedDuration, retrievedScore);
                summary.addEntries(record);
            }
            summary.addEntries(activityRecord); // add new activity
//
            // store summary //
            Gson gson2 = new Gson();
            String json2 = gson2.toJson(summary);
            prefsEditor.putString("ActivitySummary", json2);
            prefsEditor.apply();
//
//            SharedPreferences.Editor editor = mPrefs.edit();
//            editor.putString("ActivitySummary", summary);
//            editor.commit();

        } else {
            ActivitySummary newSummary = new ActivitySummary();
            newSummary.addEntries(activityRecord);
            // store summary //
            Gson gson3 = new Gson();
            String json3 = gson3.toJson(newSummary);
            prefsEditor.putString("ActivitySummary", json3);
            prefsEditor.apply();
        }
    }

    public void onSummaryButtonClicked(View button) {
        Log.d(getClass().toString(), "onSummaryButtonClicked was called");

//        String duration = durationText.getText().toString();

        intent = new Intent(this, MoodSummaryActivity.class);
//        intent.putExtra("durationEntry", duration);
        startActivity(intent);

    }


}
