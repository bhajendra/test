package bpund.isurakaha.com.test.sqlit.login.registration;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;
import bpund.isurakaha.com.test.sqlit.database.manager.DatabaseManager;

public class EditUseDetails extends AppCompatActivity implements View.OnClickListener {

    String TAG = EditUseDetails.class.getSimpleName();
    EditText edt_name, edt_password;
    TextView set_date;
    String id, name, password, date;
    long editId;
    Button btn_edit_user_update, btn_edit_user_delete, edit_user_select_date_btn;
    Context mContext;
    String date_time = "";
    int mYear;
    int mMonth;
    int mDay;

    int mHour;
    int mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_use_details);
        mContext = this;
        Intent intent = getIntent();
        initializeView();
        id = intent.getStringExtra(Constant.EDIT_ID);
        name = intent.getStringExtra(Constant.EDIT_NAME);
        password = intent.getStringExtra(Constant.EDIT_PASSWORD);
        date = intent.getStringExtra(Constant.EDIT_DATE);

        editId = Long.parseLong(id); // convet string id to long for update...
        Log.d(TAG, String.valueOf(editId));
        btn_edit_user_update.setOnClickListener(this);
        btn_edit_user_delete.setOnClickListener(this);
        setExistingDataOnView();
        edit_user_select_date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });

    }

    private void datePicker() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        //*************Call Time Picker Here ********************
                        tiemPicker();
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void tiemPicker() {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        mHour = hourOfDay;
                        mMinute = minute;

                        set_date.setText(date_time + " " + hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void initializeView() {
        edt_name = (EditText) findViewById(R.id.edit_user_name);
        edt_password = (EditText) findViewById(R.id.edit_user_password);
        set_date = (TextView) findViewById(R.id.edit_user_set_date);

        btn_edit_user_update = (Button) findViewById(R.id.edit_btn_update);
        btn_edit_user_delete = (Button) findViewById(R.id.edit_btn_delete);
        edit_user_select_date_btn = (Button) findViewById(R.id.edit_user_select_date_btn);
    }

    private void setExistingDataOnView() {
        edt_name.setText(name);
        edt_password.setText(password);
        set_date.setText(date);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_btn_update:
                update();
                break;
            case R.id.edit_btn_delete:
                delete();
                break;
        }
    }

    private void update() {
        String name = edt_name.getText().toString();
        String password = edt_password.getText().toString();
        String date = set_date.getText().toString();
        String millisecond = Constant.convertDateIntoMilli(date);
        Log.d(TAG, millisecond);

        int updateRecord = new DatabaseManager(mContext).update(editId, name, password, millisecond);
        if (updateRecord > 0) {
            Intent intent = new Intent(EditUseDetails.this, UserDetailsActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void delete() {
        int deleteRecord = new DatabaseManager(mContext).delete(editId);
        if (deleteRecord > 0) {
            Intent intent = new Intent(EditUseDetails.this, UserDetailsActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
