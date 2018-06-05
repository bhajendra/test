package bpund.isurakaha.com.test.adapters.arrayAdapter;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import bpund.isurakaha.com.test.R;

/**
 * Created by isuraksha3 on 5/8/2018.
 */

public class ArrayAdapterMainActivity extends Activity {

    ArrayList<String> alist;
    ListView listview;
    ArrayAdapter<String> aa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        // Bhajendra b = new Bhajendra();
        String str = "bhajendra";
        String str1 = "Bhajendra";
        Object obj = str;
        System.out.print("**********"); //
        System.out.print(str.compareToIgnoreCase(str1)); //
        System.out.print(str.compareTo(obj.toString())); // 0
        System.out.print(str1.compareTo(obj.toString())); // 0



    }

    public void sortList(View view) {
        Collections.sort(alist);
        aa.notifyDataSetChanged();
    }

    public void reverseList(View view) {
        Collections.reverse(alist);
        aa.notifyDataSetChanged();
    }

}


// servie
class SeviceDemo extends IntentService {

    // 1 calle super class conturctor

    public SeviceDemo(String name) {
        super(name);
    }


    //2 intent call this method from defaault worker thread.
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }


    }
}
/*

// service example
class HelloService extends Service {

    private Looper mServiceLooper;  // refrence of class

    private ServiceHandler mServiceHandler;
    int THREAD_PRIORITY_BACKGROUND = 100;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        // Start up the thread running the service. Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block. We also make it
        // background priority so CPU-intensive work doesn't disrupt our UI.
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();

        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    private final class ServiceHandler extends Handler { //


        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            // Normally we would do some work here, like download a file.
            // For our sample, we just sleep for 5 seconds.
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // Restore interrupt status.
                Thread.currentThread().interrupt();
            }
            // Stop the service using the startId, so that we don't stop
            // the service in the middle of handling another job
            stopSelf(msg.arg1);
        }

    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }


}


/// local broadcast listner
public class LocalBroadcastExampleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_list);

        Button buttonStartService = (Button) findViewById(R.id.button_ok);
        buttonStartService.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Register MessageService in Manifest to work
                startService(new Intent(LocalBroadcastExampleActivity.this, MessageService.class));
            }
        });

    }

    @Override
    protected void onPause() {
        // Unregister since the activity is paused.
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onPause();
    }

    // Our handler for received Intents. This will be called whenever an Intent
    // with an action named "custom-event-name" is broadcasted.
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            // Get extra data included in the Intent
            String message = intent.getStringExtra("message");
            Log.d("receiver", "Got message: " + message);
        }
    };

    @Override
    protected void onResume() {
        // Register to receive messages.
        // We are registering an observer (mMessageReceiver) to receive Intents
        // with actions named "custom-event-name".
        LocalBroadcastManager.getInstance(this).registerReceiver(
                mMessageReceiver, new IntentFilter("custom-event-name"));
        super.onResume();
    }
}

// service
class MessageService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        sendMessage();
        return super.onStartCommand(intent, flags, startId);
    }

    // Send an Intent with an action named "custom-event-name". The Intent
    // sent should
    // be received by the ReceiverActivity.
    private void sendMessage() {
        Log.d("sender", "Broadcasting message");
        Intent intent = new Intent("custom-event-name");
        // You can also include some extra data.
        intent.putExtra("message", "This is my message!");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

}

interface Bhajendra  // not
{
    void Show();
}

abstract class Amol implements Bhajendra {

}

class kiru extends Amol implements Bhajendra{

    @Override
    public void Show() {

    }

    Bhajendra b = new kiru();


}
*/
