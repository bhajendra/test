package bpund.isurakaha.com.test.android.facebook.integration.examp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bpund.isurakaha.com.test.R;

public class LauchActivityctivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauch_activityctivity);
        startActivity(new Intent(LauchActivityctivity.this,FaceBookActivity.class));
    }
}
