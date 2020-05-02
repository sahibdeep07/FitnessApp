package cheema.hardeep.sahibdeep.fitnessapp;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import cheema.hardeep.sahibdeep.fitnessapp.model.User;
import cheema.hardeep.sahibdeep.fitnessapp.model.UserResponse;
import cheema.hardeep.sahibdeep.fitnessapp.network.RetrofitUse;
import cheema.hardeep.sahibdeep.fitnessapp.network.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends BaseObservable {

    private String username;
    private String password;

    private UserService userService = RetrofitUse.getRetrofit();

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void loginClicked(View view) {
        userService.login(generateUser()).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Toast.makeText(view.getContext(), "Success: " + response.body().getCode(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(view.getContext(), "Failure: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void signupClicked(View view) {
        view.getContext().startActivity(SignUpActivity.createIntent(view.getContext()));
    }

    private User generateUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
