package com.example.baitap.qlsv_all;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.baitap.R;
import com.example.baitap.qlsv_all.adapter.SinhVienAdapter;
import com.example.baitap.qlsv_all.adapter.TaiKhoanAdapter;
import com.example.baitap.qlsv_all.dao.CustomDAO;
import com.example.baitap.qlsv_all.model.SinhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SinhVien_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SinhVien_Frag extends Fragment {
    RecyclerView rcvsv;
    ArrayList<SinhVien> list=new ArrayList<SinhVien>();
    CustomDAO svdao;
    SinhVienAdapter adapter;
    FloatingActionButton fltadd;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SinhVien_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SinhVien_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static SinhVien_Frag newInstance(String param1, String param2) {
        SinhVien_Frag fragment = new SinhVien_Frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sinh_vien_, container, false);

        rcvsv = view.findViewById(R.id.rcvsv);
        fltadd = view.findViewById(R.id.fltadd);

        svdao = new CustomDAO(getContext());
        list = svdao.selectAllSinhVien();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvsv.setLayoutManager(layoutManager);

        adapter = new SinhVienAdapter(getContext(), list);
        rcvsv.setAdapter(adapter);


        fltadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialogthem();
            }

        });
        return view;

    }

    private void opendialogthem() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.item_add_sv_, null);
        builder.setView(view);
        final Dialog dialog = builder.create();
        dialog.show();

        // ánh xa
        final EditText txtMaSV = view.findViewById(R.id.txtMaSV);
        final EditText txtHoTen = view.findViewById(R.id.txtHoTen);
        final EditText txtNgaySinh = view.findViewById(R.id.txtNgaySinh);
        final EditText txtHoKhau = view.findViewById(R.id.txtHoKhau);
        final EditText txtTenLop = view.findViewById(R.id.txtTenLop);
        final EditText txtKhoaHoc = view.findViewById(R.id.txtKhoaHoc);
        final EditText txtKhoa = view.findViewById(R.id.txtKhoa);
        Button btnthem = view.findViewById(R.id.btnthem);

        txtTenLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] classNames = {"Lớp 1", "Lớp 2", "Lớp 3", "Lớp 4", "Lớp 5"};
                AlertDialog.Builder classBuilder = new AlertDialog.Builder(getContext());
                classBuilder.setTitle("Chọn lớp");
                classBuilder.setItems(classNames, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        txtTenLop.setText(classNames[i]);
                    }
                });
                classBuilder.show();
            }
        });
        txtTenLop.setFocusable(false);
        txtTenLop.setClickable(true);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder confirmBuilder = new AlertDialog.Builder(getContext());
                confirmBuilder.setMessage("Bạn có muốn thêm sinh viên này không?");
                confirmBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String maSV = txtMaSV.getText().toString();
                        String hoTen = txtHoTen.getText().toString();
                        String ngaySinh = txtNgaySinh.getText().toString();
                        String hoKhau = txtHoKhau.getText().toString();
                        String tenLop = txtTenLop.getText().toString();
                        String khoaHoc = txtKhoaHoc.getText().toString();
                        String khoa = txtKhoa.getText().toString();

                        SinhVien sv = new SinhVien(maSV, hoTen, ngaySinh, hoKhau, tenLop, khoaHoc, khoa);
                        if (svdao.insertSinhVien(sv)) {
                            list.clear();
                            list.addAll(svdao.selectAllSinhVien());
                            adapter.notifyDataSetChanged();
                            dialog.dismiss();
                            Toast.makeText(getContext(), "Insert success", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "Insert fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                confirmBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                confirmBuilder.show();
            }
        });
    }
}