package com.example.livedata;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private userViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = findViewById(R.id.name);
        EditText emailaddress = findViewById(R.id.emailaddress);
        EditText password = findViewById(R.id.password);
        Button loginbutton = findViewById(R.id.loginbutton);
        Button getdata = findViewById(R.id.getdata);
        RecyclerView recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));


        viewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(userViewModel.class);
        viewModel.getLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                myAdapter adapter = new myAdapter(users);
                recyclerview.setAdapter(adapter);


            }
        });
        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              viewModel.deleteAllUsers();
            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!name.getText().toString().isEmpty() && !emailaddress.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {

                    User user = new User(name.getText().toString(), emailaddress.getText().toString(), password.getText().toString());

                    viewModel.insert(user);
                }
            }
        });


    }
}