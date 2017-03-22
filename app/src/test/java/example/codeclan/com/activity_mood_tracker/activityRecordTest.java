package example.codeclan.com.activity_mood_tracker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 17/03/2017.
 */
public class ActivityRecordTest {


    ActivityRecord activityRecord;

    @Before
    public void before() {
        activityRecord = new ActivityRecord("Running", "10/15/2015 00:00 -0700", 20, 8);
    }

    @Test
    public void canGetSport() {
        assertEquals("Running", activityRecord.getSport());
    }

    @Test
    public void canGetDate() {
        assertEquals("10/15/2015 00:00 -0700", activityRecord.getDate());
    }

    @Test
    public void canGetDuration() {
        assertEquals(20, activityRecord.getDuration());
    }

    @Test
    public void canGetScore() {
        assertEquals(8, activityRecord.getScore());
    }


}