package example.codeclan.com.activity_mood_tracker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 17/03/2017.Error:(33, 40) error: non-static method countEntries() cannot be referenced from a static context
 */
public class ActivitySummaryTest {

    ActivitySummary activitySummary;
    ActivitySummary activitySummary2;
    ActivityRecord runningEntry1;
    ActivityRecord runningEntry2;
    ActivityRecord swimmingEntry1;
    ArrayList<Sportable> sportsArray;

    @Before
    public void before() {
        sportsArray = new ArrayList<Sportable>();
        runningEntry1 = new ActivityRecord("Running", "10/15/2015 00:00 -0700", 20, 8);
        runningEntry2 = new ActivityRecord("Running", "10/15/2015 00:00 -0700", 35, 7);
        swimmingEntry1 = new ActivityRecord("Swimming", "10/15/2015 00:00 -0700", 45, 3);

        activitySummary = new ActivitySummary();
        activitySummary2 = new ActivitySummary();
        activitySummary2.addEntries(runningEntry1);
        activitySummary2.addEntries(runningEntry2);
        sportsArray.add(runningEntry1);
        sportsArray.add(runningEntry2);
        sportsArray.add(swimmingEntry1);


    }

    @Test
    public void canAddEntries() {
        assertEquals(2, activitySummary2.countEntries());
    }

    @Test
    public void canGetSportEntries(){
        assertEquals(2, activitySummary2.getSportEntries("Running").size());
    }

    @Test
    public void canGetTotalDuration(){
        assertEquals(55, activitySummary.totalDuration(sportsArray));
    }

    @Test
    public void canGetTotalMood(){
        assertEquals(15, activitySummary2.totalScore(sportsArray));
    }

    @Test
    public void canGetAverageDuration(){
        assertEquals(27, activitySummary2.averageDuration(sportsArray));
    }

    @Test
    public void canGetAverageScore(){
        assertEquals(7, activitySummary2.averageScore(sportsArray));
    }



}