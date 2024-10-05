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
import javax.servlet.http.HttpSession;
import model.DAO;
import model.GioHang;
import model.MucDonHang;
import model.TaiKhoan;

/**
 *
 * @author Administrator
 */
public class Signup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        String tendn = req.getParameter("user");
        String mk = req.getParameter("pass1");
        String mk1 = req.getParameter("pass2");
        String sdt = req.getParameter("phone");
        if (dao.checkTenDN(tendn)) {
            req.setAttribute("error", "Tên đăng nhập đã được sủ dụng");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        } else if (dao.checkSDT(sdt)) {
            req.setAttribute("error", "Số điện thoại đã được sử dụng");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        } else {
            TaiKhoan tk = new TaiKhoan(tendn, mk, "khachhang", sdt, dao.getSoLuongTK() + 1 + "");
            boolean res = dao.addUser(tk);
            if (res) {

                HttpSession session = req.getSession();
                session.setAttribute("taikhoan", tk);
                List<MucDonHang> l = new ArrayList<>();
                dao.createGioHang(new GioHang(l, 0, tk, 0, ""));
                resp.sendRedirect("home");
            }
        }

    }

}
