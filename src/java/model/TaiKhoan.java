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
public class TaiKhoan implements Serializable{
    private String ten , mk,phanquyen,sdt,id,emailString,diachi,tendn;

    public TaiKhoan() {
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public TaiKhoan(String tendn, String mk, String phanquyen, String sdt, String id) {
        this.tendn = tendn;
        this.mk = mk;
        this.phanquyen = phanquyen;
        this.sdt = sdt;
        this.id = id;
    }

    public TaiKhoan(String tendn,String ten, String mk, String phanquyen, String sdt, String id, String emailString, String diachi) {
        this.tendn = tendn;
        this.mk = mk;
        this.phanquyen = phanquyen;
        this.sdt = sdt;
        this.id = id;
        this.emailString = emailString;
        this.diachi = diachi;
        this.ten = ten;
    }


    public String getEmailString() {
        return emailString;
    }

    public void setEmailString(String emailString) {
        this.emailString = emailString;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

   

    public String getPhanquyen() {
        return phanquyen;
    }

    public void setPhanquyen(String phanquyen) {
        this.phanquyen = phanquyen;
    }

  

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }
    
}
