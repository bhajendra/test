package bpund.isurakaha.com.test.hander;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

import bpund.isurakaha.com.test.R;


public class HandlerMainActivity extends AppCompatActivity {

    final String URLS = "https://api.androidhive.info/contacts/";
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_main);
    }

    public void getHandler(View v) {

        Toast.makeText(getBaseContext(), "Please wait, connecting to server.", Toast.LENGTH_SHORT).show();

        // inner thread class
        thread = new Thread(new Runnable() {
            @Override
            public void run() {


                String requestData = "";
                HttpClient httpClient = new DefaultHttpClient();
                // call for background thread using .start method
                HttpGet httpGet = new HttpGet(URLS);
                ResponseHandler<String> stringResponseHandler = new BasicResponseHandler();
                try {
                    requestData = httpClient.execute(httpGet, stringResponseHandler);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                threadMessage(requestData);
            }

            private void threadMessage(String requestData) {

                if (!requestData.equals("") && requestData != null) {

                    Message msgObt = handler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("message", requestData);
                    msgObt.setData(bundle);
                    handler.sendMessage(msgObt);

                }
            }


            Handler handler = new Handler() {

                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    String aResponse = msg.getData().getString("message");
                    if ((null != aResponse)) {

                        // ALERT MESSAGE
                        Toast.makeText(
                                getBaseContext(),
                                "Server Response: " + aResponse,
                                Toast.LENGTH_SHORT).show();
                    } else {

                        // ALERT MESSAGE
                        Toast.makeText(
                                getBaseContext(),
                                "Not Got Response From Server.",
                                Toast.LENGTH_SHORT).show();
                    }

                }

            };

        });
        thread.start();
    }


}
