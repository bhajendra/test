package bpund.isurakaha.com.test.captureImage;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import bpund.isurakaha.com.test.R;


public class CameraActivityExam extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = CameraActivityExam.class.getName();
    Button btnCapturePicture;
    int MEDIA_TYPE_IMAGE = 1;
    Uri fileUri;
    int CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static final int TALKE_FROM_GALLERY = 200;
    ImageView imgPreview;
    String CAPTURE_IMAGE_DIRECTORY_NAME = "TAKING_IMAGE";

    ArrayList<Images> imageList = new ArrayList<>();
    Context context;
    LinearLayout inScrollView;
    ImageAdapter imageAdapter;
    ListView image_list;
    LinearLayout full_image;

    //    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_exam);
        context = this;
        //activity = this;

        image_list = (ListView) findViewById(R.id.image_list);
        imageAdapter = new ImageAdapter(context, imageList);
        image_list.setOnItemClickListener(this);
        // inScrollView = (LinearLayout) findViewById(R.id.inscrollview);
        btnCapturePicture = (Button) findViewById(R.id.btnCapturePicture);
        //  imgPreview = (ImageView) findViewById(R.id.imgPreview);
        btnCapturePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDailog(context);
            }
        });
    }

    private void showDailog(Context context) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        Button takeCamera = (Button) dialog.findViewById(R.id.btn_take_camera);
        Button takeGallery = (Button) dialog.findViewById(R.id.btn_take_gallery);
        takeCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage();
                dialog.dismiss();
            }
        });
        takeGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeFromGallery();
                dialog.dismiss();
            }
        });
        dialog.show();


    }

    private void takeFromGallery() {
        // Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("imageList/*");
        startActivityForResult(intent, TALKE_FROM_GALLERY);
    }

    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // implicite intent
        fileUri = getOutputMediaUri(MEDIA_TYPE_IMAGE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, CAPTURE_IMAGE_REQUEST_CODE);
        Log.d(TAG, "startActivityForResult");
    }

    private Uri getOutputMediaUri(int media_type_image) {
        return Uri.fromFile(getimagePate(media_type_image));

    }

    private File getimagePate(int type) {
        // External sdcard location
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), CAPTURE_IMAGE_DIRECTORY_NAME);
        Log.d(TAG, "getimagePate" + file);

        // create directory if not
        if (!file.exists()) {
            if (!file.mkdir()) {
                Log.d(CAPTURE_IMAGE_DIRECTORY_NAME, "Oops! Failed create " + CAPTURE_IMAGE_DIRECTORY_NAME + " directory");
                Log.d(TAG, "!file.exists()");

                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        Log.d(TAG, "timeStamp" + timeStamp);

        File mediaFile = null;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(file.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
            Log.d(TAG, "mediaFile  " + "" + mediaFile);
        }
        return mediaFile;

    }

    // we ll get result back here
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAPTURE_IMAGE_REQUEST_CODE) {
            Log.d(TAG, "requestCode ss ");

            if (resultCode == RESULT_OK) {
                Log.d(TAG, "resultCode ss ");

                previewCapturedImage();
            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "User cancelled imageList capture", Toast.LENGTH_SHORT)
                        .show();
            } else {
                // failed to capture imageList
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture imageList", Toast.LENGTH_SHORT)
                        .show();
            }
        } else if (requestCode == TALKE_FROM_GALLERY) {
            Log.d(TAG, "TALKE_FROM_GALLERY" + "" + String.valueOf(TALKE_FROM_GALLERY));

            if ((data.getData() != null && !data.getData().equals("")) && (resultCode == RESULT_OK)) {
                Uri selectedImage = data.getData();
                Log.d(TAG, "selectedImage" + "" + String.valueOf(selectedImage));

                // get file pathe
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null); //uri, projection, selection, selectionArgs, sortOrder, null
                Log.d(TAG, "c" + "" + String.valueOf(c));

                c.moveToFirst();
                int colmsIndex = c.getColumnIndex(filePath[0]);
                Log.d(TAG, "colmsIndex" + "" + String.valueOf(colmsIndex));

                String picturePath = c.getString(colmsIndex);
                Log.d(TAG, "picturePath" + "" + String.valueOf(picturePath));

                // decode file path
                Bitmap bitmap = (BitmapFactory.decodeFile(picturePath));
                // imgPreview.setImageBitmap(bitmap);
                Log.d(TAG, "set imageList done......");
            }


        }
    }

    private void previewCapturedImage() {

        try {
            //imgPreview.setVisibility(View.VISIBLE);
            // bimatp factory
            BitmapFactory.Options options = new BitmapFactory.Options();
            Log.d(TAG, "options ss ");

            // downsizing imageList as it throws OutOfMemory Exception for larger imageList
            options.inSampleSize = 8;
            // decode the imageList path
            Log.d(TAG, "bitmap ss before final" + fileUri.getPath());

            Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath());

            Images images = new Images();
            images.setBitmap(bitmap);
            long currentMillis = System.currentTimeMillis();
            images.setTime(currentMillis);
            imageList.add(images);
            imageAdapter.notifyDataSetChanged();
            image_list.setAdapter(imageAdapter);
            Log.d(TAG, "bitmap ss final done" + bitmap);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("fileUri", fileUri);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fileUri = savedInstanceState.getParcelable("fileUri");

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show();
        Images data = imageList.get(position);
        Intent intent = new Intent(CameraActivityExam.this, FullImageActivity.class);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        data.getBitmap().compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        intent.putExtra("images", temp);
        startActivity(intent);
    }
}
