package com.example.quiz_app.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.quiz_app.model.User_Information;
import com.example.quiz_app.model.User_Scores;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUser(User_Information user_information);
    @Delete
    void deleteUser(User_Information user_information);
    @Query("Select * from User_Information WHERE User_Information.user_id == :user_id")
    LiveData<User_Information> getUser(int user_id);
    @Query("Select * from User_Information Order by User_Information.username")
    LiveData<List<User_Information>> getAllUsers();
    @Update
    void updateUsers(User_Information user_information);
    @Query("Delete from  User_Information")
    void deleteAllUsers();
    @Transaction
    @Query("Select * from User_Information")
    LiveData<List<UsersWithScores>> getUsersWithScores();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertScore(User_Scores user_scores);
    @Delete
    void deleteScore(User_Scores user_scores);


}
