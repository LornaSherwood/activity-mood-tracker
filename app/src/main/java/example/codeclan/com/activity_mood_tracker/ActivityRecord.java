package example.codeclan.com.activity_mood_tracker;

/**
 * Created by user on 17/03/2017.
 */

    public class ActivityRecord implements Sportable{

        private String sport;
        private String date;
        private int duration;
        private double score;

        public ActivityRecord(String sport, String date, int duration, double score) {
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

        public double getScore(){
            return this.score;
        }

    }
