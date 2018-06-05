package bpund.isurakaha.com.test.constants;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by isuraksha3 on 4/5/2018.
 */

public class Constant {
    public static final String TAG = Constant.class.getSimpleName();

    public static final String urlMenu = " https://api.androidhive.info/json/menu.json";
    public static final String urlSearchFilter = " https://api.androidhive.info/json/contacts.json";

    public static final String NAME = "name";
    public static final String IMG_URL = "img_url";

    public static final String ARTIST_ID = "artist_id";
    public static final String ARTIST_NAME = "artist_name";

    public static final String UPDATE_ID = "update_id";
    public static final String UPDATE_NAME = "update_name";
    public static final String UPDATE_GEN = "update_gen";
    public static final String UPDATE_FILE_PATH = "update_file_path";

    //user Edit
    public static final String EDIT_ID = "id";
    public static final String EDIT_NAME= "name";
    public static final String EDIT_PASSWORD = "password";
    public static final String EDIT_DATE = "date";
    public static final String UPDATE_UI_FILETER = "bpund.isurakaha.com.test.broadcast.brodcastreceiverdemo2.UPDATE_UI";



    static Context mContext;

    public Constant(Context mContext) {
        this.mContext = mContext;
    }

    public static void customToast(String message) {
        Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
        toast.show();
        //Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }

    public static String encodeImage(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);

        return encImage;
    }

    public static Bitmap decodeFromBase64ToBitmap(String encodedImage) {
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);

        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedByte;
    }

    public static Bitmap stringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static String convertMilliToUTC(String millis) {
        SimpleDateFormat sdf = null;
        if (millis != null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            System.out.println(sdf.format(new Date(String.valueOf(millis))));
        }
        return sdf.format(new Date(millis));
    }

    public static String convertMilliToDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yy hh:mm:ss aa", Locale.getDefault());
        String convertedDate = simpleDateFormat.format(Long.parseLong(date));
        Log.d(TAG, "convertMilliToDate..called " + convertedDate);
        return convertedDate;
    }

    public static String convertDateIntoMilli(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yy hh:mm:ss aa", Locale.getDefault());
        long timeInMilliseconds = 0;
        try {
            Date mDate = simpleDateFormat.parse(date);
             timeInMilliseconds = mDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(timeInMilliseconds);
    }

    public static void showToast(Context mContext, String noConnectionError) {
        Toast.makeText(mContext, noConnectionError, Toast.LENGTH_LONG).show();
    }
    public static String convertMilliToUTC123(long time) {

        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yy hh:mm:ss a");
        String dateTime=sdf.format(date);
        return dateTime;
    }


}
