/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.GioHangDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GioHang;
/**
 *
 * @author holme
 */
@WebServlet(name = "GioHangServlet", urlPatterns = {"/admin/gio-hang"})
public class GioHangServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        
        GioHangDAO gioHangDAO = new GioHangDAO();

        if (action == null) {
            List<GioHang> gioHangs = gioHangDAO.getGioHangs();
            request.setAttribute("gioHangs", gioHangs);
            request.getRequestDispatcher("../QuanLy/QL-GioHang/Danh-Sach-Gio-Hang.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("danhSach")) {
            GioHang gioHang = gioHangDAO.getGioHang(request.getParameter("id"));
            request.setAttribute("gioHang", gioHang);
            request.getRequestDispatcher("../QuanLy/QL-GioHang/Danh-Sach-San-Pham.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
