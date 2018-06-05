package bpund.isurakaha.com.test.firebaseDemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.io.InputStream;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG=EditActivity.class.getSimpleName();
    EditText edtName;
    Spinner spinnerGen;
    Button buttonUpdateArtist, buttonDeleteArtist, updateImage;
    ImageView update_image_view,update_image;
    Context mContext;
    final int PICK_IMAGE_REQUEST_UPDATE = 200;
    String encodedImage;
    Bitmap decodeBitmap;
    DatabaseReference databaseReference;
    String artistId, selectedName, selectedGen,imageFilePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_dialog);
        mContext=this;
        Intent intent = getIntent();
        artistId =intent.getStringExtra(Constant.UPDATE_ID);
        selectedName =intent.getStringExtra(Constant.UPDATE_NAME);
        selectedGen =intent.getStringExtra(Constant.UPDATE_GEN);
        imageFilePath =intent.getStringExtra(Constant.UPDATE_FILE_PATH);

        edtName = (EditText) findViewById(R.id.update_editTextName);
        spinnerGen = (Spinner) findViewById(R.id.update_spinnerGenres);
        buttonUpdateArtist = (Button) findViewById(R.id.buttonUpdateArtist);
        buttonDeleteArtist = (Button) findViewById(R.id.buttonDeleteArtist);
        update_image_view = (ImageView) findViewById(R.id.update_image_view);
        updateImage = (Button) findViewById(R.id.update_button);

        buttonUpdateArtist.setOnClickListener(this);
        buttonDeleteArtist.setOnClickListener(this);
        updateImage.setOnClickListener(this);

        edtName.setText(selectedName);

        Glide.with(mContext).load(imageFilePath).into(update_image_view);
        updateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUploadImage();
            }
        });
    }
    private void updateUploadImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        EditActivity artistActivity=(EditActivity)mContext;  // return result to  this class obj.
        artistActivity.startActivityForResult(Intent.createChooser(intent, "SELECT PICTURE"), PICK_IMAGE_REQUEST_UPDATE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == PICK_IMAGE_REQUEST_UPDATE && resultCode == RESULT_OK) && (data.getData() != null && data != null)){
            final Uri imageUri = data.getData();
            final InputStream imageStream;
            try {
                imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                encodedImage = Constant.encodeImage(selectedImage);

                 decodeBitmap=Constant.decodeFromBase64ToBitmap(encodedImage);
                update_image_view.setImageBitmap(decodeBitmap);
                Log.d(TAG,"bitmap"+ encodedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.buttonUpdateArtist:
                update(artistId, selectedName, selectedGen,imageFilePath);
                finish();
                break;
            case R.id.buttonDeleteArtist:
                delete(artistId);
                finish();
                break;
            case R.id.update_button:
                updateUploadImage();

                break;
        }

    }
    private boolean update(String artistId, String artistName, String artistGenre ,String imageFilePath) {

        String selectedName = edtName.getText().toString();
        String selectedGen = spinnerGen.getSelectedItem().toString();

        // get database node and update record;
        databaseReference = FirebaseDatabase.getInstance().getReference("artist").child(artistId);
        long time=System.currentTimeMillis();
       /* Artist artist = new Artist(artistId, selectedName, selectedGen,decodeBitmap.toString(),time);
        databaseReference.setValue(artist);*/
        Toast.makeText(mContext, "Record Updated Successfully.", Toast.LENGTH_LONG).show();
        return true;
    }
    private boolean delete(String artistId) {

        DatabaseReference databaseReferenceArtist = FirebaseDatabase.getInstance().getReference("artist").child(artistId);
        databaseReferenceArtist.removeValue();

        DatabaseReference databaseReferenceArtist1 = FirebaseDatabase.getInstance().getReference("tracks").child(artistId);
        databaseReferenceArtist1.removeValue();
        Toast.makeText(mContext, "Record Deleted Successfully.", Toast.LENGTH_LONG).show();
        return true;
    }

}
