<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link rel = "stylesheet" type = "text/css" href = "../css/logincss.css" />
    <script> 
//取出传回来的参数error并与yes比较
/*   */
	
 /*  if(errori=='yes'){
   alert("登录失败!");
  } */
</script>
</head>
<body>
<div class="div1">
    <div class="div2">
        <a href="index.jsp"><img src="../images/login/1.png" alt=""></a>

    </div>
    <div class="div3"><h2>欢迎登陆</h2></div>
</div>
<div>
<div class="larger_map">
    
    <!-- <img src="../images/login/2.png" width="1450px" height="500px"> -->
</div>

    <div class="login">
        <div class="login_log">
            <h3>账户登录</h3>
        </div>
        <div class="login_body">
            <form  method="post" action="/Store/login">
                <div class="login_body_dw">
                <a>用户名:&nbsp;</a><input  style="height: 22px" type="text" name="name">
              
                <br>
                    <br>

                <a>密&nbsp;&nbsp;&nbsp;码:&nbsp;</a><input style="height: 22px" type="password" name="password">
                    
                    <br>
                    <br>
                    <a class="forget_password" href="#">忘记密码</a>
                    <br>
                <input class="login_submit" type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录" />
                </div>
            </form>
        </div>
        <div class="login_reg">
            <a class="reg" href="register.jsp">立即注册</a>
        </div>
    </div>
    
</div>
 <%@include file="bottom.html"%>
</body>
</html>