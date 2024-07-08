package com.example.baitap.lab3;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;
import com.example.baitap.lab3.adapter_.AppAdapter;
import com.example.baitap.lab3.model_.App;

import java.util.ArrayList;

public class lab3bai1 extends AppCompatActivity {
    private ArrayList<App> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab3bai1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lst = findViewById(R.id.lst);
        list.add(new App(R.drawable.icons8_linkedin,"Linkedin"));
        list.add(new App(R.drawable.ic_fb,"FaceBook"));
        list.add(new App(R.drawable.icons8_skype,"Skype"));
        list.add(new App(R.drawable.icons8_yahoo,"Yahoo"));
        list.add(new App(R.drawable.twitter_color_svgrepo_com,"Twitter"));

        AppAdapter adapter = new AppAdapter(this,list);
        lst.setAdapter(adapter);
    }
}