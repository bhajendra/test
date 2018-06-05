package bpund.isurakaha.com.test.captureImage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.ImageView;

import bpund.isurakaha.com.test.R;

public class FullImageActivity extends AppCompatActivity  {

    ImageView full_image ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        full_image=(ImageView)findViewById(R.id.full_image);
        Intent intent=getIntent();
        String imagePath=intent.getStringExtra("images");

        byte [] encodeByte=Base64.decode(imagePath, Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
        full_image.setImageBitmap(bitmap);
        //Glide.with(this).load(bitmap).into(full_image);
    }


}
