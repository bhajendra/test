package bpund.isurakaha.com.test.json.parsing;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bpund.isurakaha.com.test.R;
import bpund.isurakaha.com.test.recycleviewswipedeleteexample.MyApplication;
import bpund.isurakaha.com.test.sortingarraylist.Student;

//https://beginnersbook.com/2015/05/java-boolean-to-string/
public class JsonParsingMainAcitivy extends AppCompatActivity {

    String url = "https://api.androidhive.info/contacts/";
    Context mContext;
    ListView listview_18;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parsing_main_acitivy);
        mContext = this;
        listview_18 = (ListView) findViewById(R.id.listview_18);
        //     callingAPI();
        // callsyncrhonizeMap();
        // gsonCallingType2(); 1{ 2 [ 3 {}]}
       // gsonCallingType1();  // 1[2[]]
        //dataDeserializationofArraysLists3(); //1 [ 2 {}] // fails
        jsonObject();
    }

    private void jsonObject() {
        JSONObject profile=new JSONObject();
        try {
            profile.put("firstName","bhajendra");
            profile.put("lastName","pund");
            profile.put("address","pune");
            profile.put("dist","pune");
            profile.put("pinCOde",41015);
            JSONObject skill=new JSONObject();
            skill.put("skill_1","android");
            skill.put("skill_2","java");
            profile.put("userSkill",skill);
            JSONArray qualificationDetails=new JSONArray();

            qualificationDetails.put("ssc : 2006");
            qualificationDetails.put("hsc : 2008");
            qualificationDetails.put("profile : 2011");
            qualificationDetails.put("master : 2015");
            profile.put("qualification",qualificationDetails);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("profile ", profile.toString());

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void dataDeserializationofArraysLists3() {
        List<Flower> flowerArrayList = new ArrayList<>();
        flowerArrayList.add(new Flower("rose",5));
        flowerArrayList.add(new Flower("Amaryllis",2));
        flowerArrayList.add(new Flower("Bellflower",1));
        flowerArrayList.add(new Flower("Bergamot",4));

       String convettolist=String.valueOf(flowerArrayList.toString());  // convet arraylist to string....
        Log.d("flowerArrayListRelt11 ", convettolist);
      /*  Gson gson = new Gson();
        Flower[] flowers=gson.fromJson(Arrays.asList(flowerArrayList).toString(),Flower[].class);*/
        Gson gson = new Gson();
        Type founderListType = new TypeToken<ArrayList<Flower>>(){}.getType();
        List<Flower> founderList = gson.fromJson(founderListType.toString(), founderListType);

       /* ArrayList<Flower> flowerAllData = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(flowers);
            for (int i = 0; i < jsonArray.length(); i++) {
                Flower flower=new Flower();
                JSONObject innerObj = jsonArray.getJSONObject(i);
                flower.setFlowerCount(innerObj.getInt("flowerCount"));
                flower.setName(innerObj.getString("name"));
                flowerAllData.add(flower);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
       /* CustomAdapter18 customAdapter18 = new CustomAdapter18(mContext, founderList);
        listview_18.setAdapter(customAdapter18);*/


       /* String flowerArrayListResult = gson.toJson(flowerArrayList);
        Log.d("flowerArrayListResult ", flowerArrayListResult);*/


    }

    private void gsonCallingType2() {
        List<Student> stude = new ArrayList<>();
        stude.add(new Student(1, "bhajendra"));
        stude.add(new Student(2, "ramraje"));
        stude.add(new Student(3, "ramraje"));
        stude.add(new Student(4, "ramraje"));
        Gson gson = new Gson();
        String restaurantJson = gson.toJson(stude);
        Log.d("restaurantJson1 ", restaurantJson);
        ArrayList<StudeBean> studeBeen = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(restaurantJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                StudeBean studeBeanObje = new StudeBean();
                JSONObject innerObj = jsonArray.getJSONObject(i);
                studeBeanObje.setId(innerObj.getInt("id"));
                studeBeanObje.setName(innerObj.getString("name"));

                studeBeen.add(studeBeanObje);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
       /* CustomAdapter18 customAdapter18 = new CustomAdapter18(mContext, studeBeen);
        listview_18.setAdapter(customAdapter18);*/

    }

    private void gsonCalling1() {

        List<Student> stude = new ArrayList<>();
        stude.add(new Student(1, "bhajendra"));
        stude.add(new Student(2, "ramraje"));

        NewStudent std = new NewStudent("Future Studio Steak House", stude);
        Gson gson = new Gson();
        String restaurantJson = gson.toJson(std);
        Log.d("restaurantJson ", restaurantJson);
        ArrayList<StudeBean> studeBeen = null;
        try {
            studeBeen = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(restaurantJson);
            JSONArray studObje = jsonObject.getJSONArray("stude");
            for (int i = 0; i < jsonObject.length(); i++) {
                StudeBean studeBean = new StudeBean();
                JSONObject innerObj = studObje.getJSONObject(i);
                studeBean.setId(innerObj.getInt("id"));
                studeBean.setName(innerObj.getString("name"));
                studeBeen.add(studeBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
       /* CustomAdapter18 customAdapter18 = new CustomAdapter18(mContext, studeBeen);
        listview_18.setAdapter(customAdapter18);*/
    }

    private void callsyncrhonizeMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "bhajendra");
        map.put(2, "bhajendra");
        map.put(3, "bhajendra");
        map.put(4, "bhajendra");
        // syncronization
        Map map1 = Collections.synchronizedMap(map);
        Set set = map1.entrySet();
        synchronized (map) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry val = (Map.Entry) iterator.next();
                Log.d("values ", val.getKey() + "" + val.getValue());
            }
        }
    }

    private void callingAPI() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("response", response.toString());
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("response", error.toString());
            }
        });
        MyApplication.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
