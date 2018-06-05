package bpund.isurakaha.com.test.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

import bpund.isurakaha.com.test.R;

/**
 * Created by isuraksha3 on 4/15/2018.
 */

public class StartStopService extends Service {

    final int MIN = 0;
    final int MAX = 100;
    boolean isRandomnumber=false;
    class Myservice extends Binder {

        private StartStopService getService() {
            return StartStopService.this;
        }
    }

    IBinder iBinder=new Myservice();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    // this return integer flag
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(getResources().getString(R.string.start_service), "2 " + Thread.currentThread().getId());

          isRandomnumber = true;
        new Thread(new Runnable() {
            @Override
            public void run() {

                genrateRandomNumber();
            }


        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    private void genrateRandomNumber() {
        while (isRandomnumber) {
            try {
                Thread.sleep(1000);
                if (isRandomnumber) {
                    int random = new Random().nextInt(MAX) + MIN;
                    Log.d("random numberr", Thread.currentThread().getId() + " " + random);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onDestroy() {
        Log.d("stop servicec method", "calledd");
        super.onDestroy();
        isRandomnumber=false;
        genrateRandomNumber();
    }
}
