package example.codeclan.com.activity_mood_tracker;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by user on 19/03/2017.
 */

public class moodTrackerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //call oncreate from super class
        setContentView(R.layout.activity_main); //set content view to what's in activity main
    }


}
