package bpund.isurakaha.com.test.login.registratin.model.registration;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;
import bpund.isurakaha.com.test.request.singletone.RequestSingleton;

public class RegistrationActivity18 extends AppCompatActivity implements View.OnClickListener {

    String TAG = RegistrationActivity18.class.getSimpleName();
    private EditText mUsernameView;
    private EditText mPasswordView;
    private EditText mMobileNumber;
    private Button mRegisterBtn;
    private CheckBox mAgree;
    private boolean checkValues = false;
    String CONTACT_NUMBER = "contact";
    Context mContext;
    ProgressDialog progressBar;
    private String mTimeZone = "+0530";
    private String mCountryCode = "91";
    private String mMobilePlatform = "Android";
    String url = "http://192.168.0.4:8070/isuraksha/register/registerUser";
    ProgressDialog progressDialog;
    String uName, uPassword, uMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mContext = this;
        progressDialog = new ProgressDialog(mContext);
        mUsernameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);
        mMobileNumber = (EditText) findViewById(R.id.mobile_number);
        mRegisterBtn = (Button) findViewById(R.id.btn_register_reflection);
        progressBar = new ProgressDialog(mContext);
        mRegisterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register_reflection:
                userRegistration();
                break;
        }

    }

    private void userRegistration() {
        progressBar.setMessage("registering user ");
        progressBar.show();
        uName = mUsernameView.getText().toString();
        uPassword = mPasswordView.getText().toString();
        uMobile = mMobileNumber.getText().toString();

        StringRequest registerRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getString("success").equals(true)) {
                        Toast.makeText(mContext, "Register Successfully.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(mContext, "Your not Register \n Please try again", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "response " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                if (error instanceof NoConnectionError) {
                    Constant.showToast(mContext,"NoConnectionError");
                    Toast.makeText(mContext, "NoConnectionError", Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    Constant.showToast(mContext,"AuthFailureError");
                } else if (error instanceof TimeoutError) {
                    Constant.showToast(mContext,"TimeoutError");
                } else if (error instanceof ParseError) {
                    Constant.showToast(mContext,"ParseError");
                } else if (error instanceof ServerError) {
                    Constant.showToast(mContext,"ServerError");
                }
                Log.d(TAG, "error " + error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("contact", "91" + uMobile);
                params.put("mobilePlatform", mMobilePlatform);
                try {
                    params.put("timeZone", URLEncoder.encode(mTimeZone, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                params.put("username", uName);
                params.put("password", uPassword);
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        registerRequest.setRetryPolicy(new DefaultRetryPolicy(60000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestSingleton.getInstance(this).addToRequestQueue(registerRequest);
    }

}

