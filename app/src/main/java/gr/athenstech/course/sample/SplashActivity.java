package gr.athenstech.course.sample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import gr.athenstech.course.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d("SplashActivity", "onCreate called");

        binding.viewpager.setAdapter(new CustomPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("SplashActivity", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("SplashActivity", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("SplashActivity", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("SplashActivity", "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("SplashActivity", "onDestroy called");
    }
}