package com.example.baitap.example_json;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainJson extends AppCompatActivity {

     GiaoVienAdapter adapter;
     ArrayList<GiaoVien> giaoVienList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_json);
        ListView listView = findViewById(R.id.listView);
        Button btnShowData = findViewById(R.id.btnShowData);
        giaoVienList = new ArrayList<>();

        adapter = new GiaoVienAdapter(this, giaoVienList);
        listView.setAdapter(adapter);

        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadGiaoVienData();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadGiaoVienData() {
        String jsonData = "[\n" +
                "  {\n" +
                "    \"magv\": \"GV001\",\n" +
                "    \"hoten\": \"Nguyễn Văn A\",\n" +
                "    \"quequan\": \"Hà Nội\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"magv\": \"GV002\",\n" +
                "    \"hoten\": \"Trần Thị B\",\n" +
                "    \"quequan\": \"Hồ Chí Minh\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"magv\": \"GV003\",\n" +
                "    \"hoten\": \"Lê Văn C\",\n" +
                "    \"quequan\": \"Đà Nẵng\"\n" +
                "  }\n" +
                "]";

        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            giaoVienList.clear();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String magv = jsonObject.getString("magv");
                String hoten = jsonObject.getString("hoten");
                String quequan = jsonObject.getString("quequan");

                GiaoVien giaoVien = new GiaoVien(magv, hoten, quequan);
                giaoVienList.add(giaoVien);
            }

            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}