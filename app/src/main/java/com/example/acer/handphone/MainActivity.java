package com.example.acer.handphone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiInterface apiInterface;
    private List<HpKu>hpku;
    RecyclerView Hp;
    RecyclerView.LayoutManager layoutManager;
    HpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hp=(RecyclerView)findViewById(R.id.hp);
        layoutManager=new LinearLayoutManager(this);
        Hp.setLayoutManager(layoutManager);
        Hp.setHasFixedSize(true);

        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call <List<HpKu>>call=apiInterface.getHp();
        call.enqueue(new Callback<List<HpKu>>() {
            @Override
            public void onResponse(Call<List<HpKu>> call, Response<List<HpKu>> response) {
                hpku=response.body();
                adapter=new HpAdapter(hpku, MainActivity.this);
                Hp.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<HpKu>> call, Throwable t) {

            }
        });

    }
}
