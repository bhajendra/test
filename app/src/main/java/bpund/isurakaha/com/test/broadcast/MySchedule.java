package bpund.isurakaha.com.test.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by isuraksha3 on 4/17/2018.
 */

public class MySchedule extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MySchedule", "Intent Fired");
        Toast.makeText(context, "Session Timeout", Toast.LENGTH_LONG).show();

        Intent intent1=new Intent();
        intent1.setAction("isuraksha.FINISH");
        context.sendBroadcast(intent1);
    }
}
