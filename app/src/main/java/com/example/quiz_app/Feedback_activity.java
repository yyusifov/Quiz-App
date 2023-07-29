package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.quiz_app.adapter.Feedback_adapter;

public class Feedback_activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        recyclerView = findViewById(R.id.feedback_recylerview);
        back = findViewById(R.id.backto);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Feedback_activity.this));
        Feedback_adapter feedback_adapter = new Feedback_adapter(getIntent().getIntegerArrayListExtra("wrongAnswers"));
        recyclerView.setAdapter(feedback_adapter);
    }
}