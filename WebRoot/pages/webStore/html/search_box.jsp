<%@page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>搜索模块</title>
<link rel="stylesheet" type="text/css" href="../css/search_css.css">
</head>
<body>
	<div id="search">
		<div class="logo">
			<img src="../images/search/logo.png" width="300px" height="80px">
		</div>
		<form action="/Store/search" method="post">
			<div class="search_box">
				<input type="text" name="input_text">
				<!--搜索-->
				<input class="character" type="submit" value="搜索">

			</div>
		</form>

		<div id="settleup-2014" class="dorpdown">
			<div class="cw-icon">
				<i class="ci-left"></i> <i class="ci-right">&gt;</i><i
					class="ci-count" id="shopping-amount">${shoppingCarInfo.get("num") }</i> <a target="_blank"
					href="/Store/control/shopCar">我的购物车</a>
			</div>
			<div class="dorpdown-layer">
				<div class="spacer"></div>
				<c:if
					test="${shoppingCar==null || shoppingCar.order_items.size()==0}">
					<div class="prompt">
						<div class="nogoods">
							<b></b>购物车中还没有商品，赶紧选购吧！
						</div>
					</div>
				</c:if>
				<c:if test="${shoppingCar.order_items.size()>0}">
					<div id="settleup-content">
						<div class="smt">
							<h4 class="fl">最新加入的商品</h4>
						</div>

						<!-- 可重复模块，购物车预览 -->
						<c:forEach var="productlist" items="${shoppingCar.order_items}"
							varStatus="num">
							<!-- 遍历列表项 -->
							<c:if test="${num.count<5}">
								<div class="smc">
									<ul id="mcart-sigle"></ul>
									<ul id="mcart-gift"></ul>
									<ul id="mcart-mz">
										<li>
											<div class="p-img fl">
												<a href="" target="_blank"> <img
													src="..${productlist.product.image }"
													width="50" height="50" alt="">
												</a>
											</div>
											<div class="p-name fl">
												<span></span> <a href="/Store/DetailProductServlet?p_id=${productlist.product.id }" target="_blank">${productlist.product.name }</a>
											</div>
											<div class="p-detail fr ar">
												<span class="p-price"> <strong>￥${productlist.product.price}</strong>× <fmt:formatNumber
														value="${productlist.subtotal/productlist.product.price }"
														pattern="#" />
											</div>
										</li>
									</ul>
								</div>
								</c:if>
								</c:forEach>
								<div class="smb ar">
									<div class="p-total">
										共<b>${shoppingCarInfo.get("num") }</b>件商品 共计<strong>￥ ${shoppingCarInfo.get("price") }</strong>
									</div>
									<a href="/Store/control/shopCar" title="去购物车" id="btn-payforgoods">去购物车</a>
								</div>
					</div>
					</c:if>
			</div>
		</div>
		<!--购物车-->

		<!-- <div class="shopping">
        <img class="pig" src="../images/search/3.png" >
        <p class="my">购物车</p>
        <div id="shop_car" class="shop_car"></div>
    </div>  -->




		<!-- 
     <a href="/Store//control/shopCar">
	    <div class="shopping">
	        <img class="pig" src="../images/search/3.png" >
	        <p class="my">购物车</p>
	        <div id="shop_car" class="shop_car"></div>
	    </div>
    </a>
    
    -->


	</div>




</body>
</html>