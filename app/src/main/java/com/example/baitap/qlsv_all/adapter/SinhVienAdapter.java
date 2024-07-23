package com.example.baitap.qlsv_all.adapter;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;
import com.example.baitap.qlsv_all.dao.CustomDAO;
import com.example.baitap.qlsv_all.model.SinhVien;

import java.util.ArrayList;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<SinhVien> sinhVienList;
    CustomDAO svdao;

    public SinhVienAdapter(Context context, ArrayList<SinhVien> sinhVienList) {
        this.context = context;
        this.sinhVienList = sinhVienList;
        svdao = new CustomDAO(context);
    }


    @NonNull
    @Override
    public SinhVienAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sv_, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienAdapter.ViewHolder holder, int position) {
        SinhVien sinhVien = sinhVienList.get(position);
        if (holder.txtMaSV != null) {
            holder.txtMaSV.setText("Mã SV: " + sinhVien.getMaSV());

        }
        if (holder.txtHoTen != null) {
            holder.txtHoTen.setText("Họ Tên: " + sinhVien.getHoTen());
        }
        if (holder.txtNgaySinh != null) {
            holder.txtNgaySinh.setText("Ngày Sinh: " + sinhVien.getNgaySinh());
        }
        if (holder.txtHoKhau != null) {
            holder.txtHoKhau.setText("Hộ Khẩu: " + sinhVien.getHoKhau());
        }
        if (holder.txtTenLop != null) {
            holder.txtTenLop.setText("Tên Lớp: " + sinhVien.getTenLop());
        }
        if (holder.txtKhoaHoc != null) {
            holder.txtKhoaHoc.setText("Khóa Học: " + sinhVien.getKhoaHoc());
        }
        if (holder.txtKhoa != null) {
            holder.txtKhoa.setText("Khoa: " + sinhVien.getKhoa());
        }
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder confirmDelete = new AlertDialog.Builder(context);
                confirmDelete.setTitle("Xác nhận xóa");
                confirmDelete.setMessage("Bạn có chắc chắn muốn xóa sinh viên này?");
                confirmDelete.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (svdao.deleteSinhVien(sinhVien.getMaSV())) {
                            sinhVienList.clear();
                            sinhVienList.addAll(svdao.selectAllSinhVien());
                            notifyDataSetChanged();
                            Toast.makeText(context, "Đã xóa", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "xóa fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                confirmDelete.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                confirmDelete.show();
            }
        });
        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog(holder.crdsv, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return sinhVienList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtMaSV;
        TextView txtHoTen;
        TextView txtNgaySinh;
        TextView txtHoKhau;
        TextView txtTenLop;
        TextView txtKhoaHoc;
        TextView txtKhoa;
        ImageButton btnUpdate;
        ImageButton btnDelete;
        CardView crdsv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMaSV = itemView.findViewById(R.id.txtMaSV);
            txtHoTen = itemView.findViewById(R.id.txtHoTen);
            txtNgaySinh = itemView.findViewById(R.id.txtNgaySinh);
            txtHoKhau = itemView.findViewById(R.id.txtHoKhau);
            txtTenLop = itemView.findViewById(R.id.txtTenLop);
            txtKhoaHoc = itemView.findViewById(R.id.txtKhoaHoc);
            txtKhoa = itemView.findViewById(R.id.txtKhoa);
            btnUpdate = itemView.findViewById(R.id.btnupdate);
            btnDelete = itemView.findViewById(R.id.btndelete);
            crdsv = itemView.findViewById(R.id.crdsv);
        }
    }
    public void opendialog(final CardView cv, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_update_sv_, null);
        builder.setView(view);

         EditText txtMaSVUpdate = view.findViewById(R.id.txtMaSV);
         EditText txtHoTenUpdate = view.findViewById(R.id.txtHoTen);
        EditText txtNgaySinhUpdate = view.findViewById(R.id.txtNgaySinh);
        EditText txtHoKhauUpdate = view.findViewById(R.id.txtHoKhau);
         EditText txtTenLopUpdate = view.findViewById(R.id.txtTenLop);
         EditText txtKhoaHocUpdate = view.findViewById(R.id.txtKhoaHoc);
         EditText txtKhoaUpdate = view.findViewById(R.id.txtKhoa);

        SinhVien sinhVien = sinhVienList.get(position);
        txtMaSVUpdate.setText(sinhVien.getMaSV());
        txtHoTenUpdate.setText(sinhVien.getHoTen());
        txtNgaySinhUpdate.setText(sinhVien.getNgaySinh());
        txtHoKhauUpdate.setText(sinhVien.getHoKhau());
        txtTenLopUpdate.setText(sinhVien.getTenLop());
        txtKhoaHocUpdate.setText(sinhVien.getKhoaHoc());
        txtKhoaUpdate.setText(sinhVien.getKhoa());

        txtTenLopUpdate.setFocusable(false);
        txtTenLopUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] classNames = {"Lớp 1", "Lớp 2", "Lớp 3", "Lớp 4", "Lớp 5"};
                AlertDialog.Builder classBuilder = new AlertDialog.Builder(view.getContext());
                classBuilder.setTitle("Chọn lớp");
                classBuilder.setItems(classNames, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        txtTenLopUpdate.setText(classNames[i]);
                    }
                });
                classBuilder.show();
            }
        });
        builder.setPositiveButton("Cập nhật", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog.Builder confirmBuilder = new AlertDialog.Builder(context);
                confirmBuilder.setTitle("Xác nhận");
                confirmBuilder.setMessage("Bạn có chắc chắn muốn cập nhật sinh viên này không?");

                confirmBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String maSV = txtMaSVUpdate.getText().toString();
                        String hoTen = txtHoTenUpdate.getText().toString();
                        String ngaySinh = txtNgaySinhUpdate.getText().toString();
                        String hoKhau = txtHoKhauUpdate.getText().toString();
                        String tenLop = txtTenLopUpdate.getText().toString();
                        String khoaHoc = txtKhoaHocUpdate.getText().toString();
                        String khoa = txtKhoaUpdate.getText().toString();

                        SinhVien sv = new SinhVien(maSV, hoTen, ngaySinh, hoKhau, tenLop, khoaHoc, khoa);
                        if (svdao.updateSinhVien(sv)) {
                            sinhVienList.set(position, sv);
                            notifyDataSetChanged();
                            Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                confirmBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                Dialog confirmDialog = confirmBuilder.create();
                confirmDialog.show();
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }
}

