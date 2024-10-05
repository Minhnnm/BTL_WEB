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
 * @author MinhNN
 */
public class DeleteSP extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        List<SanPham> list_sp = dao.getSanPhams();
        List<DanhMuc> list_dm = dao.getDanhMucs();
        int trang, soSanPham = 12, soTrang, spDau, spCuoi, trangD = 0, trangC = 0;
        int slSanPham = list_sp.size();

        if (slSanPham % soSanPham == 0) {
            soTrang = slSanPham / soSanPham;
        } else {
            soTrang = slSanPham / soSanPham + 1;
        }
        String trangHt = request.getParameter("page");
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
        request.setAttribute("trangd", trangD);
        request.setAttribute("trangc", trangC);
        List<SanPham> lTrang = list_sp.subList(spDau, spCuoi);
        request.setAttribute("trangHt", trang);
        request.setAttribute("soTrang", soTrang);

        request.setAttribute("list", lTrang);
        request.setAttribute("danhmuc", list_dm);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao=new DAO();
        String id=request.getParameter("idxoa");
        System.out.println(id);
        SanPham sanPham=new SanPham();
        sanPham.setId(id);
        dao.getDeleteSP(sanPham);
        doGet(request, response);
    }
}
