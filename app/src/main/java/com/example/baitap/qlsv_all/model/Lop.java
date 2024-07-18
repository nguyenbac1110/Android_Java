package com.example.baitap.qlsv_all.model;

public class Lop {
    private String TenLop;
    private String DayNha;
    private String KhuVuc;

    public Lop() {
    }

    public Lop(String tenLop, String dayNha, String khuVuc) {
        TenLop = tenLop;
        DayNha = dayNha;
        KhuVuc = khuVuc;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String tenLop) {
        TenLop = tenLop;
    }

    public String getDayNha() {
        return DayNha;
    }

    public void setDayNha(String dayNha) {
        DayNha = dayNha;
    }

    public String getKhuVuc() {
        return KhuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        KhuVuc = khuVuc;
    }
}
