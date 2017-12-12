<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <link rel = "stylesheet" type = "text/css" href = "../css/logincss.css" />
    <script src="../js/jquery-3.1.0.min.js"></script>
    
</head>
<!--页首-->
<body>
<div class="div1">
    <div class="div2">
        <a href="index.jsp"><img src="../images/login/1.png" alt=""></a>

    </div>
    <div class="div3"><h2>欢迎注册</h2></div>
    <div class="reg_login">
        <a>已有账号？</a><a href="login.jsp">请登录</a>
    </div>
    <hr>
</div>
<!--中间注册部分-->
<div class="reg_middle">
    <form action="/Store/register" method="post">
        <div class="input_box">
            <a>用户姓名:</a>&nbsp;
            <input id="input_name" type="text" name="username" placeholder="用户名或账号" >
            <img class="pig_name" id="aaa" src="../images/login/4.png" >
        </div>
        <div class="input_box">
            <a>设置密码:</a>&nbsp;
            <input id="input_password" type="password" name="password" placeholder="密码">
             <img class="pig_password" src="../images/login/4.png" >
        </div>
        <div class="input_box">
            <a>确认密码:</a>&nbsp;
            <input id="input_passwords" type="password" name="passwords" placeholder="再次输入密码">
             <img class="pig_passwords" src="../images/login/4.png" >
        </div>
        <div class="input_box">
            <a>性&nbsp;&nbsp;别:</a>&nbsp;
           <!-- <input type="text" name="gender">-->
            <input class="input_radio" type="radio" name="man" value="男"><a>男</a>
            <input class="input_radio" type="radio" name="man" value="女" ><a>女</a>
             <img class="pig_radio" src="../images/login/4.png" >
        </div>
        <div class="input_box">
            <a>年&nbsp;&nbsp;龄:</a>&nbsp;
            <input id="input_age" type="number" min="0" max="100" style="text-decoration: none; outline: none;" name="age" placeholder="年龄">
        	 <img class="pig_age" src="../images/login/4.png" >
        </div>
        <div class="input_box">
            <a>手机号码:</a>&nbsp;
            <input id="input_tel" type="tel" name="phone" placeholder="手机号码">
             <img class="pig_tel" src="../images/login/4.png" >
        </div>
        <div class="input_box">
            <a>地&nbsp;&nbsp;址:</a>&nbsp;
            <input id="input_add" type="text" name="add" placeholder="默认收货地址">
             <img class="pig_add" src="../images/login/4.png" >
        </div>
        <div class="input_box2">
            <input class="input_check" type="checkbox" name="agreen" value="T">
            <a class="input_box_a">阅读并同意</a>
            <a class="input_box_a" href="javascript:;" >《京东用户注册协议》</a>
            <a class="input_box_a" href="javascript:;">《隐私政策》</a>
        </div>

        <div class="input_box3">
            <input class="input_submit" type="submit" value="确认注册">
        </div>
    </form>
    
    <script>
        /*名字*/
        $("#input_name").focus(function(){
            $("#input_name").attr("placeholder"," ");
        });
        $("#input_name").blur(function () {
            if($("#input_name").val().length==0){
            	$("#input_password").val("");
                $("#input_name").attr("placeholder","请输入用户名！");
                $(".pig_password").css("display","none");
            }
            if($("#input_name").val().length!=0){
                //获取value值
              /*  alert($("#input_name").val());*/
                    $(".pig_name").css("display","inherit");
                }
        });


        /*密码*/
        $("#input_password").focus(function () {
            $("#input_password").attr("placeholder"," ");
        });
        $("#input_password").blur(function () {
          /*alert($("#input_password").val());*/
          var pass = $("#input_password").val().length;
          
            if(pass<6){
            
            	$("#input_password").val("");
                $("#input_password").attr("placeholder","密码长度不够！");
                $(".pig_password").css("display","none");
            }else{
                
                $(".pig_password").css("display","inherit");
            }
        });


        /*第二次确定密码*/
        $("#input_passwords").focus(function () {
            $("#input_passwords").attr("placeholder"," ");
        });
        $("#input_passwords").blur(function () {

            if($("#input_passwords").val()!=$("#input_password").val()){
                $("#input_passwords").val("");
                $("#input_passwords").attr("placeholder","与第一次输入密码不一致！");
                $(".pig_passwords").css("display","none");
            }
            if($("#input_password").val().length==0){
            	$("#input_passwords").val("");
                $("#input_passwords").attr("placeholder","请输入密码！");
                $(".pig_passwords").css("display","none");
            }
            if($("#input_passwords").val()==$("#input_password").val()){
                $(".pig_passwords").css("display","inherit");
            }
        });

        /*性别*/
       $(".input_radio").click(function(){
           $(".pig_radio").css("display","inherit");
       });

       /*年龄input_age*/
        $("#input_age").focus(function () {
            $("#input_age").attr("placeholder"," ");
        });
        $("#input_age").blur(function () {
			var age = $("#input_age").val().length;
			
			
            
            if(1<age<3){
                $(".pig_age").css("display","inherit");
            }else{
                $("#input_tel").val("");
                $("#input_age").attr("placeholder","请输入（1-100）内的年龄");
                $(".pig_age").css("display","none");
            }

        });

//        /*电话*/
        $("#input_tel").focus(function(){
            $("#input_tel").attr("placeholder"," ");
        });
        $("#input_tel").blur(function(){
            /*alert($("#input_tel").val().length);*/
            var a =$("#input_tel").val().length;
            
            if(a==11){

                $(".pig_tel").css("display","inherit");
            }
            if(a!=11){

                $("#input_tel").val("");
                $("#input_tel").attr("placeholder","请输入正确的手机号码");
                $(".pig_tel").css("display","none");
            }

        });
        
        /*地址  */
        $("#input_add").focus(function(){
        	$("#input_add").attr("placeholder"," ");
        });
         $("#input_add").blur(function(){
           
            var a =$("#input_tel").val().length;
            
            if(a==""){
                $("#input_add").attr("placeholder","地址不能为空");
            }
            else{
            
                $(".pig_add").css("display","inherit");
            }
        });

    </script>

</div>
 <%@include file="bottom.html"%>


</body>
</html>