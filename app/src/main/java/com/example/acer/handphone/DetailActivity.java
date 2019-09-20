package com.example.acer.handphone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    public static String KEY_ACTIVITY;
    private TextView namaProduk, ram, internalMemory,harga;
    private ImageView imgHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        namaProduk=(TextView)findViewById(R.id.nama_produk);
        ram=(TextView)findViewById(R.id.ram);
        internalMemory=(TextView)findViewById(R.id.internal_memory);
        harga=(TextView)findViewById(R.id.harga);
        imgHp=(ImageView)findViewById(R.id.pic);

        Intent intent=getIntent();
        HpKu hpNya=(HpKu)intent.getSerializableExtra(KEY_ACTIVITY);
        namaProduk.setText(hpNya.getNama_produk());
        ram.setText(hpNya.getRam());
        internalMemory.setText(hpNya.getInternal_memory());
        harga.setText(hpNya.getHarga());
        Picasso.with(this).load(hpNya.getPic()).into(imgHp);



    }
}
