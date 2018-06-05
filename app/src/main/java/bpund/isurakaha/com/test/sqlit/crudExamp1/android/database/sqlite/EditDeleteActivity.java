package bpund.isurakaha.com.test.sqlit.crudExamp1.android.database.sqlite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bpund.isurakaha.com.test.R;

public class EditDeleteActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_edit_delete;
    String id, name;
    Button update, delete;
    long idToUpdate;
    DBManager dbManager;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);
        context = this;
        edt_edit_delete = (EditText) findViewById(R.id.edt_edit_delete_name);
        update = (Button) findViewById(R.id.btn_edit_edt);
        delete = (Button) findViewById(R.id.btn_edit_delete);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        Intent intent = getIntent();
        id = intent.getStringExtra("id"); // here get string id
        name = intent.getStringExtra("name");
        edt_edit_delete.setText(name);
        idToUpdate = Long.parseLong(id); // cast string to long
        dbManager = new DBManager(context);
        dbManager.open();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_edit_edt:
                update();
                break;
            case R.id.btn_edit_delete:
                deleteData();
                break;
        }

    }

    private void deleteData() {
        int deletes = dbManager.delete(idToUpdate);
        Toast.makeText(context, "Record Deleted Successfully " + deletes, Toast.LENGTH_LONG).show();
        startActivity(new Intent(EditDeleteActivity.this, StudListMainActivity.class));
        finish();
    }

    private void update() {
        String name = edt_edit_delete.getText().toString();
        int updates = dbManager.update(idToUpdate, name);
        Toast.makeText(context, "Record Updated Successfully " + updates, Toast.LENGTH_LONG).show();
        startActivity(new Intent(EditDeleteActivity.this, StudListMainActivity.class));
        finish();

    }
}
