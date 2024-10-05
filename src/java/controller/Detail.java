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
public class Detail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao = new DAO();
        String id = req.getParameter("id");
        SanPham sp = dao.getSanPham(id);
        List<DanhMuc> l1 = dao.getDanhMucs();
        List<SanPham> l = dao.getSanPhamsLienQuan(id);
        DanhMuc dm = dao.getDanhMuc(id);
        req.setAttribute("sp", sp);
        req.setAttribute("danhmuc", l1);
        req.setAttribute("dm", dao.getDanhMucSanPham(id));
        if(l.size() >=8){
             req.setAttribute("list", l.subList(0, 8));
        }
        else{
            req.setAttribute("list", l);
        }
        req.getRequestDispatcher("detail.jsp").forward(req, resp);

    }

}
