<%-- 
    Document   : detail
    Created on : Apr 28, 2022, 10:15:17 AM
    Author     : Administrator
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="css/cart.css">
        <link rel="stylesheet" href="css/detail.css">

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
                            <li class="dieuhuong-muc"><a href="category?id=${requestScope.dm.id}">
                                    <span>${requestScope.dm.ten}</span>
                                    <img src="image/phancach.png" alt="" class="phancach">
                                </a></li>
                            <li class="dieuhuong-muc"><a >
                                    <span>${requestScope.sp.ten}</span></a></li>
                        </ul>

                    </div>
                    <div class="noidung-hang">
                        <!-- phần dan mục sản phầm của web -->
                        <div class="danhmuc">
                            <div class="danhmuc-khoi">
                                <h3 class="tieude-danhmuc">DANH MỤC SẢN PHẨM</h3>
                                <ul class="danhmuc-danhsach">
                                    <c:forEach items="${requestScope.danhmuc}" var="dm">
                                        <li class="danhmuc-sanpham"><a href="category?id=${dm.id}" class="danhmuc-duongdan">${dm.ten}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="chitietsp">
                            <form action="chinhsua" method="POST">
                                <div class="chitietsp-noidung">
                                    <div class="chitiet-img">
                                        <img src="${requestScope.sp.img}" alt="">
                                    </div>
                                    <div class="chitiet-thongtin">
                                        <c:if test="${quyen==null || quyen=='khachhang'}">
                                            <div class="ten"><span>${requestScope.sp.ten}</span></div>
                                            <div class="gia"><span><fmt:formatNumber value="${requestScope.sp.gia}" type="currency"/></span></div>
                                            <div class="soluong">
                                                <span>Số lượng</span>
                                                <div class="muc-thongtin item-quantity">
                                                    <div class="muc-dem">
                                                        <input value="-" type="button" class="down" onclick="clickChange(this)">
                                                        <span id="item-quantity">1</span>
                                                        <input value="+" type="button" class="up" onclick="clickChange(this)">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="btn-muahang">
                                                <a class="themsanpham" id="${requestScope.sp.id}" onclick="themSanPham(this)"><span>Thêm vào giỏ</span></a>
                                            </div>
                                        </c:if>

                                        <c:if test="${quyen=='admin'}">
                                            <div class="ten">
                                                <input type="text" value="${requestScope.sp.ten}" name="tensp" style="font-size: 25px; width: 400px" required>
                                            </div>
                                            <div class="gia">
                                                <!--<span><fmt:formatNumber value="${requestScope.sp.gia}" type="currency"/></span>-->
                                                <input type="number" value="${requestScope.sp.gia}" name="giasp" required style="font-size: 25px; color: red; width: 400px">
                                            </div>
                                            <div>
                                                <select class="ten" style="width: 400px;" name="loaisp">
                                                    <c:forEach items="${requestScope.danhmuc}" var="dm">
                                                        <option value="${dm.id}">${dm.ten}</option>
                                                    </c:forEach>
                                                </select></br>
                                                <!--<input type="number" value="${requestScope.sp.gia}" name="giasp" required style="font-size: 25px; color: red; width: 400px">-->
                                            </div>
                                            <!--                                            <div class="soluong">
                                                                                            <span>Số lượng</span>
                                                                                            <div class="muc-thongtin item-quantity">
                                                                                                <div class="muc-dem">
                                                                                                    <input value="-" type="button" class="down" onclick="clickChange(this)">
                                                                                                    <span id="item-quantity">1</span>
                                                                                                    <input value="+" type="button" class="up" onclick="clickChange(this)">
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>-->

                                            <div class="btn-muahang">
                                                <!--<a class="themsanpham" id="${requestScope.sp.id}" onclick="themSanPham(this)"><span>Cập nhật</span></a>-->
                                                <button class="capnhat" type="submit" name="capnhat" value="${requestScope.sp.id}">Cập nhật</button>
                                            </div>
                                        </c:if>
                                    </div>
                            </form>

                        </div>

                        <div class="sanpham-lienquan">
                            <h1>Sản phẩm liên quan</h1>
                            <div class="danhsach-sanpham">
                                <div class="noidung-hang">
                                    <c:forEach items="${requestScope.list}" var="sanPham" >
                                        <div class="sanpham-bocuc">
                                            <!--chi tiết hiển thị nội dung sản phẩm--> 
                                            <c:if test="${quyen==null || quyen=='khachhang'}">
                                                <div class="sanpham-muc" style="height: 400px">
                                                </c:if>
                                                <c:if test="${quyen=='admin'}">
                                                    <div class="sanpham-muc" style="height: 450px">
                                                    </c:if>
                                                    <!--Hiển thị hình ảnh sản phẩm--> 
                                                    <div class="sanpham-hinhanh">
                                                        <c:if test="${quyen=='khachhang' || quyen==null}">
                                                            <a href="detail?id=${sanPham.id}"> 
                                                            </c:if> 
                                                            <img src="${sanPham.img}" alt="" class="sanpham-hinhanh__img"></a>
                                                    </div>
                                                    <!--Hiển thị thông tin sản phẩm--> 
                                                    <div class="sanpham-noidung">
                                                        <h3 class="sanpham-ten">${sanPham.ten}</h3>
                                                        <div class="sanpham-noidung-chitiet">
                                                            <span class="sanpham-gia"> <fmt:formatNumber value="${sanPham.gia}" type="currency" /></span>
                                                            <c:if test="${quyen==null || quyen=='khachhang'}">
                                                                <a href="cart?add=${sanPham.id}&url=home?page=${requestScope.trangHt}" class="themsanpham"><span>Mua Hàng</span></a>
                                                            </c:if>
                                                            <c:if test="${quyen=='admin'}">
                                                                <a href="detail?id=${sanPham.id}" class="themsanpham"><span>Chỉnh sửa</span></a>
                                                            </c:if>
                                                        </div>
                                                        <c:if test="${quyen=='admin'}">
                                                            <form action="xoasanpham" method="POST">
                                                                <button class="xoasanpham" type="submit" name="idxoa" value="${sanPham.id}" style="margin-left: 32px; margin-right: 32px; width: 125px; height: 35px;">Xóa Sản Phẩm</button>
                                                            </form>
                                                        </c:if> 

                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>

                                    </div>
                                </div>

                            </div>

                        </div>

                    </div>


                </div>
            </div>
            <script type="text/javascript" src="js/main.js"></script>
            <jsp:include page="footer.jsp"/>

    </body>

</html>