package com.example.quiz_app.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.quiz_app.model.User_Information;
import com.example.quiz_app.model.User_Scores;

import java.util.List;

public class UsersWithScores {
    @Embedded public User_Information user_information;
    @Relation(
                  parentColumn = "user_id",
                  entityColumn = "user_score_id"
          )
    public List<User_Scores> user_scores;
}