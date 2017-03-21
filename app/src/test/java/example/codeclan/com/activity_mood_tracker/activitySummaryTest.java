package example.codeclan.com.activity_mood_tracker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by user on 17/03/2017.Error:(33, 40) error: non-static method countEntries() cannot be referenced from a static context
 */
public class activitySummaryTest {

    ActivitySummary activitySummary;
    ActivitySummary activitySummary2;
    ActivityRecord runningEntry1;
    ActivityRecord runningEntry2;

    @Before
    public void before() {
        runningEntry1 = new ActivityRecord("Running", "10/15/2015 00:00 -0700", 20, 8);
        runningEntry2 = new ActivityRecord("Running", "10/15/2015 00:00 -0700", 35, 7);
        activitySummary = new ActivitySummary();
        activitySummary2 = new ActivitySummary();
        activitySummary2.getEntries(runningEntry1);
        activitySummary2.getEntries(runningEntry2);

    }

    @Test
    public void entriesStartEmpty(){
        assertEquals(0, activitySummary.countEntries());
    }

    @Test
    public void canGetEntries() {
        assertEquals(2, activitySummary2.countEntries());
    }

    @Test
    public void canGetTotalDuration(){
        assertEquals(55, activitySummary2.totalDuration());
    }

    @Test
    public void canGetTotalMood(){
        assertEquals(15, activitySummary2.totalScore());
    }

    @Test
    public void canGetAverageDuration(){
        assertEquals(27, activitySummary2.averageDuration());
    }

    @Test
    public void canGetAverageScore(){
        assertEquals(7, activitySummary2.averageScore());
    }



}