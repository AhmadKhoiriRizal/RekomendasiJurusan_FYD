package com.example.sistempakarrekomendasijurusan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class EnsiklopediaAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listKategori;
    private Map<String, List<String>> mapJurusan;

    public EnsiklopediaAdapter(Context context, List<String> listKategori, Map<String, List<String>> mapJurusan) {
        this.context = context;
        this.listKategori = listKategori;
        this.mapJurusan = mapJurusan;
    }

    @Override
    public int getGroupCount() {
        return listKategori.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mapJurusan.get(listKategori.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listKategori.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapJurusan.get(listKategori.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String kategori = (String) getGroup(groupPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
        }
        TextView text = convertView.findViewById(android.R.id.text1);
        text.setText(kategori);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        String jurusan = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView text = convertView.findViewById(android.R.id.text1);
        text.setText(jurusan);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
