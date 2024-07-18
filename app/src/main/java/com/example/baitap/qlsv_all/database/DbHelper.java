package com.example.baitap.qlsv_all.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "QLSV";
    public static final String TABLE_LOP = "Lop";
    public static final String TABLE_SINHVIEN = "SinhVien";
    public static final String TABLE_TAIKHOAN = "TaiKhoan";

    public DbHelper (Context context){
        super(context,DB_NAME,null,5);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tb_lop = "CREATE TABLE " + TABLE_LOP + "(" +
                "TenLop text primary key, " +
                "DayNha text, " +
                "KhuVuc text)";
        sqLiteDatabase.execSQL(tb_lop);

        String tb_sinhvien = "CREATE TABLE " + TABLE_SINHVIEN + "(" +
                "MaSV text primary key, " +
                "HoTen text, " +
                "NgaySinh text, " +
                "HoKhau text, " +
                "TenLop text, " +
                "KhoaHoc text, " +
                "Khoa text)";
        sqLiteDatabase.execSQL(tb_sinhvien);

        String tb_taikhoan = "CREATE TABLE " + TABLE_TAIKHOAN + "(" +
                "TaiKhoan text primary key, " +
                "MatKhau text)";
        sqLiteDatabase.execSQL(tb_taikhoan);

        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_LOP + " VALUES ('Lop 1', 'Day Nha 1', 'Khu Vuc 1')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_LOP + " VALUES ('Lop 2', 'Day Nha 2', 'Khu Vuc 2')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_LOP + " VALUES ('Lop 3', 'Day Nha 3', 'Khu Vuc 3')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_LOP + " VALUES ('Lop 4', 'Day Nha 4', 'Khu Vuc 4')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_LOP + " VALUES ('Lop 5', 'Day Nha 5', 'Khu Vuc 5')");

        // Chèn dữ liệu vào bảng SinhVien
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SINHVIEN + " VALUES ('SV1', 'Ho Ten 1', 'Ngay Sinh 1', 'Ho Khau 1', 'Lop 1', 'Khoa Hoc 1', 'Khoa 1')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SINHVIEN + " VALUES ('SV2', 'Ho Ten 2', 'Ngay Sinh 2', 'Ho Khau 2', 'Lop 2', 'Khoa Hoc 2', 'Khoa 2')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SINHVIEN + " VALUES ('SV3', 'Ho Ten 3', 'Ngay Sinh 3', 'Ho Khau 3', 'Lop 3', 'Khoa Hoc 3', 'Khoa 3')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SINHVIEN + " VALUES ('SV4', 'Ho Ten 4', 'Ngay Sinh 4', 'Ho Khau 4', 'Lop 4', 'Khoa Hoc 4', 'Khoa 4')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SINHVIEN + " VALUES ('SV5', 'Ho Ten 5', 'Ngay Sinh 5', 'Ho Khau 5', 'Lop 5', 'Khoa Hoc 5', 'Khoa 5')");

        // Chèn dữ liệu vào bảng TaiKhoan
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_TAIKHOAN + " VALUES ('TK1', 'MK1')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_TAIKHOAN + " VALUES ('TK2', 'MK2')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_TAIKHOAN + " VALUES ('TK3', 'MK3')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_TAIKHOAN + " VALUES ('TK4', 'MK4')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_TAIKHOAN + " VALUES ('TK5', 'MK5')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LOP);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SINHVIEN);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TAIKHOAN);
            onCreate(sqLiteDatabase);
        }
    }
}
