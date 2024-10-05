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

            <h1>Thêm mới sản phẩm</h1>

            <div class="bieu_mau">
                <h3>Thông tin sản phẩm</h3>
                <form action="san-pham" method="post">
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Tên sản phẩm : </label>
                            <input name="tenSp" type="text" placeholder="Nhập tên sản phẩm">
                        </div>
                    </div>
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Giá sản phẩm: </label>
                            <input type="number" min="0" class="input" required name="giaSp" placeholder="Nhập giá sản phẩm"></br>
                        </div>
                    </div>
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Ảnh sản phẩm : </label>
                            <input type="file" class="input" name="img" required>
                        </div>
                    </div>
                    <div class="than">
                        <div class="thanh-phan">
                            <label for="email">Loại sản phẩm : </label></br>
                            <select class="input" name="idLoaiSp" style="width: 555px; height: 40px; font-size: 1.5rem">
                                <c:forEach items="${danhMucs}" var="danhMuc">
                                    <option value="${danhMuc.id}">${danhMuc.ten}</option>
                                </c:forEach>
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
