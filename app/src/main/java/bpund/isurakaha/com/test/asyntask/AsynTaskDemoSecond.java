package bpund.isurakaha.com.test.asyntask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import bpund.isurakaha.com.test.R;

public class AsynTaskDemoSecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyn_task_demo_second);
        new AsynTaskDemoSecondClone(10).execute();

    }

    public class AsynTaskDemoSecondClone extends AsyncTask<String, Integer, Long> {

        long result = 0;
        int iii;

        public AsynTaskDemoSecondClone(int i) {
            this.iii = i;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Long doInBackground(String... params) {

            for (int i = 0; i <= iii; i++) {
                result = i * 5;
            }

            return result;  // method return the result
        }

        @Override
        protected void onPostExecute(Long aLong) {   // result get in onpostexecute method parameters...
            super.onPostExecute(aLong);
            Log.d("result50 ", aLong.toString());
            new AsynTaskDemoSecondCloneCone(10).execute();

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }

    public class AsynTaskDemoSecondCloneCone extends AsyncTask<String, Integer, Long> {

        long result = 0;
        int iii;

        public AsynTaskDemoSecondCloneCone(int i) {
            this.iii = i;
        }

        @Override
        protected Long doInBackground(String... params) {

            for (int i = 0; i <= iii; i++) {
                result = i * 5;
            }
            return result;  // method return the result to onpost execute method...
        }

        @Override
        protected void onPostExecute(Long aLong) { // result get in onpostexecute method parameters...
            super.onPostExecute(aLong);
            Log.d("result50 50", aLong.toString());
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
