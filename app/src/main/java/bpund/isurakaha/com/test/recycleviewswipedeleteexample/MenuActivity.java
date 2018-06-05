package bpund.isurakaha.com.test.recycleviewswipedeleteexample;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

public class MenuActivity extends AppCompatActivity {

    ArrayList<Item> itemArrayList;
    String TAG = MenuActivity.class.getSimpleName();
    MenuAdapter menuAdapter;
    Context mContext;

    private ListView recyclerView;
    private View coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mContext = this;
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        getSupportActionBar().setTitle(getString(R.string.my_cart));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (ListView) findViewById(R.id.recycler_view_menu);
        // coordinatorLayout = findViewById(R.id.coordinator_layout);
        itemArrayList = new ArrayList<>();
        getData();
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String names = itemArrayList.get(position).getName();
                String urls = itemArrayList.get(position).getThumbnail();
                Intent intent = new Intent(MenuActivity.this, FullScreen.class);
                intent.putExtra(Constant.NAME, names);
                intent.putExtra(Constant.IMG_URL, urls);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        String URL = Constant.urlMenu;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(JSONArray response) {
                Log.d("response", response.toString());
                if (response == null) {
                    Toast.makeText(getApplicationContext(), "data not load..", Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    JSONArray jArray = response;
                    for (int i = 0; i < jArray.length(); i++) {
                        Item item = new Item();
                        JSONObject json_data = jArray.getJSONObject(i);
                        item.setId(json_data.getInt("id"));
                        item.setName(json_data.getString("name"));
                        item.setDescription(json_data.getString("description"));
                        item.setThumbnail(json_data.getString("thumbnail"));
                        item.setPrice(json_data.getDouble("price"));
                        itemArrayList.add(item);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

               /* Gson gson = new Gson();

             *//*   Type listType = new TypeToken<List<Item>>(){}.getType();
                List<Item> items = (List<Item>) gson.fromJson(response.toString(), listType);*//*

                Type listType = new TypeToken<List<Item>>(){}.getType();
                List<Item> items = (List<Item>) gson.fromJson(response.toString(), listType);
                // items.clear();
                itemArrayList.addAll(items);*/
                menuAdapter = new MenuAdapter(mContext, itemArrayList);
                recyclerView.setAdapter(menuAdapter);
                menuAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}
