package bpund.isurakaha.com.test.firebaseDemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;

/**
 * Created by isuraksha3 on 4/7/2018.
 */

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.MyViewHolder> implements View.OnLongClickListener {
    final String TAG = ArtistAdapter.class.getSimpleName();
    Context mContext;
    ArrayList<Artist> artistArrayList;
    DatabaseReference databaseReference;
     final int PICK_IMAGE_REQUEST=200;
    public ArtistAdapter(Context mContext, ArrayList<Artist> artistArrayList) {
        this.mContext = mContext;
        this.artistArrayList = artistArrayList;
        databaseReference = FirebaseDatabase.getInstance().getReference("artist");
    }

    public ArtistAdapter() {
    }

    // inflate layout
    @Override
    public ArtistAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.layout_artist_list, parent, false);

        return new MyViewHolder(view);
    }

    // bind data on view
    @Override
    public void onBindViewHolder(ArtistAdapter.MyViewHolder holder, int position) {
        Artist artistRef = artistArrayList.get(position);
        holder.name.setText(artistRef.getArtistName());
        holder.gen.setText(artistRef.getArtistGenre());
        String longToString=String.valueOf(artistRef.getCurrentMills());
        if (longToString != null){
            String time= Constant.convertMilliToUTC(longToString);
            holder.textView_time.setText(time);
        }
        if (artistRef.getImageFilePath() != null) {
            Glide.with(mContext).load(artistRef.getImageFilePath()).into(holder.image);
        }
    }

    // return the data size
    @Override
    public int getItemCount() {
        return artistArrayList.size();
    }

    @Override
    public boolean onLongClick(View view) {
        MyViewHolder holder = (MyViewHolder) view.getTag();
        int position = holder.getLayoutPosition();
        Log.d("testing ", "pos" + position);

        return true;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name, gen,textView_time;
        ImageView image;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.textViewartistitemsName);
            gen = (TextView) view.findViewById(R.id.textViewartistitemGenre);
            image = (ImageView) view.findViewById(R.id.artist_items_image);
            textView_time = (TextView) view.findViewById(R.id.textViewartist_times);

        }
    }



}
