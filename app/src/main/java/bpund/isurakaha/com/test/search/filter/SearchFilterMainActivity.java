package bpund.isurakaha.com.test.search.filter;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.constants.Constant;
import bpund.isurakaha.com.test.recycleviewswipedeleteexample.MyApplication;

public class SearchFilterMainActivity extends AppCompatActivity {

    private static final String TAG = SearchFilterMainActivity.class.getSimpleName();
    ArrayList<Contact> contactArrayList;
    ContactFilterAdapter contactFilterAdapter;
    Context mContext;
    RecyclerView recyclerView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_filter_main);
        mContext = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // toolbar fancy stuff
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.toolbar_title);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //  recyclerView.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 36));

        contactArrayList=new ArrayList<>();

        // white background notification bar
        whiteNotificationBar(recyclerView);


        fetchContacts();
    }

    private void fetchContacts() {
        JsonArrayRequest request = new JsonArrayRequest(Constant.urlSearchFilter,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response == null) {
                            Toast.makeText(getApplicationContext(), "Couldn't fetch the contacts! Pleas try again.", Toast.LENGTH_LONG).show();
                            return;
                        }

                      /*  List<Contact> items = new Gson().fromJson(response.toString(), new TypeToken<List<Contact>>() {
                        }.getType());*/
                        try {
                            JSONArray jArray = response;
                            for (int i = 0; i < jArray.length(); i++) {
                              Contact contact=new Contact();

                                JSONObject json_data = jArray.getJSONObject(i);

                                contact.setName(json_data.getString("name"));
                                contact.setImage(json_data.getString("image"));
                                contact.setPhone(json_data.getString("phone"));

                                contactArrayList.add(contact);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        contactFilterAdapter=new ContactFilterAdapter(SearchFilterMainActivity.this,contactArrayList,mContext);
                        recyclerView.setAdapter(contactFilterAdapter);
                        // refreshing recycler view
                        contactFilterAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error in getting json
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        MyApplication.getInstance().addToRequestQueue(request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Associate searchable configuration with the SearchView
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("onQueryTextSubmit",query);
                contactFilterAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("onQueryTextChange",newText);
                contactFilterAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itms=item.getItemId();
        if (itms==R.id.action_search)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        // close search view on back button pressed
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    public void onContactSelected(Contact contact) {
        Toast.makeText(getApplicationContext(), "Selected: " + contact.getName() + ", " + contact.getPhone(), Toast.LENGTH_LONG).show();
    }
}
