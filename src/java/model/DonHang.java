/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

public class DonHang {
    private String id;
    private TaiKhoan taiKhoan;
    private String ngayDat;
    private int tongTien;
    private List<MucDonHang> mucDonHangs;

    public DonHang() {
    }

    public DonHang(String id, TaiKhoan taiKhoan, String ngayDat, int tongTien, List<MucDonHang> mucDonHangs) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
        this.mucDonHangs = mucDonHangs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public List<MucDonHang> getMucDonHangs() {
        return mucDonHangs;
    }

    public void setMucDonHangs(List<MucDonHang> mucDonHangs) {
        this.mucDonHangs = mucDonHangs;
    }
    
    
}
