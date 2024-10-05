/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class GioHang implements Serializable {

    private List<MucDonHang> l;
    private int tongtien;
    private int sl;
    private TaiKhoan tk;
    private String ghichu;
    
    public GioHang() {
    }

    public GioHang(List<MucDonHang> l, int tongtien, TaiKhoan tk,int sl, String ghichu) {
        this.l = l;
        this.tongtien = tongtien;
        this.tk = tk;
        this.sl = sl;
        this.ghichu=ghichu;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public List<MucDonHang> getL() {
        return l;
    }

    public void setL(List<MucDonHang> l) {
        this.l = l;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public TaiKhoan getTk() {
        return tk;
    }

    public void setTk(TaiKhoan tk) {
        this.tk = tk;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    
}
