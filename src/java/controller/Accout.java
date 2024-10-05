/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.GioHang;
import model.TaiKhoan;

/**
 *
 * @author Administrator
 */
public class Accout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("accout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String ten = req.getParameter("ten").toLowerCase();
        String sdt = req.getParameter("sdt").toLowerCase();
        String email = req.getParameter("email");
        String diachi = req.getParameter("diachi").toLowerCase();
        String mk = req.getParameter("pass");
        TaiKhoan tk = (TaiKhoan) req.getSession().getAttribute("taikhoan");
        tk.setTen(ten);
        tk.setEmailString(email);
        tk.setDiachi(diachi);
        tk.setSdt(sdt);
        if (!mk.equals("")) {
            tk.setMk(mk);
          
        }
       
        dao.updateTaiKhoan1(tk);
//     
        req.setAttribute("update", "ok");

        req.getRequestDispatcher("accout.jsp").forward(req, resp);

    }

}
