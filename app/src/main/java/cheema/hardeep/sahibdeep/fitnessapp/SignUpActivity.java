package cheema.hardeep.sahibdeep.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import cheema.hardeep.sahibdeep.fitnessapp.databinding.ActivitySignupBinding;

public class SignUpActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, SignUpActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SignUpViewModel signUpViewModel = new SignUpViewModel();
        ActivitySignupBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        binding.setViewModel(signUpViewModel);
        getSupportActionBar().hide();
    }
}
