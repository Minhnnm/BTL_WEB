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
import model.GioHang;
import model.MucDonHang;
import model.SanPham;

/**
 *
 * @author holme
 */
public class GioHangDAO extends ConnectDB {

    public GioHangDAO() {
        super();
    }

    public List<GioHang> getGioHangs() {
        try {
            TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
            ArrayList<GioHang> l = new ArrayList<>();
            String sql = "select * from GioHang";
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                GioHang gh = new GioHang();
                gh.setTk(taiKhoanDAO.getTaiKhoan(rs.getString(2)));
                l.add(gh);
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public GioHang getGioHang(String idTk) {
        try {
            SanPhamDAO sanPhamDAO = new SanPhamDAO();

            ArrayList<MucDonHang> mucDonHangs = new ArrayList<>();
            String sql0 = "select * from MucGioHang where id_gh = ?";

            PreparedStatement p0 = connection.prepareStatement(sql0);
            p0.setString(1, idTk + "gh");
            ResultSet rs0 = p0.executeQuery();
            while (rs0.next()) {
                MucDonHang mucDonHang = new MucDonHang();
                mucDonHang.setSoluong(rs0.getInt(3));
                mucDonHang.setTongtien(rs0.getInt(4));
                mucDonHang.setSp(sanPhamDAO.getSanPham(rs0.getString(2)));
                mucDonHangs.add(mucDonHang);
            }

            TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
            String sql = "select * from GioHang where id_tk = ?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, idTk);
            ResultSet rs = p.executeQuery();

            GioHang gh = new GioHang();
            while (rs.next()) {
                gh.setTk(taiKhoanDAO.getTaiKhoan(rs.getString(2)));
            }
            gh.setL(mucDonHangs);
            return gh;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean deleteGioHang(String idTk) {

        String sql0 = "delete from MucGioHang where id_gh = ?";
        String sql = "delete from GioHang where id = ?";
        try {
            PreparedStatement p0 = connection.prepareStatement(sql0);
            PreparedStatement p = connection.prepareStatement(sql);
            p0.setString(1, idTk + "gh");
            p.setString(1, idTk);
            p0.executeUpdate();
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
