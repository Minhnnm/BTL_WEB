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
import model.SanPham;

/**
 *
 * @author holme
 */
public class SanPhamDAO extends ConnectDB {

    public SanPhamDAO() {
        super();
    }

    public List<SanPham> getSanPhams() {
        try {
            ArrayList<SanPham> l = new ArrayList<>();
            String sql = "select * from SanPham order by id_lsp";
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getString(1));
                sp.setTen(rs.getNString(2));
                sp.setImg(rs.getNString(4));
                sp.setGia(rs.getInt(3));
                l.add(sp);
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public SanPham getSanPham(String id) {
        try {
            String sql = "select * from SanPham where id = " + id;
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            SanPham sp = new SanPham();

            while (rs.next()) {
                sp.setId(rs.getString(1));
                sp.setTen(rs.getNString(2));
                sp.setImg(rs.getNString(4));
                sp.setGia(rs.getInt(3));

            }
            return sp;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<SanPham> getSanPhamsTheoDanhMuc(String id) {
        ArrayList<SanPham> l = new ArrayList<>();
        try {
            String sql = "select * from SanPham where id_lsp = ?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getString(1));
                sp.setTen(rs.getNString(2));
                sp.setImg(rs.getNString(4));
                sp.setGia(rs.getInt(3));
                l.add(sp);
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return l;
        }
    }
    
    public boolean createSanPham (SanPham sanPham){
        String sql = "insert into SanPham(id,ten, gia, img, id_lsp) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, sanPham.getId());
            p.setNString(2, sanPham.getTen());
            p.setNString(3, String.valueOf(sanPham.getGia()));
            p.setNString(4, sanPham.getImg());
            p.setNString(5, sanPham.getDanhMuc().getId());
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateSanPham (SanPham sanPham){
        String sql = "update SanPham set ten = ?, gia = ?, img = ?, id_lsp = ? where id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setNString(1, sanPham.getTen());
            p.setNString(2, String.valueOf(sanPham.getGia()));
            p.setNString(3, sanPham.getImg());
            p.setNString(4, sanPham.getDanhMuc().getId());
            p.setString(5, sanPham.getId());
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteSanPham (SanPham sanPham){
        String sql = "delete from SanPham where id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, sanPham.getId());
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<SanPham> getTimKiemSP(String ten){
        List<SanPham> list=new ArrayList<>();
        try {
            
            String sql="select * from SanPham where ten like N'%" + ten + "%'";
            PreparedStatement pre=connection.prepareStatement(sql);
            ResultSet res=pre.executeQuery();
            while(res.next()){
                SanPham sp=new SanPham();
                sp.setId(res.getString(1));
                sp.setTen(res.getNString(2));
                sp.setImg(res.getNString(4));
                sp.setGia(res.getInt(3));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) {
        SanPhamDAO sanPhamDAO=new SanPhamDAO();
        List<SanPham> list=sanPhamDAO.getTimKiemSP("c");
        System.out.println(list.size());
        for(SanPham i:list){
            System.out.println(i.getGia()+" "+i.getTen());
        }
    }
}
