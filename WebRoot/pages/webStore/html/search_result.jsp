<%@ page language="java" import="java.util.*,cn.qblank.model.entity.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>search_result</title>
    <link rel = "stylesheet" type = "text/css" href = "../css/search_result_css.css" />
    <link rel="stylesheet" href="../css/search_css.css">
</head>
<body>
	<%@include file="top.jsp" %>
	<%@include file="search_box.jsp" %>
<div id="top">
    <hr>
</div>
<div id="middle">
    <!--热卖商品栏-->
    <div class="left">
        <div class="left_top">
            <p class="left_top_p">热卖商品</p>
        </div>
        
        
        <c:forEach items="${prosList }" var="pros">
	        <a href="/Store/DetailProductServlet?p_id=${pros.id}">
	        <div class="picture_one">
	            <div class="one">
	                <img class="img" src="..${pros.image }" >
	            </div>
	            <p class="two">￥ ${pros.price }</p>
	            <p class="three">${pros.name }</p>
	
	        </div>
	        </a>
      </c:forEach>
       
        
    </div>
    <!--商品展示栏-->
    <div class="right">
        <div class="right_top">
            <ul>
                <li class="ts"> &nbsp;&nbsp;</li> 

                <li class="ts"><a href="/Store/AscServlet">价格&nbsp;&nbsp;↑</a></li>

                <li class="ts"><a href="/Store/DescServlrt">价格&nbsp;&nbsp;↓<a></li>
            </ul>
        </div>
        <%-- <%
        	for(int i = 0;i<8;i++){
         %> --%>
         <c:forEach items="${proList }" var="pro">
	         <a href="/Store/DetailProductServlet?p_id=${pro.id}">
	            <div class="picture_two">
	                <img class="one" src="..${pro.image }" alt="">
	                <p class="two">￥ ${pro.price }</p>
	                <p class="three">${pro.name }</p>
	            </div></a>
	         <a href="#">
         </c:forEach>
         <%-- <%
         	}
          %> --%>
        <div class="right_bottom">
           <!--  <ul>
                <li class="page">上一页</li>
                <li class="page">1</li>
                <li class="page">2</li>
                <li class="page">3</li>
                <li class="page">...</li>
                <li class="page">下一页</li>
            </ul> -->
        </div>
    </div>
</div>
	<%@include file="bottom.html" %>
</body>
</html>