package bpund.isurakaha.com.test.ActivityLifeCycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import bpund.isurakaha.com.test.R;

public class ActivityTwo extends AppCompatActivity {

    String TAG=ActivityTwo.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.d(TAG,"onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");

    }
    public void  activityTwo(View v)
    {
        Intent intent=new Intent(this,ActivityOne.class);
        startActivity(intent);
        finish();


    }

}
