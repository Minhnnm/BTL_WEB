/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DanhMuc;

@WebServlet(urlPatterns = {"/admin/danh-muc"})
public class DanhMucServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        DanhMucDAO danhMucDAO = new DanhMucDAO();
        request.setAttribute("danhMucs", danhMucDAO.getDanhMucs());

        if (action == null) {
            request.getRequestDispatcher("../QuanLy/QL-DanhMuc/Danh-Sach-Danh-Muc.jsp").forward(request, response);
        } else {
            if (action.equalsIgnoreCase("add")) {
                request.getRequestDispatcher("../QuanLy/QL-DanhMuc/Them-Moi-Danh-Muc.jsp").forward(request, response);
            }
            if (action.equalsIgnoreCase("edit")) {
                request.setAttribute("danhMuc", danhMucDAO.getDanhMuc(request.getParameter("id")));
                request.getRequestDispatcher("../QuanLy/QL-DanhMuc/Chinh-Sua-Danh-Muc.jsp").forward(request, response);
            }
            if (action.equalsIgnoreCase("delete")) {
                danhMucDAO.deleteDanhMuc(danhMucDAO.getDanhMuc(request.getParameter("id")));
                response.sendRedirect(request.getContextPath() + "/admin/danh-muc");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DanhMucDAO danhMucDAO = new DanhMucDAO();
        String action = request.getParameter("action");

        if (action == null) {
            List<DanhMuc> danhMucs = danhMucDAO.getDanhMucs();
            Long id = Long.parseLong(danhMucs.get(danhMucs.size() - 1).getId());
            DanhMuc danhMuc = new DanhMuc((id + 1) + "", request.getParameter("tenDanhMuc"));
            danhMucDAO.createDanhMuc(danhMuc);

            response.sendRedirect(request.getContextPath() + "/admin/danh-muc");
        } else if (action.equalsIgnoreCase("edit")) {
            DanhMuc danhMuc = danhMucDAO.getDanhMuc(request.getParameter("id"));
            danhMuc.setTen(request.getParameter("tenDanhMuc"));
            danhMucDAO.updateDanhMuc(danhMuc);

            response.sendRedirect(request.getContextPath() + "/admin/danh-muc");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
