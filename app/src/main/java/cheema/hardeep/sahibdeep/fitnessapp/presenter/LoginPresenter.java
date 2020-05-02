package cheema.hardeep.sahibdeep.fitnessapp.presenter;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cheema.hardeep.sahibdeep.fitnessapp.activity.SignUpActivity;
import cheema.hardeep.sahibdeep.fitnessapp.model.User;
import cheema.hardeep.sahibdeep.fitnessapp.model.UserResponse;
import cheema.hardeep.sahibdeep.fitnessapp.network.RetrofitUse;
import cheema.hardeep.sahibdeep.fitnessapp.network.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {

    private UserService userService;
    private Context context;

    public LoginPresenter(Context context) {
        this.userService = RetrofitUse.getRetrofit();
        this.context = context;
    }

    public void attachLogin(Button login, EditText username, EditText password) {
        login.setOnClickListener(view -> LoginPresenter.this.login(username, password));
    }

    public void attachSignUp(TextView signup) {
        signup.setOnClickListener(view -> context.startActivity(SignUpActivity.createIntent(view.getContext())));
    }

    public void login(EditText username, EditText password) {
        User user = getLoginData(username.getText().toString() , password.getText().toString());
        userService.login(user).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Toast.makeText(context, "Success: " + response.body().getCode(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(context, "Failure: " + t.getLocalizedMessage() , Toast.LENGTH_SHORT).show();
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
