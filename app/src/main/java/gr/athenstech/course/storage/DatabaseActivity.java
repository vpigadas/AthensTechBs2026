package gr.athenstech.course.storage;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import gr.athenstech.course.databinding.ActivityDatabaseBinding;
import gr.athenstech.course.storage.database.DatabaseInstance;
import gr.athenstech.course.storage.database.UserEntity;

public class DatabaseActivity extends AppCompatActivity {

    private ActivityDatabaseBinding binding;
    private Executor executor = Executors.newSingleThreadExecutor();

    private MutableLiveData<List<UserEntity>> _usersLiveData = new MutableLiveData<>();
    LiveData<List<UserEntity>> usersLiveData = _usersLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DatabaseInstance database = Room
                .databaseBuilder(this, DatabaseInstance.class, "user_database")
//                .allowMainThreadQueries()
                .build();

        updateUi();

        usersLiveData.observe(this, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> userEntities) {
                StringBuilder stringBuilder = new StringBuilder();

                for (UserEntity userEntity : userEntities) {
                    stringBuilder.append(userEntity.getName()).append(" - ");
                }

                binding.databaseData.setText(stringBuilder.toString());
            }
        });

        binding.databaseAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        database.userDAO().save(new UserEntity("vassilis", "athens"));
                        updateUi();
                    }
                });
            }
        });
    }

    private void updateUi() {
        DatabaseInstance database = Room
                .databaseBuilder(this, DatabaseInstance.class, "user_database")
//                .allowMainThreadQueries()
                .build();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                _usersLiveData.postValue(database.userDAO().getAllUsers());

//                StringBuilder stringBuilder = new StringBuilder();
//
//                for (UserEntity userEntity : database.userDAO().getAllUsers()) {
//                    stringBuilder.append(userEntity.getName()).append("\n");
//                }
//
//                binding.databaseData.setText(stringBuilder.toString());
            }
        });
    }
}
