package gr.athenstech.course;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.athenstech.course.databinding.ActivityLoginScreenBinding;

public class LoginScreen extends AppCompatActivity {

    private ActivityLoginScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginScreenBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        if (getIntent().getExtras() != null) {
            String name = getIntent().getExtras().getString("name");
            Log.d("LoginScreen", "Received name: " + name);
        }

        binding.loginBtnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("age", 100);

                setResult(3000, intent);
                finish();
            }
        });
    }
}