package bpund.isurakaha.com.test.broadcast.brodcastreceiverdemo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import bpund.isurakaha.com.test.constants.Constant;

/**
 * Created by isuraksha3 on 4/25/2018.
 */

public class IncomingCallBroadCast extends BroadcastReceiver {
    boolean ringing=false;
    @Override
    public void onReceive(Context context, Intent intent) {

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {

            Toast.makeText(context, "Ringing State", Toast.LENGTH_SHORT).show();
            String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            DbHelperReadPhoneCall dbHelperReadPhoneCall = new DbHelperReadPhoneCall(context);
            SQLiteDatabase db = dbHelperReadPhoneCall.getWritableDatabase();
            new DBManagerReadPhoneCall(context).saveNumber(number, db);
        }
        // send broadcast receiver....
        Intent sendBroadCast = new Intent(Constant.UPDATE_UI_FILETER);
        context.sendBroadcast(sendBroadCast);

    }
}
