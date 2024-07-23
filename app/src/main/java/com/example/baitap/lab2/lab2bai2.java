package com.example.baitap.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;

public class lab2bai2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab2bai2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btndang = findViewById(R.id.btnDang);
        btndang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtId = findViewById(R.id.edtMa);
                EditText txtTen = findViewById(R.id.edtTen);
                EditText txtGia = findViewById(R.id.edtGia);
                EditText txtSologan = findViewById(R.id.edtSlogan);
                EditText txtdonvi = findViewById(R.id.unit);
                String ma = txtId.getText().toString().trim();
                String ten = txtTen.getText().toString().trim();
                String gia = txtGia.getText().toString().trim();
                String sologan = txtSologan.getText().toString().trim();
                String donvi = txtdonvi.getText().toString().trim();

                Bundle bundle = new Bundle();
                bundle.putString("ma", ma);
                bundle.putString("ten", ten);
                bundle.putString("gia", gia);
                bundle.putString("sologan", sologan);
                bundle.putString("donvi", donvi);
                Intent intent = new Intent(lab2bai2.this, lab2bai2hienthi.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}