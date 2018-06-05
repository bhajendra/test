package bpund.isurakaha.com.test.broadcast.local.broad.cast.receiver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import bpund.isurakaha.com.test.R;

public class ReceiveBroadCast extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_broad_cast);
        context = this;

        sendMessage();
    }
    private void sendMessage() {

        Intent intent=new Intent("local.broad.send.bhajendra1");
        intent.putExtra("message","hi bhajendra");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        Log.d("LocalBroadcast200","sendMessage Success end...");
    }
}
