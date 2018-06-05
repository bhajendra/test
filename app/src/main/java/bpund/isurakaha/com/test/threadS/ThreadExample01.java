package bpund.isurakaha.com.test.threadS;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import bpund.isurakaha.com.test.R;

public class ThreadExample01 extends AppCompatActivity {

    TextView txt_thread_progress;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_example01);
        txt_thread_progress = (TextView) findViewById(R.id.txt_thread_progress);
        context = this;
    }

    public void startThread(View v) {
        new Thread(new Task()).start();
    }

    class Task implements Runnable {

        int val = 0;

        public Task() {
        }

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <= 10; i++) {
                        try {
                            Thread.sleep(1000);
                            val = i;
                            txt_thread_progress.setText(Integer.toString(val));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

           /* for (int i = 0; i <=10; i++) {
                try {
                    Thread.sleep(1000);
                    val = i;
                    txt_thread_progress.setText(Integer.toString(val));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }*/

        }
    }
}
