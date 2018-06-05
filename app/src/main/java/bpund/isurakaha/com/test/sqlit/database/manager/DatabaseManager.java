package bpund.isurakaha.com.test.sqlit.database.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import bpund.isurakaha.com.test.sqlit.database.helper.SQLiteHelper;
import bpund.isurakaha.com.test.sqlit.login.registration.LoginAcitivy;
import bpund.isurakaha.com.test.sqlit.model.LoginRegister;

/**
 * Created by isuraksha3 on 4/19/2018.
 */

public class DatabaseManager {

    private static final String TAG = LoginAcitivy.class.getSimpleName();
    static SQLiteDatabase db;
    Context c;
    static SQLiteHelper sqLiteHelper;

    public DatabaseManager() {
    }

    public DatabaseManager(Context c) {
        this.c = c;
    }

    public DatabaseManager(Context c, SQLiteHelper sqLiteHelper) {
        this.c = c;
        this.sqLiteHelper = sqLiteHelper;
    }

    // OPEN DB.
    public void openDb() {
        db = sqLiteHelper.getWritableDatabase();
    }

    // CLOSE DB.
    public void closeDb() {
        sqLiteHelper.close();
    }

    // insert query...
    //(String table, String nullColumnHack, ContentValues values)
    public long insert(String name, String password, long currentMillis) {
        Log.d(TAG, "insert..");
        long recoredInserted;
        sqLiteHelper = new SQLiteHelper(c);
        db = sqLiteHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteHelper.NAME, name);
        contentValues.put(SQLiteHelper.PASSWORD, password);
        contentValues.put(SQLiteHelper.COLUMN_TIME_STAMP, currentMillis);

        recoredInserted = db.insert(SQLiteHelper.TABLE_NAME, null, contentValues);
        Log.d("inserted record", String.valueOf(recoredInserted));
        return recoredInserted;
    }

    // check userIsEXIST OR NOT
    //
    /*String table, String[] columns,
    String selection, String[] selectionArgs, String groupBy,
    String having, String orderBy, String limit
    */
    public boolean checkUserExist(String userName) {
        Log.d(TAG, "checkUserExist..");
        String[] cols = {SQLiteHelper.NAME};
        String selection = SQLiteHelper.NAME + "=?";
        String[] selectionArg = {userName};
        String limit = "1";
        sqLiteHelper = new SQLiteHelper(c);
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();

        Cursor cursor = db.query(SQLiteHelper.TABLE_NAME, cols, selection, selectionArg, null, null, null, limit);
        boolean isUserExist = (cursor.getCount() > 0);
        cursor.close();
        return isUserExist;
    }

    public boolean checkUserExistForRegistration(String userName) {
        Log.d(TAG, "checkUserExistForRegistration..");
        boolean userIsAllReadyExist = false;
        String[] cols = {SQLiteHelper.NAME};
        String selection = SQLiteHelper.NAME + "=?";
        String[] selectionArg = {userName};
        //String limit = "1";
        sqLiteHelper = new SQLiteHelper(c);
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();

        Cursor cursor = db.query(SQLiteHelper.TABLE_NAME, cols, selection, selectionArg, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex(SQLiteHelper.NAME));
                    if (name.equals(userName)) {
                        userIsAllReadyExist = true;
                    }

                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        return userIsAllReadyExist;
    }

    public ArrayList<LoginRegister> getAllRecord() {
        //1 select query...
        //2 sqlite refrence to read data
        //3 curser query
        //4 iterate over cursor.
        //5 add to arraylist
        //6 close cursor
        // 7 return arraylis refrence...
        String query = "select * from " + SQLiteHelper.TABLE_NAME + " order by " + SQLiteHelper.COLUMN_TIME_STAMP + " desc";

        sqLiteHelper = new SQLiteHelper(c);
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<LoginRegister> loginRegistersList = new ArrayList<>();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    LoginRegister loginRegister = new LoginRegister();
                    loginRegister.setId(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.KEY_ID)));
                    loginRegister.setName(cursor.getString(cursor.getColumnIndex(SQLiteHelper.NAME)));
                    loginRegister.setPassword(cursor.getString(cursor.getColumnIndex(SQLiteHelper.PASSWORD)));
                    loginRegister.setTimeStamp(cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLUMN_TIME_STAMP)));
                    loginRegistersList.add(loginRegister);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return loginRegistersList;
    }

    //String table, ContentValues values, String whereClause, String[] whereArgs
    public int update(long editId, String name, String password, String millisecond) {
        ContentValues val = new ContentValues();
        sqLiteHelper = new SQLiteHelper(c);
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();

        val.put(SQLiteHelper.NAME, name);
        val.put(SQLiteHelper.PASSWORD, password);
        val.put(SQLiteHelper.COLUMN_TIME_STAMP, millisecond);
        int updateRecord = db.update(SQLiteHelper.TABLE_NAME, val, SQLiteHelper.KEY_ID + " = " + editId, null);
        return updateRecord;
    }
    //String table, String whereClause, String[] whereArgs
    public int delete(long editId)
    {
        sqLiteHelper = new SQLiteHelper(c);
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        int deleteRecord=db.delete(SQLiteHelper.TABLE_NAME,SQLiteHelper.KEY_ID + "="+editId,null);
        return deleteRecord;
    }
}
