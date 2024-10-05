/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DonHangDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DonHang;
import model.GioHang;

/**
 *
 * @author holme
 */
@WebServlet(name = "DonHangServlet", urlPatterns = {"/admin/don-hang"})
public class DonHangServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        
        DonHangDAO donHangDAO = new DonHangDAO();

        if (action == null) {
            List<DonHang> donHangs = donHangDAO.getDonHangs();
            request.setAttribute("donHangs", donHangs);
            request.getRequestDispatcher("../QuanLy/QL-DonHang/Danh-Sach-Don-Hang.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("danhSach")) {
            DonHang donHang = donHangDAO.getDonHang(request.getParameter("id"));
            request.setAttribute("donHang", donHang);
            request.getRequestDispatcher("../QuanLy/QL-DonHang/Danh-Sach-San-Pham.jsp").forward(request, response);
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
