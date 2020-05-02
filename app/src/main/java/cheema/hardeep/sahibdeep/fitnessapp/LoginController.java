package cheema.hardeep.sahibdeep.fitnessapp;

import android.widget.Toast;

import cheema.hardeep.sahibdeep.fitnessapp.model.User;
import cheema.hardeep.sahibdeep.fitnessapp.model.UserResponse;
import cheema.hardeep.sahibdeep.fitnessapp.network.RetrofitUse;
import cheema.hardeep.sahibdeep.fitnessapp.network.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginController {

    private UserService userService;
    private LoginInterface loginInterface;

    public LoginController(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
        this.userService = RetrofitUse.getRetrofit();
    }

    public void login(String username, String password) {
        User user = getLoginData(username, password);
        userService.login(user).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                loginInterface.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                loginInterface.onFailure(t);
            }
        });
    }

    private User getLoginData(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
