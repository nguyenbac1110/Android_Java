package com.example.baitap.qlsv;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;
import com.example.baitap.lab4.adapter_.FoodAdapter;
import com.example.baitap.lab4.model_.Food;

import java.util.ArrayList;

public class MainSinhVien extends AppCompatActivity {
    SinhVienAdapter adapter;
    public static final String TENFILE = "sinhvien.txt";
     ArrayList<SinhVien> list_ = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_sinh_vien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ListView lst = findViewById(R.id.lstsv);
        Button btnadd = findViewById(R.id.btnadd);
        try {
            if (Xfile.kiemtratontai(MainSinhVien.this, TENFILE)) {
                list_ = (ArrayList<SinhVien>) Xfile.docfile(MainSinhVien.this, TENFILE);
                if (list_ == null || list_.isEmpty()) {
                    list_ = new ArrayList<>();
                    Toast.makeText(this, "Không có dữ liệu hợp lệ, tạo danh sách mặc định.", Toast.LENGTH_SHORT).show();
                    list_.add(new SinhVien(1, "Nguyen Van A", "Nam", R.drawable.banh_canh));
                    list_.add(new SinhVien(2, "Nguyen Thi B", "Nu", R.drawable.banh_trang));
                    Xfile.ghifile(MainSinhVien.this, TENFILE, list_);
                }
            } else {
                list_ = new ArrayList<>();
                list_.add(new SinhVien(1, "Nguyen Van A", "Nam", R.drawable.banh_canh));
                list_.add(new SinhVien(2, "Nguyen Thi B", "Nu", R.drawable.banh_trang));
                Xfile.ghifile(MainSinhVien.this, TENFILE, list_);
            }
        } catch (Exception e) {
            list_ = new ArrayList<>();
            Toast.makeText(this, "Lỗi khi đọc file, tạo danh sách mặc định.", Toast.LENGTH_SHORT).show();
            list_.add(new SinhVien(1, "Nguyen Van A", "Nam", R.drawable.banh_canh));
            list_.add(new SinhVien(2, "Nguyen Thi B", "Nu", R.drawable.banh_trang));
        }

        registerForContextMenu(lst);

        adapter = new SinhVienAdapter(this, list_);
        lst.setAdapter(adapter);
         adapter.notifyDataSetChanged();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddDialog();
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.update_xoa,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        if(item.getItemId() == R.id.update){
         SinhVien sv = list_.get(position);
           openUpdateDialog(sv, position);
            Toast.makeText(this, "update", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.delete) {
            list_.remove(position);
            adapter.notifyDataSetChanged();
            Xfile.ghifile(this, TENFILE, list_);
            Toast.makeText(this, "đã xóa", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
    private void openUpdateDialog(SinhVien sv, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.item_update, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();

        ImageView imgHinhUpdate = view.findViewById(R.id.imghinh_update);
        EditText edtMa = view.findViewById(R.id.edtMa);
        EditText edtTen = view.findViewById(R.id.edtTen);
        RadioGroup rgGioiTinh = view.findViewById(R.id.rgGioiTinh);
        Button btnChangeImage = view.findViewById(R.id.btnChangeImage);
        Button btnSave = view.findViewById(R.id.btnSave);

        imgHinhUpdate.setImageResource(sv.getHinh());
        edtMa.setText(String.valueOf(sv.getId()));
        edtTen.setText(sv.getTen());
        if (sv.getGioitinh().equals("Nam")) {
            rgGioiTinh.check(R.id.rbNam);
        } else {
            rgGioiTinh.check(R.id.rbNu);
        }

        btnChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newId = Integer.parseInt(edtMa.getText().toString());
                String newTen = edtTen.getText().toString();
                String newGioiTinh = rgGioiTinh.getCheckedRadioButtonId() == R.id.rbNam ? "Nam" : "Nữ";

                sv.setId(newId);
                sv.setTen(newTen);
                sv.setGioitinh(newGioiTinh);

                list_.set(position, sv);
                adapter.notifyDataSetChanged();
                Xfile.ghifile(MainSinhVien.this, TENFILE, list_);
                Toast.makeText(MainSinhVien.this, "Đã cập nhật", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    private void openAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.item_add, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();


        EditText txtMaSV = view.findViewById(R.id.txtmasv);
        EditText txtHoTen = view.findViewById(R.id.txthoten);
        EditText txtTenAnh = view.findViewById(R.id.txttenanh);
        RadioGroup rgGioiTinh = view.findViewById(R.id.rgGioiTinh_add);
        Button btnThem = view.findViewById(R.id.btnthem);
        Button btnHuy = view.findViewById(R.id.btnhuy);



        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maSV = Integer.parseInt(txtMaSV.getText().toString());
                String tenSV = txtHoTen.getText().toString();
                String gioiTinh = rgGioiTinh.getCheckedRadioButtonId() == R.id.rbNam_add ? "Nam" : "Nữ";
                int hinhAnh;

                String tenAnh = txtTenAnh.getText().toString().trim();
                int resId = getResources().getIdentifier(tenAnh, "drawable", getPackageName());
                if (resId != 0) {
                    hinhAnh = resId;

                    SinhVien sv = new SinhVien(maSV, tenSV, gioiTinh, hinhAnh);
                    list_.add(sv);
                    adapter.notifyDataSetChanged();
                    Xfile.ghifile(MainSinhVien.this, TENFILE, list_);

                    Toast.makeText(MainSinhVien.this, "Đã thêm sinh viên", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainSinhVien.this, "Không tìm thấy ảnh trong drawable", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMaSV.setText("");
                txtHoTen.setText("");
                txtTenAnh.setText("");
                rgGioiTinh.clearCheck();
            }
        });
        dialog.show();
    }

}