package bpund.isurakaha.com.test.broadcast.brodcastreceiverdemo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;

/**
 * Created by isuraksha3 on 4/25/2018.
 */

public class IncommingCallAdapter extends RecyclerView.Adapter<IncommingCallAdapter.MyViewHolder> {

    Context context;
    ArrayList<incomingCalls> incomingCallsArrayList;

    public IncommingCallAdapter(Context context, ArrayList<incomingCalls> incomingCallsArrayList) {
        this.context = context;
        this.incomingCallsArrayList = incomingCallsArrayList;
    }

    @Override
    public IncommingCallAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_incoming_call, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IncommingCallAdapter.MyViewHolder holder, int position) {
        holder.txt_incoming_call_id1.setText(Integer.toString(incomingCallsArrayList.get(position).getId()));
        holder.txt_incoming_call_number2.setText(incomingCallsArrayList.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return incomingCallsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_incoming_call_id1, txt_incoming_call_number2;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_incoming_call_id1 = (TextView) itemView.findViewById(R.id.txt_incoming_call_id1);
            txt_incoming_call_number2 = (TextView) itemView.findViewById(R.id.txt_incoming_call_number2);

        }
    }
}
