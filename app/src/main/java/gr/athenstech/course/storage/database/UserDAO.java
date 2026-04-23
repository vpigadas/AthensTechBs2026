package gr.athenstech.course.storage.database;

import android.database.SQLException;

import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    void save(UserEntity user);
    @Insert
    void insert(UserEntity user) throws SQLException;

    @Update
    void update(UserEntity user) throws SQLException;

    @Delete
    void delete(UserEntity user);

    @Query("SELECT * FROM UserEntity WHERE id = :userId")
    @Nullable
    UserEntity getUserById(int userId);

    @Query("SELECT * FROM UserEntity")
    List<UserEntity> getAllUsers();

}
