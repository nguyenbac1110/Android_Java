package com.example.baitap.example_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.baitap.R;
import com.example.baitap.lab4.model_.Food;

import java.util.ArrayList;

public class GiaoVienAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<GiaoVien> list;

    public GiaoVienAdapter(Context context, ArrayList<GiaoVien> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_gv, viewGroup, false);
        }

        GiaoVien giaoVien = list.get(i);

        TextView tvMaGV = view.findViewById(R.id.tvMaGV);
        TextView tvHoTen = view.findViewById(R.id.tvHoTen);
        TextView tvQueQuan = view.findViewById(R.id.tvQueQuan);

        tvMaGV.setText("Mã GV: " + giaoVien.getMagv());
        tvHoTen.setText("Họ tên: " + giaoVien.getHoten());
        tvQueQuan.setText("Quê quán: " + giaoVien.getQuequan());

        return view;
    }
}
