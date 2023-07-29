package com.example.quiz_app.util;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.quiz_app.data.UsersWithScores;
import com.example.quiz_app.model.User_Information;
import com.example.quiz_app.model.User_Scores;
import com.example.quiz_app.repository.User_Information_Repository;

import java.util.List;

public class User_Information_View_Model extends AndroidViewModel {
    public static User_Information_Repository user_information_repository;
    public User_Information_View_Model(@NonNull Application application) {
        super(application);
        user_information_repository = new User_Information_Repository(application);
    }

    public LiveData<List<User_Information>> getAllUserInformation(){
        return user_information_repository.getAllUserInformation();
    }
    public LiveData<User_Information> getUserInformation(int user_id){
        return user_information_repository.getUserInformation(user_id);
    }
    public LiveData<List<UsersWithScores>> getAllUsersWithScore(){
        return user_information_repository.getUsersWithScores();
    }
    public static void insertUserInformation(User_Information user_information){
        user_information_repository.insertUserInformation(user_information);
    }
    public static void insertUserScore(User_Scores user_scores){
        user_information_repository.insertScore(user_scores);
    }
    public static void deleteUserInformation(User_Information user_information){
        user_information_repository.deleteUserInformation(user_information);
    }
    public static void deleteUserScore(User_Scores user_scores){
        user_information_repository.deleteScore(user_scores);
    }
    public static void deleteAll(){
        user_information_repository.deleteAllUserInformation();
    }
    public static void updateUserInformation(User_Information user_information){
        user_information_repository.updateUserInformation(user_information);
    }

}
