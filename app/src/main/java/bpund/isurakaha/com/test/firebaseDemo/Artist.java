package bpund.isurakaha.com.test.firebaseDemo;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by isuraksha3 on 4/7/2018.
 */
@IgnoreExtraProperties
public class Artist {

    String artistId;
    String artistName;
    String artistGenre;
    String imageFilePath;
    long currentMills;

    public long getCurrentMills() {
        return currentMills;
    }

    public void setCurrentMills(long currentMills) {
        this.currentMills = currentMills;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public Artist() {}

    public Artist(String artistId, String artistName, String artistGenre, String imageFilePath,long currentMills) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistGenre = artistGenre;
        this.imageFilePath = imageFilePath;
        this.currentMills=currentMills;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistGenre() {
        return artistGenre;
    }

    public void setArtistGenre(String artistGenre) {
        this.artistGenre = artistGenre;
    }
}
