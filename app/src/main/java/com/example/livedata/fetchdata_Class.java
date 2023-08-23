package com.example.livedata;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class fetchdata_Class {
    private  UserDao userDao;

    private LiveData<List<User>> liveData;

    public fetchdata_Class(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        userDao = database.userDao();
        liveData = userDao.getAlldata();
    }

    public void insert(User user){
        new InsertNoteAyncTask(userDao).execute(user);

    }
    public void update(User user){
        new updateNoteAyncTask(userDao).execute(user);

    }
    public void delete(User user){
        new deleteNoteAyncTask(userDao).execute(user);

    }
    public void deleteAllUsers(){
        new deleteAllNoteAyncTask(userDao).execute();

    }

    public  LiveData<List<User>> getLiveData() {
        return liveData;
    }

    private static  class  InsertNoteAyncTask  extends AsyncTask<User,Void,Void>{
        private  UserDao userDao;

        public InsertNoteAyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }
    private static  class  updateNoteAyncTask  extends AsyncTask<User,Void,Void>{
        private  UserDao userDao;

        public updateNoteAyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.update(users[0]);
            return null;
        }
    }

    private static  class  deleteNoteAyncTask  extends AsyncTask<User,Void,Void>{
        private  UserDao userDao;

        public deleteNoteAyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.delete(users[0]);
            return null;
        }
    }
    private static  class  deleteAllNoteAyncTask  extends AsyncTask<User,Void,Void>{
        private  UserDao userDao;

        public deleteAllNoteAyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.deleteAllUsers();
            return null;
        }
    }
}
