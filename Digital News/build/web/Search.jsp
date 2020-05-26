<%-- 
    Document   : Search
    Created on : Feb 21, 2020, 2:48:27 PM
    Author     : TRUNG KIEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script>
            function kien(this){
                
            }
        </script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <c:forEach items="${listSearch}" var="i">
                        <div class="title-search" >
                            <a href="HomePage?id=${i.id}">${i.title}</a>
                        </div>
                        <div class="image-search" style="font-size: 13px;">
                            <img src="./images/${i.image}" width="200px">
                            ${i.getSortContent()}
                        </div>
                        <div class="text-search">
                            
                        </div>
                        <br>
                    </c:forEach>
                        <div class="paging">
                            <c:if test="${numberPage<1}">
                                <h2>Not found!</h2>
                            </c:if>
                                
                            <c:if test="${numberPage>1}">
                                <p class="paging-number">
                                <c:forEach begin="1" end="${numberPage}" var="i"> 
                                    <a class="${i==pageIndex?"active":""}" name="${i}" id="${i}"  style="cursor:pointer;"
                                       onmouseover="this.style.textDecoration = 'underline'"
                                       onmouseout="this.style.textDecoration = 'none'"
                                       onclick="document.getElementById('index').value = this.innerHTML;
                                           document.getElementById('form1').submit();">${i}</a> 
                                </c:forEach>
                                </p>
                            </c:if>
                                <form action="Search" method="post" id="form1">
                                    <input type="hidden" id="index" name="index" value="">
                                    <input type="hidden" id="search" name="search" value="${search}">
                                </form>
                        </div>        
                </div>
                <jsp:include page="RightContent.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
