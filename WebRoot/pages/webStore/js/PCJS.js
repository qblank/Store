/**
 * Created by Oliver on 2017/8/4.
 */
$(document).ready(function(){
    var picture=$("#picture");
    var pictures=picture.children();
    var width=picture.width();
    var arr=$("#arr");
    var pointlist=$("#pointList");
    var points=pointlist.children();
    var left=$("#left");
    var right=$("#right");
    var index=0;
    var timers=null;
    //鼠标放到原点换图
    points.bind("mouseover",function(){
        index=$(this).index();
        pictures.eq(index).fadeIn("slow").siblings().fadeOut("slow");
        $(this).attr({"style":"background-color:#db192a"}).siblings().attr({"style":"background-color:#fff"});
    });
    //设置定时器，自动轮播
    timers = setInterval( function autoplay(){
        points.eq(index).attr({"style":"background-color:#db192a"}).siblings().attr({"style":"background-color:#fff"});
        pictures.eq(index).fadeIn("slow").siblings().fadeOut("slow");
        index++;
        if(index==points.length){
            index=0;
        }
    },3000);

    //下一张按钮
    //悬停事件
    right.hover(function(){
        $(this).attr({"style":"opacity: 0.5"}).siblings().attr({"style":"opacity: 0.3"});
    },function(){
        $(this).attr({"style":"opacity: 0"}).siblings().attr({"style":"opacity: 0"});
    });
    //换到下一张
    right.bind("click",function(){
        index++;
        if(index==points.length){
            index=0;
        }
        points.eq(index).attr({"style":"background-color:#db192a"}).siblings().attr({"style":"background-color:#fff"});
        pictures.eq(index).fadeIn("slow").siblings().fadeOut("slow");
    });

    //上一张按钮
    //悬停事件
    left.hover(function(){
        $(this).attr({"style":"opacity: 0.5"}).siblings().attr({"style":"opacity: 0.3"});
    },function(){
        $(this).attr({"style":"opacity: 0"}).siblings().attr({"style":"opacity: 0"});
    });
    //换到上一张
    left.bind("click",function(){
        if(index==0){
            index=points.length;
        }
        index--;
        points.eq(index).attr({"style":"background-color:#db192a"}).siblings().attr({"style":"background-color:#fff"});
        pictures.eq(index).fadeIn("slow").siblings().fadeOut("slow");
    });
    //图片悬停显示上下张
    picture.hover(function(){
        right.attr({"style":"opacity: 0.3"});
        left.attr({"style":"opacity: 0.3"});
        //清除定时器
        clearInterval(timers);
    },function(){
        right.attr({"style":"opacity: 0"});
        left.attr({"style":"opacity: 0"});
        //重新添加定时器
        timers = setInterval(function(){
            points.eq(index).attr({"style":"background-color:#db192a"}).siblings().attr({"style":"background-color:#fff"});
            pictures.eq(index).fadeIn("slow").siblings().fadeOut("slow");
            index++;
            if(index==points.length){
                index=0;
            }
        },3000);
    });
    //原点悬停显示上下张
    pointlist.hover(function(){
        //清除定时器
        clearInterval(timers);
        arr.children().attr({"style":"opacity: 0.3"});
    },function(){
        //重新添加定时器
        timers = setInterval(function(){
            points.eq(index).attr({"style":"background-color:#db192a"}).siblings().attr({"style":"background-color:#fff"});
            pictures.eq(index).fadeIn("slow").siblings().fadeOut("slow");
            index++;
            if(index==points.length){
                index=0;
            }
        },3000);
        arr.children().attr({"style":"opacity: 0"});
    });
    
    arr.hover(function(){
        //清除定时器
        clearInterval(timers);
    },function(){
        //重新添加定时器
        timers = setInterval(function(){
            points.eq(index).attr({"style":"background-color:#db192a"}).siblings().attr({"style":"background-color:#fff"});
            pictures.eq(index).fadeIn("slow").siblings().fadeOut("slow");
            index++;
            if(index==points.length){
                index=0;
            }
        },3000);
    })

});





   
