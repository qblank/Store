/**
 * Created by Administrator on 2017/8/4.
 */


	
   	$(document).ready(function(){
   		/**
   		 * 右边的新闻栏
   		 */
    	var rt = $("#right_title a");
    	var rtBox = $(".content_right>div");
    	console.log(rt);
    	rt.on("mouseover",function(){
    		rtBox.eq($(this).index()).show().siblings("div").hide();
    	});
    	
    	/**
    	 * 左边的导航栏
    	 */
    	var con_left = $(".content_left ul li");
    	
    	con_left.on("mouseover",function(){
    		$(this).index()
    		
    	});
    	
    	
    	
    });
   

    /*改变颜色*/
    function changeColor(){
        var pro_navs = document.getElementsByClassName("pro_nav");
        var nav_colors = ["#E01222","#33868F","#6E3A80","#E56804","#EB2D14","#54609B"];
        for(var i = 0;i<pro_navs.length;i++){
            pro_navs[i].style.backgroundColor = nav_colors[i];
        }

    }
    
    
    /*
     * 主页面加载时就把商品小类加载出来
     * */
  /* $(function() {
		$.ajax({
			url:"/Store/CategoryServlet",
			type:"post",
			dataType:"json",
			success:function(data){
				alert(1);
				 <div class="pro_nav">
		            <span class="des_title">图片汽车</span>
		            <span>男人的车库</span>
		        </div>
							var res="<option>"+pro.pro_name+"</option>";
							//<span style="white-space:pre">  </span>res += "<option>"+pro[i].ServletdaoImpi+"</option>";
							$(res).appendTo($("#province"));
				var category = data;
				for (var i = 0; i < category.length; i++) {
					var c=category[i];
					var res="";
					$(res).appendTo($("#myUL"));
				}
			}
		});
	});*/
    
    /**
     * 移到左边导航栏中，添加一个盒子
     */
    
    
    
    

