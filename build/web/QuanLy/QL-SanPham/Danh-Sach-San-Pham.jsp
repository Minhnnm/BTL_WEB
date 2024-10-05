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

            <h1>Danh sách sản phẩm</h1>
            <div class="timkiem" >
                <div>
                    <a href="san-pham?action=add" class="btn btn-submit" >Thêm mới</a>
                </div>
                <form class="frmtimkiem" action="san-pham?action=timkiem" method="POST">
                    <input name="tensp" class="tk_sp" type="text" placeholder="Nhập tên sản phẩm cần tìm"  >
                    <input name ="btntimkiem" type="submit" value="Tìm kiếm">
                </form>
            </div>
            <table class="di_chuot">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên sản phẩm</th>
                        <th>Giá sản phẩm</th>
                        <th>Ảnh sản phẩm</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${sanPhams}" var="sanPham">
                        <tr>
                            <td>${sanPham.id}</td>
                            <td>${sanPham.ten}</td>
                            <td>${sanPham.gia}</td>
                            <td><img src="${sanPham.img}" alt="sanpham" style="width: 100px"/></td>
                            <td>
                                <a href="san-pham?action=edit&id=${sanPham.id}" class="btn btn-sua">Sửa</a>
                                <a href="san-pham?action=delete&id=${sanPham.id}" class="btn btn-xoa">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>


        </div>
    </body>
</html>
