package com.example.baitap.qlsv_all.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;
import com.example.baitap.qlsv_all.model.TaiKhoan;

import java.util.ArrayList;

public class TaiKhoanAdapter extends RecyclerView.Adapter<TaiKhoanAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<TaiKhoan> taiKhoanList;

    public TaiKhoanAdapter(Context context, ArrayList<TaiKhoan> taiKhoanList) {
        this.context = context;
        this.taiKhoanList = taiKhoanList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tk, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TaiKhoan taiKhoan = taiKhoanList.get(position);
        holder.txtTaiKhoan.setText(taiKhoan.getTaiKhoan());
        holder.txtMatKhau.setText(taiKhoan.getMatKhau());
    }

    @Override
    public int getItemCount() {
        return taiKhoanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTaiKhoan;
        TextView txtMatKhau;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTaiKhoan = itemView.findViewById(R.id.txtTaiKhoan);
            txtMatKhau = itemView.findViewById(R.id.txtMatKhau);
        }
    }
}
