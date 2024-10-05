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
import javax.servlet.http.HttpSession;
import model.DAO;
import model.GioHang;
import model.MucDonHang;
import model.SanPham;
import model.TaiKhoan;

/**
 *
 * @author Administrator
 */
public class Cart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao = new DAO();
        System.out.println(req.getSession().getAttribute("sl"));
        TaiKhoan tk = (TaiKhoan) req.getSession().getAttribute("taikhoan");
        GioHang gh = null;
        if (tk != null) {
            gh = dao.getGioHang(tk);
        }
        String addID = req.getParameter("add");
        String deleteID = req.getParameter("delete");
        String updateID = req.getParameter("update");
        String action = req.getParameter("action");
        String soluong = req.getParameter("sl");
        String url = req.getParameter("url");
//Show giỏ hàng
        if (action != null && action.equals("show") && tk != null) {
            req.setAttribute("listDonHang", gh.getL());
            req.setAttribute("giohang", gh);
            if (gh.getL().size() == 0) {
                req.setAttribute("messege", "Giỏ hàng của bạn đang trống");
            }
            req.getRequestDispatcher("cart.jsp").forward(req, resp);
        } else if (tk != null) {
            //xử lí thêm sản phẩm
            if (addID != null) {
                //trường hợp sản phẩm chưa có trong giỏ hàng
                int addsl = 1;
                if (soluong != null) {
                    addsl = Integer.parseInt(soluong);
                }
                SanPham sp = dao.getSanPham(addID);
                System.out.println(dao.checkDonHang(addID, gh.getTk().getId() + "gh"));
                if (dao.checkDonHang(addID, gh.getTk().getId() + "gh") == false) {
                    MucDonHang m = new MucDonHang(sp, addsl, addsl * sp.getGia());
                    System.out.println(addsl * sp.getGia());
                    List<MucDonHang> l = gh.getL();
                    l.add(m);
                    gh.setL(l);
                    System.out.println("123456789");
                    dao.addDonHang(gh);
//                    req.setAttribute("listDonHang", l);

                } else {
                    //trường hợp sản phẩm có trong giỏ hàng

                    for (MucDonHang m : gh.getL()) {
                        if (addID.equals(m.getSp().getId())) {
                            System.out.println(addID);
                            m.setSoluong(m.getSoluong() + addsl);
                            m.setTongtien(m.getTongtien() + addsl * m.getSp().getGia());
                            gh.setTongtien(gh.getTongtien() + addsl * m.getSp().getGia());
                            dao.updateDonHang(m, gh.getTk().getId() + "gh");
                            break;
                        }
                    }
//                    req.setAttribute("listDonHang", gh.getL());
//                    req.getRequestDispatcher("home").forward(req, resp);

                }
                gh.setSl(gh.getSl() + addsl);

                url = "home";
                //xoá sản phẩm
            } else if (deleteID != null) {
                for (MucDonHang m : gh.getL()) {
                    if (deleteID.equals(m.getSp().getId())) {
                        dao.deleteDonHang(m, gh.getTk().getId() + "gh");
                        int tt = m.getTongtien();
                        int sl = m.getSoluong();
                        gh.getL().remove(m);
                        gh.setTongtien(gh.getTongtien() - tt);
                        gh.setSl(gh.getSl() - sl);
                        break;
                    }
                }
                if (gh.getSl() == 0) {
                    req.getSession().removeAttribute("sl");
                }
//                req.setAttribute("listDonHang", gh.getL());
//                req.setAttribute("giohang", gh);
                url = "cart?action=show";
                // cập nhật số lương sản phẩm
            } else if (updateID != null) {
                for (MucDonHang m : gh.getL()) {
                    if (updateID.equals(m.getSp().getId())) {
                        if (action.equals("up")) {
                            m.setSoluong(m.getSoluong() + 1);
                            m.setTongtien(m.getTongtien() + m.getSp().getGia());
                            gh.setTongtien(gh.getTongtien() + m.getSp().getGia());
                            gh.setSl(gh.getSl() + 1);
                        } else if (gh.getSl() > 1) {
                            m.setSoluong(m.getSoluong() - 1);
                            m.setTongtien(m.getTongtien() - m.getSp().getGia());
                            gh.setTongtien(gh.getTongtien() - m.getSp().getGia());
                            gh.setSl(gh.getSl() - 1);
                        }
                        dao.updateDonHang(m, gh.getTk().getId() + "gh");
                        break;
                    }
                }
                url = "cart?action=show";

            }
            if (gh.getSl() != 0) {
                req.getSession().setAttribute("sl", gh.getSl());
            }
            if (req.getParameter("url") != null) {
                resp.sendRedirect(req.getParameter("url"));
            } else {
                resp.sendRedirect(url);
            }

        }
//        if (dao.getSLgHoaDon() != 0) {
//            req.getSession().setAttribute("tongsl", dao.getSLgHoaDon());
//        }
//        if (dao.getSLgHoaDon() == 0) {
//            req.getSession().removeAttribute("tongsl");
//        }
    }

}
