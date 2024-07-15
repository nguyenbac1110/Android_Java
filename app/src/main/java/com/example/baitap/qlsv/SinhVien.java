package com.example.baitap.qlsv;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private static final long serialVersionUID = 1L;
    private int Id;
    private String ten;
    private String gioitinh;
    private int hinh;

    public SinhVien() {
    }

    public SinhVien(int id, String ten, String gioitinh, int hinh) {
        Id = id;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.hinh = hinh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
