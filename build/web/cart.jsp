<%-- 
    Document   : cart
    Created on : Apr 26, 2022, 4:04:42 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="icon/fontawesome-free-6.1.1-web/css/all.min.css">
        <link rel="stylesheet" href="css/base.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/form.css">
        <link rel="stylesheet" href="css/cart.css">

        <title>Document</title>
    </head>

    <body>
        <div class="web">

            <!-- phần tiêu đề của web -->
            <jsp:include page="header.jsp"/>
            <!-- phần nội dung của web -->
            <div class="web-noidung">
                <!--                <div class="content-cart">
                                    <h1>Giỏ Hàng</h1>
                                </div>-->
                <div class="wrapper">
                    <div class="dieuhuong-noidung">
                        <ul class="dieuhuong-danhsach">
                            <li class="dieuhuong-muc"><a href="home">
                                    <span>Trang chủ</span>
                                    <img src="image/phancach.png" alt="" class="phancach">
                                </a>
                            </li>
                            <li class="dieuhuong-muc">
                                <a href="#"> <span>Giỏ hàng</span></a>

                            </li>
                        </ul>
                    </div>
                    <div class="container">
                        <!-- phần giỏ hàng -->
                        <div class="container-giohang">
                            <h5 class="header">Giỏ Hàng</h5>
                            <div class="giohang">
                                <ul>
                                    <c:forEach items="${requestScope.listDonHang}" var="i">
                                        <li class="muc-giohang">
                                            <div class="item-anh">
                                                <a href="#">
                                                    <img src="${i.sp.img}" alt="dogiadung">
                                                </a>
                                            </div>
                                            <div class="muc-thongtin muc-mota ">
                                                <span>${i.sp.ten}</span>
                                            </div>
                                            <div class="muc-thongtin muc-gia">
                                                <span><fmt:formatNumber value="${i.tongtien}" type="currency" /></span>
                                            </div>
                                            <div class="muc-thongtin item-quantity">
                                                <div class="muc-dem">
                                                    <a href="cart?update=${i.sp.id}&action=down" class="down">-</a>
                                                    <span>${i.soluong}</span>
                                                    <a href="cart?update=${i.sp.id}&action=up" class="up">+</a>
                                                </div>
                                            </div>
                                            <div class="muc-thongtin">
                                                <a href="cart?delete=${i.sp.id}">
                                                    <span>delete</span>
                                                </a>
                                            </div>
                                        </li>
                                    </c:forEach>
                                    <c:out value="${requestScope.messege}"/>
                                </ul>
                            </div>
                        </div>

                        <!-- phần thông tin hoá đơn -->
                        <div class="container-dathang">
                            <h5 class="header">Thông tin đơn hàng</h5>
                            <div class="dathang">
                                <div class="thongtin-dathang">
                                    <div class="thongtin-dathang-hang">
                                        <span>Tạm tính</span>
                                        <span><fmt:formatNumber value="${requestScope.giohang.tongtien}" type="currency" /></span>
                                    </div>
                                    <div class="thongtin-dathang-hang">
                                        <span>Khuyến mãi</span>
                                        <span>0 đ</span>
                                    </div>
                                    <div class="thongtin-dathang-hang">
                                        <span>Phí vận chuyển</span>
                                        <span>0 đ</span>
                                    </div>
                                    <div class="thongtin-dathang-hang tong-dathang">
                                        <span>Tổng tiền</span>
                                        <span id="tong-tien"><fmt:formatNumber value="${requestScope.giohang.tongtien}" type="currency" /></span>
                                    </div>
                                    <c:if test="${sessionScope.sl==null}">
                                        <div class="thongbao">
                                            <h5>Đơn hàng của bạn không thể thanh toán</h5>
                                        </div>
                                    </c:if> 
                                    <div class="thanhtoan">
                                        <a href="${sessionScope.sl!=null ? "order" : ""}">Thanh Toán</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
            </div>


            <jsp:include page="footer.jsp"/>
        </div>
    </body>

</html>