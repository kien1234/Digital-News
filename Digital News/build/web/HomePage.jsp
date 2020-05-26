<%-- 
    Document   : HomePage
    Created on : Feb 21, 2020, 2:33:36 PM
    Author     : TRUNG KIEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <div class="title">
                        ${postById.title}
                    </div>
                    <div class="image">
                         <img src="images/${postById.image}">
                    </div>
                    <div class="post">
                        ${postById.content}
                    </div>
                    <div class="signature">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        By ${postById.author} | ${postById.getDateFormat()}
                    </div>
                </div>
                <jsp:include page="RightContent.jsp"/>   
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
