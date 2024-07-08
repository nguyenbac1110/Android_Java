package com.example.baitap.lab3.adapter_;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baitap.R;
import com.example.baitap.lab3.model_.App;

import java.util.ArrayList;

public class AppAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<App> list;

    public AppAdapter(Context context, ArrayList<App> list) {
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
        LayoutInflater infl = ((Activity) context).getLayoutInflater();

        view = infl.inflate(R.layout.itemlab3bai1,viewGroup,false);

        ImageView imghinh = view.findViewById(R.id.imghinh);
        TextView txtten = view.findViewById(R.id.txtcon);
        imghinh.setImageResource(list.get(i).getHinh());
        txtten.setText(list.get(i).getTen());
        return view;
    }
}