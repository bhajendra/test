package bpund.isurakaha.com.test.sqlit.login.registration;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.sqlit.database.manager.DatabaseManager;

public class LoginAcitivy extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG=LoginAcitivy.class.getSimpleName();
    EditText loginUserName, loginUserPassword;
    Button login;
    TextView not_register;
    String userName,userPassword;
    Context mContext;
    DatabaseManager sqLiteHelper;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitivy);
        mContext=this;
        progressDialog=new ProgressDialog(mContext);
        loginUserName = (EditText) findViewById(R.id.login_user_name);
        loginUserPassword = (EditText) findViewById(R.id.login_user_password);
        login = (Button) findViewById(R.id.btn_login);
        not_register = (TextView) findViewById(R.id.user_not_register);
        login.setOnClickListener(this);
        not_register.setOnClickListener(this);
        sqLiteHelper=new DatabaseManager(mContext);
        //sqLiteHelper.openDb();


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.user_not_register:
                registrationPage();
                break;
        }


    }

    private void registrationPage() {
        Intent intent=new Intent(LoginAcitivy.this,RegistrationActivity.class);
        startActivity(intent);

    }

    private void login() {
        Log.d(TAG,"login called");
         userName=loginUserName.getText().toString();
         userPassword=loginUserPassword.getText().toString();
         if (validate()){
             progressDialog.setMessage("user login..");
             progressDialog.show();
             DatabaseManager databaseManager=new DatabaseManager(mContext);
             boolean isUserExits= databaseManager.checkUserExist(userName);
             if (isUserExits) {
                 progressDialog.dismiss();
                 Toast.makeText(mContext,"login Successfully",Toast.LENGTH_LONG).show();
                 Intent intent=new Intent(LoginAcitivy.this,UserDetailsActivity.class);
                 startActivity(intent);
             }else {
                 progressDialog.dismiss();
                 Toast.makeText(mContext,"User not exist \n Please Register First !",Toast.LENGTH_LONG).show();
             }
         }
    }

    private boolean validate() {
        boolean isValidate=true;
        if (TextUtils.isEmpty(userName)){
            loginUserName.setError("User Name is empty");
            loginUserName.setFocusable(true);
            isValidate=false;
        }
        return isValidate;
    }
}
