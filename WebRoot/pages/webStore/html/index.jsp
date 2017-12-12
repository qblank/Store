<%@ page language="java" import="java.util.*,cn.qblank.model.entity.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>京东首页</title>
    <link rel="stylesheet" href="../css/index.css">
    <script src="../js/jquery-3.1.0.min.js"></script>
    <script src="../js/index.js"></script>
    <!--轮播图-->
    <script src="../js/PCJS.js"></script>
    <!--顶部-->
    <link rel="stylesheet" href="../css/topcss.css">
    <link rel="stylesheet" href="../css/search_css.css">
    <link rel="stylesheet" type="text/css" href="../css/PC.css">
</head>
<body onload="changeColor()">
	<%@include file="top.jsp" %>
	<%@include file="search_box.jsp" %>
    <div class="header">
            <div class="logo">
                <ul class="content_nav">
                    <!-- <li><a href="#">爱吃</a></li>
                    <li><a href="#">电子数码</a></li>
                    <li><a href="#">服饰</a></li>
                    <li><a href="#">家电</a></li>
                    <li><a href="#">母婴家居</a></li>
                    <li><a href="#">图书汽车</a></li> -->
                    <c:forEach var="category"  items="${list}"> 
                    	<li><a href="#">${category.name}</a></li>
                    </c:forEach>
                </ul>
                
            </div>
    </div>

    <div class="content">
        <div class="content_right">-
            <ul>
                <li>hi,<a href="login.jsp" class="u_name">
                	<c:choose>
                		<c:when test="${empty sessionScope.username}">登陆</c:when>
                		<c:otherwise><%=session.getAttribute("username") %></c:otherwise>
                	</c:choose>
                </a></li>
                <li><div class="right_title" id="right_title"><a data-cont="sell">促销</a>&nbsp;|&nbsp;<a data-cont="inform">公告</a></div></li>
                <!-- <div>
                	<li><a href="#">88购物节零食专场低至6折</a></li>
	                <li><a href="#">奶爸盛典8.8元好货疯抢</a></li>
	                <li><a href="#">厨具好货领券满399减90</a></li>
	                <li><a href="#">京东水饮节，5折喝好水</a></li>
	                <li><a href="#">88购物节零食专场低至6折</a></li>
	                <li><a href="#">奶爸盛典8.8元好货疯抢</a></li>
                </div>
                <li><a href="#">厨具好货领券满399减90</a></li>
                <li><a href="#">京东水饮节，5折喝好水</a></li>
                <li><a href="#">88购物节零食专场低至6折</a></li>
                <li><a href="#">奶爸盛典8.8元好货疯抢</a></li>
                <li><a href="#">厨具好货领券满399减90</a></li>
                <li><a href="#">京东水饮节，5折喝好水</a></li> -->
            </ul>
            <div class="sell">
	            <ul>
	            	<li><a href="#">88购物节零食专场低至6折</a></li>
		            <li><a href="#">奶爸盛典8.8元好货疯抢</a></li>
		            <li><a href="#">厨具好货领券满399减90</a></li>
		            <li><a href="#">京东水饮节，5折喝好水</a></li>
		            <li><a href="#">88购物节零食专场低至6折</a></li>
		            <li><a href="#">奶爸盛典8.8元好货疯抢</a></li>
		        </ul>
            </div>
            <div class="inform">
            	<ul>
	            	<li><a href="#">厨具好货领券满399减90</a></li>
	                <li><a href="#">京东水饮节，5折喝好水</a></li>
	                <li><a href="#">88购物节零食专场低至6折</a></li>
	                <li><a href="#">奶爸盛典8.8元好货疯抢</a></li>
	                <li><a href="#">厨具好货领券满399减90</a></li>
	                <li><a href="#">京东水饮节，5折喝好水</a></li>
		        </ul>
            </div>
            
        </div>

        <div class="content_left">
            <ul class="left_nav">
            	<!-- 动态获取右侧导航栏 -->
            	<c:forEach var="cate"  items="${list}"> 
	                <li><a href="#">${cate.name }</a></li>
                </c:forEach>
            </ul>
        </div>

        <!--<div class="pic_center">
            <img src="../images/1.jpg" width="790px" height="340px">
        </div>-->
        <div id="main">
            <ul id="picture">
                <li><img src="../images/index/1.jpg" width="790px" height="340px"></li>
                <li><img src="../images/index/2.jpg" width="790px" height="340px"></li>
                <li><img src="../images/index/3.jpg" width="790px" height="340px"></li>
                <li><img src="../images/index/4.jpg" width="790px" height="340px"></li>
                <li><img src="../images/index/5.jpg" width="790px" height="340px"></li>
                <li><img src="../images/index/6.jpg" width="790px" height="340px"></li>
                <li><img src="../images/index/7.jpg" width="790px" height="340px"></li>
                <li><img src="../images/index/8.jpg" width="790px" height="340px"></li>
            </ul>
            <div class="pointList" id="pointList">
            
                <i class="pointer" style="background-color:#db192a"></i>
                <i class="pointer"></i>
                <i class="pointer"></i>
                <i class="pointer"></i>
                <i class="pointer"></i>
                <i class="pointer"></i>
                <i class="pointer"></i>
                <i class="pointer"></i>
            </div>
            <div id="arr">
                <span id="left"><</span>
                <span id="right">></span>
            </div>
        </div>

        <img src="../images/index/content_left.jpg" width="390px" height="130px" class="img_left">
        <img src="../images/index/content_right.jpg" width="390px" height="130px" class="img_right">

	

    </div>
	<!-- 遍历一级类 -->
	<c:forEach var="category"  items="${list}">  
       <%-- <c:forEach var="list1"  items="${lists}"> --%>
    <!--模块1-->
    <div class="model" id="model${category.id }">
        <div class="pro_nav">
            <span class="des_title">
            ${category.name}</span>
            <!-- <span>这是吃货的世界</span> -->
        </div>

        <!--重复代码-->
        <div class="pros_content">
            <ul id="myUL">
            <!-- 从一级类中和获取二级类集合 -->
	        <c:forEach items="${category.towPCategory}" var="categorys">
	                <!--以下内容可以通过数据库获取数据-->
	                <!-- 将二级类的集合遍历出来 -->
		                <li>
		                    <a href="/Store/ProductServlet?pro_id=${categorys.id}">
		                        <div class="pro_des">
		                        	<!-- 用于将id传出去 -->
		                        	<%-- ${categorys.id} --%>
		                        	<input name="pro_id" hidden="hidden" value="${categorys.id}">
		                            <span>${categorys.name }</span><br>
		                            <!-- <span class="des_word">海鲜海鲜,我的最爱</span> -->
		                            <!-- 获取二级类下面商品的第一个 -->
		                            <c:forEach  items="${categorys.product }" end="0" var="p" >
		                            <div id="pro_imgs">
		                            	<img src="../${p.image}" width="130px" height="167px"> 
		                           	</div>
		                            </c:forEach>
		                        </div>
		                    </a>
		                </li>
	        </c:forEach>
            </ul>
        </div>
        
    </div>
          </c:forEach>
    
   <%-- </c:forEach>  --%>
    <%-- <%
    	}
     %> --%>
    <!--电脑数码模块2-->
    <!-- <div class="model" id="model2">
        <div class="pro_nav">
            <span class="des_title">电脑数码</span>
            <span>宅男的天堂</span>
        </div>
        <div class="pros_content">
            <ul>
                以下内容可以通过数据库获取数据
                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span>海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span>海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span>海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span>海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span>海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span class="des_title">海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    服饰模块3
    <div class="model" id="model3">
        <div class="pro_nav">
            <span class="des_title">服饰</span>
            <span>妹纸的衣柜</span>
        </div>
        <div class="pros_content">
            重复代码
            <ul>
                以下内容可以通过数据库获取数据
                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span>海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span>海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span>海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span>海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span>海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pro_des">
                            <span class="des_title">海鲜水产</span><br>
                            <span class="des_word">海鲜海鲜,我的最爱</span>
                            <img src="../images/index/eat1.jpg" width="130px">
                        </div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    家电模块4
    <div class="model" id="model4">
        <div class="pro_nav">
            <span class="des_title">家电</span>
            <span>家庭主妇的好帮手</span>
        </div>
    </div>
    母婴家居模块5
    <div class="model" id="model5">
        <div class="pro_nav">
            <span class="des_title">母婴家居</span>
            <span>这是吃货的世界</span>
        </div>
    </div> -->
    <!--图片汽车模块6-->
    <!-- <div class="model" id="model6">
        <div class="pro_nav">
            <span class="des_title">图片汽车</span>
            <span>男人的车库</span>
        </div>
    </div> -->
    <!--左边悬浮导航栏-->
    <div class="left_list">
        <ul>
            <li><a href="#model1">海鲜水产</a></li>
            <li><a href="#model2">电脑数码</a></li>
            <li><a href="#model3">服饰</a></li>
            <li><a href="#model4">家电</a></li>
            <li><a href="#model5">母婴家居</a></li>
            <li><a href="#model6">图片汽车</a></li>
            <li><a href="#top">顶部</a></li>
        </ul>
    </div>
    <!--<div class="footer">

    </div>-->
    <%@include file="bottom.html"%>
</body>
</html>