package com.example.myapplication123;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    @GET("{number}?json")
    Call<FactResponse> getFact(@Path("number") String number);
}
