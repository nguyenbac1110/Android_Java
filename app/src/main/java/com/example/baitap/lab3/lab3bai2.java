package com.example.baitap.lab3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;
import com.example.baitap.lab3.adapter_.AppAdapter;
import com.example.baitap.lab3.adapter_.FoodAdapter;
import com.example.baitap.lab3.model_.App;
import com.example.baitap.lab3.model_.Food;

import java.util.ArrayList;

public class lab3bai2 extends AppCompatActivity {
     ArrayList<Food> list_ = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab3bai2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lst = findViewById(R.id.lst);
        list_.add(new Food(R.drawable.banh_canh,"Bánh canh",9000000));
        list_.add(new Food(R.drawable.banh_trang,"Bánh tráng",8000000));
        list_.add(new Food(R.drawable.bun_cha,"Bún chả",7000000));

        FoodAdapter adapter = new FoodAdapter(this,list_);
        lst.setAdapter(adapter);
    }
}