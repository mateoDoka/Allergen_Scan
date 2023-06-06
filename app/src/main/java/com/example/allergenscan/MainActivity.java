package com.example.allergenscan;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
import java.io.IOException;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.allergenscan.API_DOC.*;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton scanBtn;
    ImageView profile_btn,productsBTn;
    String code = "";
    FrameLayout fragmentContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentContainer = findViewById(R.id.frameLayout);
        profileFragment profileFragment = new profileFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, profileFragment);
        fragmentTransaction.commit();

        scanBtn=findViewById(R.id.scan_btn);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Scan();
            }
        });
        profile_btn=findViewById(R.id.profile_img);
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frameLayout,profileFragment.class,null)
                            .setReorderingAllowed(true)
                            .commit();
            }
        });
        productsBTn=findViewById(R.id.products_img);
        productsBTn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frameLayout,ProductFragment.class,null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });
    }

    public void Scan() {
        ScanOptions scanOptions = new ScanOptions();
        scanOptions.setCaptureActivity(CaptureAct.class);
        scanResult.launch(scanOptions);
    }
    ActivityResultLauncher<ScanOptions> scanResult = registerForActivityResult(new ScanContract(), result -> {
        code = result.getContents();
        if (code != null) {
            getInfoCode(code);
        }
    });

    public void getInfoCode(String code) {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct(code);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                    String jsonString = null;
                    try {
                        if(response.isSuccessful()){
                            jsonString = response.body().string();
                            Intent intent = new Intent(MainActivity.this,DisplayProduct.class);
                            intent.putExtra("Response", jsonString);
                            startActivity(intent);
                        }
                         else {
                                Toast.makeText(MainActivity.this, "No item found 222", Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }

}