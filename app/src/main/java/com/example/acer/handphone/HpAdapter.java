package com.example.acer.handphone;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HpAdapter extends RecyclerView.Adapter<HpAdapter.hp>{
    List<HpKu>hpku;
    Activity activity;

    public HpAdapter(List<HpKu> hpku, Activity activity) {
        this.hpku = hpku;
        this.activity = activity;
    }

    @NonNull
    @Override
    public hp onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hp_item,parent,false);
        return new hp(view);
    }

    @Override
    public void onBindViewHolder(@NonNull hp holder, final int i) {
        holder.namaProduk.setText(hpku.get(i).getNama_produk());
        Picasso.with(activity).load(hpku.get(i).getPic()).into(holder.imgHp);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               HpKu hpKuu = hpku.get(i);
                Intent pindah = new Intent(activity,DetailActivity.class);
                pindah.putExtra(DetailActivity.KEY_ACTIVITY,hpKuu);
                view.getContext().startActivity(pindah);

            }
        });

    }

    @Override
    public int getItemCount() {
        return hpku.size();
    }

    static class hp extends RecyclerView.ViewHolder{
        TextView namaProduk;
        TextView ram;
        TextView internalMemory;
        TextView harga;
        ImageView imgHp;

        public hp(@NonNull View itemView) {
            super(itemView);
            namaProduk=(TextView)itemView.findViewById(R.id.nama_produk);
            ram=(TextView)itemView.findViewById(R.id.ram);
            internalMemory=(TextView)itemView.findViewById(R.id.internal_memory);
            harga=(TextView)itemView.findViewById(R.id.harga);
            imgHp=(ImageView)itemView.findViewById(R.id.pic);
        }
    }

}
