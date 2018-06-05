package bpund.isurakaha.com.test.viewpagerFragmentLifeCycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bpund.isurakaha.com.test.R;

public class FragmentWithOneImage extends Fragment {

    String FragmentName = FragmentWithOneImage.class.getName();

    String title;
    int image;


    public static FragmentWithOneImage newInstance(int image, String title) {

        FragmentWithOneImage fragmentWithOneImage = new FragmentWithOneImage();
        Bundle args = new Bundle();
        args.putInt("image", image);
        args.putString("titles", title);
        fragmentWithOneImage.setArguments(args);
        return fragmentWithOneImage;


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(FragmentName, "onAttach 1");

    }
    // this mehtod is called only once
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(FragmentName, "onCreate 2");

        image = getArguments().getInt("image", 0);
        title = getArguments().getString("titles");

    }

    // this mehtod is called everytime
    @Nullable
    @Override //....initialize view...
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false); // layout,containter,false;
        Log.d(FragmentName, "onCreateView 3");

        TextView txMain = (TextView) view.findViewById(R.id.txtMain);
        txMain.setText(title);

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
