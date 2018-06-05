package bpund.isurakaha.com.test.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bpund.isurakaha.com.test.R;

/**
 * Created by isuraksha3 on 4/18/2018.
 */

public class CustomAdapter extends BaseAdapter {


    List<Hero> list;
    Context mContext;
    public CustomAdapter( Context mContext,List<Hero> list) {
        this.list = list;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return list.size();
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
        View view=layoutInflater.inflate(R.layout.retorfit_itmes,parent,false);
        TextView textView=(TextView)view.findViewById(R.id.retro_name);
        Hero hero=list.get(position);
        textView.setText(hero.getName());

        return view;
    }
}
