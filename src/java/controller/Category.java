/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.DanhMuc;
import model.SanPham;

/**
 *
 * @author Administrator
 */
public class Category extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        DAO dao = new DAO();
        List<SanPham> l = dao.getSanPhamsTheoDanhMuc(id);
        DanhMuc dm = dao.getDanhMuc(id);
        List<DanhMuc> l1 = dao.getDanhMucs();
        System.out.println(l.size() + " " + l1.size());
        int trang, soSanPham = 8, soTrang, spDau, spCuoi, trangD = 0, trangC = 0;
        int slSanPham = l.size();
        if (slSanPham % soSanPham == 0) {
            soTrang = slSanPham / soSanPham;
        } else {
            soTrang = slSanPham / soSanPham + 1;
        }
        String trangHt = req.getParameter("page");
        if (trangHt == null) {
            trang = 1;
        } else {
            trang = Integer.parseInt(trangHt);
        }
        if (trang - 2 > 1 && trang + 2 < soTrang) {
            trangD = trang - 2;
            trangC = trang + 2;
        } else if (trang - 2 <= 1) {
            trangD = 1;
            trangC = Math.min(5, soTrang);
        } else if (trang + 2 >= soTrang) {
            trangC = soTrang;
            trangD = soTrang - 4;
        }
        req.setAttribute("trangd", trangD);
        req.setAttribute("trangc", trangC);
        spDau = (trang - 1) * soSanPham;
        spCuoi = Math.min(trang * soSanPham, slSanPham);
        List<SanPham> lTrang = l.subList(spDau, spCuoi);
        req.setAttribute("slsanpham", slSanPham);
        req.setAttribute("trangHt", trang);
        req.setAttribute("soTrang", soTrang);
        req.setAttribute("list", lTrang);
        req.setAttribute("danhmuc", l1);
        req.setAttribute("dm", dm);
        req.getRequestDispatcher("contentOfCategory.jsp").forward(req, resp);
    }

}
