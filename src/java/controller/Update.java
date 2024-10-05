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
public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        String id = request.getParameter("capnhat");
        SanPham sanPham = dao.getSanPham(id);
        List<DanhMuc> listdm = dao.getDanhMucs();
        List<SanPham> listsp = dao.getSanPhamsLienQuan(id);
        DanhMuc dm = dao.getDanhMuc(id);
        request.setAttribute("sp", sanPham);
        request.setAttribute("danhmuc", listdm);
        request.setAttribute("dm", dao.getDanhMucSanPham(id));
        if(listsp.size() >=8){
             request.setAttribute("list", listsp.subList(0, 8));
        }
        else{
            request.setAttribute("list", listsp);
        }
        request.getRequestDispatcher("detail.jsp").forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String ten=request.getParameter("tensp");
        int gia=Integer.valueOf(request.getParameter("giasp"));
        String id=request.getParameter("capnhat");
        String idloaisp=request.getParameter("loaisp");
        DanhMuc danhMuc=new DanhMuc();
        danhMuc.setId(idloaisp);
        SanPham sanPham=new SanPham();
        sanPham.setTen(ten);
        sanPham.setDanhMuc(danhMuc);
        sanPham.setId(id);
        sanPham.setGia(gia);
        DAO dao=new DAO();
        dao.getUpdateSP(sanPham);
        doGet(request, response);
    }
}