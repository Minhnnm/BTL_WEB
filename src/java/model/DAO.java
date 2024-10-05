/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DAO {

    private Connection connection;

    public DAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1443;databasename=sanpham1;"
                    + "username=sa;password=1234");
            System.out.println("ket noi thanh cong");
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("lỗi sql");
        } 
        catch(ClassNotFoundException e){
            
            System.out.println("lỗi class");
        }
    }
//Thao tác với san phẩm

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

    public List<SanPham> getSanPhamsLienQuan(String id) {
        try {
            ArrayList<SanPham> l = new ArrayList<>();
            String sql = " select *from\n"
                    + " SanPham , ( select *from SanPham where id = ?) AS A\n"
                    + " where SanPham.id_lsp = A.id_lsp and SanPham.id <> A.id\n"
                    + "  ";
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

    public List<SanPham> searchSanPhams(String key) {
        try {
            ArrayList<SanPham> l = new ArrayList<>();
            String sql = "select * from SanPham where ten like N'%" + key + "%'";
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
//    public List<SanPham> searchSanPhams(String key) {
//       List<SanPham> l = getSanPhams();
//       return l.stream().filter(e -> e.getTen().con)
//    }
//    

    public int getSoLuongSP() {
        try {
            String sql = "select count(*) from SanPham";
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            int res = 0;
            while (rs.next()) {
                res = rs.getInt(1);
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
//Thao tác danh mục sản phẩm

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

    public DanhMuc getDanhMucSanPham(String id) {
        try {
            String sql = " select * from\n"
                    + " LoaiSanPham \n"
                    + " where LoaiSanPham.id =  ( select  id_lsp from SanPham where id = ?)";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
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

//thao tác dao tai khoản
    public int getSoLuongTK() {
        try {
            String sql = "select count(*) from TaiKhoan";
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            int res = 0;
            while (rs.next()) {
                res = rs.getInt(1);
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public boolean checkTenDN(String ten) {
        try {
            String sql = "select tendn from TaiKhoan where tendn = ?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setNString(1, ten);
            ResultSet rs = p.executeQuery();
            int res = 0;
            while (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     public boolean checkSDT(String sdt) {
        try {
            String sql = "select sdt from TaiKhoan where sdt = ?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setNString(1, sdt);
            ResultSet rs = p.executeQuery();
            int res = 0;
            while (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public TaiKhoan Authendication(String ten, String mk) {
        try {

            String sql = "select * from TaiKhoan where tenDN =? and mk = ?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setNString(1, ten);
            p.setString(2, mk);
            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getNString(3));
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

    public void updateTaiKhoan(TaiKhoan tk) {
        String sql = "update TaiKhoan set ten = ? , sdt = ? , diachi = ?, email = ? where id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setNString(1, tk.getTen());
            p.setString(2, tk.getSdt());
            p.setNString(3, tk.getDiachi());
            p.setString(4, tk.getEmailString());
            p.setString(5, tk.getId());
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTaiKhoan1(TaiKhoan tk) {
        String sql = "update TaiKhoan set ten = ? , sdt = ? , diachi = ?, email = ?, mk = ? where id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setNString(1, tk.getTen());
            p.setString(2, tk.getSdt());
            p.setNString(3, tk.getDiachi());
            p.setString(4, tk.getEmailString());
            p.setString(5, tk.getMk());
            p.setString(6, tk.getId());
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean addUser(TaiKhoan tk) {
        String sql = "insert into TaiKhoan(id,tenDN,mk,sdt,phanquyen) values(?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, tk.getId());
            p.setNString(2, tk.getTendn());
            p.setString(3, tk.getMk());
            p.setString(4, tk.getSdt());
            p.setString(5, tk.getPhanquyen());
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
//Thao tác dao giỏ hàng

    public List<MucDonHang> getMucDonHangs(String id) {

        ArrayList<MucDonHang> l = new ArrayList<>();
        try {

            String sql = "select * from MucGioHang where id_gh = ? ";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                MucDonHang sp = new MucDonHang();
                sp.setSp(getSanPham(rs.getString(2)));
                sp.setSoluong(rs.getInt(3));
                sp.setTongtien(rs.getInt(4));
                l.add(sp);
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean checkDonHang(String id,String id_gh) {
        String sql = "select * from MucGioHang where id_sp = ? and id_gh = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, id_gh);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                System.out.println("San ko co hàng");
                return true;
            }
            System.out.println("đã có trong don hang");
            return false;
        } catch (SQLException ex) {
            System.out.println("lỗi");
            return false;
        }
    }

    public boolean addDonHang(GioHang gh) {
        String sql = "insert into MucGioHang values(?,?,?,?)";
        List<MucDonHang> l = gh.getL();
        try {

            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, gh.getTk().getId() + "gh");
            p.setString(2, l.get(l.size() - 1).getSp().getId());
            p.setInt(3, l.get(l.size() - 1).getSoluong());
            p.setInt(4, l.get(l.size() - 1).getSp().getGia() * l.get(l.size() - 1).getSoluong());
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("thanh cong"+gh.getTk().getId() + "gh" + "    " + l.get(l.size() - 1).getSp().getId());
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateDonHang(MucDonHang m, String id) {
        System.out.println(m.getSp().getId() + " " + id);
        try {
            String sql = "update MucGioHang set soLuong =? , tongTien = ? where id_sp=?  and id_gh =?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, m.getSoluong());
            p.setInt(2, m.getTongtien());
            p.setString(3, m.getSp().getId());
            p.setString(4, id);
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteDonHang(MucDonHang m, String id) {
        System.out.println(m.getSp().getId() + " " + id);
        try {
            String sql = "delete from MucGioHang where id_sp=?  and id_gh =?";
            PreparedStatement p = connection.prepareStatement(sql);

            p.setString(1, m.getSp().getId());
            p.setString(2, id);
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteGioHang(GioHang gh) {
        try {
            String sql = "delete from MucGioHang where id_gh =?";
            PreparedStatement p = connection.prepareStatement(sql);

            p.setString(1, gh.getTk().getId() + "gh");

            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public GioHang getGioHang(TaiKhoan tk) {
        GioHang gh = new GioHang();
        List<MucDonHang> l = getMucDonHangs(tk.getId() + "gh");
        int tt = 0, sl = 0;
        if (l.size() != 0) {
            for (MucDonHang mdh : l) {
                tt += mdh.getTongtien();
            }
            for (MucDonHang mdh : l) {
                sl += mdh.getSoluong();
            }
        }
        gh.setTk(tk);
        gh.setL(l);
        gh.setSl(sl);
        gh.setTongtien(tt);
        return gh;
    }

    public boolean createGioHang(GioHang gh) {

        String sql = "insert into GioHang values(?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, gh.getTk().getId() + "gh");
            p.setString(2, gh.getTk().getId());
            return p.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
// thao tác với hoá đơn

    public int getIdHoaDon() {
        int idHD=0;
        try {
            String sql = "select top 1 cast(id as int) as ID from HoaDon order by ID desc";
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                idHD = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idHD;
    }

    public void createHoaDon(GioHang gh) {
        String sql = "insert into HoaDon(id,id_kh,ngayTao,tongTien,soluong, ghichu) values(?,?,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            int id = getIdHoaDon()+ 1; ///
            p.setString(1, id + "");
            p.setString(2, gh.getTk().getId());
            p.setString(3, format.format(new Date()));
            p.setInt(4, gh.getTongtien());
            p.setInt(5, gh.getSl());
            p.setString(6, gh.getGhichu());
            p.executeUpdate();
            createCTHoaDon(gh, id + "");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createCTHoaDon(GioHang gh, String id) {
        String sql = "insert into CTHoaDon values(?,?,?,?)";
        for (MucDonHang m : gh.getL()) {
            try {
                PreparedStatement p = connection.prepareStatement(sql);
                p.setString(1, id);
                p.setString(2, m.getSp().getId());
                p.setInt(4, m.getTongtien());
                p.setInt(3, m.getSoluong());

                p.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    //ad
    public void getUpdateSP(SanPham sanPham){
        try {
            String sql="Update SanPham set ten=?, gia=?, id_lsp=? where id=?";
            PreparedStatement pre=connection.prepareStatement(sql);
            pre.setString(1, sanPham.getTen());
            pre.setInt(2, sanPham.getGia());
            pre.setString(3, sanPham.getDanhMuc().getId());
            pre.setString(4, sanPham.getId());
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void getDeleteSP(SanPham sanPham){
        try {
            String sql="Delete from SanPham where id=?";
            PreparedStatement pre=connection.prepareStatement(sql);
            pre.setString(1, sanPham.getId());
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public int getIDSanPham(){
        int id=0;
        try {
            String sql="select top 1 cast(id as int) as ID from SanPham order by ID desc";
            PreparedStatement pre=connection.prepareStatement(sql);
            ResultSet res=pre.executeQuery();
            while(res.next()){
                id=res.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }
    
    public void getThemSP(SanPham sanPham){
        try {
            String sql="insert into SanPham(id, ten, gia, img, id_lsp) values(?,?,?,?,?)";
            PreparedStatement pre=connection.prepareStatement(sql);
            pre.setString(1, sanPham.getId());
            pre.setString(2, sanPham.getTen());
            pre.setInt(3, sanPham.getGia());
            pre.setString(4, sanPham.getImg());
            pre.setString(5, sanPham.getDanhMuc().getId());
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public int getIDLoaiSP(){
        int idloaisp=0;
        try {
            String sql="  select top 1 cast(id as int) as ID from LoaiSanPham order by ID desc";
            PreparedStatement pre=connection.prepareStatement(sql);
            ResultSet res=pre.executeQuery();
            while(res.next()){
                idloaisp=res.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return idloaisp;
    }
    public void getThemLoaiSP(DanhMuc danhMuc){
        try {
            String sql="insert into LoaiSanPham(id, ten) values(?,?)";
            PreparedStatement pre=connection.prepareCall(sql);
            pre.setString(1, danhMuc.getId());
            pre.setString(2, danhMuc.getTen());
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public int getSLgHoaDon(){
        int slg=0;
        try {
            String sql="select count(id_kh) from HoaDon";
            PreparedStatement pre=connection.prepareStatement(sql);
            ResultSet res=pre.executeQuery();
            while(res.next()){
                slg=res.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return slg;
    }
    
    public int getTong(){
        int slg=0;
        try {
            String sql="select soLuong from MucGioHang";
            PreparedStatement pre=connection.prepareStatement(sql);
            ResultSet res=pre.executeQuery();
            while(res.next()){
                slg+=res.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return slg;
    }
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.getTong());
    }
}
