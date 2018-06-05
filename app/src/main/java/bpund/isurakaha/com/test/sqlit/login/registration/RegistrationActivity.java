package bpund.isurakaha.com.test.sqlit.login.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.sqlit.database.manager.DatabaseManager;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    EditText registerUserName, registerPassword, registerConfirmPassword;
    Button register;
    String registerName, registerPass, registerConfirmPass;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        mContext=this;
        registerUserName = (EditText) findViewById(R.id.register_user_name);
        registerPassword = (EditText) findViewById(R.id.register_user_password);
        registerConfirmPassword = (EditText) findViewById(R.id.register_user_confirm_password);
        register = (Button) findViewById(R.id.btn_register);
        register.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_register:
                register();
                break;
        }
    }

    private void register() {

        registerName = registerUserName.getText().toString();
        registerPass = registerPassword.getText().toString();
        registerConfirmPass = registerConfirmPassword.getText().toString();

        if (validator()) {
            DatabaseManager databaseManager=new DatabaseManager(mContext);
            boolean isUserExits= databaseManager.checkUserExistForRegistration(registerName);
            if (isUserExits){
                Toast.makeText(mContext,"User Already Exist !",Toast.LENGTH_LONG).show();
                return;
            }
            long currentMillis=System.currentTimeMillis();
            long inserted=new DatabaseManager(mContext).insert(registerName,registerPass,currentMillis);
            if (inserted>0){
                Toast.makeText(mContext,"Registration Success !",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(RegistrationActivity.this,LoginAcitivy.class);
                startActivity(intent);
                finish();
            }
        }
    }

    private boolean validator() {
        boolean isValidate = true;
        if (TextUtils.isEmpty(registerName)) {
            registerUserName.setError("User Name is empty");
            registerUserName.setFocusable(true);
            isValidate = false;
        }
        if (TextUtils.isEmpty(registerPass)) {
            registerPassword.setError("Password is empty");
            registerPassword.setFocusable(true);
            isValidate = false;
        }
        if (TextUtils.isEmpty(registerConfirmPass)) {
            registerConfirmPassword.setError("ConfirmPassword is empty");
            registerConfirmPassword.setFocusable(true);
            isValidate = false;
        }
        if (!registerPass.equals(registerConfirmPass)) {
            registerConfirmPassword.setError("Password and confirm Password is not match");
            registerConfirmPassword.setFocusable(true);
            isValidate = false;
        }
        return isValidate;
    }
}
