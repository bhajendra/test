package bpund.isurakaha.com.test.ThreadExamp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import bpund.isurakaha.com.test.R;

public class ThreadMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_main);
        /*https://beginnersbook.com/2017/09/java-examples/*/




        // call runable interface..
      /*  RunableInterfaceImple runableInterfaceImple = new RunableInterfaceImple();
        runableInterfaceImple.run();

        ThredDemoDemo thredDemoDemo = new ThredDemoDemo();
        thredDemoDemo.start();*/

        // create runable object
     /*   Log.d("RunableDemo2 interface", "started.....");

        RunableDemo2 r = new RunableDemo2();
        // create thread to run runable interface
        Thread thread = new Thread(r);
        thread.start();

        /// loop throw all data
        while (RunableDemo2.count <= 10) {
            Log.d("RunableDemo2 interface1", "" + ++RunableDemo2.count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
*/
    }


}
