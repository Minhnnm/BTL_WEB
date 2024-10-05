<%-- 
    Document   : Add
    Created on : Jun 12, 2022, 11:48:04 PM
    Author     : MinhNN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="icon/fontawesome-free-6.1.1-web/css/all.min.css">
        <link rel="stylesheet" href="css/base.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/form.css">
        <link rel="stylesheet" href="css/cart.css">
        <link rel="stylesheet" href="css/detail.css">
        <title>Document</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="themtt">
            <div class="themsp">
                <h2 class="head">Thêm sản phẩm</h2>
                <form class="frmthem" action="themsanpham" method="POST">
                    <label class="label">Tên sản phẩm</label></br>
                    <input type="text" placeholder="Nhập tên sản phẩm" name="tensp" class="input" required></br>
                    <label class="label">Tên loại sản phẩm</label></br>
                    <select class="input" name="loaisp">
                        <c:forEach items="${requestScope.danhmuc}" var="dm">
                            <option value="${dm.id}">${dm.ten}</option>
                        </c:forEach>
                    </select></br>
                    <label class="label">Giá sản phẩm</label></br>
                    <input type="number" min="0" class="input" required name="giasp"></br>
                    <label class="label">Ảnh sản phẩm</label></br>
                    <input type="file" class="input" name="img" required></br>
                    <input type="submit" class="submit" value="Thêm">
                </form>
            </div>
            <div class="themdm">
                <h2 class="head">Thêm loại sản phẩm</h2>
                <form action="themloaisp" method="POST" class="frmthem">
                    <label class="label">Tên loại sản phẩm</label></br>
                    <input type="text" placeholder="Nhập tên loại sản phẩm" name="tenloaisp" class="input" required></br>
                    <input type="submit" class="submit" value="Thêm">
                </form>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
