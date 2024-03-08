package com.example.fragment.Model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int hinh;
    private String tensp;



    private int soluong;
    private int gia;
    public SanPham(int hinh, String tensp, int soluong, int gia) {
        this.hinh = hinh;
        this.tensp = tensp;
        this.soluong = soluong;
        this.gia = gia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
