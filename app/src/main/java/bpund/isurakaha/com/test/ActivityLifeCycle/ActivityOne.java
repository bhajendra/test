package bpund.isurakaha.com.test.ActivityLifeCycle;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import bpund.isurakaha.com.test.R;

public class ActivityOne extends AppCompatActivity {

    String TAG = ActivityOne.class.getSimpleName();

    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        Log.d(TAG, "onCreate");
        activity=this;
       // callMap();
    }


    private void ShowAlertDialog(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("bhajendra");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity,"setPositiveButton",Toast.LENGTH_LONG).show();

            }
        });
        builder.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity,"setNegativeButton",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog buildershow= builder.create();
        buildershow.show();
    }
    private void callMap() {

        ArrayList<HashMap<String, String>> arraylist = new ArrayList<>();

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("name", "bhajendra");
        map1.put("name1", "bhajendra1");
        map1.put("name2", "bhajendra2");
        map1.put("name3", "bhajendra3");
        arraylist.add(map1);
        HashMap<String, String> map2 = new HashMap<>();
        map1.put("name", "bhajendra");
        map1.put("name4", "bhajendra1");
        map1.put("name5", "bhajendra2");
        map1.put("name6", "bhajendra3");
        arraylist.add(map2);

        for (HashMap<String, String> map : arraylist) {
            Collections.synchronizedMap(map);
            for (String key : map.keySet()) {

                Log.d("key ", key + " " + map.get(key));
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
       // ShowAlertDialog(activity);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");

    }

    public void activityOne(View v) {
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG,"onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.d(TAG,"onRestoreInstanceState");

    }
}
