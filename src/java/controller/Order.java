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
public class Order extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao = new DAO();
        TaiKhoan tk = (TaiKhoan) req.getSession().getAttribute("taikhoan");
        GioHang gh = dao.getGioHang(tk);
        req.setAttribute("gh", gh);
        req.getRequestDispatcher("order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao = new DAO();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        String ten = req.getParameter("ten").toLowerCase();
        String sdt = req.getParameter("sdt").toLowerCase();
        String email = req.getParameter("email");
        String diachi = req.getParameter("diachi").toLowerCase();
        String ghichu=req.getParameter("ghichu").trim().replaceAll("//s+", " ");
        TaiKhoan tk = (TaiKhoan) req.getSession().getAttribute("taikhoan");
        System.out.println(tk.getTendn());
        GioHang gh = dao.getGioHang(tk);
        tk.setTen(ten);
        tk.setEmailString(email);
        tk.setDiachi(diachi);
        tk.setSdt(sdt);
        gh.setGhichu(ghichu);
        System.out.println(ten);
        System.out.println(ghichu);
        dao.updateTaiKhoan(tk);
        dao.createHoaDon(gh);
        dao.deleteGioHang(gh);
        req.setAttribute("dathang", "ok");
        req.setAttribute("date", dateFormat.format(new Date()));
        req.setAttribute("gh", gh);
        req.getSession().removeAttribute("sl");
        req.getRequestDispatcher("order.jsp").forward(req, resp);

    }

}
