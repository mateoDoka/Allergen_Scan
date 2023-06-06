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

public class Sign_Up extends AppCompatActivity {
 EditText username,password;
 Button signUpBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username= findViewById(R.id.username);
        password =findViewById(R.id.password);
        signUpBtn= findViewById(R.id.loginbtn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    Toast.makeText(Sign_Up.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    MyAsyncTask asyncTask=new  MyAsyncTask();
                    asyncTask.execute();

                }
            }
        });


       
    }

    private class MyAsyncTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... voids) {

            UserDatabase userDatabase= UserDatabase.getUserDatabase(getApplicationContext());
            final UserDao userDao =userDatabase.userDao();
          UserTable userTable= new UserTable();
          userTable.setUsername(username.getText().toString());
          userTable.setPassword(password.getText().toString());
            userDao.insert(userTable);
            Intent intent= new Intent(Sign_Up.this,MainActivity.class);
            startActivity(intent);
            finish();
            return null;
        }
    }
}