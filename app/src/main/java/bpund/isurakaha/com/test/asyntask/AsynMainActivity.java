package bpund.isurakaha.com.test.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import bpund.isurakaha.com.test.R;

public class AsynMainActivity extends AppCompatActivity {

    EditText amount_of_time;
    Button start;
    TextView show_details;
    String second;
    Context mContext;
    int a;
    TextView tv_title, tv_catagory, tv_date;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyn_main);
        mContext = this;
        amount_of_time = (EditText) findViewById(R.id.edt_second);
        start = (Button) findViewById(R.id.btn_start_task);
        show_details = (TextView) findViewById(R.id.text_set_details);

        tv_title = (TextView) findViewById(R.id.txt_asny_title);
        tv_catagory = (TextView) findViewById(R.id.txt_asny_cat);
        tv_date = (TextView) findViewById(R.id.txt_asny_date);
        imageView = (ImageView) findViewById(R.id.txt_asny_image);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second = amount_of_time.getText().toString();
                MyAsynTask myAsynTask = new MyAsynTask();
                myAsynTask.execute(second);
            }
        });
    }

    private class MyAsynTask extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;
        Context mContext;
        String resp = null;
        String apiUrl = "http://mobileappdatabase.in/demo/smartnews/app_dashboard/jsonUrl/single-article.php?article-id=71";

        public MyAsynTask() {

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(AsynMainActivity.this);
            progressDialog.setMessage("Please Wait");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping...");

            String current = "";
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiUrl);

                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream in = urlConnection.getInputStream();

                    InputStreamReader isw = new InputStreamReader(in);

                    int data = isw.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isw.read();
                        System.out.print(current);

                    }
                    // return the data to onPostExecute method
                    return current;

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return current;
         /*   try {
                int time = Integer.parseInt(params[0])*1000;
                Thread.sleep(time);
                resp = "Slept for " + params[0] + " seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;*/
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            show_details.setText(s);

            try {
                JSONArray jsonArray = new JSONArray(s);
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                String titles, catagorys, dates, url;
                titles = jsonObject.getString("title");
                catagorys = jsonObject.getString("category");
                dates = jsonObject.getString("date");
                url = jsonObject.getString("image");

                tv_title.setText(titles);
                tv_catagory.setText(catagorys);
                tv_date.setText(dates);

                Glide.with(AsynMainActivity.this).load(url).into(imageView);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
