<%@ page language="java" import="java.util.*,cn.qblank.model.entity.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品页面</title>
    <link rel="stylesheet" href="../css/product.css">
    <link rel="stylesheet" href="../css/search_css.css">
</head>
<body>
	<%@include file="top.jsp" %>
<%@include file="search_box.jsp" %>
    <form action="/Store/control/ShopCarServlet">
    <div class="product_intro">
        <div class="pic">
            <img src="..${product.image }" width="350px" class="pro_pic">
        </div>
        <div class="pro_des">
            <!--商品名字-->
            <div class="pro_title">
                <%-- ${sessionScope.product.name} --%>
                <c:out value="${product.name }" default="无该商品"></c:out>
                
            </div>
            <!--商品价格-->
            <div class="pro_price">
                &nbsp;&nbsp;&nbsp;&nbsp;价&nbsp;格: <span class="pro_price_num" >￥
                <c:out value="${product.price }" default="无该商品"></c:out></span>
            </div>

            <!-- 地址 -->
            <div class="address">
                &nbsp;&nbsp;&nbsp;&nbsp;湖南长沙市望城区金山桥镇&nbsp;
                <c:choose>
                	<c:when test="${product.count > 0 }">有货</c:when>
                	<c:otherwise>无货</c:otherwise>
                </c:choose>
            </div>

            <!--重量-->
            <div class="pro_weight">
                &nbsp;&nbsp;&nbsp;&nbsp;重量:&nbsp;<c:out value="${product.weight }" default="无"></c:out>
            </div>
			<!-- 隐藏域，传递id -->
			<input  type="text" name="p_id" value="${product.id }"  hidden="hidden" />
			
            <!--购买模块-->
            <div class="pro_brought">
                数量:<input type="number" class="pro_num"  min="1" max="100" value="1" name="pro_num"/>
                <a href="/Store/control/ShopCarServlet"><button class="add_car" type="submit">加人购物车</button></a>
                <a href="Order.html"><button class="buy_pro">一键购买</button></a>
            </div>
        </div>
    </div>
    

    </form>
    
    <%-- <c:forEach begin="0" end="2" step="1" var="student" varStatus="stu" items="${list}">  
        编号:${stu.count}   姓名:${student.name},年龄:${student.age} <br/>  
</c:forEach>   --%>
        <div id="comment">
        	<div class="comment_top"><p>商品评论</p></div>

        	
        	
        <c:forEach var="comm" items="${comment}" varStatus="comms">
   			<div class="comments">
        	<div class="username">
            <img class="jpg" src="../images/top/user_pic.jpg" >
            
            <c:forEach var="user" items="${names}"  begin="${comms.count-1}" end="${comms.count-1}">
            <p>用户: ${user.name}</p>
            </c:forEach>
            </div>
        	<div class="content">
            	<p class="p1">${comm.comment}</p>
            	<div class="p2">
                	<p class="p2">${comm.time}</p>
           	 	</div>
        	</div>
        	
    	</div>
        	</c:forEach>
    </div>
    
    <%@include file="bottom.html" %>
</body>
</html>