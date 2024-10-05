<%-- 
    Document   : payment
    Created on : Apr 30, 2022, 8:29:37 PM
    Author     : Administrator
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : payment
    Created on : Apr 30, 2022, 8:22:14 PM
    Author     : Administrator
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="icon/fontawesome-free-6.1.1-web/css/all.min.css">
        <link rel="stylesheet" href="css/base.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/cart.css">
        <link rel="stylesheet" href="css/order.css">

        <title>Document</title>
    </head>

    <body>
        <div class="web">

            <!-- phần tiêu đề của web -->
            <jsp:include  page="header.jsp"/>
            <!-- phần nội dung của web -->
            <div class="web-noidung">

                <div class="wrapper">
                    <div class="dieuhuong-noidung">
                        <ul class="dieuhuong-danhsach">
                            <li class="dieuhuong-muc"><a href="home">
                                    <span>Trang chủ</span>
                                    <img src="image/phancach.png" alt="" class="phancach">
                                </a>
                            </li>
                            <li class="dieuhuong-muc"><a href="#">
                                    <span>Đặt hàng</span></a></li>
                        </ul>
                    </div>
                    <!--                    <h1 >Thanh toán</h1>-->
                    <c:if test="${requestScope.dathang == null}">
                        <div >
                            <form class="container-thanhtoan" name="order" method="post" action="order" class="info-nguoinhan">
                                <div class="thongtin">
                                    <h1>Thông tin thanh toán</h1>
                                    <div class="thongtin-hang">
                                        <label for="info-row-item1">Họ và tên</label>
                                        <input onclick="clickRow(this)"  onblur="blurRow(this)" required="true" value="${sessionScope.taikhoan.ten}" name="ten" type="text" id="info-row-item1" class="muc-thongtin-hang">
                                    </div>
                                    <div class="thongtin-hang">
                                        <label for="info-row-item2">Số điện thoại</label>
                                        <input onclick="clickRow(this)"  onblur="blurRow(this)" required="true" value ="${sessionScope.taikhoan.sdt}" name="sdt" type="text" id="info-row-item2" class="muc-thongtin-hang">

                                    </div>
                                    <div class="thongtin-hang">
                                        <label for="info-row-item3">Email</label>
                                        <input onclick="clickRow(this)"  onblur="blurRow(this)" required="true" value ="${sessionScope.taikhoan.emailString}" name="email" type="text" id="info-row-item3" class="muc-thongtin-hang email">
                                    </div>
                                    <div class="thongtin-hang">
                                        <label for="info-row-item4">Địa chỉ</label>
                                        <input onclick="clickRow(this)"  onblur="blurRow(this)" required="true" value ="${sessionScope.taikhoan.diachi}" name="diachi" type="text" id="info-row-item4" class="muc-thongtin-hang">
                                    </div>
                                </div>
                                <div class="container-ghichu">
                                    <h1>Thông tin thêm</h1>
                                    <div class="thongtin-hang">
                                        <label for="info-row-item5">Ghi chú đơn hàng</label>
                                        <textarea name="ghichu" placeholder="Ghi chú đơn hàng...." id="info-row-item5" class="muc-thongtin-hang" cols="50" rows="5">
                                        
                                        </textarea>
                                        
                                    </div>
                                </div>
                            </form>

                        </div>

                        <div class="container">
                            <!-- phần giỏ hàng -->
                            <div class="container-giohang">
                                <h5 class="header">Thông tin đơn hàng</h5>
                                <div class="giohang">
                                    <ul>
                                        <c:forEach items="${requestScope.gh.l}" var="i">
                                            <li class="muc-giohang">
                                                <div class="item-anh">
                                                    <a>
                                                        <img src="${i.sp.img}" alt="quan-ao">
                                                    </a>
                                                </div>
                                                <div class="muc-thongtin muc-mota">
                                                    <span>${i.sp.ten}</span>
                                                </div>

                                                <div class="muc-thongtin item-quantity">
                                                    <span>x${i.soluong}</span>
                                                </div>
                                                <div class="muc-thongtin muc-gia">
                                                    <span><fmt:formatNumber value="${i.tongtien}" type="currency"/> </span>
                                                </div>
                                            </li>
                                        </c:forEach>

                                    </ul>
                                </div>
                            </div>

                            <!-- phần thông tin hoá đơn -->
                            <div class="container-dathang">

                                <div class="dathang">
                                    <div class="thongtindathang">
                                        <div class="thongtin-dathang-hang">
                                            <span>Tạm tính</span>
                                            <span><fmt:formatNumber value="${gh.tongtien}" type="currency"/></span>
                                        </div>
                                        <div class="thongtin-dathang-hang">
                                            <span>Khuyến mãi</span>
                                            <span>0 đ</span>
                                        </div>
                                        <div class="thongtin-dathang-hang">
                                            <span>Phí vận chuyển</span>
                                            <span>0 đ</span>
                                        </div>
                                        <div class="thongtin-dathang-hang tong-dathang">
                                            <span>Tổng tiền</span>
                                            <span id="tong-tien"><fmt:formatNumber value="${gh.tongtien}" type="currency"/></span>
                                        </div>

                                        <div class="thanhtoan btn-dathang">
                                            <a onclick="orderProduct()" >Đặt hàng</a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </c:if>
                    <c:if test="${requestScope.dathang != null}">
                        <div class="thongtindathang">
                            <div class="noidung-thongtindathang">
                                <h2>Đơn hàng đã nhận</h2>
                                <h5>Cảm ơn bạn.Đơn hàng của bạn đã được nhận</h5>
                                <div class="thongtindonhang">
                                    <div class="muc-thongtin">
                                        <span>Người nhận : ${sessionScope.taikhoan.ten}</span>
                                    </div>
                                    <div class="muc-thongtin">
                                        <span>Ngày đặt : ${requestScope.date}</span>
                                    </div>
                                    <div class="muc-thongtin email">
                                        <span>Email : ${sessionScope.taikhoan.emailString}</span>
                                    </div>
                                    <div class="muc-thongtin">
                                        <span>Số điện thoại : ${sessionScope.taikhoan.sdt}</span>
                                    </div>
                                    <div class="muc-thongtin">
                                        <span>Địa chỉ : ${sessionScope.taikhoan.diachi}</span>
                                    </div>
                                    <div class="muc-thongtin">
                                        <span>Tổng tiền : <fmt:formatNumber value="${requestScope.gh.tongtien}" type="currency"/></span>
                                    </div>
                                    <div class="muc-thongtin">
                                        <span>Phương thức thanh toán: Thanh toán khi nhận hàng</span>
                                    </div>
                                </div>
                                <div class="chitietdonhang">
                                    <h2>Chi tiết đơn hàng</h2>
                                    <div class="giohang">
                                        <ul>
                                            <c:forEach items="${requestScope.gh.l}" var="i">
                                                <li class="muc-giohang">
                                                    <div class="item-anh">
                                                        <a>
                                                            <img src="${i.sp.img}" alt="quan-ao">
                                                        </a>
                                                    </div>
                                                    <div class="muc-thongtin muc-mota">
                                                        <span>${i.sp.ten}</span>
                                                    </div>

                                                    <div class="muc-thongtin item-quantity">
                                                        <span>x${i.soluong}</span>
                                                    </div>
                                                    <div class="muc-thongtin item-price">
                                                        <span><fmt:formatNumber value="${i.tongtien}" type="currency"/> </span>
                                                    </div>
                                                </li>
                                            </c:forEach>

                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="thanhtoan btn-dathang">
                                <a href="home" >Tiếp tục mua hàng</a>
                            </div>
                        </div>

                    </c:if>

                </div>
            </div>


            <jsp:include page="footer.jsp"/>
            <script src="js/main.js"></script>
        </div>
    </body>

</html>
