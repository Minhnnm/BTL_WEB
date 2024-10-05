/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class MucDonHang implements Serializable{
    private SanPham sp;
    private int soluong;
    private int tongtien;

    public MucDonHang() {
    }

    public MucDonHang(SanPham sp, int soluong, int tongtien) {
        this.sp = sp;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
}
