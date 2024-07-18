package com.example.baitap.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.baitap.R;
import com.example.baitap.navigation.CaiDat;
import com.example.baitap.navigation.HoaDon;
import com.example.baitap.navigation.Luu;
import com.example.baitap.navigation.TrangChu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNav extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bottom_nav);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Set the OnNavigationItemSelectedListener
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@androidx.annotation.NonNull MenuItem item) {
                Fragment fragment = null;
                if(item.getItemId() == R.id.home){
                    fragment = new TrangChu();
                }
            else if(item.getItemId() == R.id.caidat){
                    fragment = new CaiDat();
                }else if(item.getItemId() == R.id.luu){
                    fragment = new Luu();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();

                return true;
            }
        });
    }
}