<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en" class="root61">
<head>
    <meta charset="UTF-8">
    <title>评论</title>
    <script src="../js/jquery-3.1.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/CmtCss.css">
    <script src="../js/CmtJS.js"></script>
</head>
<body>
<%@include file="top.jsp" %>
    <div id="nav">
		<div class="w">
			<div class="logo">
				<a href="/Store/CategoryServlet" target="_blank" class="fore1"></a>
				<a href="" target="_self" class="fore2">我的京东</a> <a
					href="/Store/CategoryServlet" target="_blank" class="fore3">返回京东首页</a>
			</div>
			<div class="navitems">
				<ul>
					<li class="fore-1"><a target="_self"
						href="/Store/CategoryServlet">首页</a></li>
					<li class="fore-3">
						<div class="dl">
							<div class="dt">
								<a>账户设置</a>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="nav-r">
				<div id="search-2014">
					<div class="form">
					<form action="/Store/search" method="post">
						<input type="text" class="text" name="input_text">
						<button class="button cw-icon" type="submit">
							<i></i>搜索
						</button>
						</form>
					</div>
				</div>
				<div id="settleup-2014" class="dorpdown">
					<div class="cw-icon">
						<i class="ci-left"></i> <i class="ci-right">&gt;</i><i
							class="ci-count" id="shopping-amount">${shoppingCarInfo.get("num") }</i> <a target="_blank"
							href="/Store/control/shopCar">我的购物车</a>
					</div>
					<div class="dorpdown-layer">
						<div class="spacer"></div>
						<c:if test="${shoppingCar==null || shoppingCar.order_items.size()==0}">
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
															src="..${productlist.product.image }" width="50" height="50"
															alt="">
														</a>
													</div>
													<div class="p-name fl">
														<span></span> <a
															href="/Store/DetailProductServlet?p_id=${productlist.product.id }"
															target="_blank">${productlist.product.name }</a>
													</div>
													<div class="p-detail fr ar">
														<span class="p-price"> <strong>￥${productlist.product.price}</strong>×
															<fmt:formatNumber
																value="${productlist.subtotal/productlist.product.price }"
																pattern="#" />
														</span><br>
													</div>
												</li>
											</ul>
										</div>
									</c:if>
								</c:forEach>
								<div class="smb ar">
									<div class="p-total">
										共<b>${shoppingCarInfo.get("num") }</b>件商品 共计<strong>￥
											${shoppingCarInfo.get("price") }</strong>
									</div>
									<a href="/Store/control/shopCar" title="去购物车"
										id="btn-payforgoods">去购物车</a>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
			<div class="clr"></div>
		</div>
	</div>
    <div id="container">
        <div class="w">
            <div class="mycomment-detail">
                <div class="detail-hd" id="o-info-orderinfo">
                    <div class="orderinfo" id="${commentOrder.id }">
                        <h3 class="o-title">评价订单</h3>
                        <div class="o-info">
                            <span class="mr20">订单号：<a href="" target="_blank" class="gray1">${commentOrder.name}</a></span>
                            <span>${commentOrder.order_time}</span>
                        </div>
                    </div>

                </div>
                <div class="mycomment-form">
                    <div class="form-part1">
                    <c:forEach items="${commentOrder.order_items}" var="order_item">
                        <div class="f-item f-goods product-10424165140">
							
								<div class="fi-info">
									<div class="comment-goods">
										<div class="p-img">
											<a href="" target="_blank"><img
												src="../${order_item.product.image }"></a>
										</div>
										<div class="p-name">
											<a href="" target="_blank">${order_item.product.name}</a>
										</div>
										<div class="p-price">
											<strong>${order_item.product.price}</strong>
										</div>
										<div class="p-attr"></div>
									</div>
								</div>
								<div class="fi-operate">
									<div class="fop-item ">
										<div class="fop-label">评价晒单</div>
										<div class="fop-main">
											<div class="f-textarea">
												<textarea name="textarea" id="${order_item.product.id}"  placeholder="商品是否给力？快分享你的购买心得吧~"></textarea>
												<div class="textarea-ext">
													<em class="textarea-num"><b>0</b> / 500</em><span
														class="tips">（评价多于<span class="ftc1">10</span>个字,有机会奖励京豆哦~）
													</span>
												</div>
											</div>
										</div>
										<div class="fop-tip">
											<i class="tip-icon"></i><em class="tip-text"></em>
										</div>
									</div>

								</div>
								</div>
							</c:forEach>

                    </div>
                    <div class="f-btnbox">
                        <a href="" class="btn-submit">提交</a>
					<span class="f-checkbox">
					<input id="check1" class="i-check" type="checkbox" checked="checked">
					<label for="check1">匿名评价</label>
					</span>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>
</html>