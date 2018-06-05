package bpund.isurakaha.com.test.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by isuraksha3 on 4/18/2018.
 */

public interface API {
    String BASE_URL = "https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
