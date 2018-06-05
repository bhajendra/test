package bpund.isurakaha.com.test.viewpagerFragmentLifeCycle;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bpund.isurakaha.com.test.R;

public class FragmentWithThreeImage extends Fragment {
    String FragmentName = FragmentWithThreeImage.class.getName();

    int image;
    String titles;

    public static FragmentWithThreeImage newInstance(int image, String title) {
        FragmentWithThreeImage fragment = new FragmentWithThreeImage();
        Bundle args = new Bundle();
        args.putInt("image", image);
        args.putString("titles", title);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(FragmentName, "onAttach 1");

    }
    // this mehtod is called only once
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(FragmentName, "onCreate 2");
        image = getArguments().getInt("image", 0);
        titles = getArguments().getString("titles");

    }
    // this mehtod is called everytime
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(FragmentName, "onCreateView 3");
        View view = inflater.inflate(R.layout.fragment_fragment_with_three_image, container, false);
        TextView title = (TextView) view.findViewById(R.id.txtMain);
        title.setText(titles);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(FragmentName, "onActivityCreated 4");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(FragmentName, "onStart 5");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(FragmentName, "onResume 6");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(FragmentName, "onPause 7");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(FragmentName, "onStop 8");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(FragmentName, "onDestroyView 9");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(FragmentName, "onDestroy 10");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(FragmentName, "onDetach 11");

    }

}
