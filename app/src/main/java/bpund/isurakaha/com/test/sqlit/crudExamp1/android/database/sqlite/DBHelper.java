package bpund.isurakaha.com.test.sqlit.crudExamp1.android.database.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by isuraksha3 on 5/23/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String TAG = DBHelper.class.getName();
    public static final String DATABASE_NAME = "Isuraksha";
    public static final String TABLE_NAME = "Infotable";
    public static final int DATABASE_VERSION = 1;

    public static final String ID = "id";
    public static final String NAME = "name";

    // query for create table
    String create = "create table " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NAME + " TEXT" + ")";

    //Context context, String name, SQLiteDatabase.CursorFactory factory, int version
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create);
        Log.d(TAG, "onCreate ss");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF NOT EXIST" + TABLE_NAME);
        Log.d(TAG, "onUpgrade ss");
        db.execSQL(create);
        Log.d(TAG, "db.execSQL(create); ss");


    }
}
