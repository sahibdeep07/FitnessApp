package cheema.hardeep.sahibdeep.fitnessapp.viewmodel;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import cheema.hardeep.sahibdeep.fitnessapp.BR;
import cheema.hardeep.sahibdeep.fitnessapp.model.User;
import cheema.hardeep.sahibdeep.fitnessapp.model.UserResponse;
import cheema.hardeep.sahibdeep.fitnessapp.network.RetrofitUse;
import cheema.hardeep.sahibdeep.fitnessapp.network.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpViewModel extends BaseObservable {

    private String firstName;
    private String lastName;
    private String age;
    private String weight;
    private String height;
    private String username;
    private String password;

    private UserService userService = RetrofitUse.getRetrofit();

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
        notifyPropertyChanged(BR.weight);
    }

    @Bindable
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
        notifyPropertyChanged(BR.height);
    }

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

    public void signUpClicked(View view) {
        userService.createUser(generateUser()).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Toast.makeText(view.getContext(), "Hi" + response.body().getCode() + response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(view.getContext(), "BI", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private User generateUser() {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setHeight(height);
        user.setWeight(weight);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
