package com.example.livedata;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {


    @Query("SELECT * FROM logindata")
    LiveData<List<User>> getAlldata();

    @Query("SELECT * FROM logindata where id= :id")
    User find_record(int id);

    @Insert
    void insert(User users);
    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM logindata")
    void deleteAllUsers();

}
