package bpund.isurakaha.com.test.firebaseDemo;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by isuraksha3 on 4/7/2018.
 */
@IgnoreExtraProperties
public class Tracks {

    String trackId;
    String trackName;
    String trackRating;

    public Tracks() {
    }

    public Tracks(String trackId, String trackName, String trackRating) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackRating = trackRating;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackRating() {
        return trackRating;
    }

    public void setTrackRating(String trackRating) {
        this.trackRating = trackRating;
    }
}
