<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
	<link rel="stylesheet" href="../css/shopcar.css">
    <script src="../js/jquery-3.1.0.min.js"></script>
    <script src="../js/index.js"></script>
	<script type="text/javascript" src="../js/shopcar.js"></script>

  </head>
  
  <body>
    <%@include file="top.jsp" %>

    <div class="content_car">
        <!--表单提交数据-->
        <form action="/Store/control/PostServlet">
        <input type="text" hidden="hidden" name="order_total" value="" id="orderTotal" />
        <!-- <input type="button"  name="order_total" value="12312313" onclick="postTotal()" /> -->
            <div class="header">
                <span class="all_pro">全部商品</span>
            </div>

            <div class="pro_des">
                <ul>
                    <li><span><input type="checkbox" id="checkedAll" onchange="selAll()">&nbsp;全选</span></li>
                    <li><span class="pro_des">商品</span></li>
                    <li><span>单价</span></li>
                    <li><span>数量</span></li>
                    <li><span>小计</span></li>
                    <li><span>操作</span></li>
                </ul>
            </div>

            <div class="item_list">
                 	<c:forEach items="${shoppingCar.order_items}" var="order_item" varStatus="nums">
			                 <div class="pro" id="pro${nums.count}">
			                    <ul>
				                        <li>
				                        	<span>
				                        		<input type="checkbox" class="pros" onchange="getSubTotal(${nums.count})" id="pros${nums.count}" name="order_id" value="${order.id}">
				                        	</span>
				                        </li>
				                        <li>
				                        	<img src="..${order_item.product.image}" width="80px" class="pro_img">
				                        </li>
				                        <li class="pro_des_des">
				                        	<span>${order_item.product.name}</span>
				                        </li>
				                        <li>
				                        	<span>
				                        		￥<span id="price${nums.count}">${order_item.product.price}</span>
				                        	</span>
				                        </li>
				                        <li>
				                        	<span>
				                        		<span onclick="sub(${nums.count})" id="left">
				                        			-&nbsp;
				                        		</span>
				                        			<span id="proNum${nums.count}"><fmt:formatNumber value= "${order_item.subtotal/order_item.product.price}"  /></span> 
				                        		<span onclick="add(${nums.count})" id="right">
				                        			&nbsp;+ 
				                        		</span>
				                        	</span>
				                        </li>
				                        <li>
				                        		￥<span class="subtotal" id="subtotal${nums.count}">${order_item.subtotal}</span>
				                        </li>
				                        <li>
				                        	<input type="text" value="${order_item.id }" hidden="hidden" id="itemId${nums.count}"/>
				                        </li>
			 	                        <li onclick="removePro(${nums.count})">
			 	                        	<span>
			 	                        		<a href="javascript:void(0)" class="del_pro" id="remove${nums.count}">删除</a>
			 	                        	</span>
			 	                        </li>
			                    </ul>
			                </div>
	                </c:forEach>
                <div class="page" id="page">
                    <ul>
                        <!-- <li class="pg">上一页</li> -->
                        <%
                        	int pages = (Integer)session.getAttribute("page");
                        	for(int i = 1;i <= pages ;i++){
                         %>
	                        <li><a href="/Store/control/shopCar?page=<%=i %>"><%=i%></a></li>
                        <%
                        	}
                         %>
                        <!-- <li class="pg">下一页</li> -->
                    </ul>
                </div>

                
                <div class="post_form">
                    <ul>
                        <li class="post_it"><input type="submit" value="去结算" class="btn_form" onclick="postTotal()"></li>
                        <li class="price">总价 <span class="total" >￥<span id="total">0.0</span></span></li>
                        
                        <!-- <li><a href="#" class="pro_del">删除选中的商品</a></li> -->
                    </ul>
                    
                </div>
            </div>
        </form>
    </div>
    
    <%@include file="bottom.html" %>
  </body>
</html>
