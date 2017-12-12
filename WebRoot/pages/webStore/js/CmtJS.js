$(document).ready(function(){
	
	var textareas=$("[name='textarea']");
	var text="";
	var index=0;
	var id=$("[class='orderinfo']").attr("id");
	textareas.bind("input propertychange",function(){
		$(this).attr({"value":$(this).val()});
		index=$(this).index();
//		alert($("[name='textarea']").eq(index).val());
//		alert($("#3").val());
	});
//	textareas.bind("blur",function(){
//		alert(textareas.eq(index).val());
//	});
	
	var submit=$("[class='btn-submit']");
	submit.hover(function(){
		$.each($("[name='textarea']"),function(){
			text+="&comment"+index+"="+$(this).val();
			index++;
//			alert(text);
		});
		index=0;
	},function(){
		text="";
	});
	submit.bind("click",function(){
//		alert("123123123");
//		alert(text);
//		alert(id);
		$(this).attr({"href":"/Store/control/commentServlet?order_id="+id+"&activity=1"+text});
//		alert($(this).attr("href"));
		text="";
	});
	
});