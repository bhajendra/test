package bpund.isurakaha.com.test.firebaseDemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;

public class TrackActivity extends AppCompatActivity {

    Context mContext;
    DatabaseReference databaseReference;
    ArrayList<Tracks> tracksArrayList;
    EditText name;
    TextView textViewRating;
    SeekBar seekBar;
    Button addTrack;
    TrackAdapter trackAdapter;
    ListView listViewTracks;
    //TackAdapter tackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        mContext = this;
        Intent intent = getIntent();
        // get artist id and make forigen key with track table
        databaseReference = FirebaseDatabase.getInstance().getReference("tracks").child(intent.getStringExtra(Constant.ARTIST_ID));
        tracksArrayList = new ArrayList<>();
        name = (EditText) findViewById(R.id.editTextName);
        seekBar = (SeekBar) findViewById(R.id.seekBarRating);
        textViewRating = (TextView) findViewById(R.id.textViewRating);
        addTrack = (Button) findViewById(R.id.buttonAddTrack);
        listViewTracks = (ListView) findViewById(R.id.listViewTracks);

        //trackAdapter=new TrackAdapter(mContext,tracksArrayList);
        addTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTrack();
            }
        });
    }

    private void addTrack() {

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewRating.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        String trackName = name.getText().toString().trim();
        int rating = seekBar.getProgress();
        if (!TextUtils.isEmpty(trackName)) {
            // push to unique id.
            String id = databaseReference.push().getKey();
            Tracks tracks = new Tracks(id, trackName, String.valueOf(rating));
            databaseReference.child(id).setValue(tracks);
            Toast.makeText(this, "Track Name is Added", Toast.LENGTH_LONG).show();
            name.setText("");
            getData();
        } else {
            Toast.makeText(this, "Track Name is Empty", Toast.LENGTH_LONG).show();
        }
    }

    private void getData() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    Tracks data = dataSnapshot1.getValue(Tracks.class);
                    tracksArrayList.add(data);
                    trackAdapter = new TrackAdapter(mContext, tracksArrayList);
                    listViewTracks.setAdapter(trackAdapter);
                    trackAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        getData();
    }
}
