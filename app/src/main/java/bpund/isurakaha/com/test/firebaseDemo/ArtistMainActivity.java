package bpund.isurakaha.com.test.firebaseDemo;
//firebase auth
/*http://javasampleapproach.com/android/firebase-storage-get-list-files-display-image-firebase-ui-database-android*/

// digital signature
//https://androidmads.blogspot.in/2015/10/digital-signature-in-android.html

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;
import bpund.isurakaha.com.test.firebaseDemo.push.notification.app.Config;

public class ArtistMainActivity extends AppCompatActivity implements View.OnClickListener {

    final String TAG = ArtistMainActivity.class.getSimpleName();
    TextView editArtistName;
    Spinner spinnerGenres;
    Button buttonAddArtist, selectImage;
    ArrayList<Artist> artistArrayList;
    DatabaseReference databaseReference;
    //ListView listView;
    RecyclerView recyclerView;
    ArtistAdapter artistAdapter;
    Context mContext;
    ImageView imageView;
    final int PICK_IMAGE_REQUEST = 100;
    final int PICK_IMAGE_REQUEST_UPDATE = 200;

    Uri filePath;
    String encodedImage;
    // Bitmap decodeBitmap;
    ProgressDialog progressDialog;
    private StorageReference imageReference;
    private StorageReference fileRef;
    private Uri fileUri;

    // push notification
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private TextView txtRegId, txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        mContext = this;
        progressDialog = new ProgressDialog(mContext);
        editArtistName = (TextView) findViewById(R.id.editArtistName);
        spinnerGenres = (Spinner) findViewById(R.id.spinnerGenres);
        buttonAddArtist = (Button) findViewById(R.id.buttonAddArtist);

        imageView = (ImageView) findViewById(R.id.image_view_user);
        selectImage = (Button) findViewById(R.id.btn_select_image);
        selectImage.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_artist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);

        artistArrayList = new ArrayList<>();

     /*   // database ref.
        databaseReference = FirebaseDatabase.getInstance().getReference("artist");
        imageReference = FirebaseStorage.getInstance().getReference().child("artist");
        fileRef = null;
        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRecord();
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Artist artistRef = artistArrayList.get(position);
                Intent updateIntent = new Intent(ArtistMainActivity.this, EditActivity.class);

                updateIntent.putExtra(Constant.UPDATE_ID, artistRef.getArtistId());
                updateIntent.putExtra(Constant.UPDATE_NAME, artistRef.getArtistName());
                updateIntent.putExtra(Constant.UPDATE_GEN, artistRef.getArtistGenre());
                updateIntent.putExtra(Constant.UPDATE_FILE_PATH, artistRef.getImageFilePath());
                startActivity(updateIntent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));*/

        // gcm push notification
/*
        txtRegId = (TextView) findViewById(R.id.txt_reg_id);
        txtMessage = (TextView) findViewById(R.id.txt_push_message);
        Log.e(TAG, "Firebase reg id: " + "FirebaseNoficationMainActivity");

        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // checking for type intent filter
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    // gcm successfully registered
                    // now subscribe to `global` topic to receive app wide notifications
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);
                    displayFirebaseRegId();
                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    // new push notification is received
                    String message = intent.getStringExtra("message");
                    Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();
                    txtMessage.setText(message);
                }
            }
        };
        displayFirebaseRegId();*/
    }


    // p notification
    @Override
    protected void onResume() {
        super.onResume();
       /* // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));
        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));
        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());*/
    }

    @Override
    protected void onPause() {
     //   LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }

    private void saveRecord() {
        String name = editArtistName.getText().toString().trim();
        String genre = spinnerGenres.getSelectedItem().toString();
        if (validate()) {
            if (!TextUtils.isEmpty(name)) {
                String fileName = "artist1";
                fileRef = imageReference.child(fileName + "." + fileUri);
                uploadingimage(name, genre);
            } else {
                Toast.makeText(this, "Name is empty", Toast.LENGTH_LONG).show();
            }
        }
    }


    private void uploadingimage(final String artistName, final String artistGenre) {
        progressDialog.setTitle("Uploading...");
        progressDialog.show();
        if (fileUri != null) {
            fileRef.putFile(fileUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();

                            String name = taskSnapshot.getMetadata().getName();
                            String url = taskSnapshot.getDownloadUrl().toString();

                            Log.e(TAG, "Uri: " + url);
                            Log.e(TAG, "Name: " + name);

                            writeNewImageInfoToDB(artistName, artistGenre, url);

                            Toast.makeText(ArtistMainActivity.this, "File Uploaded ", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            progressDialog.dismiss();

                            Toast.makeText(ArtistMainActivity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            // progress percentage
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

                            // percentage in progress dialog
                            progressDialog.setMessage("Uploaded " + ((int) progress) + "%...");
                        }
                    })
                    .addOnPausedListener(new OnPausedListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onPaused(UploadTask.TaskSnapshot taskSnapshot) {
                            System.out.println("Upload is paused!");
                        }
                    });
        } else {
            Toast.makeText(ArtistMainActivity.this, "No File!", Toast.LENGTH_LONG).show();
        }
    }

    private void writeNewImageInfoToDB(String artistName, String artistGenre, String url) {
        // get unique data to push data into database
        String id = databaseReference.push().getKey();
        // create object or artist class
        long currentMills = System.currentTimeMillis();
        Artist artist = new Artist(id, artistName, artistGenre, url, currentMills);
        // insert/save into database
        databaseReference.child(id).setValue(artist);
        Toast.makeText(this, "Record Inserted", Toast.LENGTH_LONG).show();
        editArtistName.setText("");
        imageView.setImageBitmap(null);
        getData();
    }

    private boolean validate() {
        boolean validates = true;
        if (filePath == null) {
            validates = false;
            // Constant.customToast("Select Image");
            Toast.makeText(mContext, "Select Image", Toast.LENGTH_LONG).show();
        }
        return validates;
    }

    private void getData() {
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //clearing the previous artist list
                progressDialog.dismiss();
                artistArrayList.clear();
                //on data change call this lister.
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Log.d("artistArrayList", dataSnapshot.toString());
                    Artist data = dataSnapshot1.getValue(Artist.class);
                    // add into arraylist
                    artistArrayList.add(data);
                    //Collections.sort(artistArrayList,new Comparator());
                    artistAdapter = new ArtistAdapter(mContext, artistArrayList);
                    //listView.setAdapter(artistAdapter);
                    recyclerView.setAdapter(artistAdapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    //sort name by decending order
    class Comparator implements java.util.Comparator<Artist> {

        @Override
        public int compare(Artist obj1, Artist obj2) {
            return obj2.getArtistName().compareTo(obj1.getArtistName());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // getData();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_select_image:
                selectImage();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "SELECT PICTURE"), PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) && (data.getData() != null && data != null)) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //  imageView.setImageBitmap(bitmap);
                fileUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(fileUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                encodedImage = Constant.encodeImage(selectedImage);
                Bitmap decodeBitmap = Constant.decodeFromBase64ToBitmap(encodedImage);

                imageView.setImageBitmap(decodeBitmap);
                Log.d(TAG, "bitmap" + encodedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ((requestCode == PICK_IMAGE_REQUEST_UPDATE && resultCode == RESULT_OK) && (data.getData() != null && data != null)) {
            final Uri imageUri = data.getData();
            final InputStream imageStream;
            try {
                imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                encodedImage = Constant.encodeImage(selectedImage);

                Bitmap decodeBitmap = Constant.decodeFromBase64ToBitmap(encodedImage);
                imageView.setImageBitmap(decodeBitmap);
                Log.d(TAG, "bitmap" + encodedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }
    //p notification
    private void displayFirebaseRegId() {
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF, MODE_PRIVATE);
        String regId = sharedPreferences.getString("regId", null);
        Log.e(TAG, "Firebase reg id: " + regId);
        if (!TextUtils.isEmpty(regId))
            txtRegId.setText("Firebase Reg Id: " + regId);
        else
            txtRegId.setText("Firebase Reg Id is not received yet!");
    }

}
