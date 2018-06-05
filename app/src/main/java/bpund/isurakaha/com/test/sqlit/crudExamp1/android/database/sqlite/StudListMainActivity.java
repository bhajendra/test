package bpund.isurakaha.com.test.sqlit.crudExamp1.android.database.sqlite;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.sqlit.crudExamp1.android.database.sqlite.adapters.CustomStudAdapter;

public class StudListMainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = StudListMainActivity.class.getName();

    Context context;
    DBManager dbManager;
    CustomStudAdapter customStudAdapter;
    ListView stud_listview;
    ArrayList<Stud> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_list_main);
        stud_listview = (ListView) findViewById(R.id.stud_listview);
        context = this;
        dbManager = new DBManager(context);
        dbManager.open();

        arraylist = dbManager.getAllRecord();
        Log.d(TAG, " @ " + arraylist.size());
        customStudAdapter = new CustomStudAdapter(context, arraylist);
        customStudAdapter.notifyDataSetChanged();
        stud_listview.setAdapter(customStudAdapter);

        stud_listview.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // infalte layout
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.stud_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_stude:
                invokeAddRecordActivity();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private void invokeAddRecordActivity() {
        //*********Activity
        Intent intent = new Intent(StudListMainActivity.this, AddStudeActivity.class);
        startActivity(intent);

/*
        // start sevice
        /*//*********Service
         Intent intentStartService = new Intent(StudListMainActivity.this, TestSevice.class);
         startService(intentStartService);
         Toast.makeText(this, "intentStartService", Toast.LENGTH_LONG).show();*/

        //*********BroadCast

        // send Broad Cast method 1


      /*  Intent intentSendBroadCast = new Intent("com.isuraksha.broadcast");
        intentSendBroadCast.putExtra("message", "BroadCastRecier method 1111");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intentSendBroadCast); // //local brodcast
        Toast.makeText(this, "intentSendBroadCast", Toast.LENGTH_LONG).show();*/

        // send Broad Cast method 2
        // this use intent-fileter in manifest to receive the action
      /*  Intent intentSendBroadCast1 = new Intent();
        intentSendBroadCast1.setAction("com.isuraksha.broadcast");
        intentSendBroadCast.putExtra("message", "BroadCastRecier method 2222");
        sendBroadcast(intentSendBroadCast1);*/
    }

    @Override
    protected void onResume() {
        if (context != null) {
            Intent intents = new Intent("local.broad.send.bhajendra");
            intents.putExtra("message", "hi bhajendra");
            LocalBroadcastManager.getInstance(context).sendBroadcast(intents);
            Log.d("LocalBroadcast", "sendMessage Success end...");
        }


        super.onResume();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Stud selectedData = arraylist.get(position);
        Intent intent = new Intent(StudListMainActivity.this, EditDeleteActivity.class);
        intent.putExtra("id", String.valueOf(selectedData.getId()));
        intent.putExtra("name", selectedData.getName());
        startActivity(intent);


    }
}
