package bpund.isurakaha.com.test.broadcast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bpund.isurakaha.com.test.R;

public class SecondActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    BroadCastMain broadCastMain;
    Button btn_send_back;
    EditText edt_take_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn_send_back=(Button)findViewById(R.id.btn_send_return_data);
        edt_take_data=(EditText)findViewById(R.id.edt_send_return_data);
        btn_send_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=edt_take_data.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("data",data);
                setResult(2,intent);
                finish();
            }
        });

        /*IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("isuraksha.FINISH");*/
   /*     broadCastMain=new BroadCastMain();
        broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Intent intent1=new Intent();
                intent.putExtra("result","ABC");
                broadCastMain.setResult(RESULT_OK,intent1);
                Log.d("test","1");
                finish();
            }
        };*/
        // Register broadcast receiver...
      //  registerReceiver(broadcastReceiver,intentFilter); // broadcast recevier ,intentfilter
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    //    unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
/*
        Intent intent=new Intent(SecondActivity.this,MySchedule.class);

        Bundle bundle=new Bundle();
        bundle.putInt("val",8);
        intent.putExtras(bundle);
        pendingIntent=PendingIntent.getBroadcast(getBaseContext(),0,intent,0);
        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 10);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),*/
             /*   pendingIntent);*/
       /* if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
            Log.v("Second Activity", "Scheduled Alarm Cancelled");
        }*/
    }
}
