package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.quiz_app.model.User_Information;
import com.example.quiz_app.util.User_Information_View_Model;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Login_page extends AppCompatActivity {
    ImageView back, username_logo, password_logo;
    EditText username, password;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        back = findViewById(R.id.back2);
        username_logo = findViewById(R.id.username_logo2);
        password_logo = findViewById(R.id.lock_logo2);
        username = findViewById(R.id.username_txt2);
        loginButton = findViewById(R.id.login_button);
        password = findViewById(R.id.password_txt2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        float density = getResources().getDisplayMetrics().density;
        int leftMargin1 = (int)(50.0 * density);
        int leftMargin2 = (int)(6.0 * density);

        layoutParams1.leftMargin = leftMargin1;
        layoutParams2.leftMargin = leftMargin2;

        username.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(password.getText().toString().isEmpty()){
                    password_logo.setVisibility(View.VISIBLE);
                    password.setLayoutParams(layoutParams1);
                    password.setHint("Password");
                }
                username_logo.setVisibility(View.GONE);
                username.setHint("");
                username.setLayoutParams(layoutParams2);
                return false;
            }
        });

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(username.getText().toString().isEmpty()){
                    username_logo.setVisibility(View.VISIBLE);
                    username.setLayoutParams(layoutParams1);
                    username.setHint("Username");
                }
                password_logo.setVisibility(View.GONE);
                password.setHint("");
                password.setLayoutParams(layoutParams2);
                return false;
            }
        });

        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(Login_page.this.getApplication()).create(User_Information_View_Model.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                    user_information_view_model.getAllUserInformation().observe(Login_page.this, new Observer<List<User_Information>>() {
                        @Override
                        public void onChanged(List<User_Information> user_informations) {
                            for (int i = 0; i < user_informations.size(); i++) {
                                if(username.getText().toString().equals(user_informations.get(i).getUsername()) && password.getText().toString().equals(user_informations.get(i).getPassword())){
                                    Intent intent = new Intent(Login_page.this, MainPage.class);
                                    intent.putExtra("username_id",user_informations.get(i).getUser_id());
                                    startActivity(intent);
                                }
                                else{
                                    Snackbar.make(username, "Username or password is wrong!", Snackbar.LENGTH_LONG).show();
                                }
                            }
                        }
                    });

                }
                else{
                    Snackbar.make(username, "All fields should be filled!", Snackbar.LENGTH_LONG).show();
                }

            }
        });
    }
}