package bpund.isurakaha.com.test.retrofit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import bpund.isurakaha.com.test.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitDemoMainActivity extends AppCompatActivity {

    CustomAdapter customAdapter;
    Context mContext;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_demo_main);
        listView=(ListView)findViewById(R.id.retro_list);
        mContext=this;
  getHeroes();


    }

    private void getHeroes() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        API api = retrofit.create(API.class);

        Call<List<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                Log.d("responseTest",response.toString());
                List<Hero> list=response.body();

                customAdapter=new CustomAdapter(mContext,list);
                listView.setAdapter(customAdapter);


               /* for (int i=0;i<jsonArray.length();i++){
                    Data data=new Data();


                }*/

              /*  Gson gson = new Gson();
                List<Data> parseData = gson.fromJson(response.toString(),
                        new TypeToken<List<Data>>(){}.getType());
                Log.d("responseTestUsers",parseData.toString());*/
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });

    }


}
