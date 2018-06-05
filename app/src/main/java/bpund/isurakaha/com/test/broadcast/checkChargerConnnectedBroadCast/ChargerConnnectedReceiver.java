package bpund.isurakaha.com.test.broadcast.checkChargerConnnectedBroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ChargerConnnectedReceiver extends BroadcastReceiver {

    public ChargerConnnectedReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context,"Hi bhajendra charger Connected",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context, "Hi bhajendra  charger DisConnected", Toast.LENGTH_LONG).show();
        }
    }
}
