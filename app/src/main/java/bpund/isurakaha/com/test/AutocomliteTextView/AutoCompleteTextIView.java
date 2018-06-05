package bpund.isurakaha.com.test.AutocomliteTextView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import bpund.isurakaha.com.test.R;

public class AutoCompleteTextIView extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView1;
    String[] country = {"india", "bangle", "country", "delhi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_iview);
        autoCompleteTextView1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        //Context context, @LayoutRes int resource, @IdRes int textViewResourceId
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, country);
        autoCompleteTextView1.setAdapter(adapter);

        autoCompleteTextView1.setThreshold(1);


    }
}
