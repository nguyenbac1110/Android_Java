package com.example.baitap.example_json;

public class GiaoVien {
    private String magv;
    private String hoten;
    private String quequan;

    public GiaoVien(String magv, String hoten, String quequan) {
        this.magv = magv;
        this.hoten = hoten;
        this.quequan = quequan;
    }

    public String getMagv() {
        return magv;
    }

    public String getHoten() {
        return hoten;
    }

    public String getQuequan() {
        return quequan;
    }

    @Override
    public String toString() {
        return "Mã GV: " + magv + "\nHọ tên: " + hoten + "\nQuê quán: " + quequan;
    }
}
