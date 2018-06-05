package bpund.isurakaha.com.test.startActivityForResultExample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import bpund.isurakaha.com.test.R;

public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitystartresultone);


    }

    public void redBackground(View v) {

        Intent intent = new Intent(OneActivity.this, TwoActivity.class);
        intent.putExtra("color", "red");
        startActivityForResult(intent, 1);
        finish();
    }

    public void greenBackground(View v) {

        Intent intent = new Intent(OneActivity.this, TwoActivity.class);
        intent.putExtra("color", "green");
        startActivityForResult(intent, 1);
        finish();
    }

    public void blueBackground(View v) {

        Intent intent = new Intent(OneActivity.this, TwoActivity.class);
        intent.putExtra("color", "blue");
        startActivityForResult(intent, 1);
        finish();
    }

}
