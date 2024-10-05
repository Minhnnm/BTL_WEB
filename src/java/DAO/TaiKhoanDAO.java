/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO;
import model.TaiKhoan;

/**
 *
 * @author holme
 */
public class TaiKhoanDAO extends ConnectDB {

    public TaiKhoanDAO() {
        super();
    }

    public List<TaiKhoan> getTaiKhoans() {
        try {
            List<TaiKhoan> l = new ArrayList<>();
            String sql = "select * from TaiKhoan";
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(rs.getNString(3),
                        rs.getNString(2), rs.getString(4),
                        rs.getString(7), rs.getString(5), rs.getString(1),
                        rs.getString(8), rs.getNString(6));
                l.add(tk);
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public TaiKhoan getTaiKhoan(String id) {
        try {

            String sql = "select * from TaiKhoan where id = " + id;
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                return new TaiKhoan(rs.getNString(3),
                        rs.getNString(2), rs.getString(4),
                        rs.getString(7), rs.getString(5), rs.getString(1),
                        rs.getString(8), rs.getNString(6));
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean createTaiKhoan(TaiKhoan tk) {
        String sql = "insert into TaiKhoan(id, ten, tenDN, mk, sdt, diaChi, phanQuyen, email) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setNString(1, tk.getId());
            p.setNString(2, tk.getTen());
            p.setNString(3, tk.getTendn());
            p.setString(4, tk.getMk());
            p.setNString(5, tk.getSdt());
            p.setString(6, tk.getDiachi());
            p.setString(7, tk.getPhanquyen());
            p.setNString(8, tk.getEmailString());
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateTaiKhoan(TaiKhoan tk) {
        String sql = "update TaiKhoan set ten = ? , tenDN = ?, mk = ? , sdt = ?, diaChi = ?, phanQuyen = ?, email = ? where id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setNString(1, tk.getTen());
            p.setNString(2, tk.getTendn());
            p.setString(3, tk.getMk());
            p.setNString(4, tk.getSdt());
            p.setString(5, tk.getDiachi());
            p.setString(6, tk.getPhanquyen());
            p.setNString(7, tk.getEmailString());
            p.setNString(8, tk.getId()); 
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteTaiKhoan (TaiKhoan taiKhoan){
        
        GioHangDAO gioHangDAO = new GioHangDAO();
        
        gioHangDAO.deleteGioHang(taiKhoan.getId());
        
        String sql = "delete from TaiKhoan where id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, taiKhoan.getId());
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
