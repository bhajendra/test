package bpund.isurakaha.com.test.startActivityForResultExample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import bpund.isurakaha.com.test.R;

public class TwoActivity extends AppCompatActivity {

    LinearLayout containerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitystartresultwo);
        containerTwo = (LinearLayout) findViewById(R.id.containerTwo);

        Intent intent=getIntent();
        String color=intent.getStringExtra("color");
        changeColor(color);

    }
    public void openActivityOne(View v){
        Intent intent=new Intent(TwoActivity.this,OneActivity.class);
        startActivity(intent);
        finish();
    }

    private void changeColor(String color) {
        if (color.equals("red")){
            containerTwo.setBackgroundColor(Color.RED);
        }else if (color.equals("green")){
            containerTwo.setBackgroundColor(Color.GREEN);
        }else if(color.equals("blue")){
            containerTwo.setBackgroundColor(Color.BLUE);

        }
    }
}
