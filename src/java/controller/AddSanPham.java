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
public class AddSanPham extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        List<DanhMuc> listdm = dao.getDanhMucs();
        request.setAttribute("danhmuc", listdm);
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String tensp=request.getParameter("tensp");
        String idloaisp=request.getParameter("loaisp");
        int giasp=Integer.valueOf(request.getParameter("giasp"));
        String anh=request.getParameter("img");
        SanPham sanPham=new SanPham();
        DanhMuc danhMuc=new DanhMuc();
        DAO dao=new DAO();
        danhMuc.setId(idloaisp);
        sanPham.setGia(giasp);
        sanPham.setDanhMuc(danhMuc);
        sanPham.setTen(tensp);
        sanPham.setId(String.valueOf(dao.getIDSanPham()+1));
        sanPham.setImg("image/"+idloaisp+"/"+anh);
        dao.getThemSP(sanPham);
        doGet(request, response);
    }

}
