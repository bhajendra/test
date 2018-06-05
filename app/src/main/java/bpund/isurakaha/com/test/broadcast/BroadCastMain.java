package bpund.isurakaha.com.test.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bpund.isurakaha.com.test.R;

public class BroadCastMain extends AppCompatActivity {
    Button startButton;
    final int REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_main);
        startButton = (Button) findViewById(R.id.button_start);

        final Intent intent = new Intent(BroadCastMain.this, SecondActivity.class);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent, REQUEST_CODE); // intent, request code
            }
        });

    }

    // onresult received
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("test", "2");
    if (requestCode == REQUEST_CODE) {
        if (data != null) {
            String result = data.getStringExtra("data"); // name of desire item , default values.
            TextView textView = (TextView) findViewById(R.id.textView2);
            textView.setText(result);

       /* if (resultCode == RESULT_OK){
            //get data from data
            if (data != null) {
                String result = data.getStringExtra("data"); // name of desire item , default values.
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setText(result);
            }*/
        }
        }
        /* if (requestCode == 1 && resultCode == RESULT_OK) {
            //get data from data
            String result = data.getStringExtra("result"); // name of desire item , default values.
            if (result !=null) {
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setVisibility(View.VISIBLE);
            }

        }*/

    }
}
