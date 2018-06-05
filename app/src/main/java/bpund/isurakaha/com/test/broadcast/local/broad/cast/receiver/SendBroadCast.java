package bpund.isurakaha.com.test.broadcast.local.broad.cast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import bpund.isurakaha.com.test.R;

public class SendBroadCast extends AppCompatActivity {
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_broad_cast);
        mContext = this;
      /*  Intent intent=new Intent(SendBroadCast.this,MessageService.class);
        startService(intent);
*/

    }
public void brodcast(View v){

    Intent intent=new Intent(SendBroadCast.this,ReceiveBroadCast.class);
    startActivity(intent);

}
    @Override
    protected void onResume() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("local.broad.send.bhajendra1");
        LocalBroadcastManager.getInstance(mContext).registerReceiver(broadcastReceiver, intentFilter);
        Log.d("LocalBroadcast200", "registerReceiver");
        super.onResume();
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(broadcastReceiver);
        Log.d("LocalBroadcast", "unregisterReceiver");
        super.onPause();
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("LocalBroadcast200", "BroadcastReceiverReceive");
            String message = intent.getStringExtra("message");
            Log.d("LocalBroadcast200", message);
        }
    };

}
