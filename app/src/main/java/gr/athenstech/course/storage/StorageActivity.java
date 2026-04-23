package gr.athenstech.course.storage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.athenstech.course.databinding.ActivityStorageBinding;

public class StorageActivity extends AppCompatActivity {

    private ActivityStorageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences("storage_data", MODE_PRIVATE);

        binding.storageTxt.setText(sharedPreferences.getString("value", "default value"));

//        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
//        preferences.edit().putString("name", "vassilis").apply();
//        preferences.edit().putString("name", "vassilis").commit();
//
//        sharedPreferences.edit().putString("name", "vassilis").apply();
//        String name = sharedPreferences.getString("name", "default value");

        binding.storageBtnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.storageTxt.setText(saveData(true));

            }
        });

        binding.storageBtnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.storageTxt.setText(saveData(false));
            }
        });
    }

    private String saveData(boolean up) {
        SharedPreferences sharedPreferences = getSharedPreferences("storage_data", MODE_PRIVATE);
        String value = sharedPreferences.getString("value", "0");
        int intValue = Integer.parseInt(value);
        if(up){
            intValue++;
        }else{
            intValue--;
        }
        sharedPreferences.edit().putString("value", String.valueOf(intValue)).apply();
        return String.valueOf(intValue);
    }
}