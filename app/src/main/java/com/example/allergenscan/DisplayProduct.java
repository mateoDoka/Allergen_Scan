package com.example.allergenscan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class DisplayProduct extends AppCompatActivity {
 TextView product_name;
 ImageView product_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);

        Intent intent = getIntent();
        String extras = intent.getStringExtra("Response");
        TableLayout tableLayout = findViewById(R.id.nutrientTable);
        product_name =findViewById(R.id.productName);
        product_img =findViewById(R.id.productImg);

        
        try {
            JSONObject jsonObject = new JSONObject(extras);
            if (extras.isEmpty()) {
                Toast.makeText(this, "No item found", Toast.LENGTH_SHORT).show();
            } else {
                JSONObject product = jsonObject.getJSONObject("product");
                JSONObject nutriments = product.getJSONObject("nutriments");
                String productName= product.getString("product_name");
                String imageUrl = product.getString("image_front_url");
                Glide.with(this)
                        .load(imageUrl)
                        .into( product_img);
                product_name.setText(productName);
                // Extract nutrient information from the API response
                String energyAmount = product.getJSONObject("nutriments").optString("energy");
                String fatAmount = product.getJSONObject("nutriments").optString("fat");
                String carbohydratesAmount = product.getJSONObject("nutriments").optString("carbohydrates");
                String energyDailyValue = nutriments.optString("energy_daily_value");
                String fatDailyAmount= nutriments.optString("fat_daily_value");
                String carbohydratesDailyAmount=  product.getJSONObject("nutriments").optString("carbohydrates_daily_value");

                // Add more nutrient fields as needed

                // Create a TableRow for each nutrient
                addNutrientRow(tableLayout, "Energy", energyAmount );
                addNutrientRow(tableLayout, "Fat", fatAmount);
                addNutrientRow(tableLayout, "Carbohydrates", carbohydratesAmount );
                // Add more nutrients as needed
            }
        } catch (JSONException ex) {
            Toast.makeText(DisplayProduct.this, "No item found", Toast.LENGTH_SHORT).show();
        }
    }

    private void addNutrientRow(TableLayout tableLayout, String nutrient, String amount) {
        TableRow row = new TableRow(this);

        TextView nutrientTextView = new TextView(this);
        nutrientTextView.setText(nutrient);
        nutrientTextView.setPadding(8, 8, 8, 8);

        TextView amountTextView = new TextView(this);
        amountTextView.setText(amount);
        amountTextView.setPadding(8, 8, 8, 8);



        row.addView(nutrientTextView);
        row.addView(amountTextView);

        tableLayout.addView(row);
    }
}