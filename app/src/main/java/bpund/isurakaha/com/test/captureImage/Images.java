package bpund.isurakaha.com.test.captureImage;

import android.graphics.Bitmap;

/**
 * Created by isuraksha3 on 5/22/2018.
 */

public class Images {

    private Bitmap bitmap;
    long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Images() {
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
