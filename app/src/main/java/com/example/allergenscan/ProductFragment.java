package com.example.allergenscan;



import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.allergenscan.API_DOC.RestAPI;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductFragment extends Fragment {
ImageView productImg1,productImg2,productImg3,productImg4,productImg5,productImg6,productImg7,productImg8,productImg9,productImg10,productImg11,productImg12,productImg13,productImg14,productImg15,productImg16;
   TextView productname1,productname2,productname3,productname4,productname5,productname6,productname7,productname8,productname9,productname10,productname11,productname12,productname13,productname14,productname15,productname16 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        productImg1 = view.findViewById(R.id.productImg1);
        productImg2=view.findViewById(R.id.productImg2);
        productImg3=view.findViewById(R.id.productImg3);
        productImg4=view.findViewById(R.id.productImg4);
        productImg5 =view.findViewById(R.id.productImg5);
        productImg6=view.findViewById(R.id.productImg6);
        productImg7=view.findViewById(R.id.productImg7);
        productImg8=view.findViewById(R.id.productImg8);
        productImg9=view.findViewById(R.id.productImg9);
        productImg10=view.findViewById(R.id.productImg10);
        productImg11=view.findViewById(R.id.productImg11);
        productImg12=view.findViewById(R.id.productImg12);
        productImg13=view.findViewById(R.id.productImg13);
        productImg14=view.findViewById(R.id.productImg14);
        productImg15=view.findViewById(R.id.productImg15);
        productImg16=view.findViewById(R.id.productImg16);
        productname1=view.findViewById(R.id.productname1);
        productname2=view.findViewById(R.id.productname2);
        productname3=view.findViewById(R.id.productname3);
        productname4=view.findViewById(R.id.productname4);
        productname5=view.findViewById(R.id.productname5);
        productname6=view.findViewById(R.id.productname6);
        productname7=view.findViewById(R.id.productname7);
        productname8=view.findViewById(R.id.productname8);
        productname9=view.findViewById(R.id.productname9);
        productname10=view.findViewById(R.id.productname10);
        productname11=view.findViewById(R.id.productname11);
        productname12=view.findViewById(R.id.productname12);
        productname13=view.findViewById(R.id.productname13);
        productname14=view.findViewById(R.id.productname14);
        productname15=view.findViewById(R.id.productname15);
        productname16=view.findViewById(R.id.productname16);


        MyAsyncTask asyncTask=new  MyAsyncTask();
        asyncTask.execute();
        return view;

    }

    private class MyAsyncTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            getInfoCode1();
            getInfoCode2();
            getInfoCode3();
            getInfoCode4();
            getInfoCode5();
            getInfoCode6();
            getInfoCode7();
            getInfoCode8();
            getInfoCode9();
            getInfoCode10();
            getInfoCode11();
            getInfoCode12();
            getInfoCode13();
            getInfoCode14();
            getInfoCode15();
            getInfoCode16();
            return null;
        }
    }
    public void getInfoCode1() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("3017620422003");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname1.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg1);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode2() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("6009510806168");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        String imageUrl = product.getString("image_front_url");
                        productname2.setText(productName);
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg2);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode3() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("5449000000996");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname3.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg3);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode4() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("040000464082");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname4.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg4);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode5() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("5000159459228");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname5.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg5);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode6() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("5060335632777");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname6.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg6);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode7() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("6221033101517");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname7.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg7);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode8() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("5449000000996");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname8.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg8);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode9() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("7622300270506");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname9.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg9);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode10() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("7622300510121");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname10.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg10);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode11() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("7622200009176");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname11.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg11);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode12() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("7622200009176");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname12.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg12);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode13() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("7622200009176");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname13.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg13);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode14() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("7622300270506");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname14.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg14);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode15() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("5000159461128");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname15.setText(productName);
                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg15);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getInfoCode16() {
        Call<ResponseBody> call = RestAPI.apiCall().getProduct("5449000000996");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if(response.isSuccessful()){
                        jsonString = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonString);
                        JSONObject product = jsonObject.getJSONObject("product");
                        String productName= product.getString("product_name");
                        productname16.setText(productName);

                        String imageUrl = product.getString("image_front_url");
                        Glide.with(ProductFragment.this)
                                .load(imageUrl)
                                .into(productImg16);
                    }
                    else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Error no api call", Toast.LENGTH_SHORT).show();
            }
        });
    }



}