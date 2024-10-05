/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.TaiKhoanDAO;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TaiKhoan;

@WebServlet(urlPatterns = {"/admin/tai-khoan"})
public class TaiKhoanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

        if (action == null) {
            request.setAttribute("taiKhoans", taiKhoanDAO.getTaiKhoans());
            request.getRequestDispatcher("../QuanLy/QL-TaiKhoan/Danh-Sach-Tai-Khoan.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("add")) {
            request.getRequestDispatcher("../QuanLy/QL-TaiKhoan/Them-Moi-Tai-Khoan.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("edit")) {
            request.setAttribute("taiKhoan", taiKhoanDAO.getTaiKhoan(request.getParameter("id")));
            request.getRequestDispatcher("../QuanLy/QL-TaiKhoan/Chinh-Sua-Tai-Khoan.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            taiKhoanDAO.deleteTaiKhoan(taiKhoanDAO.getTaiKhoan(request.getParameter("id")));
            response.sendRedirect(request.getContextPath() + "/admin/tai-khoan");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");

        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

        if (action == null) {

            List<TaiKhoan> taiKhoans = taiKhoanDAO.getTaiKhoans();
            Collections.sort(taiKhoans, new Comparator<TaiKhoan>() {
                @Override
                public int compare(TaiKhoan tk1, TaiKhoan tk2) {
                    return Long.parseLong(tk1.getId()) > Long.parseLong(tk2.getId()) ? 1 : -1;
                }
            });

            String idTk = Long.parseLong(taiKhoans.get(taiKhoans.size() - 1).getId()) + 1 + "";
            String ten = request.getParameter("ten");
            String tenDN = request.getParameter("tenDn");
            String mk = request.getParameter("mk");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String phanQuyen = request.getParameter("phanQuyen");
            String email = request.getParameter("email");

            TaiKhoan taiKhoan = new TaiKhoan(tenDN, ten, mk, phanQuyen, sdt, idTk, email, diaChi);

            taiKhoanDAO.createTaiKhoan(taiKhoan);

            response.sendRedirect(request.getContextPath() + "/admin/tai-khoan");
        } else if (action.equalsIgnoreCase("edit")) {

            String idtk = request.getParameter("id");
            String ten = request.getParameter("ten");
            String tenDN = request.getParameter("tenDn");
            String mk = request.getParameter("mk");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String phanQuyen = request.getParameter("phanQuyen");
            String email = request.getParameter("email");

            TaiKhoan taiKhoan = new TaiKhoan(tenDN, ten, mk, phanQuyen, sdt, idtk, email, diaChi);

            taiKhoanDAO.updateTaiKhoan(taiKhoan);

            response.sendRedirect(request.getContextPath() + "/admin/tai-khoan");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
