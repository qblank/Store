	
	
    /**
     * 添加数量同时添加金钱
     */
    function add(data){
    	var numSpanAdd = document.getElementById("proNum" + data);
    	//获取单价
    	var priceSpan = document.getElementById("price" + data);
    	var subTotal = document.getElementById("subtotal" + data);
    	var price = parseFloat(priceSpan.innerHTML);
    	var num = parseInt(numSpanAdd.innerHTML);
    	num++;
    	numSpanAdd.innerHTML = num;
    	if (num > 100) {
    		num = 100;
    		numSpanAdd.innerHTML = 100;
    		subTotal.innerHTML = (num*Math.floor(price*100)/100).toFixed(2);
		}
    	//如果按钮此时是被选中的状态
    	if (isChecked(data)) {
    		getSubTotal(data);
		}
    	subTotal.innerHTML = (num*Math.floor(price*100)/100).toFixed(2);
    }
    
    /**
     * 减少数量同时减少金钱
     */
    function sub(i){
    	//获取子复选框
    	var numSpanSub = document.getElementById("proNum" + i);
    	//获取单价
    	var priceSpan = document.getElementById("price" + i);
    	var subTotal = document.getElementById("subtotal" + i);
    	var price = parseFloat(priceSpan.innerHTML);
    	var num = parseInt(numSpanSub.innerHTML);
    	num--;
    	numSpanSub.innerHTML = num;
    	if (num < 1) {
    		num = 1;
    		numSpanSub.innerHTML = 1;
    		subTotal.innerHTML = price;
		}
    	
    	//如果按钮此时是被选中的状态
    	if (isChecked(i)) {
    		getSubTotal(i);
		}
    	subTotal.innerHTML = (num*Math.floor(price*100)/100).toFixed(2);
    }
    
    /**
     * 判断复选框是否被选中
     * @param data
     * @returns {Boolean}
     */
    function isChecked(data){
    	var inpArr = document.getElementById("pros" + data);
    	if (inpArr.checked) {
			return true;
		}
    	return false;
    }

    /**
     * 获取总计
     */
    function getTotalMoney(){
    	var allButton = document.getElementById("checkedAll");
    	//获取小计
    	var subList = document.getElementsByClassName("subtotal");
    	var total = document.getElementById("total");
    	var sum = 0;
    	if (allButton.checked) {
    		for(var i = 0; i< subList.length ;i++){
        		sum +=  parseFloat(subList[i].innerHTML);
        	}
        	total.innerHTML = sum;
		}
    	return sum;
    }
    
    /**
     * 获取选中的总价
     */
    var sum = 0.0;
    function getSubTotal(i){
    	
    	//先获取到小计的值
    	var subtotal = document.getElementById("subtotal" + i);
    	var sub = parseFloat(subtotal.innerHTML);
    	//获取总计
    	var total = document.getElementById("total");
    	
    	if (isChecked(i)) {
    		sum = (Math.floor(sum*100 + sub*100)/100).toFixed(2);
		}else{
			sum = (Math.floor(sum*100 - sub*100)/100).toFixed(2);
		}
    	total.innerHTML = sum;
    	
    	return sum;
    }
    /**
     * 全选
     */
    function selAll(){
//    	var total = document.getElementById("total");
    	/*获取全选按钮*/
        var allButton = document.getElementById("checkedAll");
            /*获取其他子复选按钮*/
        var inpArr = document.getElementsByClassName("pros");
        //全选
        for(var i = 0;i<inpArr.length;i++){
            inpArr[i].checked = allButton.checked;
        }
        //其他的全部选中则全选为选中
        for(var i = 0;i<inpArr.length;i++){
            inpArr[i].onclick = function(){
                var bool = true;
                //一个为false,则全选框为false
                for(var j = 0;j<inpArr.length;j++){
                    if (inpArr[j].checked == false){
                        bool = false;
                    }
                }
                allButton.checked = bool;
            };
        }
        if (allButton.checked) {
        	//获取总计
            getTotalMoney();
		}else{
			//获取当前选中的按钮，并获取其金额
			total.innerHTML = 0.0;
//			var selArr = document.getElementsByName("ckId");
			//获取被选中的复选框的小计
			/*for(var k = 0 ; k< selArr.length;k++){
				if (selArr[i].checked) {
					alert(i);
				}
			}*/
//			alert(selArr.value);
		}
    }
    

/**
 * 使用ajax删除商品
 */
function removePro(data){
	$(function() {
		//获取数量和商品id
		var price = $("#price" + data);
		var pNumSpan = $("#proNum" + data);
		var itemIdSpan =  $("#itemId" + data);
		
		var numSpanSub = document.getElementById("pros" + data);
		//将复选框的状态设置为false
		alert(numSpanSub.checked);
		numSpanSub.checked = false;
		getSubTotal(data);
		
		//获取订单项的id
		var itemId = itemIdSpan.val();
		var pNum = pNumSpan.html(); 
		
		
//		alert(oid);
//		console.log(price.html() + ":" + pNumSpan.html()+":" + itemId);
		$.get(
				"/Store/control/ShopCarDelete",
				{
					'itemId':itemId,
					'pNum':pNum
				},function(){
					$("#pro" + data).remove();
				}
		);
	});
}

/**
 * 通过id获取总价
 */
function postTotal(){
		
		var total = document.getElementById("total");
		
		var totalSpan = document.getElementById("orderTotal");
		
		totalSpan.value = total.innerHTML;
}

/**
 * 分页查询  通过点击获取当前值的id
 */
/*function getpage(page){
	$(function(){
		$("");
		
	});
}*/







