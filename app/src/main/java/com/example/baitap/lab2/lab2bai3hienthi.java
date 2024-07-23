package com.example.baitap.lab2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;

public class lab2bai3hienthi extends AppCompatActivity { private TextView tvMaGV;
    private TextView tvHoTen;
    private TextView tvGioiTinh;
    private TextView tvSoThich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab2bai3hienthi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvMaGV = findViewById(R.id.tvMaGV);
        TextView tvHoTen = findViewById(R.id.tvHoTen);
        TextView tvGioiTinh = findViewById(R.id.tvGioiTinh);
        TextView tvSoThich = findViewById(R.id.tvSoThich);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String maGV = bundle.getString("maGV");
            String hoTen = bundle.getString("hoTen");
            String gioiTinh = bundle.getString("gioiTinh");

            boolean isXemPhim = bundle.getBoolean("xemPhim");
            boolean isNgheNhac = bundle.getBoolean("ngheNhac");
            boolean iscbCaHat = bundle.getBoolean("caHat");
            boolean iscbDocSach = bundle.getBoolean("docSach");
            boolean iscbDuLich = bundle.getBoolean("duLich");
            boolean iscbTheDuc = bundle.getBoolean("theDuc");

            String soThich = "";
            if (isXemPhim) soThich += "Xem phim, ";
            if (isNgheNhac) soThich += "Nghe nhạc, ";
            if (iscbCaHat) soThich += "Ca hát, ";
            if (iscbDocSach) soThich += "Đọc sách, ";
            if (iscbDuLich) soThich += "Du lịch, ";
            if (iscbTheDuc) soThich += "Thể dục, ";


            soThich = soThich.length() > 0 ? soThich.substring(0, soThich.length() - 2) : "Không có";

            tvMaGV.setText(maGV);
            tvHoTen.setText(hoTen);
            tvGioiTinh.setText(gioiTinh);
            tvSoThich.setText(soThich);
        }
    }
}