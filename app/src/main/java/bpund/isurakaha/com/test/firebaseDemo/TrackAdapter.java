package bpund.isurakaha.com.test.firebaseDemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;

/**
 * Created by isuraksha3 on 4/9/2018.
 */

public class TrackAdapter extends BaseAdapter {

    ArrayList<Tracks> tracksArrayList;
    Context mContext;

    public TrackAdapter( Context mContext ,ArrayList<Tracks> tracksArrayList) {
        this.tracksArrayList = tracksArrayList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return tracksArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return  null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater   layoutInflater = LayoutInflater.from(mContext);
        View view =layoutInflater.inflate(R.layout.track_item,parent,false);
        TextView name=(TextView)view.findViewById(R.id.textViewtrackName);
        TextView ratting=(TextView)view.findViewById(R.id.textView_tracks_ratting);

        Tracks trackRef=tracksArrayList.get(position);
        name.setText(trackRef.getTrackName());
        ratting.setText(trackRef.getTrackRating());

        return view;
    }
}
