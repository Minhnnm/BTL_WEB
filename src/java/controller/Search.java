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
public class Search extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String key = req.getParameter("tk");
        DAO dao = new DAO();
        List<SanPham> l = dao.searchSanPhams(key);
        List<DanhMuc> l1 = dao.getDanhMucs();
        int trang, soSanPham = 12, soTrang, spDau, spCuoi, trangD = 0, trangC = 0;
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
        System.out.println(slSanPham);
        req.setAttribute("trangd", trangD);
        req.setAttribute("trangc", trangC);
        spDau = (trang - 1) * soSanPham;
        spCuoi = Math.min(trang * soSanPham, slSanPham);
        System.out.println("spd :" + spDau + "  spcuoi" + spCuoi + "  " + key);
        List<SanPham> lTrang = l.subList(spDau, spCuoi);
        req.setAttribute("slsanpham", slSanPham);
        req.setAttribute("trangHt", trang);
        req.setAttribute("soTrang", soTrang);
        req.setAttribute("list", lTrang);
        req.setAttribute("danhmuc", l1);
        req.setAttribute("key", key);
//        req.getRequestDispatcher("search.jsp").forward(req, resp);

        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }

}
