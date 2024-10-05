<%-- 
    Document   : trangchu
    Created on : Jun 11, 2022, 12:25:49 AM
    Author     : holme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trang Quản lý</title>

        <link rel="stylesheet" href="../css/quanly/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <script src="js/quanly/script.js"></script>
    </head>
    <body>

        <jsp:include page="../Header-QL.jsp"/>

        <div class="noi_dung">

            <h1>Chỉnh sửa Tài khoản</h1>

            <div class="bieu_mau">
                <h3>Thông tin tài khoản</h3>
                <form action="tai-khoan?action=edit&id=${taiKhoan.id}" method="post">
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Tên đăng nhập : </label>
                            <input value="${taiKhoan.tendn}" name="tenDn" type="text" placeholder="Nhập tên đăng nhập" required>
                        </div>
                    </div>
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Mật khẩu: </label>
                            <input value="${taiKhoan.mk}" type="text" name="mk" placeholder="Nhập mật khẩu" required></br>
                        </div>
                    </div>
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Tên tài khoản : </label>
                            <input value="${taiKhoan.ten}" type="text" class="input" name="ten" placeholder="Nhập tên tài khoản">
                        </div>
                    </div>
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Số điện thoại : </label>
                            <input value="${taiKhoan.sdt}" type="text" class="input" name="sdt" placeholder="Nhập số điện thoại">
                        </div>
                    </div>
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Địa chỉ : </label>
                            <input value="${taiKhoan.diachi}" type="text" class="input" name="diaChi" placeholder="Nhập địa chỉ">
                        </div>
                    </div>
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Email : </label>
                            <input value="${taiKhoan.emailString}" type="email" class="input" name="email" placeholder="Nhập email">
                        </div>
                    </div>
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Phân quyền : </label>
                            <select class="input" name="phanQuyen">
                                <option value="khachhang">Khách hàng</option>
                                <option value="admin">Quản lý</option>
                            </select></br>
                        </div>
                    </div>
                    <div class="duoi">
                        <button type="submit" class="btn btn-submit">Submit</button>
                    </div>
                </form>
            </div>


        </div>
    </body>
</html>
