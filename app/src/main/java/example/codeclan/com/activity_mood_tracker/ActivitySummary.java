package example.codeclan.com.activity_mood_tracker;

import java.util.ArrayList;

/**
 * Created by user on 18/03/2017.
 */

public class ActivitySummary {

    private String sport;
    private ArrayList<Sportable> entries;

    public ActivitySummary(String sport) {
        this.sport = sport;
        entries = new ArrayList<Sportable>();
    }



    public String getSport() {
        return sport;
    }

    public int countEntries(){
        return this.entries.size();
    }

    public void getEntries(Sportable entry) {
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

    public double totalScore() {
        double totalScore = 0;
        for (Sportable entry : entries) {
            double score = entry.getScore();
            totalScore += score;
        }
        return totalScore;
    }

    public int averageDuration(){
        return this.totalDuration()/this.countEntries();
    }

    public double averageScore(){
        return this.totalScore()/this.countEntries();
    }
}


