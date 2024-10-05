/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DanhMuc;
import model.SanPham;

@WebServlet(urlPatterns = {"/admin/san-pham"})
public class SanPhamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        DanhMucDAO danhMucDAO = new DanhMucDAO();

        if (action == null) {
            request.setAttribute("sanPhams", sanPhamDAO.getSanPhams());
            request.getRequestDispatcher("../QuanLy/QL-SanPham/Danh-Sach-San-Pham.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("add")) {
            List<DanhMuc> danhMucs = danhMucDAO.getDanhMucs();
            request.setAttribute("danhMucs", danhMucs);
            request.getRequestDispatcher("../QuanLy/QL-SanPham/Them-Moi-San-Pham.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("edit")) {
            SanPham sanPham = sanPhamDAO.getSanPham(request.getParameter("id"));
            request.setAttribute("sanPham", sanPham);
            request.setAttribute("danhMucs", danhMucDAO.getDanhMucs());
            request.getRequestDispatcher("../QuanLy/QL-SanPham/Chinh-Sua-San-Pham.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            sanPhamDAO.deleteSanPham(sanPhamDAO.getSanPham(request.getParameter("id")));
            response.sendRedirect(request.getContextPath() + "/admin/san-pham");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        DanhMucDAO danhMucDAO = new DanhMucDAO();

        if (action == null) {

            List<SanPham> sanPhams = sanPhamDAO.getSanPhams();
            Collections.sort(sanPhams, new Comparator<SanPham>() {
                @Override
                public int compare(SanPham sp1, SanPham sp2) {
                    return Long.parseLong(sp1.getId()) > Long.parseLong(sp2.getId()) ? 1 : -1;
                }
            });

            String idSp = Long.parseLong(sanPhams.get(sanPhams.size() - 1).getId()) + 1 + "";
            String tenSp = request.getParameter("tenSp");
            String giaSp = request.getParameter("giaSp");
            String idDanhMuc = request.getParameter("idLoaiSp");
            String img = "/btlweb"+"/image/"+idDanhMuc+"/"+request.getParameter("img");
            SanPham sanPham = new SanPham(tenSp, idSp, img, Integer.parseInt(giaSp), danhMucDAO.getDanhMuc(idDanhMuc));

            sanPhamDAO.createSanPham(sanPham);

            response.sendRedirect(request.getContextPath() + "/admin/san-pham");
        } else if (action.equalsIgnoreCase("edit")) {
            String id = request.getParameter("id");
            String idDanhMuc = request.getParameter("idLoaiSp");
            SanPham sanPham = sanPhamDAO.getSanPham(id);
            String path=request.getContextPath();
            System.out.println(path);
            sanPham.setTen(request.getParameter("tenSp"));
            sanPham.setGia(Integer.parseInt(request.getParameter("giaSp")));
            sanPham.setImg(path+"/image/"+idDanhMuc+"/"+request.getParameter("img"));
            sanPham.setDanhMuc(danhMucDAO.getDanhMuc(request.getParameter("idLoaiSp")));

            sanPhamDAO.updateSanPham(sanPham);

            response.sendRedirect(request.getContextPath() + "/admin/san-pham");
        } else if (action.equalsIgnoreCase("timkiem")) {
            String tensp = request.getParameter("tensp");
            System.out.println(tensp);
            request.setAttribute("sanPhams", sanPhamDAO.getTimKiemSP(tensp));
            request.getRequestDispatcher("../QuanLy/QL-SanPham/Danh-Sach-San-Pham.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
