package com.example.livedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class userViewModel extends AndroidViewModel{
    private  fetchdata_Class repository;
    private LiveData<List<User>> liveData;


    public userViewModel(@NonNull Application application) {
        super(application);
        repository = new fetchdata_Class(application);
        liveData = repository.getLiveData();
    }

    public void insert(User user){
        repository.insert(user);
    }
    public void update(User user){
        repository.update(user);
    }
    public void delete(User user){
        repository.delete(user);
    }
    public void deleteAllUsers() {
        repository.deleteAllUsers();
    }

    public LiveData<List<User>> getLiveData() {
        return liveData;
    }
}
