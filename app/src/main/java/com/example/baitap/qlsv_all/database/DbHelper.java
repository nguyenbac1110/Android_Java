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
        super(context,DB_NAME,null,1);
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

        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_LOP + " VALUES ('DHTI15A1HN', 'HA8', 'Lĩnh Nam')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_LOP + " VALUES ('DHTI15A2HN', 'HA8', 'Lnh Nam')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_LOP + " VALUES ('DHTI15A3HN', 'HA9', 'Hoàng Mai')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_LOP + " VALUES ('DHTI15A4HN', 'HA10', 'Hoàng Mai')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_LOP + " VALUES ('DHTI15A5HN', 'HA11', 'Lnh Nam')");

        // Chèn dữ liệu vào bảng SinhVien
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SINHVIEN + " VALUES ('SV1', 'Nguyen Van A', '12/6/2003', 'Nam Định', 'Lop 1', 'IT', '2016')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SINHVIEN + " VALUES ('SV2', 'Nguyen Van B', '13/8/2003', 'Lạng Sơn', 'Lop 2', 'BA', '2018')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SINHVIEN + " VALUES ('SV3', 'Nguyen Thi C', '15/8/2004', 'Lào Cai', 'Lop 3', 'TMDT', '2020')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SINHVIEN + " VALUES ('SV4', 'Nguyen Thi D', '19/8/2002', 'Hưng Yên', 'Lop 4', 'Dancer', '2020')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SINHVIEN + " VALUES ('SV5', 'Nguyen Van E', '20/8/2006', 'Bắc Giang', 'Lop 5', 'MMT', '2021')");

        // Chèn dữ liệu vào bảng TaiKhoan
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_TAIKHOAN + " VALUES ('admin1', '1128')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_TAIKHOAN + " VALUES ('admin2', '1128')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_TAIKHOAN + " VALUES ('admin3', '1128')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_TAIKHOAN + " VALUES ('admin4', '1128')");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_TAIKHOAN + " VALUES ('admin5', '1128')");
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
