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
import java.util.stream.Collectors;
import model.DAO;
import model.DanhMuc;
import model.SanPham;

/**
 *
 * @author holme
 */
public class DanhMucDAO extends ConnectDB {

    public DanhMucDAO() {
        super();
    }

    public List<DanhMuc> getDanhMucs() {
        try {
            ArrayList<DanhMuc> l = new ArrayList<>();
            String sql = "select * from LoaiSanPham";
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                DanhMuc sp = new DanhMuc();
                sp.setId(rs.getString(1));
                sp.setTen(rs.getNString(2));
                l.add(sp);
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public DanhMuc getDanhMuc(String id) {
        try {
            String sql = "select * from LoaiSanPham where id =" + id;
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                DanhMuc sp = new DanhMuc();
                sp.setId(rs.getString(1));
                sp.setTen(rs.getNString(2));
                return sp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    public boolean createDanhMuc(DanhMuc danhMuc) {
        String sql = "insert into LoaiSanPham(id,ten) values(?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, danhMuc.getId());
            p.setNString(2, danhMuc.getTen());
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateDanhMuc(DanhMuc danhMuc) {
        String sql = "update LoaiSanPham set ten = ? where id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setNString(1, danhMuc.getTen());
            p.setString(2, danhMuc.getId());
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteDanhMuc(DanhMuc danhMuc) {

        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        List<SanPham> sanPhams = sanPhamDAO.getSanPhamsTheoDanhMuc(danhMuc.getId());

        for (SanPham i : sanPhams) {
            sanPhamDAO.deleteSanPham(i);
        }

        String sql = "delete from LoaiSanPham where id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, danhMuc.getId());
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
