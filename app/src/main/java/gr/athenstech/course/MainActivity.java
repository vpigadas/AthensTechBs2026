package gr.athenstech.course;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.snackbar.Snackbar;

import gr.athenstech.course.databinding.ActivityMainBinding;
import gr.athenstech.course.fragments.MyFragmentActivity;
import gr.athenstech.course.list.RecyclerActivity;
import gr.athenstech.course.network.NetworkActivity;
import gr.athenstech.course.sample.SplashActivity;
import gr.athenstech.course.storage.DatabaseActivity;
import gr.athenstech.course.storage.StorageActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.mainBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "First button clicked");
                Snackbar.make(v, "First button clicked", Snackbar.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, LoginScreen.class);
                intent.putExtra("name", "vassilis");
//                startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });

        binding.mainBtnLogin.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(v, "First button long clicked", Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });

        binding.mainBtnNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Network button clicked");

                Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(intent);
            }
        });

        binding.mainBtnSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Sample button clicked");

                Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

        binding.mainBtnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Recycler button clicked");

                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });

        binding.mainBtnStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Storage button clicked");

                Intent intent = new Intent(MainActivity.this, StorageActivity.class);
                startActivity(intent);
            }
        });

        binding.mainBtnDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Database button clicked");

                Intent intent = new Intent(MainActivity.this, DatabaseActivity.class);
                startActivity(intent);
            }
        });

        binding.mainBtnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Fragment button clicked");

                Intent intent = new Intent(MainActivity.this, MyFragmentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("MainActivity", "onActivityResult called with requestCode: " + requestCode + ", resultCode: " + resultCode);
        Log.d("MainActivity", "Data received: " + (data != null ? data.getExtras().getInt("age") : "null"));
    }
}
