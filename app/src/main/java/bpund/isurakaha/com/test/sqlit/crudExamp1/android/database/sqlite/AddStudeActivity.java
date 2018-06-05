package bpund.isurakaha.com.test.sqlit.crudExamp1.android.database.sqlite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bpund.isurakaha.com.test.R;

public class AddStudeActivity extends Activity implements View.OnClickListener {

    private static final String TAG = AddStudeActivity.class.getName();
    Context mContext;
    EditText edt_add_stud_name;
    Button btn_add_stud_name;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stude);
        mContext = this;
        edt_add_stud_name = (EditText) findViewById(R.id.edt_add_stud_name);
        btn_add_stud_name = (Button) findViewById(R.id.btn_add_stud_name);
        btn_add_stud_name.setOnClickListener(this);
        dbManager = new DBManager(mContext);
        dbManager.open();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_stud_name:
                addRecord();
                break;
        }
    }

    private void addRecord() {

        String name = edt_add_stud_name.getText().toString();
        dbManager.insetRecord(name);
        Toast.makeText(mContext, "Record Inserted Successfully", Toast.LENGTH_LONG).show();
        startActivity(new Intent(AddStudeActivity.this, StudListMainActivity.class));
        finish();
    }
}

