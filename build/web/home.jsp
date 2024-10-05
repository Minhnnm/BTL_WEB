<%-- 
    Document   : home
    Created on : Apr 17, 2022, 4:02:35 PM
    Author     : Administrator
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <!--<meta http-equiv="X-UA-Compatible" content="IE=edge">-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="icon/fontawesome-free-6.1.1-web/css/all.min.css">
        <link rel="stylesheet" href="css/base.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="web">
            <jsp:include page="header.jsp"/>
            <jsp:include page="content.jsp"/>
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
