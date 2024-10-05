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

/**
 *
 * @author MinhNN
 */
public class AddLoaiSP extends HttpServlet {


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
        String ten=request.getParameter("tenloaisp");
        DanhMuc danhMuc=new DanhMuc();
        DAO dao=new DAO();
        danhMuc.setId(String.valueOf(dao.getIDLoaiSP()+1));
        danhMuc.setTen(ten);
        dao.getThemLoaiSP(danhMuc);
        doGet(request, response);
    }
}
