package com.example.baitap.lab4.adapter_;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitap.R;
import com.example.baitap.lab4.model_.Food;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<Food> list;

    public FoodAdapter(Context context, ArrayList<Food> list) {
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
        view = infl.inflate(R.layout.itemlab4, viewGroup, false);
        ImageView imghinh = view.findViewById(R.id.imghinh);
        TextView txtten = view.findViewById(R.id.txtcon);
        EditText txtgia = view.findViewById(R.id.txtgia);
        imghinh.setImageResource(list.get(i).getHinh());
        txtten.setText(list.get(i).getTen());
        txtgia.setHint(String.valueOf(list.get(i).getGia()));

        Spinner spinnerTable = view.findViewById(R.id.spinner_table);
        ArrayAdapter<CharSequence> tableAdapter = ArrayAdapter.createFromResource(context, R.array.table_array, android.R.layout.simple_spinner_item);

        tableAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTable.setAdapter(tableAdapter);
        spinnerTable.setVisibility(View.INVISIBLE);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerTable.setVisibility(View.VISIBLE);
                spinnerTable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String tableName = parent.getItemAtPosition(position).toString();
                        String foodName = list.get(i).getTen();
                        Toast.makeText(context, "Bàn số " + tableName + " chọn đặt tên món ăn " + foodName, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(context, "Nothing", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return view;

    }
}
