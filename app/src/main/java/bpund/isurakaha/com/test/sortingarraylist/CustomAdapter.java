package bpund.isurakaha.com.test.sortingarraylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;

/**
 * Created by isuraksha3 on 4/12/2018.
 */

public class CustomAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<Student> studentArrayList;

    public CustomAdapter(Context mContext, ArrayList<Student> students) {
        this.mContext = mContext;
        studentArrayList = students;
    }

    @Override
    public int getCount() {
        return studentArrayList.size();
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
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.list_items_test, parent, false);
        TextView name = (TextView) view.findViewById(R.id.list_test_name);

        Student student = studentArrayList.get(position);
        name.setText(student.getName());
        return view;
    }
}
