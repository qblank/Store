<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>top</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type = "text/javascript"  src = "../js/topjs.js"></script>
    <link rel = "stylesheet" type = "text/css" href = "../css/topcss.css" />
    <script src="../js/jquery-3.1.0.min.js"></script>
</head>
<body>
<div id="top">
	<div class="user_money" id="user_money">
		<img alt="" src="../images/top/user_pic.jpg" width="80" class="user_pic">
		<br/>
		&nbsp;<%=session.getAttribute("username") %><br/><br/>
		&nbsp;余额:<span>￥<%=session.getAttribute("userMoney")%></span>
	</div>	
    <ul>
        <li>
            <div class="login">
                <a href="login.jsp">
                	<c:choose>
                		<c:when test="${empty sessionScope.username}">登陆</c:when>
                		<c:otherwise><%=session.getAttribute("username") %></c:otherwise>
                	</c:choose>
                	
                </a>&nbsp;&nbsp;<a href="register.jsp">注册</a>
            </div>
        </li>
        
        <li>
            <div>
            	
                <a href="/Store/control/withdraw">
                	<c:choose>
                		<c:when test="${empty sessionScope.username}"></c:when>
                		<c:otherwise>注销</c:otherwise>
                	</c:choose>
                </a>
            </div>
        </li>
        
        <li>
            <div id="reCharge" onmousemove="reCharge()" onmouseout="hideReCharge()">
                <a href="#">账户充值</a>
            </div>
        </li>
        <li>
            <div>
                <a href="/Store/control/orderServlet?status=0">我的订单</a>
            </div>
        </li>
        <li>
            <div id="user" onmouseover="showMoney()" onmouseout="hideMoney()">
                <a href="#">我的京东</a>
            </div>
        </li>
        <li>
            <div>
                <a href="/Store/CategoryServlet">京东首页</a>
            </div>
        </li>

       
        <li>
            <div>
                <a href="#">客户服务</a>
            </div>
        </li>
        <li>
            <div>
                <a href="#">网站导航</a>
            </div>
        </li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
  <!--  <div class="pay">
        <div>
            <p>充值金额：</p><input type="text">
        </div>
    </div>-->
    <div class="pay" onmouseover="reCharge()" onmouseout="hideReCharge()" id="pay" >
    <form class="pay_weizi" action="/Store/control/RechargeServlet">
        <table>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>充值金额:</td>
            </tr>

            <tr>
                <td><input class="input" type="number" name="recharge"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td><input class="pay_submit" type="submit" value="确认充值"></td>
            </tr>
        </table>
    </form>
</div>
</div>
<%-- <div class="pay" onmouseover="reCharge()" onmouseout="hideReCharge()" id="pay" >
    <form class="pay_weizi" action="/Store/control/RechargeServlet">
        <table>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>充值金额:</td>
            </tr>

            <tr>
                <td><input class="input" type="number" name="recharge"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td><input class="pay_submit" type="submit" value="确认充值"></td>
            </tr>
        </table>
    </form>
</div> --%>

<%-- <div class="user_money" id="user_money">
	<img alt="" src="../images/top/user_pic.jpg" width="80" class="user_pic">
	<br/>
	&nbsp;<%=session.getAttribute("username") %><br/><br/>
	&nbsp;余额:<span>￥<%=session.getAttribute("userMoney")%></span>
</div> --%>


</body>

</html>