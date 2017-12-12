
<%@page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@page import="cn.qblank.model.entity.Order_item"%>
<%@page import="cn.qblank.model.entity.Order"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en" class="root61">
<head>
<meta charset="UTF-8">
<title>订单</title>
<script src="../js/jquery-3.1.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/OrderCss.css">
<script src="../js/OrderJS.js"></script>
</head>
<body>
	<%@include file="top.jsp"%>
	<!--<div id="back">-->
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
		<div class="content">
			<div id="main">
				<div class="blank"></div>
				<div class="myorder">
					<div class="otext">
						<h3>我的订单</h3>
					</div>
				</div>
				<div id="orderbox">
					<div class="orderlist">
						<div class="menu">
							<ul class="extra-l">
								<li><a href="/Store/control/orderServlet?status=0" order-status="0" class="<c:if test="${status==0 }">curr</c:if>">全部订单</a></li>
								<li><a href="/Store/control/orderServlet?status=1" order-status="1" class="<c:if test="${status==1 }">curr</c:if>">待付款</a></li>
								<li><a href="/Store/control/orderServlet?status=2" order-status="2" class="<c:if test="${status==2 }">curr</c:if>">待收货</a></li>
								<li><a href="/Store/control/orderServlet?status=3" order-status="3" class="<c:if test="${status==3 }">curr</c:if>">待评价</a></li>
				
							</ul>
						
							
							<div class="extra-r">
								<div class="search">
								<form>
									<input type="text" class="itxt"> 
										<a class="search-btn"><b></b></a>
										</form>
								</div>
							</div>
						</div>
					</div>

					<!-- 订单列表 -->
					<div class="mc" style="line-height: 20px">
						<table class="table">
							<!-- 菜单 -->
							<thead>
								<tr class="thlist">
									<th class="ordervalue">订单详情</th>
									<th style="width:123px">收货人</th>
									<th style="width:118px">金额</th>
									<th style="width:118px">状态</th>
									<th style="width:135px">操作</th>
								</tr>
							</thead>

							<!-- 重复代码块盒子 订单项 -->
							<c:if test="${orders.size()!=0}">
								<c:forEach var="order" items="${orders}" varStatus="tbodynum">
								<c:if test="${tbodynum.count<=4}">
									<tbody id="tbody${tbodynum.count}" style="display: block" tbodystatus="${order.order_status }"  class="tbody">
								</c:if>
								<c:if test="${tbodynum.count>4}">
									<tbody id="tbody${tbodynum.count}" style="display: none" tbodystatus="${order.order_status } "  class="tbody" >
								</c:if>
										<!-- 占位的空白 -->
										<tr class="sep-row">
											<td colspan="5"></td>
										</tr>
										<!-- 订单号以及时间 -->
										<tr class="tr-th">
											<td colspan="5"><span class="gap"></span> <span
												class="dealtime" title="${order.order_time} ">${order.order_time}</span>
												<span class="number"> 订单号： <a id="${order.name}"
													target="_blank" href="">${order.name}</a>
											</span></td>
										</tr>


										<!-- 订单项的值  可重复的代码块-->
										<c:forEach var="order_item" items="${order.order_items}"
											varStatus="num">
											<tr class="tr-bd" id="order-item${order_item.id}">
												<!-- 商品的名字，图片，数量，有几件商品就有几个单元格 -->
												<td class="firsttd">
													<div class="goods-item">
														<div class="p-img">
															<a href="" target="_blank"> <img class=""
																src="../${order_item.product.image}"
																title="${order_item.product.name }" 
																width="60" height="60">
															</a>
														</div>
														<div class="p-msg">
															<div class="p-name">
																<a href="/Store/DetailProductServlet?p_id=${order_item.product.id }" class="a-link" target="_blank"
																	title="${order_item.product.name }">${order_item.product.name }</a>
															</div>
														</div>
													</div>
													<div class="goods-number">
														x
														<fmt:formatNumber
															value="${order_item.subtotal/order_item.product.price }"
															pattern="#" />

													</div>
												</td>
												<!-- 用户信息，一个订单只有一个，修改rowspan -->
												<c:if test="${num.count <= 1 }">
													<td rowspan="${order.order_items.size() }" class="secondtd">
														<div class="consignee tooltip">
															<span class="txt">${order.user_name} </span><b></b>
														</div>
													</td>
													<!-- 订单总金额，一个订单只有一个，修改rowspan -->
													<td rowspan="${order.order_items.size() }" class="thirdtd">
														<div class="amount" id="amount${order.id }">
															<span>总额 ¥${order.order_price }</span> 
															<c:if test="${order.order_status>1 }">
																<br> <span class="ftx-13">在线支付</span>
															</c:if>
														</div>
													</td>
													<!-- 订单的状态，一个订单只有一个，修改显示的值 -->
													<td rowspan="${order.order_items.size() }" class="thirdtd">
														<div class="status${order.id }">
															<c:choose>
																<c:when test="${order.order_status==1}">
																	<span>未付款</span>
																	<br>
																</c:when>
																<c:when test="${order.order_status==2}">
																	<span>已付款</span>
																	<br>
																</c:when>
																<c:when test="${order.order_status==3}">
																	<span>已付款</span>
																	<br>
																	<span>已收货</span>
																	<br>
																</c:when>
																<c:when test="${order.order_status==4}">
																	<span>已付款</span>
																	<br>
																	<span>已收货</span>
																	<br>
																	<span>已评价</span>
																	<br>
																</c:when>
															</c:choose>
														</div>
													</td>
													<!-- 订单操作栏，一个订单只有一个，修改rowspan的值 -->
													<td rowspan="${order.order_items.size() }"
														 class="forthtd">
														<div class="operate${order.id}">
															<c:choose>
																<c:when test="${order.order_status==1}">
																	<a href="javascript:void(0)"  a-order-id="${order.id }" class="btn-again"><b></b>
																		立即付款 </a>
																		<a style="display:none" href="javascript:void(0)"  class="btn-5" a-order-id="${order.id }">确认收货</a>
																		<a style="display:none" href="/Store/control/commentServlet?order_id=${order.id }&activity=0" class="btn-comment" >&nbsp;&nbsp;&nbsp;&nbsp;马上评价&nbsp;&nbsp;&nbsp;&nbsp;</a>
																		<a style="display:none" href="javascript:void(0)" a-order-id="${order.id }" class="btn-delete" tbody_num="${ tbodynum.count}">&nbsp;&nbsp;&nbsp;&nbsp;删除订单&nbsp;&nbsp;&nbsp;&nbsp;</a>
																	<br>
																</c:when>
																<c:when test="${order.order_status==2}">
																	<a href="javascript:void(0)"  class="btn-5" a-order-id="${order.id }">确认收货</a>
																	<a style="display:none" href="/Store/control/commentServlet?order_id=${order.id }&activity=0" class="btn-comment">&nbsp;&nbsp;&nbsp;&nbsp;马上评价&nbsp;&nbsp;&nbsp;&nbsp;</a>
																	<a style="display:none" href="javascript:void(0)" a-order-id="${order.id }" class="btn-delete" tbody_num="${ tbodynum.count}">&nbsp;&nbsp;&nbsp;&nbsp;删除订单&nbsp;&nbsp;&nbsp;&nbsp;</a>
																	<br>
																</c:when>
																<c:when test="${order.order_status==3}">
																	<a href="/Store/control/commentServlet?order_id=${order.id }&activity=0" class="btn-comment">&nbsp;&nbsp;&nbsp;&nbsp;马上评价&nbsp;&nbsp;&nbsp;&nbsp;</a>
																	<a style="display:none"  href="javascript:void(0)" a-order-id="${order.id }" class="btn-delete" tbody_num="${ tbodynum.count}">&nbsp;&nbsp;&nbsp;&nbsp;删除订单&nbsp;&nbsp;&nbsp;&nbsp;</a>
																	<br>
																</c:when>
																<c:when test="${order.order_status==4}">
																	<a href="javascript:void(0)" a-order-id="${order.id }" class="btn-delete" tbody_num="${ tbodynum.count}">&nbsp;&nbsp;&nbsp;&nbsp;删除订单&nbsp;&nbsp;&nbsp;&nbsp;</a>
																	<br>
																</c:when>
															</c:choose>
														</div>
													</td>
												</c:if>
											</tr>
										</c:forEach>
									</tbody>

								</c:forEach>
							</c:if>




						</table>
						<!-- 没有订单的时候不显示分页 -->
						<c:if test="${orders.size()!=0}">
							<div class="mt20">
								<div class="pagin fr">
									<!--  <span class="text">共6条记录</span>    <span class="text">共1页</span> -->
									<span class="prev-disabled">上一页<b></b></span>

									<!-- <span class="prev-disabled">首页</span> -->
									<a class="current">1</a>
									<!-- <span class="next-disabled">末页</span>  -->
									<span class="next-disabled" >下一页<b></b></span>
								</div>
								<div class="clr"></div>
							</div>
							<div class="empty-box" style="display:none">
								<i class="empty-icon"></i>
								<div class="e-cont">
									<h5>最近没有下过订单哦~</h5>
									<div class="op-btns">
										<a href="/Store/CategoryServlet" class="btn-1" target="_blanck">去首页看看</a>
									</div>
								</div>
							</div>
						</c:if>
						<c:if test="${orders.size()==0}">
							<div class="empty-box">
								<i class="empty-icon"></i>
								<div class="e-cont">
									<h5>最近没有下过订单哦~</h5>
									<div class="op-btns">
										<a href="/Store/CategoryServlet" class="btn-1" target="_blanck">去首页看看</a>
									</div>
								</div>
							</div>
						</c:if>

					</div>
				</div>
			</div>
		</div>
		<div class="ui-slidebar">
			<div class="dl">
				<div class="dt">
					<a href="" class="jd-im"></a>
				</div>
				<div class="dd">
					<ul>
						<li><a href="#top" class="backtop" style="display: block;">回
								到顶 部</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>