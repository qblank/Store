<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的购物车</title>
    <link rel="stylesheet" href="../css/shopcar.css">
    <script src="../js/jquery-3.1.0.min.js"></script>
    <script src="../js/index.js"></script>
	<script type="text/javascript" src="../js/shopcar.js"></script>
</head>
<body>
    <!-- <div class="top">
    </div> -->
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

            <div class="item_list" id="item_list">
                 	<c:forEach items="${orders}" var="order">
                 		<c:forEach items="${order.order_items}"  var="item" varStatus="nums">
			                 <div class="pro" id="pro${nums.count}">
			                    <ul>
				                        <li>
				                        	<span>
				                        		<input type="text" name="ckId" value="nums.count" hidden="hidden">
				                        		<input type="checkbox" class="pros" onchange="getSubTotal(${nums.count})" id="pros${nums.count}" name="itemIds" value="${item.id}">
				                        	</span>
				                        </li>
				                        <li>
				                        	<img src="..${item.product.image}" width="80px" class="pro_img">
				                        </li>
				                        <li class="pro_des_des">
				                        	<span>${item.product.name}</span>
				                        </li>
				                        <li>
				                        	<span>
				                        		￥<span id="price${nums.count}">${item.product.price}</span>
				                        	</span>
				                        </li>
				                        <li>
				                        	<span>
				                        		<span onclick="sub(${nums.count})" id="left">
				                        			-&nbsp;
				                        		</span>
				                        			<span id="proNum${nums.count}"><fmt:formatNumber value= "${item.subtotal/item.product.price}"  /></span> 
				                        		<span onclick="add(${nums.count})" id="right">
				                        			&nbsp;+ 
				                        		</span>
				                        	</span>
				                        </li>
				                        <li>
				                        		￥<span class="subtotal" id="subtotal${nums.count}">${item.subtotal}</span>
				                        </li>
				                        <li>
				                        	<input type="text" value="${item.id }" hidden="hidden" id="itemId${nums.count}" name="itemId"/>
				                        </li>
			 	                        <li onclick="removePro(${nums.count})">
			 	                        	<span>
			 	                        		<a href="javascript:void(0)" class="del_pro" id="remove${nums.count}">删除</a>
			 	                        	</span>
			 	                        </li>
			                    </ul>
			                </div>
			              </c:forEach>
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