package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizQuestions extends AppCompatActivity {
    Button textButton, variantA,variantB,variantC,variantD, nextButton, backButton;
    TextView questionText, questionNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);
        textButton = findViewById(R.id.textButton);
        questionText = findViewById(R.id.question_txt);
        variantA = findViewById(R.id.variantA);
        variantB = findViewById(R.id.variantB);
        variantC = findViewById(R.id.variantC);
        variantD = findViewById(R.id.variantD);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        questionNumber = findViewById(R.id.questionNumber);
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizQuestions.this, Text_activity.class);
                startActivity(intent);
            }
        });

        Questions[] questions = new Questions[]{
                new Questions("What is a significant environmental advantage of electric vehicles over conventional vehicles?","Higher fuel efficiency","Lower emissions","Faster acceleration", "Greater cargo capacity",
                        "Lower emissions"),
                new Questions("Which technological advancement has contributed to the increased practicality of electric vehicles?","Improved fuel injection systems","Enhanced brake technology","Advancements in battery technology","Upgraded tire materials",
                        "Advancements in battery technology"),
                new Questions("What role do electric vehicles play in combating climate change?","Increasing greenhouse gas emissions","Reducing air pollution","Enhancing deforestation","Intensifying ozone depletion",
                        "Reducing air pollution"),
                new Questions("What is a crucial aspect that influences the adoption of electric vehicles by consumers?","Availability of gas station infrastructure","Complexity of electric vehicle maintenance","Government incentives and rebates","Production of loud engine noises",
                        "Government incentives and rebates"),
                new Questions("How have advancements in battery technology affected electric vehicles?","Reduced the range and charging capabilities","Increased the weight and decreased acceleration","Improved the range and charging capabilities","Hindered the performance and safety features",
                        "Improved the range and charging capabilities")};

        final int[] counter = {0};

        questionText.setText(questions[counter[0]].getQuestion());
        questionNumber.setText("Question " + (counter[0] + 1) + "/" + questions.length);
        variantA.setText(questions[counter[0]].getVariantA());
        variantB.setText(questions[counter[0]].getVariantB());
        variantC.setText(questions[counter[0]].getVariantC());
        variantD.setText(questions[counter[0]].getVariantD());

        ArrayList<Integer> wrongAnswers = new ArrayList<>();
        ArrayList<Integer> correctAnswers = new ArrayList<>();

        variantA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variantA.setTextColor(Color.rgb(0,0,0));
                variantB.setTextColor(Color.rgb(255,255,255));
                variantC.setTextColor(Color.rgb(255,255,255));
                variantD.setTextColor(Color.rgb(255,255,255));

                if(!variantA.getText().toString().toLowerCase().equals(questions[counter[0]].getAnswer().toLowerCase())){
                    if(!wrongAnswers.contains(counter[0] + 1)) {
                        wrongAnswers.add(counter[0] + 1);
                        Log.d("Correct answerA: ", questions[counter[0]].getAnswer());
                    }

                    if(correctAnswers.contains((counter[0] + 1))) {
                        for (int i = 0; i < correctAnswers.size(); i++) {
                            if (correctAnswers.get(i) == (counter[0] + 1)) {
                                correctAnswers.remove(i);
                            }
                        }
                    }
                }
                else{
                    if(wrongAnswers.contains(counter[0] + 1)){
                        for (int i = 0; i < wrongAnswers.size(); i++) {
                            if(wrongAnswers.get(i) == (counter[0] + 1)){
                                wrongAnswers.remove(i);
                            }
                        }
                    }

                    if(!correctAnswers.contains(counter[0] + 1)){
                        correctAnswers.add((counter[0] + 1));
                    }
                }
                variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(255,184,0)}));
                variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));

            }
        });

        variantB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variantB.setTextColor(Color.rgb(0,0,0));
                variantA.setTextColor(Color.rgb(255,255,255));
                variantC.setTextColor(Color.rgb(255,255,255));
                variantD.setTextColor(Color.rgb(255,255,255));

                if(!variantB.getText().toString().toLowerCase().equals(questions[counter[0]].getAnswer().toLowerCase())){
                    if(!wrongAnswers.contains(counter[0] + 1)) {
                        wrongAnswers.add(counter[0] + 1);
                        Log.d("Correct answerB: ", questions[counter[0]].getAnswer());

                    }

                    if(correctAnswers.contains((counter[0] + 1))) {
                        for (int i = 0; i < correctAnswers.size(); i++) {
                            if (correctAnswers.get(i) == (counter[0] + 1)) {
                                correctAnswers.remove(i);
                            }
                        }
                    }
                }
                else{
                    if(wrongAnswers.contains(counter[0] + 1)){
                        for (int i = 0; i < wrongAnswers.size(); i++) {
                            if(wrongAnswers.get(i) == (counter[0] + 1)){
                                wrongAnswers.remove(i);
                            }
                        }
                    }
                    if(!correctAnswers.contains(counter[0] + 1)){
                        correctAnswers.add((counter[0] + 1));
                    }
                }
                variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(255,184,0)}));
                variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));

            }
        });

        variantC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variantC.setTextColor(Color.rgb(0,0,0));
                variantB.setTextColor(Color.rgb(255,255,255));
                variantA.setTextColor(Color.rgb(255,255,255));
                variantD.setTextColor(Color.rgb(255,255,255));

                if(!variantC.getText().toString().toLowerCase().equals(questions[counter[0]].getAnswer().toLowerCase())){
                    if(!wrongAnswers.contains(counter[0] + 1)) {
                        wrongAnswers.add(counter[0] + 1);
                        Log.d("Correct answerC: ", questions[counter[0]].getAnswer());

                    }
                    if(correctAnswers.contains((counter[0] + 1))) {
                        for (int i = 0; i < correctAnswers.size(); i++) {
                            if (correctAnswers.get(i) == (counter[0] + 1)) {
                                correctAnswers.remove(i);
                            }
                        }
                    }
                }
                else{
                    if(wrongAnswers.contains(counter[0] + 1)){
                        for (int i = 0; i < wrongAnswers.size(); i++) {
                            if(wrongAnswers.get(i) == (counter[0] + 1)){
                                wrongAnswers.remove(i);
                            }
                        }
                    }
                    if(!correctAnswers.contains(counter[0] + 1)){
                        correctAnswers.add((counter[0] + 1));
                    }
                }

                variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(255,184,0)}));
                variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));

            }
        });

        variantD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variantD.setTextColor(Color.rgb(0,0,0));
                variantB.setTextColor(Color.rgb(255,255,255));
                variantC.setTextColor(Color.rgb(255,255,255));
                variantA.setTextColor(Color.rgb(255,255,255));

                if(!variantD.getText().toString().toLowerCase().equals(questions[counter[0]].getAnswer().toLowerCase())){
                    if(!wrongAnswers.contains(counter[0] + 1)) {
                        wrongAnswers.add(counter[0] + 1);
                        Log.d("Correct answerD: ", questions[counter[0]].getAnswer());

                    }
                    if(correctAnswers.contains((counter[0] + 1))) {
                        for (int i = 0; i < correctAnswers.size(); i++) {
                            if (correctAnswers.get(i) == (counter[0] + 1)) {
                                correctAnswers.remove(i);
                            }
                        }
                    }
                }
                else{
                    if(wrongAnswers.contains(counter[0] + 1)){
                        for (int i = 0; i < wrongAnswers.size(); i++) {
                            if(wrongAnswers.get(i) == (counter[0] + 1)){
                                wrongAnswers.remove(i);
                            }
                        }
                    }
                    if(!correctAnswers.contains(counter[0] + 1)){
                        correctAnswers.add((counter[0] + 1));
                    }
                }

                variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(255,184,0)}));
                variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));

            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((counter[0] + 1) < questions.length){
                    ++counter[0];
                    questionText.setText(questions[counter[0]].getQuestion());
                    variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                    variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                    variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                    variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));

                    variantB.setTextColor(Color.rgb(255,255,255));
                    variantC.setTextColor(Color.rgb(255,255,255));
                    variantA.setTextColor(Color.rgb(255,255,255));
                    variantD.setTextColor(Color.rgb(255,255,255));

                    questionNumber.setText("Question " + (counter[0] + 1) + "/" + questions.length);
                    variantA.setText(questions[counter[0]].getVariantA());
                    variantB.setText(questions[counter[0]].getVariantB());
                    variantC.setText(questions[counter[0]].getVariantC());
                    variantD.setText(questions[counter[0]].getVariantD());
                    if((counter[0] + 1) == questions.length){
                        nextButton.setText("Finish");
                    }
                }
                else if((counter[0] + 1) == questions.length){
                    variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                    variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                    variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                    variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));

                    variantB.setTextColor(Color.rgb(255,255,255));
                    variantC.setTextColor(Color.rgb(255,255,255));
                    variantA.setTextColor(Color.rgb(255,255,255));
                    variantD.setTextColor(Color.rgb(255,255,255));

                    Intent intent = new Intent(QuizQuestions.this, Result_Activity.class);
                    Log.d("Wassup", wrongAnswers.size() + "");
                    Log.d("Wassup1", correctAnswers.size() + "");
                    intent.putExtra("username_id",getIntent().getIntExtra("username_id",10));
                    intent.putIntegerArrayListExtra("Wrong Answers", wrongAnswers);
                    intent.putIntegerArrayListExtra("Correct Answers", correctAnswers);
                    startActivity(intent);
                    finish();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((counter[0] - 1) >= 0){
                    --counter[0];
                    nextButton.setText("Next");
                    questionText.setText(questions[counter[0]].getQuestion());
                    questionNumber.setText("Question " + (counter[0] + 1) + "/" + questions.length);

                    variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                    variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                    variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));
                    variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(38,50,56)}));

                    variantB.setTextColor(Color.rgb(255,255,255));
                    variantC.setTextColor(Color.rgb(255,255,255));
                    variantA.setTextColor(Color.rgb(255,255,255));
                    variantD.setTextColor(Color.rgb(255,255,255));

                    variantA.setText(questions[counter[0]].getVariantA());
                    variantB.setText(questions[counter[0]].getVariantB());
                    variantC.setText(questions[counter[0]].getVariantC());
                    variantD.setText(questions[counter[0]].getVariantD());
                }
            }
        });

    }
}