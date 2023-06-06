package com.example.allergenscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {
Animation botAnimation,topAnimation;
LottieAnimationView lottieAnimationView;
TextView name;


private  static  int splash_screen_time=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        botAnimation= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        topAnimation=AnimationUtils.loadAnimation(this,R.anim.top_anim);
        lottieAnimationView= findViewById(R.id.logoScan);
        name=findViewById(R.id.textView);
        name.setAnimation(botAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent newIntent= new Intent(SplashScreen.this,LoginPage.class);
                startActivity(newIntent);
                finish();
            }
        },splash_screen_time) ;
    }
}
