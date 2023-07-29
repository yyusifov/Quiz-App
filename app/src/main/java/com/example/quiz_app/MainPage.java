package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiz_app.data.UsersWithScores;
import com.example.quiz_app.model.User_Information;
import com.example.quiz_app.util.User_Information_View_Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainPage extends AppCompatActivity {
    Button startButton;
    TextView welcome_txt, first_score, second_score, third_score, fourth_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        startButton = findViewById(R.id.startButton);
        welcome_txt = findViewById(R.id.welcome_txt);
        first_score = findViewById(R.id.first_score);
        second_score = findViewById(R.id.secondscore);
        third_score = findViewById(R.id.thirdscore);
        fourth_score = findViewById(R.id.fourthscore);

        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(MainPage.this.getApplication()).create(User_Information_View_Model.class);
        user_information_view_model.getUserInformation(getIntent().getIntExtra("username_id",10)).observe(MainPage.this, new Observer<User_Information>() {
            @Override
            public void onChanged(User_Information user_information) {
                welcome_txt.setText(("Welcome Back " + user_information.getUsername()).toUpperCase());
            }
        });

        user_information_view_model.getAllUsersWithScore().observe(MainPage.this, new Observer<List<UsersWithScores>>() {
            @Override
            public void onChanged(List<UsersWithScores> usersWithScores) {
                for (int i = 0; i < usersWithScores.size(); i++) {
                    if(usersWithScores.get(i).user_information.getUser_id() == getIntent().getIntExtra("username_id",10)){

                        for (int j = usersWithScores.get(i).user_scores.size() - 1; j >= 0; j--) {

                            String evaluation = "";

                            switch (usersWithScores.get(i).user_scores.get(j).getScore()){
                                case 0:
                                    evaluation = "STUDY MORE";
                                    break;
                                case 1:
                                    evaluation = "TERRIBLE";
                                    break;
                                case 2:
                                    evaluation = "BAD";
                                    break;
                                case 3:
                                    evaluation = "NORMAL";
                                    break;
                                case 4:
                                    evaluation = "GOOD";
                                    break;
                                default:
                                    evaluation = "PERFECT";
                                    break;
                            }

                            if(j == usersWithScores.get(i).user_scores.size() - 1){
                                first_score.setText("1. " + evaluation + " - " + (usersWithScores.get(i).user_scores.get(j).getScore()) + "/5");
                            }
                            else if(j == usersWithScores.get(i).user_scores.size() - 2){
                                second_score.setText("2. " + evaluation + " - " + (usersWithScores.get(i).user_scores.get(j).getScore()) + "/5");
                            }
                            else if(j == usersWithScores.get(i).user_scores.size() - 3){
                                third_score.setText("3. " + evaluation + " - " + (usersWithScores.get(i).user_scores.get(j).getScore()) + "/5");
                            }
                            else if(j == usersWithScores.get(i).user_scores.size() - 4){
                                fourth_score.setText("4. " + evaluation + " - " + (usersWithScores.get(i).user_scores.get(j).getScore()) + "/5");
                            }

                        }
                    }
                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, QuizQuestions.class);
                Log.d("Mainpage: ", String.valueOf(getIntent().getIntExtra("username_id",10)));
                intent.putExtra("username_id", getIntent().getIntExtra("username_id",10));
                startActivity(intent);
            }
        });
    }
}