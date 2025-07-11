package com.example.sistempakarrekomendasijurusan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistempakarrekomendasijurusan.R;

import java.util.List;

public class KampusAdapter extends RecyclerView.Adapter<KampusAdapter.ViewHolder> {
    private final List<String> kampusList;

    public KampusAdapter(List<String> kampusList) {
        this.kampusList = kampusList;
    }

    @NonNull
    @Override
    public KampusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kampus, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KampusAdapter.ViewHolder holder, int position) {
        holder.namaKampus.setText(kampusList.get(position));
    }

    @Override
    public int getItemCount() {
        return kampusList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaKampus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaKampus = itemView.findViewById(R.id.textNamaKampus);
        }
    }
}
