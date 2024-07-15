package com.example.baitap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.lab1.Calculator;
import com.example.baitap.lab1.Login;
import com.example.baitap.lab1.Signup;
import com.example.baitap.lab2.lab2bai1;
import com.example.baitap.lab2.lab2bai2;
import com.example.baitap.lab2.lab2bai3;
import com.example.baitap.lab3.lab3bai1;
import com.example.baitap.lab3.lab3bai2;
import com.example.baitap.lab4.lab4_food;
import com.example.baitap.qlsv.MainSinhVien;

public class MainActivity extends AppCompatActivity {
    private Button btnbai1_1;
    private Button btnbai1_2;
    private Button btnbai1_3;
    private Button btnbai2_1;
    private Button btnbai2_2;
    private Button btnbai2_3;
    private Button btnbai3_1;
    private Button btnbai3_2;
    private Button btnbai4;
    private Button btnbaiqlsv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnbai1_1 = findViewById(R.id.btnbai1_1);
        btnbai1_2 = findViewById(R.id.btnbai1_2);
        btnbai1_3 = findViewById(R.id.btnbai1_3);
        btnbai2_1 = findViewById(R.id.btnbai2_1);
        btnbai2_2 = findViewById(R.id.btnbai2_2);
        btnbai2_3 = findViewById(R.id.btnbai2_3);
        btnbai3_1 = findViewById(R.id.btnbai3_1);
        btnbai3_2 = findViewById(R.id.btnbai3_2);
        btnbai4 = findViewById(R.id.btnbai4);
        btnbaiqlsv = findViewById(R.id.btnbaiqlsv);
        btnbai1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
        btnbai1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
        });
        btnbai1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Calculator.class);
                startActivity(intent);
            }
        });
        btnbai2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, lab2bai1.class);
                startActivity(intent);
            }
        });
        btnbai2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, lab2bai2.class);
                startActivity(intent);
            }
        });
        btnbai2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, lab2bai3.class);
                startActivity(intent);
            }
        });
        btnbai3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, lab3bai1.class);
                startActivity(intent);
            }
        });
        btnbai3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, lab3bai2.class);
                startActivity(intent);
            }
        });
        btnbai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, lab4_food.class);
                startActivity(intent);
            }
        });
        btnbaiqlsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainSinhVien.class);
                startActivity(intent);
            }
        });
    }
}