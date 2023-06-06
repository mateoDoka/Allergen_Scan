package com.example.allergenscan.Registration;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserTable.class},version = 1)
public  abstract class UserDatabase extends  RoomDatabase{

    private static UserDatabase INSTANCE;
    public  static   UserDatabase getUserDatabase(Context context){
         if(INSTANCE==null){
             INSTANCE = Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,"users").build();

         }
         return  INSTANCE;
    }
    public  abstract  UserDao userDao();



}
