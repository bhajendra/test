package bpund.isurakaha.com.test.broadcast.checkChargerConnnectedBroadCast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bpund.isurakaha.com.test.R;

public class ChargerConnectActivity extends AppCompatActivity {

    ChargerConnnectedReceiver chargerConnnectedReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charger_connect);
        chargerConnnectedReceiver=new ChargerConnnectedReceiver();

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(chargerConnnectedReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(chargerConnnectedReceiver);
    }
}
