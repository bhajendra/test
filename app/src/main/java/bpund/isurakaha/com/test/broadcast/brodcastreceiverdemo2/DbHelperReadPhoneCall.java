package bpund.isurakaha.com.test.broadcast.brodcastreceiverdemo2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by isuraksha3 on 4/24/2018.
 */

public class DbHelperReadPhoneCall extends SQLiteOpenHelper{

    //database version code
    public static final int DATABASE_VERSION = 1;
    //database name
    public static final String DATABASE_NAME = "ReadPhoneCall";
    // table name
    public static final String TABLE_NAME = "ReadPhoneCall";
    // field name
    public static final String KEY_ID = "id";
    public static final String NUMBER = "number";
    // table query
    String create_table = "create table " + TABLE_NAME + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NUMBER + " TEXT" + ")";
    public DbHelperReadPhoneCall(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);
        Log.d("dbhelper", "onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
