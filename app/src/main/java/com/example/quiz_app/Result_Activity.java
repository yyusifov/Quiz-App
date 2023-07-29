package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.quiz_app.model.User_Scores;
import com.example.quiz_app.util.User_Information_View_Model;

import java.util.ArrayList;
import java.util.List;

public class Result_Activity extends AppCompatActivity {
    ImageView resultImage;
    Button mainpage_button, feedback_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mainpage_button = findViewById(R.id.mainpage_button);
        resultImage = findViewById(R.id.result_image);
        feedback_button = findViewById(R.id.feedback_button);

        for (int i = 0; i < getIntent().getIntegerArrayListExtra("Wrong Answers").size(); i++) {
            Log.d("Wrong answers1: ",  ""  +getIntent().getIntegerArrayListExtra("Wrong Answers").get(i));
        }
        for (int i = 0; i < getIntent().getIntegerArrayListExtra("Correct Answers").size(); i++) {
            Log.d("Correct answers1: ",  ""  +getIntent().getIntegerArrayListExtra("Correct Answers").get(i));
        }

        ArrayList<Integer> wrongAnswers = new ArrayList<>();
        int cnt = 0;

        for (int i = 1; i <= 5; i++) {
            cnt = 0;
            for (int j = 0; j < getIntent().getIntegerArrayListExtra("Correct Answers").size(); j++) {
                if(i == getIntent().getIntegerArrayListExtra("Correct Answers").get(j)){
                    cnt++;
                }
            }
            if(cnt == 0){
                wrongAnswers.add(i);
            }
        }

        mainpage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        feedback_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result_Activity.this, Feedback_activity.class);
                Log.d("Result", String.valueOf(wrongAnswers.size()));
                intent.putIntegerArrayListExtra("wrongAnswers", wrongAnswers);
                startActivity(intent);
            }
        });

        User_Scores user_scores = new User_Scores();
        user_scores.setUser_score_id(getIntent().getIntExtra("username_id",10));
        user_scores.setScore(getIntent().getIntegerArrayListExtra("Correct Answers").size());
        User_Information_View_Model.insertUserScore(user_scores);

        switch (getIntent().getIntegerArrayListExtra("Correct Answers").size()){
            case 0:
                resultImage.setImageResource(R.drawable.studymore);
                break;
            case 1:
                resultImage.setImageResource(R.drawable.terrible);
                break;
            case 2:
                resultImage.setImageResource(R.drawable.bad);
                break;
            case 3:
                resultImage.setImageResource(R.drawable.normal);
                break;
            case 4:
                resultImage.setImageResource(R.drawable.good);
                break;
            default:
                resultImage.setImageResource(R.drawable.perfect);
                break;
        }
    }
}