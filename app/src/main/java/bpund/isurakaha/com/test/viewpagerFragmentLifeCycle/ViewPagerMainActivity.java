package bpund.isurakaha.com.test.viewpagerFragmentLifeCycle;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import bpund.isurakaha.com.test.R;

public class ViewPagerMainActivity extends AppCompatActivity {

    String ActivityName = ViewPagerMainActivity.class.getName();
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(ActivityName, "onCreate 1");
        setContentView(R.layout.activity_view_pager_main);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(ActivityName, "onStart 2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(ActivityName, "onResume 3");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(ActivityName, "onPause 4");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(ActivityName, "onStop 5");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(ActivityName, "onDestroy 6");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(ActivityName, "onRestart 7");

    }
}
