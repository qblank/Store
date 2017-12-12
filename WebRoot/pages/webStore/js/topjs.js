/**
 * Created by Administrator on 2017/8/4.
 */
/**
 * 显示余额
 */
function showMoney(){
	var user_money = document.getElementById("user_money");
	user_money.style.display = "block";
	user_money.style.backgroundColor="white";
}
/*
 * 隐藏余额
 */
function hideMoney(){
	var user_money = document.getElementById("user_money");
	user_money.style.display = "none";
}

/**
 * 充值
 */
function reCharge(){
	var pay = document.getElementById("pay");
	pay.style.display = "block";
}

function hideReCharge(){
	var pay = document.getElementById("pay");
	pay.style.display = "none";
}


