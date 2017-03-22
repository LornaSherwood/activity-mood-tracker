package example.codeclan.com.activity_mood_tracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * Created by user on 20/03/2017.
 */

public class MoodSummaryActivity extends AppCompatActivity {

    TextView kayakTextTrip;
    TextView kayakTextDuration;
    TextView kayakTextScore;

    TextView paddleTextTrip;
    TextView paddleTextDuration;
    TextView paddleTextScore;

    TextView snorkelTextTitle;
    TextView snorkelTextTrip;
    TextView snorkelTextDuration;
    TextView snorkelTextScore;
    ActivitySummary summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
//        Log.d(getClass().toString(), "SummaryActivity.onCreate called");


        // get existing activity summary //
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MoodSummaryActivity.this);
        String json = sharedPreferences.getString("ActivitySummary", "");


        // if not null, add activity to summary, else create new summary //
        if (json != null && !json.isEmpty()) {
            Log.d(getClass().toString(), "reached here");
            summary = new ActivitySummary();

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
        } else {
            Log.d(getClass().toString(), "reached here null");
        }

        // kayak results display //
        ArrayList<Sportable> kayakArray = summary.getSportEntries("Kayaking");
        if (kayakArray.size() != 0) {
            int kayakCount = summary.countArray(kayakArray);
            int kayakAveDuration = summary.averageDuration(kayakArray);
            int kayakAveScore = summary.averageScore(kayakArray);
            String kayakingTrip = "Trips: " + kayakCount;
            String kayakDuration = "Average duration: " + kayakAveDuration + "mins";
            String kayakScore = kayakAveScore + "/10";

            kayakTextTrip = (TextView) findViewById(R.id.kayak_text_trip);
            kayakTextTrip.setText(kayakingTrip);

            kayakTextDuration = (TextView) findViewById(R.id.kayak_text_duration);
            kayakTextDuration.setText(kayakDuration);

            kayakTextScore = (TextView) findViewById(R.id.kayak_text_score);
            kayakTextScore.setText(kayakScore);

        }

        // paddleboard results display //
        ArrayList<Sportable> paddleboardArray = summary.getSportEntries("Paddleboarding");
        if (paddleboardArray.size() != 0) {
            int paddleCount = summary.countArray(paddleboardArray);
            int paddleAveDuration = summary.averageDuration(paddleboardArray);
            int paddleAveScore = summary.averageScore(paddleboardArray);
            String paddleTrip = "Trips: " + paddleCount;
            String paddleDuration = "Average duration: " + paddleAveDuration + "mins";
            String paddleScore = paddleAveScore + "/10";

            paddleTextTrip = (TextView) findViewById(R.id.paddle_text_trip);
            paddleTextTrip.setText(paddleTrip);

            paddleTextDuration = (TextView) findViewById(R.id.paddle_text_duration);
            paddleTextDuration.setText(paddleDuration);

            paddleTextScore = (TextView) findViewById(R.id.paddle_text_score);
            paddleTextScore.setText(paddleScore);
        }

        // snorkelling results display //
        ArrayList<Sportable> snorkelArray = summary.getSportEntries("Snorkelling");
        if (snorkelArray.size() != 0) {
            int snorkelCount = summary.countArray(snorkelArray);
            int snorkelAveDuration = summary.averageDuration(snorkelArray);
            int snorkelAveScore = summary.averageScore(snorkelArray);

//            String snorkelTitle = "Snorkelling       " + snorkelAveScore + "/10";
            String snorkelTrip = "Trips: " + snorkelCount;
            String snorkelDuration = "Average duration: " + snorkelAveDuration + "mins";
            String snorkelScore = snorkelAveScore + "/10";

//            snorkelTextTitle = (TextView) findViewById(R.id.snorkel_text_title);
//            snorkelTextTitle.setText(snorkelTitle);

            snorkelTextTrip = (TextView) findViewById(R.id.snorkel_text_trip);
            snorkelTextTrip.setText(snorkelTrip);

            snorkelTextDuration = (TextView) findViewById(R.id.snorkel_text_duration);
            snorkelTextDuration.setText(snorkelDuration);

            snorkelTextScore = (TextView) findViewById(R.id.snorkel_text_score);
            snorkelTextScore.setText(snorkelScore);


        }


    }
}
