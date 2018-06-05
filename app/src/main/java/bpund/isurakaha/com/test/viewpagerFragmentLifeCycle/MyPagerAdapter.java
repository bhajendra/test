package bpund.isurakaha.com.test.viewpagerFragmentLifeCycle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bpund.isurakaha.com.test.R;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final int NUM_ITMES = 3;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return FragmentWithOneImage.newInstance(R.drawable.btn_white, "Fragment 1");
            case 1:
                return FragmentWithTwoImage.newInstance(R.drawable.btn_white, "Fragment 2");
            case 2:
                return FragmentWithThreeImage.newInstance(R.drawable.btn_white, "Fragment 3");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITMES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int positions=position+1;
        return "TAB " + positions;
    }
}
