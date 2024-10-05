<%-- 
    Document   : accout
    Created on : May 7, 2022, 10:00:11 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="css/order.css">
        <link rel="stylesheet" href="css/accout.css">

        <title>Document</title>
    </head>

    <body>
        <div class="web">

            <jsp:include page="header.jsp"/>
            <!-- phần nội dung của web -->
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
                                    <span>Tài Khoản</span></a></li>
                        </ul>
                    </div>

                    <div class="form-dangnhap">
                        <div class="noidung-formdangnhap">
                            <form action="accout" method="post">

                                <div class="container-thanhtoan">

                                    <div class="thongtin">
                                        <!-- <div class="info-nguoinhan"> -->
                                        <c:if test="${requestScope.update != null}">
                                            <div class="thongbao">
                                                <h5>Đã cập nhật thành công</h5>
                                            </div> 
                                        </c:if>
                                        <div class="thongtin-hang">
                                            <label for="info-row-item1">Họ và tên</label>
                                            <input value="${sessionScope.taikhoan.ten}" onclick="clickRow(this)" onblur="blurRow(this)" name="ten"  type="text"
                                                   id="info-row-item1" class="muc-thongtin-hang">
                                        </div>
                                        <div class="thongtin-hang">
                                            <label for="info-row-item2">Số điện thoại</label>
                                            <input  value="${sessionScope.taikhoan.sdt}" onclick="clickRow(this)"  onblur="blurRow(this)" name="sdt" type="text"
                                                    id="info-row-item2" class="muc-thongtin-hang">

                                        </div>
                                        <div class="thongtin-hang email">
                                            <label for="info-row-item3">Email</label>
                                            <input value="${sessionScope.taikhoan.emailString}"onclick="clickRow(this)" name="email" onblur="blurRow(this)" type="text"
                                                   id="info-row-item3" class="muc-thongtin-hang email">
                                        </div>
                                        <div class="thongtin-hang">
                                            <label for="info-row-item4">Địa chỉ</label>
                                            <input  value="${sessionScope.taikhoan.diachi}" onclick="clickRow(this)" name="diachi" onblur="blurRow(this)" type="text"
                                                    id="info-row-item4" class="muc-thongtin-hang">
                                        </div>
                                        <div class="thongtin-hang">
                                            <label for="info-row-item5">Mật khẩu mới</label>
                                            <input onclick="clickRow(this)" onblur="blurRow(this)" name="pass" type="password"
                                                   id="info-row-item5" class="muc-thongtin-hang">
                                        </div>
                                        <div class="form-hang button">
                                            <input type="submit" value="Lưu" class="muc-form-hang" >
                                        </div>
                                        <!-- </div> -->
                                    </div>

                                </div>
                            </form>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>


    <jsp:include page="footer.jsp"/>
</div>
<script src="js/main.js"></script>
</body>

</html>