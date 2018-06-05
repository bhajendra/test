package bpund.isurakaha.com.test.readdatafromlocal;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;

import bpund.isurakaha.com.test.R;

public class ReadDataFromLocalStorage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data_from_local_storage);

    }
    public void ReadFile(View view) {
        String path=Environment.getExternalStorageDirectory().toString();
        Log.d("ReadDataPath",path);
        File file=new File(path);
          File[] listfil=file.listFiles();
          for (int i=0;i<listfil.length;i++){
              Log.d("ReadDataallfile",listfil[i].getName());
          }

    }
}
