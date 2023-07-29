package com.example.quiz_app.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.quiz_app.data.UserDAO;
import com.example.quiz_app.data.UsersWithScores;
import com.example.quiz_app.model.User_Information;
import com.example.quiz_app.model.User_Scores;
import com.example.quiz_app.util.DatabaseRoom;

import java.util.List;

public class User_Information_Repository {
    private final UserDAO userDao;
    public User_Information_Repository(Application application){
        DatabaseRoom databaseRoom = DatabaseRoom.getInstance(application.getApplicationContext());
        userDao = databaseRoom.getUserDAO();
    }

    public LiveData<List<User_Information>> getAllUserInformation(){
        return userDao.getAllUsers();
    }
    public LiveData<User_Information> getUserInformation(int user_id){
        return userDao.getUser(user_id);
    }
    public void insertUserInformation(User_Information user_information){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(user_information);
            }
        });
    }
    public void updateUserInformation(User_Information user_information){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDao.updateUsers(user_information);
            }
        });
    }
    public void deleteUserInformation(User_Information user_information){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDao.deleteUser(user_information);
            }
        });
    }
    public void deleteAllUserInformation(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDao.deleteAllUsers();
            }
        });
    }

    public LiveData<List<UsersWithScores>> getUsersWithScores(){
        return userDao.getUsersWithScores();
    }
    public void insertScore(User_Scores user_scores){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertScore(user_scores);
            }
        });
    }

    public void deleteScore(User_Scores user_scores){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDao.deleteScore(user_scores);
            }
        });
    }

}
