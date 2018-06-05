package bpund.isurakaha.com.test.broadcast.brodcastreceiverdemo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by isuraksha3 on 4/24/2018.
 */

public class DBManagerReadPhoneCall {

    Context context;

    public DBManagerReadPhoneCall(Context context) {
        this.context = context;
    }

    public void saveNumber(String number, SQLiteDatabase sqLiteDatabase) {
        Log.d("insetNumber", "call");
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelperReadPhoneCall.NUMBER, number);
        long i = sqLiteDatabase.insert(DbHelperReadPhoneCall.TABLE_NAME, null, contentValues);
        Log.d("save record", String.valueOf(i));
    }

    public ArrayList<incomingCalls>  getNumberList() {

        ArrayList<incomingCalls> incomingCallsArrayList = new ArrayList<>();
        DbHelperReadPhoneCall dbHelperReadPhoneCall = new DbHelperReadPhoneCall(context);
        SQLiteDatabase db = dbHelperReadPhoneCall.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + DbHelperReadPhoneCall.TABLE_NAME;
        Cursor cur= db.rawQuery(selectQuery, null);
        incomingCallsArrayList.clear();
        if (cur.getCount() > 0) {
            if (cur.moveToFirst()){
                do {
                    incomingCalls incomingCalls = new incomingCalls();
                    incomingCalls.setId(cur.getInt(cur.getColumnIndex("id")));
                    incomingCalls.setNumber(cur.getString(cur.getColumnIndex(DbHelperReadPhoneCall.NUMBER)));
                    incomingCallsArrayList.add(incomingCalls);
                }while (cur.moveToNext());
            }
        }
        cur.close();
        return  incomingCallsArrayList;
    }
}
