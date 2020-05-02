package cheema.hardeep.sahibdeep.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import cheema.hardeep.sahibdeep.fitnessapp.viewmodel.LoginViewModel;
import cheema.hardeep.sahibdeep.fitnessapp.R;
import cheema.hardeep.sahibdeep.fitnessapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        LoginViewModelLiveData loginViewModelLiveData = new ViewModelProvider(this).get(LoginViewModelLiveData.class);
//        ActivityLoginBinding loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
//        loginBinding.setViewModel(loginViewModelLiveData);
//        loginBinding.setLifecycleOwner(this); //IMPORTANT
        LoginViewModel loginViewModel = new LoginViewModel();
        ActivityLoginBinding loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginBinding.setViewModel(loginViewModel);
        getSupportActionBar().hide();
    }
}
