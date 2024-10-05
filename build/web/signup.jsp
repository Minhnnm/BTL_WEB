<%-- 
    Document   : signin
    Created on : Apr 24, 2022, 9:10:18 AM
    Author     : Administrator
--%>

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
        <link rel="stylesheet" href="css/order.css">

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
                                    <span>Đăng Kí</span></a></li>
                        </ul>
                    </div>
                    <div class="form-dangnhap">
                        <div class="noidung-dangnhap">
                            <h1>Đăng Kí</h1>
                        </div>
                        <div class="noidung-formdangnhap">
                            <form action="signup" method="post">
                                <div class="thongbao">
                                    <h5>${requestScope.error}</h5>
                                </div> 
                                <div class="form-hang">
                                    <input onclick="clickRow(this)" onblur="blurRow(this)" required="true" name="user" type="text" class="muc-form-hang"  placeholder="Tên đăng nhập">
                                </div>
                                <div class="form-hang">
                                    <input onclick="clickRow(this)" onblur="blurRow(this)" required="true" name="phone" type="text" class="muc-form-hang"  placeholder="Số điện thoại">
                                </div>

                                <div class="form-hang">
                                    <input id="pass1" onclick="clickRow(this)" onblur="blurRow(this)"  required="true" name="pass1" type="password" class="muc-form-hang"  placeholder="Mật khẩu">
                                </div>
                                <div class="form-hang">
                                    <input id="pass2" onclick="clickRow(this)" onblur="blurRow(this)" oninput="checkPass(this)"  required="true" name="pass2" type="password" class="muc-form-hang"  placeholder="Nhập lại mật khẩu">
                                </div>
                                <div class="form-hang button">
                                    <input id="btn" type="submit" value="Đăng kí" id="btn" class="muc-form-hang" >
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