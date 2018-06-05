package bpund.isurakaha.com.test.broadcast.local.boradcast.receiver1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import bpund.isurakaha.com.test.R;

public class BroadCastActivity extends AppCompatActivity {

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        button = (Button) findViewById(R.id.btn_local_receiver);

    }

    @Override
    protected void onPause() {
        super.onPause();
        // unregister broadcast
              //  LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // register broacast
     /*   IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BroadReceiverIntentService.CUSTOM_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);*/

    }
    // receiver broad cast from....

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // class lever anymous innter class
        @Override
        public void onReceive(Context context, Intent intent) {
            // data always receiver in intent..
             String date = intent.getStringExtra("dates");
            Log.d("BroadReceiverService", date);
        }
    };

    public void locatBroadCast(View v) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BroadCastActivity.this, "service starte", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BroadCastActivity.this, BroadReceiverIntentService.class);
                startService(intent);


            }
        });
    }

}
