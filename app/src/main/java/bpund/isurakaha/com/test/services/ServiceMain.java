package bpund.isurakaha.com.test.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import bpund.isurakaha.com.test.R;

public class ServiceMain extends AppCompatActivity implements View.OnClickListener {

    Button startButton,stopButton;
   private Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);

        startButton=(Button)findViewById(R.id.btn_start_service);
        stopButton=(Button)findViewById(R.id.btn_stop_service);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_start_service:
                Log.d(getResources().getString(R.string.start_service),"1 "+Thread.currentThread().getId());
                startServices();
                break;
            case R.id.btn_stop_service:
                stopServices();
                break;
        }
    }

    private void stopServices() {
        stopService(new Intent(this,StartStopService.class));
    }

    private void startServices() {
        startService(new Intent(this,StartStopService.class));
    }
}
