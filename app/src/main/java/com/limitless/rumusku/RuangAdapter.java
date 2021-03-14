package com.limitless.rumusku;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.limitless.rumusku.model.RuangModel;
import com.limitless.rumusku.ui.ShapeRuangPreActivity;

import java.util.ArrayList;

public class RuangAdapter extends RecyclerView.Adapter<RuangAdapter.LisListViewHolder> {

    private ArrayList<RuangModel> lisruang;
    private Context context;
    private int post;
    //Deklarasi dan Inisialisasi SharedPreferences
    private SharedPreferences preferences;
    //Digunakan Untuk Konfigurasi SharedPreferences
    private SharedPreferences.Editor editor;


    public RuangAdapter(ArrayList<RuangModel> listruang) {
        this.lisruang = listruang;
    }
    @NonNull
    @Override
    public LisListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shape, parent, false);
        return new RuangAdapter.LisListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LisListViewHolder holder, final int position) {
        final RuangModel ruangModel = lisruang.get(position);
        holder.ruangimg.setImageResource(ruangModel.getRuangGambar());
        holder.tvName.setText(ruangModel.getNama());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShapeRuangPreActivity.class);
                v.getContext().startActivity(intent);
                preferences = v.getContext().getSharedPreferences("datar", 0);
                post = position;
                editor = preferences.edit();
                editor.putString("datar", ruangModel.getNama());
                editor.putInt("gambarRuang", ruangModel.getRuangGambarIsi());
                editor.putString("rumus", ruangModel.getLuasP());
                editor.putString("luas", ruangModel.getVolume());
                editor.putInt("posisi", post);
                editor.apply();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lisruang.size();
    }

    public void filterlist(ArrayList<RuangModel> ruanglist) {
        lisruang = ruanglist;
        notifyDataSetChanged();
    }


    public class LisListViewHolder extends RecyclerView.ViewHolder {
        ImageView ruangimg, ruangimgisi;
        TextView tvName;
        public LisListViewHolder(@NonNull View itemView) {
            super(itemView);
            ruangimg = itemView.findViewById(R.id.img_item_menu);
            tvName = itemView.findViewById(R.id.tv_item_menu);
            context = itemView.getContext();
        }
    }
}
