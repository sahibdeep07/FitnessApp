package cheema.hardeep.sahibdeep.fitnessapp.network;


import cheema.hardeep.sahibdeep.fitnessapp.model.User;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FitnessApiServiceProvider implements FitnessApiService {

    private static final String BASE_URL = "http://10.0.2.2:1980/";
    private FitnessApi fitnessApi;

    public FitnessApiServiceProvider() {
        fitnessApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(FitnessApi.class);
    }

    @Override
    public Observable<User> createUser(User user) {
        return fitnessApi.makeUser(user).map(userResponse -> {
            return userResponse.getData();
        });
    }

    @Override
    public Observable<User> login(User user) {
        return fitnessApi.login(user).map(userResponse -> {
            return userResponse.getData();
        });
    }
}
