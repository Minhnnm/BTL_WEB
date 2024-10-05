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

            <h1>Thêm mới danh mục</h1>

            <div class="bieu_mau">
                <h3>Thông tin danh mục</h3>
                <form action="danh-muc" method="post">
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Tên danh mục : </label>
                            <input name="tenDanhMuc" type="text" placeholder="Nhập tên danh mục">
                        </div>
                    </div>
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Mô tả : </label>
                            <input type="text" placeholder="Nhập tên mô tả">
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
