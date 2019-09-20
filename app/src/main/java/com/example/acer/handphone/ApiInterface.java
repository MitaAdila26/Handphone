package com.example.acer.handphone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("bins/1132m9")
    Call<List<HpKu>>getHp();
}
