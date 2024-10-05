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

            <h1>Danh sách Đơn hàng</h1>

            <table class="di_chuot">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Đơn hàng của</th>
                        <th>Ngày đặt hàng</th>
                        <th>Tổng tiền</th>
                        <th>Danh sách sản phẩm trong đơn hàng</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${donHangs}" var="donHang">
                        <tr>
                            <td>${donHang.id}</td>
                            <td>${donHang.taiKhoan.tendn}</td>
                            <td>${donHang.ngayDat}</td>
                            <td>${donHang.tongTien}</td>
                            <td>
                                <a href="don-hang?action=danhSach&id=${donHang.id}" class="btn btn-sua">Xem danh sách</a>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>


        </div>
    </body>
</html>
