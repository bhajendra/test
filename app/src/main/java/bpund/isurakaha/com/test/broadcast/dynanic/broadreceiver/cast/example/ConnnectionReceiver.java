package bpund.isurakaha.com.test.broadcast.dynanic.broadreceiver.cast.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by isuraksha3 on 5/18/2018.
 */

public class ConnnectionReceiver extends BroadcastReceiver {

    final String ACTION = "com.isuraksha.action.Send";
    Context context;

    public ConnnectionReceiver() {
    }

    ConnnectionReceiver(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(ACTION)) {
            Toast.makeText(context, "onReceive " + ACTION, Toast.LENGTH_LONG).show();
        } else {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            boolean IsConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();
            if (IsConnected) {
                Toast.makeText(context, "Network is connected", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "Network is Disconnected", Toast.LENGTH_LONG).show();
            }
        }


    }
}
