package com.example.baitap.qlsv_all.dao;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.baitap.qlsv_all.database.DbHelper;
import com.example.baitap.qlsv_all.model.Lop;
import com.example.baitap.qlsv_all.model.SinhVien;
import com.example.baitap.qlsv_all.model.TaiKhoan;

import java.util.ArrayList;

public class CustomDAO {
    private static DbHelper dbhelper;

    public CustomDAO(Context context) {
        dbhelper = new DbHelper(context);
    }

    public ArrayList<SinhVien> selectAllSinhVien() {
        ArrayList<SinhVien> list = new ArrayList<>();
        String query = "SELECT * FROM SinhVien";

        try (SQLiteDatabase db = dbhelper.getReadableDatabase();
             Cursor cursor = db.rawQuery(query, null)) {


            if (cursor.moveToFirst()) {
                int maSVIndex = cursor.getColumnIndex("MaSV");
                int hoTenIndex = cursor.getColumnIndex("HoTen");
                int ngaySinhIndex = cursor.getColumnIndex("NgaySinh");
                int hoKhauIndex = cursor.getColumnIndex("HoKhau");
                int tenLopIndex = cursor.getColumnIndex("TenLop");
                int khoaHocIndex = cursor.getColumnIndex("KhoaHoc");
                int khoaIndex = cursor.getColumnIndex("Khoa");

                do {
                    SinhVien sv = new SinhVien();
                    sv.setMaSV(cursor.getString(maSVIndex));
                    sv.setHoTen(cursor.getString(hoTenIndex));
                    sv.setNgaySinh(cursor.getString(ngaySinhIndex));
                    sv.setHoKhau(cursor.getString(hoKhauIndex));
                    sv.setTenLop(cursor.getString(tenLopIndex));
                    sv.setKhoaHoc(cursor.getString(khoaHocIndex));
                    sv.setKhoa(cursor.getString(khoaIndex));

                    // Log để kiểm tra giá trị TenLop
                    Log.d("CustomDAO", "TenLop: " + sv.getTenLop());

                    list.add(sv);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e("CustomDAO", "Lỗi khi truy vấn dữ liệu SinhVien", e);
        }

        return list;
    }

    public ArrayList<Lop> selectAllLop() {
        ArrayList<Lop> list = new ArrayList<>();
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        db.beginTransaction();
        try {
            Cursor cs = db.rawQuery("select * from Lop", null);
            if (cs.getCount() > 0) {
                cs.moveToFirst();
                while (!cs.isAfterLast()) {
                    Lop lop = new Lop();
                    lop.setTenLop(cs.getString(0));
                    lop.setDayNha(cs.getString(1));
                    lop.setKhuVuc(cs.getString(2));
                    list.add(lop);
                    cs.moveToNext();
                }
                db.setTransactionSuccessful();
            }
        } catch (Exception e) {
            Log.e(TAG, "Lỗi" + e);
        } finally {
            db.endTransaction();
        }
        return list;
    }

    public static ArrayList<TaiKhoan> selectAllTaiKhoan() {
        ArrayList<TaiKhoan> list = new ArrayList<>();
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        db.beginTransaction();
        try {
            Cursor cs = db.rawQuery("select * from TaiKhoan", null);
            if (cs.getCount() > 0) {
                cs.moveToFirst();
                while (!cs.isAfterLast()) {
                    TaiKhoan tk = new TaiKhoan();
                    tk.setTaiKhoan(cs.getString(0));
                    tk.setMatKhau(cs.getString(1));
                    list.add(tk);
                    cs.moveToNext();
                }
                db.setTransactionSuccessful();
            }
        } catch (Exception e) {
            Log.e(TAG, "Lỗi" + e);
        } finally {
            db.endTransaction();
        }
        return list;
    }

    public boolean insertSinhVien(SinhVien sv) {
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaSV", sv.getMaSV());
        values.put("HoTen", sv.getHoTen());
        values.put("NgaySinh", sv.getNgaySinh());
        values.put("HoKhau", sv.getHoKhau());
        values.put("TenLop", sv.getTenLop());
        values.put("KhoaHoc", sv.getKhoaHoc());
        values.put("Khoa", sv.getKhoa());
        long row = db.insert("SinhVien", null, values);
        return (row > 0);
    }


    public boolean updateSinhVien(SinhVien sv) {
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaSV", sv.getMaSV());
        values.put("HoTen", sv.getHoTen());
        values.put("NgaySinh", sv.getNgaySinh());
        values.put("HoKhau", sv.getHoKhau());
        values.put("TenLop", sv.getTenLop());
        values.put("KhoaHoc", sv.getKhoaHoc());
        values.put("Khoa", sv.getKhoa());
        long row = db.update("SinhVien", values, "MaSV=?", new String[]{String.valueOf(sv.getMaSV())});
        return (row > 0);
    }

    public boolean deleteSinhVien(String MaSV) {
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        long row = db.delete("SinhVien", "MaSV=?", new String[]{MaSV});
        return (row > 0);
    }

}