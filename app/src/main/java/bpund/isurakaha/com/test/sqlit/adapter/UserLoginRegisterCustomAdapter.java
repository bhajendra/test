package bpund.isurakaha.com.test.sqlit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;
import bpund.isurakaha.com.test.sqlit.model.LoginRegister;

/**
 * Created by isuraksha3 on 4/20/2018.
 */

public class UserLoginRegisterCustomAdapter extends RecyclerView.Adapter<UserLoginRegisterCustomAdapter.MyViewHolder> {

    String TAG = UserLoginRegisterCustomAdapter.class.getSimpleName();
    ArrayList<LoginRegister> userLoginRegisterDataList;
    Context mContext;

    public UserLoginRegisterCustomAdapter(Context mContext, ArrayList<LoginRegister> userLoginRegisterDataList) {
        this.userLoginRegisterDataList = userLoginRegisterDataList;
        this.mContext = mContext;
        Log.d(TAG, "UserLoginRegisterCustomAdapter Constructor..called");
    }

    @Override
    public UserLoginRegisterCustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder..called");
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.login_register_item, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(UserLoginRegisterCustomAdapter.MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder..called");
        LoginRegister userData = userLoginRegisterDataList.get(position);
        holder.user_items_id.setText(String.valueOf(userData.getId()));
        holder.name.setText(userData.getName());
        holder.password.setText(userData.getPassword());
        holder.date.setText(Constant.convertMilliToDate(userData.getTimeStamp()));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount..called");
        return userLoginRegisterDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user_items_id,name, password, date;

        public MyViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "MyViewHolder..called");

            user_items_id = (TextView) itemView.findViewById(R.id.user_items_id);
            name = (TextView) itemView.findViewById(R.id.user_name_item);
            password = (TextView) itemView.findViewById(R.id.user_pass_item);
            date = (TextView) itemView.findViewById(R.id.user_created_date_item);
            
        }
    }
}
