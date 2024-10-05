<%-- 
    Document   : login.jsp
    Created on : Apr 17, 2022, 5:29:54 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="icon/fontawesome-free-6.1.1-web/css/all.min.css">
        <link rel="stylesheet" href="css/base.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/form.css">
        <link rel="stylesheet" href="css/order.css">
    </head>

    <body>
        <div class="web">

            <jsp:include page="header.jsp"></jsp:include>
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
                                        <span>Đăng nhập</span></a></li>
                            </ul>
                        </div>
                        <div class="form-dangnhap">
                            <div class="noidung-dangnhap">
                                <h1>Đăng Nhập</h1>
                            </div>
                            <div class="noidung-formdangnhap">
                                <form action="" method="post">
                                <c:if test="${requestScope.loginError != null}">
                                    <div class="thongbao">
                                        <h5>Tài khoản hoặc mật khẩu không chính xác</h5>
                                    </div> 
                                </c:if>
                                <div class="form-hang">
                                    <input required="true" onclick="clickRow(this)" onblur="blurRow(this)" name="user" type="text" class="muc-form-hang"  placeholder="Tên đăng nhập">
                                </div>
                                <div class="form-hang">
                                    <input required="true" onclick="clickRow(this)" onblur="blurRow(this)" name="pass" type="password" class="muc-form-hang"  placeholder="Mật khẩu">
                                </div>
                                <div class="form-hang button">
                                    <input type="submit" value="Đăng nhập" class="muc-form-hang" >
                                </div>
                                <div class="form-hang dangnhap">
                                    <span>Bạn là thành viên mới? <a href="signup">Đăng kí</a> tại đây.</span>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


            </div>

            <jsp:include page="footer.jsp"/>
        </div>
        <script src="js/main.js"></script>
    </body>

</html>