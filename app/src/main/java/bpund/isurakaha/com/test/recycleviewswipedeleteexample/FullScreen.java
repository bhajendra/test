package bpund.isurakaha.com.test.recycleviewswipedeleteexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;

public class FullScreen extends AppCompatActivity {

    TextView name;
    ImageView imageView;
    String mName, mUrl;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        mContext = this;
        name = (TextView) findViewById(R.id.txt_name);
        imageView = (ImageView) findViewById(R.id.img_full_image);
        Intent intent = getIntent();
        mName = intent.getStringExtra(Constant.NAME);
        mUrl = intent.getStringExtra(Constant.IMG_URL);

        name.setText(mName);
        Glide.with(mContext).load(mUrl).into(imageView);


    }
}
