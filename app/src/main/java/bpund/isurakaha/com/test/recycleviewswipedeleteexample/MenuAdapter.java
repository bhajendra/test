package bpund.isurakaha.com.test.recycleviewswipedeleteexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;

/**
 * Created by isuraksha3 on 4/5/2018.
 */

public class MenuAdapter extends BaseAdapter {

    ArrayList<Item> itemArrayList;
     Context mContext;
    LayoutInflater inflter;

    public MenuAdapter(Context mContext,ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
        this.mContext = mContext;
        inflter = (LayoutInflater.from(mContext));
    }

    @Override
    public int getCount() {
        return itemArrayList.size();
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
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.cart_list_item, null);
        TextView name= (TextView)view.findViewById(R.id.name);
        TextView description= (TextView) view.findViewById(R.id.description);
        TextView price= (TextView) view.findViewById(R.id.price);
        ImageView thumbnail= (ImageView) view.findViewById(R.id.thumbnail);

        Item item=itemArrayList.get(position);
        name.setText(item.getName());
        description.setText(item.getDescription());
        price.setText(String.valueOf(item.getPrice()));
        Glide.with(mContext).load(item.getThumbnail()).into(thumbnail);

        return view;
    }
/*extends RecyclerView.Adapter<MenuAdapter.MyMenuViewHolder> {

    ArrayList<Item> itemArrayList;
    Context mContext;

    public MenuAdapter(Context mContext,ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
        this.mContext = mContext;
    }

    @Override
    public MyMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate layout.
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        View view =layoutInflater.inflate(R.layout.cart_list_item,parent,false);

        return new MyMenuViewHolder(view);
    }

    // set data on view
    @Override
    public void onBindViewHolder(MenuAdapter.MyMenuViewHolder holder, int position) {

        Item item=itemArrayList.get(position);

        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.price.setText(String.valueOf(item.getPrice()));
        Glide.with(mContext).load(item.getThumbnail()).into(holder.thumbnail);
    }
    // return size
    @Override
    public int getItemCount() {
        Log.d("arraysize",""+itemArrayList.size());

        return itemArrayList.size();
    }

    public class MyMenuViewHolder extends RecyclerView.ViewHolder {

        //declare fields
        TextView id;
        TextView name;
        TextView description;
        TextView price;
        ImageView thumbnail;


        public MyMenuViewHolder(View itemView) {
            super(itemView);
            // initialize view....
            name= (TextView) itemView.findViewById(R.id.name);
            description= (TextView) itemView.findViewById(R.id.description);
            price= (TextView) itemView.findViewById(R.id.price);
            thumbnail= (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }*/
}
