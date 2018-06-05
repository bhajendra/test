package bpund.isurakaha.com.test.json.parsing;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;

/**
 * Created by isuraksha3 on 4/24/2018.
 */

public class CustomAdapter18 extends BaseAdapter {

    Context mContext;
    // ArrayList<StudeBean> studeBeen;
    ArrayList<Flower> flowerAllData;
    public CustomAdapter18(Context mContext, ArrayList<Flower> flowerAllData) {
        this.mContext = mContext;
        this.flowerAllData = flowerAllData;
    }
    /*public CustomAdapter18(Context mContext, ArrayList<StudeBean> studeBeen) {
        this.mContext = mContext;
        this.studeBeen = studeBeen;
    }*/

    @Override
    public int getCount() {
        return flowerAllData.size();// return data set
    }

    @Override
    public Object getItem(int position) {
        Log.d("getItem ",  String.valueOf(flowerAllData.get(position)));

        return null;
    }

    @Override
    public long getItemId(int position) {
        Log.d("getItemId ", String.valueOf(flowerAllData.get(position)));

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.list_items_test, parent, false);
        TextView name = (TextView) view.findViewById(R.id.list_test_name);
        Flower obj = flowerAllData.get(position);
        name.setText(obj.getName());
        return view;
    }
}
