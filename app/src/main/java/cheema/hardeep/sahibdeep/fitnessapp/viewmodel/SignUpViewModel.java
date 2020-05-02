package cheema.hardeep.sahibdeep.fitnessapp.viewmodel;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import cheema.hardeep.sahibdeep.fitnessapp.BR;
import cheema.hardeep.sahibdeep.fitnessapp.model.User;
import cheema.hardeep.sahibdeep.fitnessapp.network.FitnessApiService;
import cheema.hardeep.sahibdeep.fitnessapp.network.ServiceProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SignUpViewModel extends BaseObservable {

    private String firstName;
    private String lastName;
    private String age;
    private String weight;
    private String height;
    private String username;
    private String password;

    private FitnessApiService fitnessApiService = ServiceProvider.provideFitnessApiService();

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

    @SuppressLint("CheckResult")
    public void signUpClicked(View view) {
        fitnessApiService.createUser(generateUser())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    //Main Thread: You can do anything
                    Toast.makeText(view.getContext(), "Hi " + user.getFirstName(), Toast.LENGTH_SHORT).show();
                }, throwable -> {
                    //MainThread: Handle your Error
                    Toast.makeText(view.getContext(), "Something went wrong, Bye!", Toast.LENGTH_SHORT).show();
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
