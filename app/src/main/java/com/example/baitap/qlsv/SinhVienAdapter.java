package com.example.baitap.qlsv;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitap.R;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<SinhVien> list;
    public int longPressedPosition = -1;
    public SinhVienAdapter(Context context, ArrayList<SinhVien> list) {
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
        view = infl.inflate(R.layout.item_sv, viewGroup, false);

        view.setLongClickable(true);
        ImageView imghinh = view.findViewById(R.id.imghinh);
        TextView txtma = view.findViewById(R.id.txtma);
        TextView txtten = view.findViewById(R.id.txtten);
        TextView txtgt = view.findViewById(R.id.txtgt);
        imghinh.setImageResource(list.get(i).getHinh());
        txtma.setText(String.valueOf(list.get(i).getId()));
        txtten.setText(list.get(i).getTen());
        txtgt.setText(list.get(i).getGioitinh());

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                longPressedPosition = i;
//                list.remove(i);
//                notifyDataSetChanged();
//                Toast.makeText(context, "đã xóa", Toast.LENGTH_SHORT).show();
//                // Xfile.ghifile(context, "nv.txt", list);//ghi file
//                Xfile.ghifile(context, MainSinhVien.TENFILE, list);//ghi file
                return false;
            }
        });
        return view;
    }
}
