package bpund.isurakaha.com.test.login.registratin.model.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.login.registratin.model.activies.MainActivity18;
import bpund.isurakaha.com.test.login.registratin.model.registration.RegistrationActivity18;
import bpund.isurakaha.com.test.request.singletone.RequestSingleton;

public class LoginActivity18 extends AppCompatActivity implements View.OnClickListener {

    String TAG = LoginActivity18.class.getSimpleName();
    EditText edt_mob_email, password;
    Button login;
    String url="http://192.168.0.4:8070/isuraksha/api/login";
  ProgressDialog progressDialog;
    Context mContext;
    TextView textViewRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mContext=this;
        progressDialog=new ProgressDialog(mContext);
        edt_mob_email = (EditText) findViewById(R.id.edit_login_mob_email);
        password = (EditText) findViewById(R.id.edit_login_password);
        textViewRegister = (TextView) findViewById(R.id.textViewRegister);
        login = (Button) findViewById(R.id.buttonLogin);
        textViewRegister.setOnClickListener(this);
        login.setOnClickListener(this);


    }

    private void login() {
        progressDialog.setMessage("login in progress...\n Please wait");
        progressDialog.show();
        final String mob_email = edt_mob_email.getText().toString();
        final String passwords = password.getText().toString();

        StringRequest loginRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {  //{ }
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray response1=jsonObject.getJSONArray("roles");
                    for (int i=0;i<response1.length();i++){
                        if (response1.getString(i).equals("ROLE_EMPLOYER"));{
                            Toast.makeText(mContext,"Login Successfully.",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(LoginActivity18.this,MainActivity18.class);
                            startActivity(intent);
                        }
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
                NetworkResponse response = error.networkResponse;
                if(response != null){
                    switch(response.statusCode){
                        case 401:
                            Toast.makeText(mContext,"Unauthorized",Toast.LENGTH_LONG).show();
                            break;
                        case 403:
                            Toast.makeText(mContext,"Forbidden",Toast.LENGTH_LONG).show();
                            break;
                    }
                }
                Log.d(TAG, "error " + error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("j_username", mob_email);
                params.put("j_password", passwords);
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        RequestSingleton.getInstance(this).addToRequestQueue(loginRequest);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonLogin:
                login();
                break;
            case R.id.textViewRegister:
                Intent intent=new Intent(LoginActivity18.this,RegistrationActivity18.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
