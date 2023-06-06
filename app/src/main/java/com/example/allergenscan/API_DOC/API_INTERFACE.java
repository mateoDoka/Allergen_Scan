package com.example.allergenscan.API_DOC;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public  interface API_INTERFACE {

    @GET("product/{barcode}.json")
    Call<ResponseBody> getProduct(@Path("barcode") String barcode);
}
