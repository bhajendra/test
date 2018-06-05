package bpund.isurakaha.com.test.broadcast.brodcastreceiverdemo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;

public class ReadPhonCallBrodcastMain extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Context mContext;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_phon_call_brodcast_main);
        mContext = this;
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_broad_cast);
        layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        mapintoArrayAndString();
        //readCall();
     /*   broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                readCall();
            }
        };
*/
    }

    private void mapintoArrayAndString() {

        Map<String,ArrayList<Employee>> stringArrayListMap=new HashMap<>();
        ArrayList<Employee> emp=new ArrayList<>();
        emp.add(new Employee(1,"bhajendra"));
        emp.add(new Employee(2,"bhaje"));

        stringArrayListMap.put("empDetails",emp);

        for (Map.Entry<String,ArrayList<Employee>> val:stringArrayListMap.entrySet()) {
            ArrayList<Employee> Employee=val.getValue();
            for (Employee employee:Employee){
                Log.d("details",employee.getId() +" "+ employee.getName());
            }
        }
    }

    public void readCall() {

        DBManagerReadPhoneCall dbManagerReadPhoneCall = new DBManagerReadPhoneCall(mContext);
        ArrayList<incomingCalls> incomingCallsArrayList = dbManagerReadPhoneCall.getNumberList();
        IncommingCallAdapter incommingCallAdapter = new IncommingCallAdapter(mContext, incomingCallsArrayList);
        recyclerView.setAdapter(incommingCallAdapter);
        incommingCallAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter(Constant.UPDATE_UI_FILETER));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }
    class Employee{

        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
