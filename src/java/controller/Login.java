/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao = new DAO();
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String ten = req.getParameter("user");
        String mk = req.getParameter("pass");
        
        TaiKhoan tk = dao.Authendication(ten, mk);
        if (tk != null) { 
            HttpSession session = req.getSession();
            session.setAttribute("taikhoan", tk);
            GioHang gh = dao.getGioHang(tk);
//            req.getSession().setAttribute("quyen", tk.getPhanquyen());
            if(gh.getSl() != 0){
                session.setAttribute("sl", gh.getSl());
            }
            if (tk.getPhanquyen().equalsIgnoreCase("admin")){
                session.setAttribute("username_admin", tk.getTendn());
                resp.sendRedirect("admin");
            }
            else 
                resp.sendRedirect("home");
        } else {
            req.setAttribute("loginError", "error");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

}
