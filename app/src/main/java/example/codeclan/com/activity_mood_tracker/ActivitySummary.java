package example.codeclan.com.activity_mood_tracker;
import android.util.Log;
import java.util.ArrayList;
import android.preference.PreferenceManager;

/**
 * Created by user on 18/03/2017.
 */

public class ActivitySummary {

    private ArrayList<Sportable> entries;

    public ActivitySummary() {
        entries = new ArrayList<Sportable>();
    }


    public int countEntries(){
        return this.entries.size();
    }

    public void addEntries(Sportable entry) {
        entries.add(entry);
    }

    public int totalDuration(){
        int totalDuration = 0;
        for (Sportable entry : entries) {
            int duration = entry.getDuration();
            totalDuration += duration;
        }
        return totalDuration;
    }

    public int totalScore() {
        int totalScore = 0;
        for (Sportable entry : entries) {
            int score = entry.getScore();
            totalScore += score;
        }
        return totalScore;
    }

    public int averageDuration(){
        return this.totalDuration()/this.countEntries();
    }

    public int averageScore(){
        return this.totalScore()/this.countEntries();
    }
}


