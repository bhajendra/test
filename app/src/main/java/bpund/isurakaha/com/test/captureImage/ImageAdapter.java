package bpund.isurakaha.com.test.captureImage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;

/**
 * Created by isuraksha3 on 5/22/2018.
 */

public class ImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<Images> imageList;

    public ImageAdapter(Context context, ArrayList<Images> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
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
        View view = LayoutInflater.from(context).inflate(R.layout.image_items, parent, false);
        ImageView image = (ImageView) view.findViewById(R.id.image_items_view);
        TextView time = (TextView) view.findViewById(R.id.image_items_date_time);
        Images im = imageList.get(position);
        image.setImageBitmap(im.getBitmap());
        String date = Constant.convertMilliToUTC123(im.getTime());
        time.setText(date);
        return view;
    }

}
