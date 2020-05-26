<%-- 
    Document   : RightContent
    Created on : Feb 21, 2020, 2:54:50 PM
    Author     : TRUNG KIEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Right Content</title>
        <link href="css/rightContent.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="right-content">
            <div class="new">
                <div class="new-title">
                    <span>Digital News</span>
                </div>
                <div class="sortContent">
                   ${postById.getSortContent()}
                </div>
            </div>
                <div class="new">
                    <div class="new-title">
                        <span>Search</span> 
                    </div>
                    <form action="Search" method="post">
                        <input class="searchBox" type="text" name="search" value="${search}" size="10" >
                        <input class="searchButton" type="submit" name="Go" value="Go">
                    </form>
                </div>
                <div class="new">
                    <div class="new-title">
                        <span>Last Article</span>
                    </div>
                    <c:forEach items="${top5OfArticle}" var="i">
                    <div class="last-article">
                        <a href="HomePage?id=${i.id}">${i.title}</a>
                    </div>
                    </c:forEach>
                </div>
        </div>
    </body>
</html>
