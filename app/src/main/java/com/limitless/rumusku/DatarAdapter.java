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

import com.limitless.rumusku.model.DatarModel;
import com.limitless.rumusku.ui.ShapeDatarPreActivity;

import java.util.ArrayList;

public class DatarAdapter extends RecyclerView.Adapter<DatarAdapter.ListViewHolder> {
    private ArrayList<DatarModel> listdatar;
    private ArrayList<DatarModel> listdatar2;
    private Context context;
    private int post;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public DatarAdapter(ArrayList<DatarModel> listdatar) {
        this.listdatar = listdatar;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shape, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final DatarModel datarModel = listdatar.get(position);

        holder.datarimg.setImageResource(datarModel.getDatarGambar());
        holder.tvName.setText(datarModel.getNama());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShapeDatarPreActivity.class);
                v.getContext().startActivity(intent);
                preferences = v.getContext().getSharedPreferences("datar", 0);
                post = position;
                editor = preferences.edit();
                editor.putString("datar", datarModel.getNama());
                editor.putInt("gambar", datarModel.getDatargambarisi());
                editor.putString("rumus", datarModel.getRumus());
                editor.putString("luas", datarModel.getLuas());
                editor.putInt("posisi", post);
                editor.apply();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listdatar.size();
    }

    public void filterlist(ArrayList<DatarModel> datarlist) {
        listdatar = datarlist;
        notifyDataSetChanged();
    }


//public void filter(CharSequence sequence) {
//    ArrayList<DatarModel> temp = new ArrayList<>();
//    if (!TextUtils.isEmpty(sequence)) {
//        for (DatarModel s : listdatar) {
//                if (s.toString().toLowerCase().contains(sequence)) {
//                temp.add(s);
//            }
//        }
//    } else {
//        temp.addAll(listdatar2);
//    }
//    listdatar.clear();
//    listdatar.addAll(temp);
//    notifyDataSetChanged();
//    temp.clear();
//}

    public class ListViewHolder extends RecyclerView.ViewHolder {
            ImageView datarimg, dataimg;
            TextView tvName;

        public ListViewHolder(@NonNull final View itemView) {
            super(itemView);
            datarimg = itemView.findViewById(R.id.img_item_menu);
            tvName = itemView.findViewById(R.id.tv_item_menu);
            context = itemView.getContext();
        }
    }
}
