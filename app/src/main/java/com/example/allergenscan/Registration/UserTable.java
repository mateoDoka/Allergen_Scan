package com.example.allergenscan.Registration;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserTable {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name ="username")
    public String username;
    @ColumnInfo(name = "password")
    public String password;

    public UserTable(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserTable() {

    }



    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
