/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.DanhMuc;
import model.SanPham;
import DAO.SanPhamDAO;

/**
 *
 * @author Administrator
 */
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao = new DAO();
//        SanPhamDAO sp=new SanPhamDAO();
        List<SanPham> l = dao.getSanPhams();
        List<DanhMuc> l1 = dao.getDanhMucs();
        int trang, soSanPham = 12, soTrang, spDau, spCuoi, trangD = 0, trangC = 0;
        int slSanPham = l.size();
        if (slSanPham % soSanPham == 0) {
            soTrang = slSanPham / soSanPham;
        } else {
            soTrang = slSanPham / soSanPham + 1;
        }
        String trangHt = req.getParameter("page");
        System.out.println(slSanPham + "   " + soTrang);
        if (trangHt == null) {
            trang = 1;
        } else {
            trang = Integer.parseInt(trangHt);
        }
        spDau = (trang - 1) * soSanPham;
        spCuoi = Math.min(trang * soSanPham, slSanPham);
        if (trang - 2 > 1 && trang + 2 < soTrang) {
            trangD = trang - 2;
            trangC = trang + 2;
        } else if (trang - 2 <= 1) {
            trangD = 1;
            trangC = 5;
        } else if (trang + 2 >= soTrang) {
            trangC = soTrang;
            trangD = soTrang - 4;
        }
        req.setAttribute("trangd", trangD);
        req.setAttribute("trangc", trangC);
        List<SanPham> lTrang = l.subList(spDau, spCuoi);
        req.setAttribute("trangHt", trang);
        req.setAttribute("soTrang", soTrang);

        req.setAttribute("list", lTrang);
        req.setAttribute("danhmuc", l1);
        req.getRequestDispatcher("home.jsp").forward(req, resp);

    }

}
