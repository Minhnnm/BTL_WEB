<%-- 
    Document   : header
    Created on : Apr 17, 2022, 4:00:58 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="icon/fontawesome-free-6.1.1-web/css/all.min.css">
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/main.css">
<!-- phần tiêu đề của web -->
<div class="tieude">
    <!-- Đăng kí và đăng nhập  -->
    <div class="navbar">
        <ul class="navbar-danhsach">
            <c:if test="${sessionScope.taikhoan == null}">
                <li class="navbar-muc"><a class="navbar-duongdan" href="login">Đăng nhập</a></li>
                <li class="navbar-muc"><a class="navbar-duongdan" href="signup">Đăng kí</a></li>
                </c:if>
                <c:if test="${sessionScope.taikhoan != null}">
                <li class="navbar-muc"><a class="navbar-duongdan" href="accout">${sessionScope.taikhoan.tendn}</a></li>
                <li class="navbar-muc"><a class="navbar-duongdan" href="logout">Đăng xuất</a></li>
                </c:if>
        </ul>
    </div>
    <!-- phần tieu de còn lại -->

    <div class="tieude-con">
        <!-- phần logo trang web -->
        <div class="tieude__logo">
            <a href="home" class="tieude__logo-link">
                <img class="tieude__logo-img" src="image/logo.webp" alt="Thế Giới Đồ Gia Dụng .com.vn"> 
            </a>
        </div>
        <!-- Phần tìm kiếm trang web -->
        <div class="tieude__timkiem">
            <form action="search" method="get" class="tieude__timkiem form">
                <input type="text" value="${requestScope.key}" name="tk" class="tieude__timkiem-input" placeholder="Tìm kiếm...">
                <button class="tieude__timkiem-btn" type="submit">
                    <i class="tieude__timkiem-btn-icon fas fa-magnifying-glass"></i>
                </button>
            </form>
        </div>

        <!-- phần giỏ hàng web -->
        <div class="tieude__giohang">
            <c:if test="${quyen==null || quyen=='khachhang'}">
                <c:url value="/cart?action=show" var="cart"/>
                <a href="${cart}" class="tieude__giohang-link">
                    <i class="fas fa-cart-shopping tieude__giohang-icon">
                        <c:if test="${sessionScope.taikhoan != null && sessionScope.sl != null}">
                            <span class="tieude__giohang-icon-span">${sessionScope.sl}</span>
                        </c:if>
                    </i>
                    Giỏ hàng
                </a>
            </c:if>
            <c:if test="${quyen=='admin'}">
                <c:url value="/cart?action=show" var="cart"/>
                <a href="${cart}" class="tieude__giohang-link">
                    <i class="fas fa-cart-shopping tieude__giohang-icon">
                        <c:if test="${sessionScope.taikhoan != null && sessionScope.tongsl != null}">
                            <span class="tieude__giohang-icon-span">${sessionScope.tongsl}</span>
                        </c:if>
                    </i>
                    Đơn hàng
                </a>
            </c:if>
        </div>

        <!-- phần số chăm sóc khách hàng -->
        <div class="tieude__dienthoai">
            <c:if test="${quyen==null || quyen=='khachhang'}">
                <i class="tieude__dienthoai-icon fas fa-phone"></i>
                <p class="tieude__dienthoai-text">
                    <span class="tieude__dienthoai-text-1">Hotline: 1800 6800 (Miễn phí)<br></span>
                    <span>Mua hàng - Góp ý - Bảo hành </span>
                </p>
            </c:if>
            <c:if test="${quyen=='admin'}">
                <div class="btnthem">
                    <a class="btn-them" href="${pageContext.request.contextPath}/themsanpham"><span>Thêm sản phẩm</span></a>
                    <a class="btn-them" href="detail?id=${sanPham.id}"><span>Đơn đã nhận</span></a>
                </div>
            </c:if>
        </div>
    </div>


</div>