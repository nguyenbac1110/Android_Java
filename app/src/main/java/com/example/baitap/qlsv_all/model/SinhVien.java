package com.example.baitap.qlsv_all.model;

public class SinhVien {
    private String MaSV;
    private String HoTen;
    private String NgaySinh;
    private String HoKhau;
    private String TenLop;
    private String KhoaHoc;
    private String Khoa;

    public SinhVien() {
    }

    public SinhVien(String maSV, String hoTen, String ngaySinh, String hoKhau, String tenlop, String khoaHoc, String khoa) {
        MaSV = maSV;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        HoKhau = hoKhau;
        TenLop = tenlop;
        KhoaHoc = khoaHoc;
        Khoa = khoa;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getHoKhau() {
        return HoKhau;
    }

    public void setHoKhau(String hoKhau) {
        HoKhau = hoKhau;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        TenLop = TenLop;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        KhoaHoc = khoaHoc;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }
}
