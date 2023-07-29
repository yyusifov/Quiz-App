package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quiz_app.util.User_Information_View_Model;

public class MainActivity extends AppCompatActivity {
    private Button signup, login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup = findViewById(R.id.sign_up_button1);
        login = findViewById(R.id.login_button1);
        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication()).create(User_Information_View_Model.class);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sign_up_page.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login_page.class);
                startActivity(intent);
            }
        });

    }
}