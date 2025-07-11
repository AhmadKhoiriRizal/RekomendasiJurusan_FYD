package com.example.sistempakarrekomendasijurusan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistempakarrekomendasijurusan.R;
import com.example.sistempakarrekomendasijurusan.model.Jurusan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PetaKarierAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private final List<Object> itemList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Jurusan jurusan);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public PetaKarierAdapter(Map<String, List<Jurusan>> dataMap) {
        itemList = new ArrayList<>();
        for (Map.Entry<String, List<Jurusan>> entry : dataMap.entrySet()) {
            itemList.add(entry.getKey()); // Header (String)
            itemList.addAll(entry.getValue()); // Jurusan objects
        }
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position) instanceof String ? TYPE_HEADER : TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = viewType == TYPE_HEADER
                ? R.layout.item_peta_header
                : R.layout.item_peta_subjurusan;
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return viewType == TYPE_HEADER ? new HeaderViewHolder(view) : new ItemViewHolder(view, listener, itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).txtHeader.setText((String) itemList.get(position));
        } else {
            Jurusan jurusan = (Jurusan) itemList.get(position);
            ((ItemViewHolder) holder).txtItem.setText("• " + jurusan.nama);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView txtHeader;

        HeaderViewHolder(View itemView) {
            super(itemView);
            txtHeader = itemView.findViewById(R.id.txtHeader);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView txtItem;

        public ItemViewHolder(@NonNull View itemView, OnItemClickListener listener, List<Object> itemList) {
            super(itemView);
            txtItem = itemView.findViewById(R.id.txtItem);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        listener.onItemClick((Jurusan) itemList.get(pos));
                    }
                }
            });
        }
    }
}
