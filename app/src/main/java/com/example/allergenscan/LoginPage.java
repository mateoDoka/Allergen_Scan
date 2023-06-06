package com.example.allergenscan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allergenscan.Registration.UserDao;
import com.example.allergenscan.Registration.UserDatabase;
import com.example.allergenscan.Registration.UserTable;

import java.util.List;

public class LoginPage extends AppCompatActivity {
EditText password, username;
 TextView text1;
 Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        UserTable userTable= new UserTable();
        password= findViewById(R.id.password);
        username = findViewById(R.id.username);
        text1=findViewById(R.id.forgotpass);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginPage.this,Sign_Up.class);
                startActivity(intent);
                finish();
            }
        });
        login =findViewById(R.id.loginbtn);
        SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        boolean isLoggedIn = preferences.getBoolean("is_logged_in", false);
        if(isLoggedIn==true){
            Intent intent= new Intent(LoginPage.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(  username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(LoginPage.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    MyAsyncTask myTask = new MyAsyncTask();
                    myTask.execute();
                }
            }
        });
    }
    private class MyAsyncTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... voids) {

            UserDatabase userDatabase= UserDatabase.getUserDatabase(getApplicationContext());
            final UserDao userDao =userDatabase.userDao();
            List<UserTable> userTable= userDao.login(username.getText().toString(),password.getText().toString());
           if(userTable==null){
               Toast.makeText(LoginPage.this, "User not found", Toast.LENGTH_SHORT).show();

           }  else {
               Intent intent= new Intent(LoginPage.this, MainActivity.class);
               startActivity(intent);

           }
            return null;
        }
    }

}