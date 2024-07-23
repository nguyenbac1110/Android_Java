package com.example.baitap.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;

public class lab2bai2hienthi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab2bai2hienthi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvMa = findViewById(R.id.tvMa);
        TextView tvTen = findViewById(R.id.tvTen);
        TextView tvGia = findViewById(R.id.tvGia);
        TextView tvSologan = findViewById(R.id.tvSologan);
        TextView tvUnit = findViewById(R.id.tvUnit);
        Button btnThoat = findViewById(R.id.btnThoat);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String ma = bundle.getString("ma");
            String ten = bundle.getString("ten");
            String gia = bundle.getString("gia");
            String sologan = bundle.getString("sologan");
            String donvi = bundle.getString("donvi");
            tvMa.setText(ma);
            tvTen.setText(ten);
            tvGia.setText(gia);
            tvSologan.setText(sologan);
            tvUnit.setText(donvi);
        }
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}