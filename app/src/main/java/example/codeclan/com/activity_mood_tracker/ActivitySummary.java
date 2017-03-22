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
        return entries.size();
    }

    public int countArray(ArrayList<Sportable> sportableArrayList){
        return sportableArrayList.size();
    }

    public void addEntries(Sportable entry) {
        entries.add(entry);
    }

    public ArrayList getSportEntries(String sport){
        ArrayList<Sportable> sportArray = new ArrayList();
        for (Sportable entry : entries){
            String sportType = entry.getSport();
            if ((sportType).equals(sport)){
                sportArray.add(entry);
            }
        }
        return sportArray;
    }

    public int totalDuration(ArrayList<Sportable> sportableArrayList){
        int totalDuration = 0;
        for (Sportable entry : sportableArrayList) {
            int duration = entry.getDuration();
            totalDuration += duration;
        }
        return totalDuration;
    }

    public int totalScore(ArrayList<Sportable> sportableArrayList) {
        int totalScore = 0;
        for (Sportable entry : sportableArrayList) {
            int score = entry.getScore();
            totalScore += score;
        }
        return totalScore;
    }

    public int averageDuration(ArrayList<Sportable> sportableArrayList){
        return this.totalDuration(sportableArrayList)/this.countArray(sportableArrayList);
    }

    public int averageScore(ArrayList<Sportable> sportableArrayList){
        return this.totalScore(sportableArrayList)/this.countArray(sportableArrayList);
    }
}


