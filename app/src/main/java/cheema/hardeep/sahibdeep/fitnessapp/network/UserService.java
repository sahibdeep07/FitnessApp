package cheema.hardeep.sahibdeep.fitnessapp.network;

import java.util.List;

import cheema.hardeep.sahibdeep.fitnessapp.model.User;
import cheema.hardeep.sahibdeep.fitnessapp.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {
    @POST("user/createUser")
    Call<UserResponse> createUser(@Body User user);

    @POST("user/login")
    Call<UserResponse> login(@Body User user);

}

