package com.example.baitap.lab3.model_;

public class App {
    private int hinh;
    private String ten;

    public App(int hinh, String ten) {
        this.hinh = hinh;
        this.ten = ten;
    }

    public App() {
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
