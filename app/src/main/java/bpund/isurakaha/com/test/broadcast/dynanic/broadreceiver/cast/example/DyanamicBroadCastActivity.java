package bpund.isurakaha.com.test.broadcast.dynanic.broadreceiver.cast.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import bpund.isurakaha.com.test.R;

public class DyanamicBroadCastActivity extends Activity {

    final String ACTION = "com.isuraksha.action.Send";
    ConnnectionReceiver connnection;
    IntentFilter intentFilter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dyanamic_broad_cast);
        context=this;
        connnection = new ConnnectionReceiver(context);
        intentFilter = new IntentFilter(ACTION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // regitster broadcast
        registerReceiver(connnection, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // unregiter broadcast
        unregisterReceiver(connnection);
    }

    public void dynamicBrodcast(View v) {
        // send action to perform.
        Intent intent = new Intent(ACTION);
        sendBroadcast(intent);
        Toast.makeText(this, "send broad cast", Toast.LENGTH_LONG).show();
    }
}

