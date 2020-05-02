package cheema.hardeep.sahibdeep.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import cheema.hardeep.sahibdeep.fitnessapp.R;
import cheema.hardeep.sahibdeep.fitnessapp.builder.Student;
import cheema.hardeep.sahibdeep.fitnessapp.view.SeekBarWithNumber;

public class SplashActivity extends AppCompatActivity {

    SeekBarWithNumber seekBarWithNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }, 50000);

        seekBarWithNumber = findViewById(R.id.sbn);
        seekBarWithNumber.setDefaultSelected(50);
        seekBarWithNumber.setRangeSliderListener(newValue -> {
            Log.d("Sahib", newValue + "");
        });
    }

    public void testBuilder() {
        Student student = new Student.Builder()
                .setAge(12)
                .setName("Sahib")
                .setRollNumber("52")
                .build();

        String name = student.getName();
    }
}
