package com.example.baitap.lab4;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;
import com.example.baitap.lab4.adapter_.FoodAdapter;
import com.example.baitap.lab4.model_.Food;

import java.util.ArrayList;

public class lab4_food extends AppCompatActivity {
     ArrayList<Food> list_ = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab4_food);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        GridView lst = findViewById(R.id.lst);
        list_.add(new Food(R.drawable.banh_canh,"Bánh canh",1000000));
        list_.add(new Food(R.drawable.banh_trang,"Bánh tráng",1000000));
        list_.add(new Food(R.drawable.bun_cha,"Bún chả",1000000));
        list_.add(new Food(R.drawable.che_lien,"Chè liên",1000000));
        list_.add(new Food(R.drawable.soup_ga,"Soup gà",1000000));
        list_.add(new Food(R.drawable.chao_ech,"Cháo ếch",1000000));

        registerForContextMenu(lst);

        FoodAdapter adapter = new FoodAdapter(this, list_);
        lst.setAdapter(adapter);

    }


        @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.ban_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        Food food = list_.get(position);
        String foodName = food.getTen();

        String tableTitle = item.getTitle().toString();

        Toast.makeText(this, tableTitle + " chọn đặt tên món ăn " + foodName, Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }
}