package com.example.baitap.qlsv_all.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;
import com.example.baitap.qlsv_all.model.Lop;

import java.util.ArrayList;

public class LopAdapter extends RecyclerView.Adapter<LopAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<Lop> lopList;

    public LopAdapter(Context context, ArrayList<Lop> lopList) {
        this.context = context;
        this.lopList = lopList;
    }

    @NonNull
    @Override
    public LopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LopAdapter.ViewHolder holder, int position) {
        Lop lop = lopList.get(position);
        holder.txtTenLop.setText(lop.getTenLop());
        holder.txtDayNha.setText(lop.getDayNha());
        holder.txtKhuVuc.setText(lop.getKhuVuc());
    }

    @Override
    public int getItemCount() {
        return lopList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenLop;
        TextView txtDayNha;
        TextView txtKhuVuc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenLop = itemView.findViewById(R.id.txtTenLop);
            txtDayNha = itemView.findViewById(R.id.txtDayNha);
            txtKhuVuc = itemView.findViewById(R.id.txtKhuVuc);
        }
    }
}
