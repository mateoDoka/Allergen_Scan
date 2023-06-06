package com.example.allergenscan.Registration;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void  insert(UserTable... userTables);



    @Query("SELECT * FROM users WHERE username=(:username) and password=(:pass)")
    List<UserTable> login(String username, String pass);

}
