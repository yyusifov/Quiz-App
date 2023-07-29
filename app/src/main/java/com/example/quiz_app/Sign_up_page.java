package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.quiz_app.data.UsersWithScores;
import com.example.quiz_app.model.User_Information;
import com.example.quiz_app.util.User_Information_View_Model;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Sign_up_page extends AppCompatActivity {
    private ImageView back, user_logo, email_logo, password_logo;
    private EditText username, email, password;
    private Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        username = findViewById(R.id.username_txt1);
        password = findViewById(R.id.password_txt1);
        email = findViewById(R.id.email_txt1);
        user_logo = findViewById(R.id.user_logo1);
        email_logo = findViewById(R.id.email_logo1);
        password_logo = findViewById(R.id.lock_logo1);
        signUp = findViewById(R.id.signup_button);
        FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        float dp = getResources().getDisplayMetrics().density;
        int leftMargin1 = (int)(50.0 * dp);
        int leftMargin2 = (int)(6.0 * dp);
        back = findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        username.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(email.getText().toString().isEmpty()){
                    email.setHint("E-mail");
                    layoutParams2.leftMargin = leftMargin1;
                    email_logo.setVisibility(View.VISIBLE);
                    email.setLayoutParams(layoutParams2);

                }
                if(password.getText().toString().isEmpty()){
                    password.setHint("Password");
                    layoutParams2.leftMargin = leftMargin1;
                    password_logo.setVisibility(View.VISIBLE);
                    password.setLayoutParams(layoutParams2);
                }
                layoutParams1.leftMargin = leftMargin2;
                user_logo.setVisibility(View.GONE);
                username.setLayoutParams(layoutParams1);
                username.setHint("");
                return false;
            }
        });
        email.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(username.getText().toString().isEmpty()){
                    username.setHint("Username");
                    layoutParams2.leftMargin = leftMargin1;
                    user_logo.setVisibility(View.VISIBLE);
                    username.setLayoutParams(layoutParams2);
                }
                if(password.getText().toString().isEmpty()){
                    password.setHint("Password");
                    layoutParams2.leftMargin = leftMargin1;
                    password.setLayoutParams(layoutParams2);
                    password_logo.setVisibility(View.VISIBLE);
                }
                email.setHint("");
                layoutParams1.leftMargin = leftMargin2;
                email.setLayoutParams(layoutParams1);
                email_logo.setVisibility(View.GONE);
                return false;
            }
        });
        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(username.getText().toString().isEmpty()){
                    username.setHint("Username");
                    layoutParams2.leftMargin = leftMargin1;
                    username.setLayoutParams(layoutParams2);
                    user_logo.setVisibility(View.VISIBLE);
                }
                if(email.getText().toString().isEmpty()){
                    email.setHint("E-mail");
                    layoutParams2.leftMargin = leftMargin1;
                    email.setLayoutParams(layoutParams2);
                    email_logo.setVisibility(View.VISIBLE);
                }
                layoutParams1.leftMargin = leftMargin2;
                password.setLayoutParams(layoutParams1);
                password.setHint("");
                password_logo.setVisibility(View.GONE);
                return false;
            }
        });

        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(Sign_up_page.this.getApplication()).create(User_Information_View_Model.class);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!username.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                    final int[] cnt2 = {0};
                    user_information_view_model.getAllUserInformation().observe(Sign_up_page.this, new Observer<List<User_Information>>() {
                        @Override
                        public void onChanged(List<User_Information> user_informations) {
                            final int[] cnt = {0};

                            if(cnt2[0] == 0) {
                                cnt2[0]++;
                                for (int i = 0; i < user_informations.size(); i++) {
                                    if (username.getText().toString().equals(user_informations.get(i).getUsername())) {
                                        Snackbar.make(username, "Selected username is already taken. Please insert different one.", Snackbar.LENGTH_LONG).show();
                                        cnt[0]++;
                                    } else if (email.getText().toString().equals(user_informations.get(i).getEmail())) {
                                        Snackbar.make(username, "Selected email is already added by different account. Please insert different one.", Snackbar.LENGTH_LONG).show();
                                        cnt[0]++;
                                    }

                                }
                                if (cnt[0] == 0) {
                                    User_Information user_information = new User_Information();
                                    user_information.setUsername(username.getText().toString());
                                    user_information.setEmail(email.getText().toString());
                                    user_information.setPassword(password.getText().toString());
                                    User_Information_View_Model.insertUserInformation(user_information);

                                    username.setHint("Username");
                                    username.setText("");
                                    layoutParams2.leftMargin = leftMargin1;
                                    username.setLayoutParams(layoutParams2);
                                    user_logo.setVisibility(View.VISIBLE);

                                    email.setHint("E-mail");
                                    email.setText("");
                                    layoutParams2.leftMargin = leftMargin1;
                                    email.setLayoutParams(layoutParams2);
                                    email_logo.setVisibility(View.VISIBLE);

                                    password.setHint("Password");
                                    password.setText("");
                                    layoutParams2.leftMargin = leftMargin1;
                                    password.setLayoutParams(layoutParams2);
                                    password_logo.setVisibility(View.VISIBLE);
                                    Snackbar.make(username, "Congrats! The account was created. Now, you can log in!", Snackbar.LENGTH_LONG).show();
                                }
                            }
                        }
                    });


                }else{
                    Snackbar.make(username, "All fields should be filled", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}