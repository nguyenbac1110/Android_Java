package com.example.baitap.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;

public class lab2bai3 extends AppCompatActivity {
    private EditText edtMaGV;
    private EditText edtHoTen;
    private RadioGroup rgGioiTinh;
    private RadioButton rbNam;
    private RadioButton rbNu;
    private CheckBox cbXemPhim;
    private CheckBox cbNgheNhac;
    private CheckBox cbCaHat;
    private CheckBox cbDocSach;
    private CheckBox cbDuLich;
    private CheckBox cbTheDuc;
    private Button btnHienThi;
    private Button btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab2bai3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnHienThi = findViewById(R.id.btnHienThi);
        btnThoat = findViewById(R.id.btnThoat);
        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtMaGV = findViewById(R.id.edtMaGV);
                edtHoTen = findViewById(R.id.edtHoTen);
                rgGioiTinh = findViewById(R.id.rgGioiTinh);
                rbNam = findViewById(R.id.rbNam);
                rbNu = findViewById(R.id.rbNu);
                btnHienThi = findViewById(R.id.btnHienThi);
                btnThoat = findViewById(R.id.btnThoat);
                cbXemPhim = findViewById(R.id.cbXemPhim);
                cbNgheNhac = findViewById(R.id.cbNgheNhac);
                cbCaHat = findViewById(R.id.cbCaHat);
                cbDocSach = findViewById(R.id.cbDocSach);
                cbDuLich = findViewById(R.id.cbDuLich);
                cbTheDuc = findViewById(R.id.cbTheDuc);
                String maGV = edtMaGV.getText().toString().trim();
                String hoTen = edtHoTen.getText().toString().trim();
                String gioiTinh = rbNam.isChecked() ? "Nam" : "Nữ";

                boolean isXemPhim = cbXemPhim.isChecked();
                boolean isNgheNhac = cbNgheNhac.isChecked();
                boolean iscbCaHat = cbCaHat.isChecked();
                boolean iscbDocSach = cbDocSach.isChecked();
                boolean iscbDuLich = cbDuLich.isChecked();
                boolean iscbTheDuc = cbTheDuc.isChecked();

                Bundle bundle = new Bundle();
                bundle.putString("maGV", maGV);
                bundle.putString("hoTen", hoTen);
                bundle.putString("gioiTinh", gioiTinh);
                bundle.putBoolean("xemPhim", isXemPhim);
                bundle.putBoolean("ngheNhac", isNgheNhac);
                bundle.putBoolean("caHat", iscbCaHat);
                bundle.putBoolean("docSach", iscbDocSach);
                bundle.putBoolean("duLich", iscbDuLich);
                bundle.putBoolean("theDuc", iscbTheDuc);
                Intent intent = new Intent(lab2bai3.this, lab2bai3hienthi.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}