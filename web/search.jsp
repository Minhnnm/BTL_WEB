<%-- 
    Document   : search
    Created on : Apr 27, 2022, 12:17:32 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <!--<meta http-equiv="X-UA-Compatible" content="IE=edge">-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="icon/fontawesome-free-6.1.1-web/css/all.min.css">
        <link rel="stylesheet" href="css/base.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="web">
            <jsp:include page="header.jsp"/>
            <div class="web-noidung">
                <div class="noidung">
                    <div class="dieuhuong-noidung">
                        <ul class="dieuhuong-danhsach">
                            <li class="dieuhuong-muc"><a href="home">
                                    <span>Trang chủ</span>
                                    <img src="image/phancach.png" alt="" class="phancach">
                                </a>
                            </li>
                            <li class="dieuhuong-muc"><a href="#">
                                    <span>Kết quả tìm kiếm</span>
                                </a>
                            </li>
                        </ul>
                    </div> 
                    <div class="noidung-hang">
                        <!--                         phần dan mục sản phầm của web 
                                                 phần dan mục sản phầm của web -->
                        <div class="danhmuc">
                            <div class="danhmuc-khoi">
                                <h3 class="tieude-danhmuc">DANH MỤC SẢN PHẨM</h3>
                                <ul class="danhmuc-danhsach">
                                    <c:forEach items="${requestScope.danhmuc}" var="dm">
                                        <li class="danhmuc-sanpham"><a href="category?id=${dm.id}" class="danhmuc-duongdan">${dm.ten}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                        </div>

                        <!-- Phần hiển thị sản phẩm -->
                        <div class="sanpham">

                            <!-- Phần danh sách sản phẩm -->
                            <div class="danhsach-sanpham">
                                <div class="noidung-hang">
                                    <c:forEach items="${requestScope.list}" var="sanPham" >
                                        <div class="sanpham-bocuc">
                                            <!--chi tiết hiển thị nội dung sản phẩm--> 
                                            <div class="sanpham-muc">
                                                <!--Hiển thị hình ảnh sản phẩm--> 
                                                <div class="sanpham-hinhanh">
                                                    <a href="detail?id=${sanPham.id}"> <img src="${sanPham.img}" alt=""
                                                                                            class="sanpham-hinhanh__img"></a>
                                                </div>
                                                <!--Hiển thị thông tin sản phẩm--> 
                                                <div class="sanpham-noidung">
                                                    <h3 class="sanpham-ten">${sanPham.ten}</h3>
                                                    <div class="sanpham-noidung-chitiet">
                                                        <span class="sanpham-gia"> <fmt:formatNumber value="${sanPham.gia}" type="currency" /></span>

                                                        <a href="cart?add=${sanPham.id}&url=search?tk=${requestScope.tk}&page=${requestScope.trangHt}" class="themsanpham"><span>Mua Hàng</span></a>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>

                            <!-- phaan trang web -->

                            <c:if test="${requestScope.slsanpham != 0}">
                                <div class="phantrang">
                                    <c:if test="${requestScope.trangHt != 1}">
                                        <a href="search?page=${requestScope.trangHt-1}&tk=${requestScope.key}">&laquo;</a>
                                    </c:if>
                                    <c:forEach begin="${requestScope.trangd}" end="${requestScope.trangc}" var="i">
                                        <a href="search?page=${i}&tk=${requestScope.key}" class=${i == requestScope.trangHt? "active":""} >${i}</a>
                                    </c:forEach>
                                    <c:if test="${requestScope.trangHt != requestScope.soTrang}">
                                        <a href="search?page=${requestScope.trangHt+1}&tk=${requestScope.key}" >&raquo;</a>
                                    </c:if>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
