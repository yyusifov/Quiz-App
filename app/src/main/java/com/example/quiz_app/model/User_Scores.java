package com.example.quiz_app.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity
public class User_Scores {
    @ForeignKey
            (entity = User_Information.class,
                    parentColumns = "user_id",
                    childColumns = "user_score_id",
                    onDelete = CASCADE
            )
    @PrimaryKey(autoGenerate = true)
    private int score_id;

    public int getScore_id() {
        return score_id;
    }

    public void setScore_id(int score_id) {
        this.score_id = score_id;
    }

    public int getUser_score_id() {
        return user_score_id;
    }

    public void setUser_score_id(int user_score_id) {
        this.user_score_id = user_score_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int user_score_id;
    private int score;

    public User_Scores(int user_score_id, int score) {
        this.user_score_id = user_score_id;
        this.score = score;
    }
    public User_Scores(){}
}
