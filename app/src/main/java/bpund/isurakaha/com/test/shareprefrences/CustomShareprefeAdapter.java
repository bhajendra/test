package bpund.isurakaha.com.test.shareprefrences;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;

/**
 * Created by isuraksha3 on 4/19/2018.
 */

public class CustomShareprefeAdapter extends BaseAdapter {

    private ArrayList<Student> studentArrayLis;
    private Context mContext;

    CustomShareprefeAdapter(Context mContext, ArrayList<Student> studentArrayLis) {
        this.studentArrayLis = studentArrayLis;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return studentArrayLis.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        View view=layoutInflater.inflate(R.layout.share_prefe_single_itemlist,parent,false);

        TextView textView=(TextView)view.findViewById(R.id.share_pref_list_item_name);
        Student stud=studentArrayLis.get(position);
        textView.setText(stud.getName());

        return view;
    }
}
