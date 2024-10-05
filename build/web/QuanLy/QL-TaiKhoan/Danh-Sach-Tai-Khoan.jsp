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

            <h1>Danh sách tài khoản</h1>
            <a href="tai-khoan?action=add" class="btn btn-submit">Thêm mới</a>

            <table class="di_chuot">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên đăng nhập</th>
                        <th>Tên người dùng</th>
                        <th>Phân quyền</th>
                        <th>Số điện thoại</th>
                        <th>Email</th>
                        <th>Địa chỉ</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${taiKhoans}" var="taiKhoan">
                        <tr>
                            <td>${taiKhoan.id}</td>
                            <td>${taiKhoan.tendn}</td>
                            <td>${taiKhoan.ten}</td>
                            <td>${taiKhoan.phanquyen}</td>
                            <td>${taiKhoan.sdt}</td>
                            <td>${taiKhoan.emailString}</td>
                            <td>${taiKhoan.diachi}</td>
                            <td>
                                <a href="tai-khoan?action=edit&id=${taiKhoan.id}" class="btn btn-sua">Sửa</a>
                                <a href="tai-khoan?action=delete&id=${taiKhoan.id}" class="btn btn-xoa">Xóa</a>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>


        </div>
    </body>
</html>
