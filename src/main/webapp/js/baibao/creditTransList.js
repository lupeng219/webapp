/**
 * Created by chen on 2015/10/28.
 */
$(function(){
	  $('.productType').on('click','li',function(){
		  if(!$(this).hasClass("title")){
			  $(this).addClass('cut').siblings('li').removeClass('cut');
			  searchProductListPage();
		  }
      });
	  $('.productTerm').on('click','li',function(){
		  if(!$(this).hasClass("title")){
			  $(this).addClass('cut').siblings('li').removeClass('cut');
			  searchProductListPage();
		  }
	  });
	  
	 $("#searchRecord").on("click",function(){
	 });
	 function searchProductListPage(){
		 var loanRate =$(".productType").find(".cut a").attr("value");
		 var loanTerm=$(".productTerm").find(".cut a").attr("value");
		   $.post(root+"/service/productList/ajaxShowCreditTransProductList",{
		         "loanRate": loanRate,
		         "loanTerm": loanTerm,
		         "currentPageNo": 1
		     },function(data){
		    	 $("#productListPage").html("");
		         $("#productListPage").html(data);
		         jinDu();
		    	  $(".productType li a").each(function(){
					  if($(this).attr("value")==productType){
						  $(this).parent().addClass("current").siblings('li').removeClass('current');
					  } 
				   });
		    	  $(".productTerm li a").each(function(){
					  if($(this).attr("value")==loanTerm){
						  $(this).parent().addClass("current").siblings('li').removeClass('current');
					  } 
				   });
		        });
	 }
});

