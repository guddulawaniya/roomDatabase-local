package com.example.livedata;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int i = 3;
    UserDao userDao;

    private List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = findViewById(R.id.name);
        EditText emailaddress = findViewById(R.id.emailaddress);
        EditText password = findViewById(R.id.password);
        Button loginbutton = findViewById(R.id.loginbutton);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
        userDao = db.userDao();
        users = userDao.getAll();


        for (User task : users) {
            Toast.makeText(this, "id : "+task.uid+"\nfirstname: " + task.firstName+"\nlastname : "+task.lastName, Toast.LENGTH_SHORT).show();
            // Process each task
        }


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String names = name.getText().toString();
                String email = emailaddress.getText().toString();
                String passwords = password.getText().toString();
                User users = new User();

                users.uid = ++i;
                users.firstName = names;
                users.lastName = email;
                userDao.insertAll(users);
                users =   userDao.findone_record(i);
                Toast.makeText(MainActivity.this, "users"+users.firstName, Toast.LENGTH_SHORT).show();

            }
        });
    }
}