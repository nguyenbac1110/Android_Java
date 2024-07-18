package com.example.baitap.qlsv_all.model;

public class TaiKhoan {
    public String TaiKhoan;
    public String MatKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String taiKhoan, String matKhau) {
        TaiKhoan = taiKhoan;
        MatKhau = matKhau;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }
}
