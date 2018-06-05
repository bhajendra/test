package bpund.isurakaha.com.test.sqlit.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by isuraksha3 on 4/19/2018.
 */
//expend ==spend
public class SQLiteHelper extends SQLiteOpenHelper {

    //database version code
    public static final int DATABASE_VERSION = 2;
    //database name
    public static final String DATABASE_NAME = "LogRegister";
    // table name
    public static final String TABLE_NAME = "LoginnRegister";
    // field name
     public static final String KEY_ID = "id";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String CONFIRM_PASSWORD = "confirm_password";
    public static final String COLUMN_TIME_STAMP = "timeStamp";

    // table query
    String create_table = "create table " + TABLE_NAME + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NAME + " TEXT,"
            + COLUMN_TIME_STAMP + " TEXT,"
            + PASSWORD + " TEXT" + ")";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
