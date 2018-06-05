package bpund.isurakaha.com.test.sqlit.login.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;
import bpund.isurakaha.com.test.firebaseDemo.RecyclerTouchListener;
import bpund.isurakaha.com.test.sqlit.adapter.UserLoginRegisterCustomAdapter;
import bpund.isurakaha.com.test.sqlit.database.manager.DatabaseManager;
import bpund.isurakaha.com.test.sqlit.model.LoginRegister;
import bpund.isurakaha.com.test.sqlit.model.MyDividerItemDecoration;

public class UserDetailsActivity extends AppCompatActivity {
    String TAG=UserDetailsActivity.class.getSimpleName();
    Context mContext;
    UserLoginRegisterCustomAdapter userCustomAdapter;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        mContext=this;
        recyclerView=(RecyclerView)findViewById(R.id.user_recycle_view);
        ArrayList<LoginRegister> getAllRecord= new DatabaseManager(mContext).getAllRecord();
        Log.d(TAG, String.valueOf(getAllRecord.size()));
        recyclerView.setHasFixedSize(true);
        userCustomAdapter=new UserLoginRegisterCustomAdapter(mContext,getAllRecord);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 10));

        recyclerView.setAdapter(userCustomAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                Log.d(TAG, "onClick");
                // get view id
                TextView id=(TextView) view.findViewById(R.id.user_items_id);
                TextView names=(TextView) view.findViewById(R.id.user_name_item);
                TextView password=(TextView) view.findViewById(R.id.user_pass_item);
                TextView date=(TextView) view.findViewById(R.id.user_created_date_item);
                Log.d(TAG, "onClick get vie id and data " +names +" "+password +" "+ date);
                //get data from view id.

                String ids= id.getText().toString();
                String userName= names.getText().toString();
                String userPassword= password.getText().toString();
                String userDate =date.getText().toString();
                Log.d(TAG, "onClick get data from viewID" +ids+" "+userName +" "+userPassword +" "+ userDate);

                Intent intent=new Intent(UserDetailsActivity.this,EditUseDetails.class);
                 intent.putExtra(Constant.EDIT_ID,ids);
                 intent.putExtra(Constant.EDIT_NAME,userName);
                 intent.putExtra(Constant.EDIT_PASSWORD,userPassword);
                 intent.putExtra(Constant.EDIT_DATE,userDate);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Log.d(TAG, "onLongClick");
            }
        }));

    }
}
