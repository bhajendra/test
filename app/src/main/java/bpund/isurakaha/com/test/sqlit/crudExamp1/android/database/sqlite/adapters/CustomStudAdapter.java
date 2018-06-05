package bpund.isurakaha.com.test.sqlit.crudExamp1.android.database.sqlite.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.sqlit.crudExamp1.android.database.sqlite.Stud;

/**
 * Created by isuraksha3 on 5/23/2018.
 */

public class CustomStudAdapter extends BaseAdapter {

    Context context;
    ArrayList<Stud> arraylist;

    public CustomStudAdapter(Context context, ArrayList<Stud> arraylist) {
        this.context = context;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
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

        View view = LayoutInflater.from(context).inflate(R.layout.stud_layout, parent, false);
        TextView txt_stud_items_id = (TextView) view.findViewById(R.id.txt_stud_items_id);
        TextView txtstud_items_name = (TextView) view.findViewById(R.id.txtstud_items_name);
        Stud studObje = arraylist.get(position);
        txt_stud_items_id.setText(String.valueOf(studObje.getId()));
        txtstud_items_name.setText(studObje.getName());
        return view;
    }

}
