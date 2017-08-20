/*图书分类tab  js 代码开始*/
$(function(){
$("#H-table li").each(function(i){
    $(this).click((function(k){
        var _index = k;
        return function(){
            $(this).addClass("cur").siblings().removeClass("cur");
            $(".H-over").hide();    
            $(".H-over:eq(" + _index + ")").show();
        }
    })(i));
});
$("#H-table1 li").each(function(i){
    $(this).click((function(k){
        var _index = k;
        return function(){
            $(this).addClass("cur").siblings().removeClass("cur");
            $(".H-over1").hide();
            $(".H-over1:eq(" + _index + ")").show();
        }
    })(i));
});
});

/*图书分类tab  js 代码结束*/



/*$(function(){     //自动点击童书按钮代码
	
	$(function(){
//		$('#H-table1 #tongshu a').bind("click", href=""function(){ 
//			alert("233");
//		});
//		$('#H-table1 #tongshu a').bind("click", href="ShowChildBookServlet" ,function(){ 
//			alert("xcedc");
//		});

//		$('#H-table1 #tongshu a').trigger("click");
//	});     */

	
	
	
/*		$("#H-table1 #tongshu").click(function(){
			alert("you click");
		});trigger("click");   */

//}
		//alert(" I click!");
//);

/*顶部选项js代码开始*/


(function(a){
    a.fn.hoverClass=function(b){
        var a=this;
        a.each(function(c){
            a.eq(c).hover(function(){
                $(this).addClass(b)
            },function(){
                $(this).removeClass(b)
            })
        });
        return a
    };
})(jQuery);

$(function(){
    // alert("hello");
    $("#pc-nav").hoverClass("current");
});

$(function(){
    $("#pc-nav1").hoverClass("current");
});

/*顶部选项js代码结束*/