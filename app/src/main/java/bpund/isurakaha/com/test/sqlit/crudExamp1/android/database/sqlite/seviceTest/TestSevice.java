package bpund.isurakaha.com.test.sqlit.crudExamp1.android.database.sqlite.seviceTest;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class TestSevice extends Service {

    Handler handler;

    public TestSevice() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "serviceStarted", Toast.LENGTH_LONG).show();
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}


