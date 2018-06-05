package bpund.isurakaha.com.test.shareprefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;

public class SimpleSharePrefrence extends AppCompatActivity implements View.OnClickListener {

    private String prefrenceName = "myPrefrence";
    private String Name = "name";
    SharedPreferences sharedPreferences; // reference of shareprefrence
    EditText edtName;
    TextView txtName;
    Button submit, show;
    Context mContext;
    ListView listView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_share_prefrence);
        mContext=this;
        edtName = (EditText) findViewById(R.id.edt_pref_name);
        txtName = (TextView) findViewById(R.id.txt_pref_show_name);
        submit = (Button) findViewById(R.id.bnt_pref_submit);
        show = (Button) findViewById(R.id.bnt_pref_show_btn);
        listView = (ListView) findViewById(R.id.share_pref_name);

        submit.setOnClickListener(this);
        show.setOnClickListener(this);


        // initialize reference
        sharedPreferences = getSharedPreferences(prefrenceName, MODE_PRIVATE);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bnt_pref_submit:
                save();
                break;
            case R.id.bnt_pref_show_btn:
                getData();
                break;
        }
    }

    private void getData() {
        SharedPreferences sharedPreferences = getSharedPreferences(prefrenceName, MODE_PRIVATE);
        String name = sharedPreferences.getString(Name, null);
        if (name != null) {
            txtName.setText(name);
        }
    }

    private void save() {
        String name = edtName.getText().toString();
        if (TextUtils.isEmpty(name)) {
            edtName.setError("Enter name");
            edtName.setFocusable(true);
            return;
        }
        // save data into shareprfrence.
        SharedPreferences sp = getSharedPreferences(prefrenceName, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Name, name); // KEY AND VALUES PAIR.
        editor.commit();
        Toast.makeText(SimpleSharePrefrence.this,"data save successfully",Toast.LENGTH_LONG).show();

        Student student=new Student(name);
        ArrayList<Student> studentArrayList=new ArrayList<>();
        studentArrayList.add(student);
        CustomShareprefeAdapter customShareprefeAdapter=new CustomShareprefeAdapter(mContext,studentArrayList);
        listView.setAdapter(customShareprefeAdapter);

        edtName.setText("");
    }
}
