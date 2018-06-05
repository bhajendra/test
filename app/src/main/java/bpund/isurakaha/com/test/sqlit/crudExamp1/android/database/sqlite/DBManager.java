package bpund.isurakaha.com.test.sqlit.crudExamp1.android.database.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by isuraksha3 on 5/23/2018.
 */

public class DBManager {

    public static final String TAG = DBManager.class.getName();
    DBHelper dbHelper;
    SQLiteDatabase database;
    Context context;

    public DBManager(Context context) {
        this.context = context;
    }

    String[] allColms = {DBHelper.ID, DBHelper.NAME};

    // open db
    public DBManager open() {
        Log.d(TAG, "open");
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    //close db
    public void close() {
        Log.d(TAG, "close");
        database.close();
    }

    // add record
    //String table, String nullColumnHack, ContentValues values
    public long insetRecord(String name) {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.NAME, name);
        long insert = database.insert(DBHelper.TABLE_NAME, null, cv);
        Log.d(TAG, "insetRecord " + insert);

        return insert;

    }

    // get data
    //String table, String[] columns, String selection
    //String selection, String[] selectionArgs, String groupBy,
    //String having, String orderBy, String limit
    public ArrayList<Stud> getAllRecord() {
        ArrayList<Stud> arrayList = new ArrayList<>();

        Cursor cur = database.query(DBHelper.TABLE_NAME, allColms, null, null, null, null, null, null);
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {
                    Stud stud = new Stud();
                    stud.setId(cur.getInt(cur.getColumnIndex(DBHelper.ID)));
                    stud.setName(cur.getString(cur.getColumnIndex(DBHelper.NAME)));
                    arrayList.add(stud);
                } while (cur.moveToNext());
            }
        }
        Log.d(TAG, "getAllRecord " + arrayList.size());

        return arrayList;
    }

    // update
    //String table, ContentValues values, String whereClause, String[] whereArgs
    public int update(long updateById, String name) {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.NAME, name);
        int update = database.update(DBHelper.TABLE_NAME, cv, DBHelper.ID + "=" + updateById, null);
        Log.d(TAG, "update " + update);

        return update;
    }

    // delete
    //String table, String whereClause, String[] whereArgs
    public int delete(long updateById) {

        int delete = database.delete(DBHelper.TABLE_NAME, DBHelper.ID + "=" + updateById, null);
        Log.d(TAG, "delete " + delete);
        return delete;
    }


}
