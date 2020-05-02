package cheema.hardeep.sahibdeep.fitnessapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUse {
    public static UserService getRetrofit() {
        UserService userService = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:1980/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserService.class);
        return userService;
    }
}
