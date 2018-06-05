package bpund.isurakaha.com.test.multilanguage;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Locale;

import bpund.isurakaha.com.test.R;

public class MulitLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulit_language);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.muliplangue, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.english:
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                Toast.makeText(this, "Locale in English !", Toast.LENGTH_LONG).show();
                this.setContentView(R.layout.activity_mulit_language);
                break;

            case R.id.hindi:
                Locale locale2 = new Locale("hi");
                Locale.setDefault(locale2);
                Configuration config2 = new Configuration();
                config2.locale = locale2;
                getBaseContext().getResources().updateConfiguration(config2, getBaseContext().getResources().getDisplayMetrics());

                Toast.makeText(this, "Locale in Hindi !", Toast.LENGTH_LONG).show();
                this.setContentView(R.layout.activity_mulit_language);
                break;

            case R.id.marati:
                Locale locale3 = new Locale("mr");
                Locale.setDefault(locale3);
                Configuration config3 = new Configuration();
                config3.locale = locale3;
                getBaseContext().getResources().updateConfiguration(config3, getBaseContext().getResources().getDisplayMetrics());

                Toast.makeText(this, "Locale in Marathi !", Toast.LENGTH_LONG).show();
                this.setContentView(R.layout.activity_mulit_language);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
