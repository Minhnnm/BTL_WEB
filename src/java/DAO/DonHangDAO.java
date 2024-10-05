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
import model.DonHang;
import model.GioHang;
import model.MucDonHang;

/**
 *
 * @author holme
 */
public class DonHangDAO extends ConnectDB{

    public DonHangDAO() {
        super();
    }
    
     public List<DonHang> getDonHangs() {
        try {
            TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
            ArrayList<DonHang> l = new ArrayList<>();
            String sql = "select * from HoaDon";
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                DonHang dh = new DonHang();
                dh.setTaiKhoan(taiKhoanDAO.getTaiKhoan(rs.getString(2)));
                dh.setId(rs.getString(1));
                dh.setNgayDat(rs.getString(3));
                dh.setTongTien(Integer.parseInt(rs.getString(4)));
                l.add(dh);
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public DonHang getDonHang(String id) {
        try {
            SanPhamDAO sanPhamDAO = new SanPhamDAO();

            ArrayList<MucDonHang> mucDonHangs = new ArrayList<>();
            String sql0 = "select * from CTHoaDon where id_hd = ?";

            PreparedStatement p0 = connection.prepareStatement(sql0);
            p0.setString(1, id);
            ResultSet rs0 = p0.executeQuery();
            while (rs0.next()) {
                MucDonHang mucDonHang = new MucDonHang();
                mucDonHang.setSoluong(rs0.getInt(3));
                mucDonHang.setTongtien(rs0.getInt(4));
                mucDonHang.setSp(sanPhamDAO.getSanPham(rs0.getString(2)));
                mucDonHangs.add(mucDonHang);
            }

            TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
            String sql = "select * from HoaDon where id = ?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet rs = p.executeQuery();

            DonHang dh = new DonHang();
            while (rs.next()) {
                dh.setTaiKhoan(taiKhoanDAO.getTaiKhoan(rs.getString(2)));
            }
            dh.setMucDonHangs(mucDonHangs);
            return dh;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
