/**
 * Created by Oliver on 2017/8/5.
 */

//var a_order_id = document.register('a-order-id');
//document.body.appendChild(new a_order_id());

$(document).ready(function(){
	
	//返回京东首页特效
//	var thirdLink=$("[class='thirdLink']");
//	thirdLink.hover(function(){
//		thirdLink.attr({"class":"thirdLink thirdLink_hover"});
//	},function(){
//		thirdLink.attr({"class":"thirdLink"});
//	});
	
//	//客服dog动图改变
//	var img=$("[class='jd-im']");
//	img.hover(function(){
//		img.attr({"class":"jd-im jd-im_hover"});
//	}, function(){
//		img.attr({"class":"jd-im"});
//	});
//	
	
////	状态切换特效
//	var extra_l=$(".extra-l li");
//	var a=extra_l.children();
//	extra_l.bind("click",function(){
//		var tbody=$("tbody");
//		var empty_box=$("[class='empty-box']");
////		alert($(this).index());
//		var index=$(this).index();
//		if(index==0){
//			if(tbody.length==0){
//				empty_box.attr({"style":"display:block"});
//			}else{
//				tbody.attr({"style":"display:block"});
//				empty_box.attr({"style":"display:none"});
//			}
//		}else{
//			var num=0;
//			for(var i=0;i<tbody.length;i++){
//				if(tbody.eq(i).attr("tbodystatus")==index){
//					tbody.eq(i).attr({"style":"display:block"});
//					num+=1;
//				}else{
//					tbody.eq(i).attr({"style":"display:none"});
//				}
//			}
//			if(num==0){
//				empty_box.attr({"style":"display:block"});
//			}else{
//				empty_box.attr({"style":"display:none"});
//			}
//		}
//		extra_l.eq(index).children(":first").attr({"class":"curr"});
//		extra_l.eq(index).siblings().children().attr({"class":""});
//
//	});
	
//	var status=$(".extra-1 li:last-child");
//	status.bind("click",function(){
//		alert($(this).index());
//		var index=$(this).index();
//		status.eq(index).attr({"class":"curr"}).siblings().attr({"class":""});
//	});

	
	
	
	//修改搜索首页的超链接传递的值
//	var textbox=$("[class='text']");
////	var btn=$("[class='button cw-icon']");
//	var text;
//	
//	textbox.bind("input propertychange",function(){
//		text=$(this).val();
//		$("[class='search-link']").attr({"href":"/Store/search?input_text="+text});
//	});
//	
	
	//修改订单超链接传递的搜索值
	var search_btn=$("[class='search-btn']");
	var itext=$("[class='itxt']");
//	itext.bind("click",function(){
//		alert("dasdasdasd")
//	});
	itext.bind("input propertychange",function(){
//		var text=encodeURI($("[class='itxt']").val());
		search_btn.attr({"href":"/Store/control/orderServlet?status=4&blur="+$("[class='itxt']").val()});
//		alert($("[class='itxt']").val());
    });
	

	
	
	var order_id;
	var tbody_num;
	//删除订单按钮
	var btn_deletes=$("[class='btn-delete']");
	var btn_delete;
	btn_deletes.bind("click",function(){
		btn_delete=$(this);
		tbody_num=$(this).attr("tbody_num");
		order_id=btn_delete.attr("a-order-id");
		if(confirm("确定删除订单吗？")){
			$.post("/Store/control/orderServlet",{
				'status':"delete",
				'order_id':order_id
			},function(){
//				alert(order_id);
				$("#tbody"+tbody_num).remove();
			},"html");
		}
	});
	
	
	
	//收货按钮
	var btn_5s=$("[class='btn-5']");
	var btn_5;
	btn_5s.bind("click",function(){
		btn_5=$(this);
		var operate_box=btn_5.parent();
		order_id=btn_5.attr("a-order-id");
		if(confirm("确定已经收到货物了吗？")){
			$.post("/Store/control/orderServlet",{
				'status':"gotgoods",
				'order_id':order_id
			},function(){
				$("[class='status"+order_id+"']").append($("[class='status"+order_id+"']").children().eq(0).clone().html("已收货")).append("<br>");
				btn_5.siblings().eq(0).attr({"style":""});
				btn_5.remove();
				$("#tbody"+order_id).attr({"tbodystatus":"3"});
			},"html");
		}
	});

	
	
	//付款按钮
	var btn_agains=$("[class='btn-again']");
	var btn_again;
	btn_agains.bind("click",function(){
		btn_again=$(this);
		order_id=btn_again.attr("a-order-id");
		var operate_box=btn_again.parent();
		if(confirm("确定付款吗？")){
			$.post("/Store/control/orderServlet",{
				'status':"paynow",
				'order_id':order_id
			},function(){
				$("[class='status"+order_id+"']").children().eq(0).remove().clone().html("已付款").insertBefore($("[class='status"+order_id+"']").children().eq(0));
				$("#amount"+order_id).append("<br> <span class='ftx-13'>在线支付</span>");
				btn_again.siblings().eq(0).attr({"style":""});
				btn_again.remove();
				$("#tbody"+order_id).attr({"tbodystatus":"2"});
			},"html");
		}
	});
	
	//所有的订单
	var tbody=$("[class='tbody']");
	//长度
	var length=tbody.length;
	//页面
	var page=$("[class='current']");
	var pagenum=page.html();;
	//上一页按钮
	var prev_page=$("[class='prev-disabled']");
	prev_page.bind("click",function(){
		if(pagenum>1){
			pagenum--;
			page.html(pagenum);
//			alert(pagenum);
			for(var i=1;i<=length;i++){
				if(pagenum*4>=i&&i>(pagenum*4-4)){
//					tbody.eq(i).attr({"style":"display:block"});
					$("#tbody"+i).attr({"style":"display:block"});
				}else{
//					tbody.eq(i).attr({"style":"display:none"});
					$("#tbody"+i).attr({"style":"display:none"});
				}
//				$.post("/Store/control/orderServlet",{
//					'page':pagenum
//				});
			}
		}
	});
	
	//下一页按钮
	var next_page=$("[class='next-disabled']");
	next_page.bind("click",function(){
		if((pagenum*4+1)<=length){
			pagenum++;
//			alert(length);
			page.html(pagenum);
			for(var i=1;i<=length;i++){
				if(pagenum*4>=i&&i>(pagenum*4-4)){
//					tbody.eq(i).attr({"style":"display:block"});
					$("#tbody"+i).attr({"style":"display:block"});
				}else{
//					tbody.eq(i).attr({"style":"display:none"});
					$("#tbody"+i).attr({"style":"display:none"});
				}
			}
//			alert(pagenum);
//			$.post("/Store/control/orderServlet",{
//				'page':pagenum
//			});
		}
	});
	
});