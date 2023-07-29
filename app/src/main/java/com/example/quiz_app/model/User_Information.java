package com.example.quiz_app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class User_Information {

    public User_Information() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @PrimaryKey(autoGenerate = true)
    private int user_id;
    private String username;

    public User_Information(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private String email;
    private String password;
}
