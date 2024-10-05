<%-- 
    Document   : dautrang
    Created on : Jun 11, 2022, 12:43:52 AM
    Author     : holme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<input type="checkbox" id="kiem_tra">

<header>

    <label for="kiem_tra">
        <i class="fas fa-bars"  id="menu_trai_btn"></i>
    </label>

    <div class="thanh_trai">
        <h3>Quản lý</h3>
    </div>
    <div class="thanh_phai">
        <a href="${pageContext.request.contextPath}/logout" class="dang_xuat">Đăng xuất</a>
    </div>
</header>

<div class="menu_trai">
    <center>
        <img src="${pageContext.request.contextPath}/image/quanly/1.png" class="anh_quanly">
        <h4>Quản lý</h4>
    </center>
    <a href="${pageContext.request.contextPath}/admin"><i class="fa-solid fa-desktop"></i><span>Bảng điều khiển</span></a>
    <a href="${pageContext.request.contextPath}/admin/tai-khoan"><i class="fa-solid fa-table"></i><span>Tài khoản</span></a>
    <a href="${pageContext.request.contextPath}/admin/san-pham"><i class="fa-solid fa-info-circle"></i><span>Sản phẩm</span></a>
    <a href="${pageContext.request.contextPath}/admin/danh-muc"><i class="fa-solid fa-cogs"></i><span>Danh mục</span></a>
    <a href="${pageContext.request.contextPath}/admin/gio-hang"><i class="fa-solid fa-th"></i><span>Giỏ hàng</span></a>
    <a href="${pageContext.request.contextPath}/admin/don-hang"><i class="fa-solid fa-sliders-h"></i><span>Đơn hàng</span></a>
</div>
