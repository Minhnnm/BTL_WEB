
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="icon/fontawesome-free-6.1.1-web/css/all.min.css">
        <link rel="stylesheet" href="css/base.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/cart.css">
    </head>
    <body>
        <div class="web">
            <jsp:include page="header.jsp"/>
            <div class="web-noidung">
                <div class="noidung">
                    <div class="dieuhuong-noidung">
                        <ul class="dieuhuong-danhsach">
                            <li class="dieuhuong-muc"><a href="home">
                                    <span>Trang chủ</span>
                                    <img src="image/phancach.png" alt="" class="phancach">
                                </a>
                            </li>
                            <li class="dieuhuong-muc">
                                <a href="#">
                                    <span>${requestScope.dm.ten}</span>
                                </a>
                            </li>
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

                        <!-- Phần hiển thị sản phẩm -->
                        <div class="sanpham">

                            <!-- Phần danh sách sản phẩm -->
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
                                                            <span class="sanpham-gia"><fmt:formatNumber value="${sanPham.gia}" type="currency"/></span>
                                                            <c:if test="${quyen==null || quyen=='khachhang'}">
                                                                <a href="cart?add=${sanPham.id}&url=home?page=${requestScope.trangHt}" class="themsanpham"><span>Mua Hàng</span></a>
                                                            </c:if>
                                                            <c:if test="${quyen=='admin'}">
                                                                <a href="detail?id=${sanPham.id}" class="themsanpham"><span>Chỉnh sửa</span></a>
                                                            </c:if>
                                                        </div>
                                                        <c:if test="${quyen=='admin'}">
                                                            <form action="xoasanpham" method="POST">
                                                                <button class="xoasanpham" type="submit" name="idxoa" value="${sanPham.id}" >Xóa Sản Phẩm</button>
                                                            </form>
                                                        </c:if> 

                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>

                                    </div>
                                </div>

                                <!-- phaan trang web -->

                                <c:if test="${requestScope.slsanpham != 0}">
                                    <div class="phantrang">
                                        <c:if test="${requestScope.trangHt != 1}">
                                            <a href="category?id=${requestScope.dm.id}&page=${requestScope.trangHt-1}" >&laquo;</a>
                                        </c:if>
                                        <c:forEach begin="1" end="${requestScope.soTrang}" var="i">
                                            <a href="category?id=${requestScope.dm.id}&page=${i}" class=${i == requestScope.trangHt? "active":""} >${i}</a>
                                        </c:forEach>
                                        <c:if test="${requestScope.trangHt != requestScope.soTrang}">
                                            <a href="category?id=${requestScope.dm.id}&page=${requestScope.trangHt+1}" >&raquo;</a>
                                        </c:if>
                                    </div>
                                </c:if>

                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>

