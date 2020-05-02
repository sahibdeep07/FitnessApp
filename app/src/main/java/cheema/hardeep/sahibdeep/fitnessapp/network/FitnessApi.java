package cheema.hardeep.sahibdeep.fitnessapp.network;


import cheema.hardeep.sahibdeep.fitnessapp.model.User;
import cheema.hardeep.sahibdeep.fitnessapp.model.UserResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FitnessApi {

    @POST("user/createUser")
    Observable<UserResponse> makeUser(@Body User user);

    @POST("user/login")
    Observable<UserResponse> login(@Body User user);
}

