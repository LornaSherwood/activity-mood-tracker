package example.codeclan.com.activity_mood_tracker;

/**
 * Created by user on 17/03/2017.
 */

    public class ActivityRecord implements Sportable{

        private String sport;
        private String date;
        private int duration;
        private int score;

        public ActivityRecord(String sport, String date, int duration, int score) {
            this.sport = sport;
            this.date = date;
            this.duration = duration;
            this.score = score;
        }

        public String getSport() {
            return sport;
        }

        public String getDate() {
            return this.date;
        }

        public int getDuration() {
            return this.duration;
        }

        public int getScore(){
            return this.score;
        }

    }
