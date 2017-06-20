<div >                		
    <div class='show-datas'>

        <p>佰宝聚利总人数<span>${pageCreditorPack.countTotal}</span>人</p>
        <div>
            <ul class='personlistTitle'>
                <li class='product_Num txt_l'>序号</li>
                <!--<li class='txt_l product_Title'>借款标题</li>-->
                <li class='txt_r product_Name'>姓名</li>
                <li class='product_IDcard'>身份证号</li>
                <li class='product_Area'>地区</li>
                <li class='product_Mny'>额度（元）</li>
                <li class='product_Operate'>操作</li>
            </ul>
        </div>
        <#list pageCreditorPack.pageList as userInfo>
        <div class='addH'>
            <ul>
                <li class='product_Num txt_l'>${userInfo_index + 1}</li>
                <!--<li class='txt_l product_Title' id="loan_title">${productDetail.ppLoantitle}</li>-->
                <li class='txt_r product_Name'>${userInfo.pcpRealName}</li>
                <li class='product_IDcard'>${userInfo.pcpCertNo}</li>
                <li class='product_Area'>${userInfo.pcpNativePlace}</li>
                <li class='product_Mny'>${userInfo.pcpAmount?string(',##0.00')}</li>
                <li class='listInfo product_Operate'><a href="javascript:;">展开详情</a></li>
            </ul>
            <ol class='detailedInfo'>
               <div>
                    <div class='infoLeft'>
                        <h4>借款人信息</h4>
                        <p>借款人：<span>${userInfo.pcpRealName}</span></p>
                        <p>年龄：<span>${userInfo.pcpAge}</span></p>
                        <p>职业：<span>${userInfo.pcpWorkPosition}</span></p>
                        <p>学历：<span>${userInfo.pcpEducation}</span></p>
                        <p>婚姻：<span>${userInfo.pcpMateria}</span></p>
                        <p>工作年限：<span>${userInfo.pcpWorkAge}</span></p>
                        <p>月收入：<span>${userInfo.pcpMonthSalary}</span></p>
                    </div>
                    <div class='infoRight'>
                         <h4>借款描述</h4>
                         <p>${userInfo.pcpRemark}</p>
                    </div>
               </div> 
            <ol>
        </div>
        </#list>
    </div>
    <!--个人信息分页 start -->
    <div class="clearfix">
	<#if pageCreditorPack ??>
	 <#if 0!=pageCreditorPack.pageList?size>
    <div class="baibao-pageye baibao-pageye1" style="margin-top:50px;color:#ffffff" >
		<ul class="clearfix" >
			<li ><a href="javascript:ajaxPage1(1)" style="" class="prev-first"></a></li>
		    <li><a href="javascript:void(0)" class="prev-on asseton" ></a></li>
		    <#list pageCreditorPack.startPageNo..pageCreditorPack.fenge as page>
		   
		    <li><a href="javascript:ajaxPage1(${page})"  
		    <#if page==pageCreditorPack.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>${page}</a></li>
		 
		    </#list>
		    <#if pageCreditorPack.pageNo<pageCreditorPack.pageTotal-2>
			<#if 3<pageCreditorPack.pageTotal>
			<li ><img src="${basePath}/pictures/page/shenglvu.png"></img></li>
			</#if>
			<li><a href="javascript:ajaxPage1(${pageCreditorPack.pageTotal})"
			 <#if pageCreditorPack.pageTotal==pageCreditorPack.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>
				${pageCreditorPack.pageTotal}
			</a></li>
			</#if>
		    
		    <li><a href="javascript:;" class="prev-next assetnext"></a></li>
		    <li ><a href="javascript:ajaxPage1(${pageCreditorPack.pageTotal})" class="prev-last"></a></li>
		</ul>
		<style>
		.baibao-pageye ul li a{margin-top:12px}
		</style>
	</div>
	 <#else>
			<p class="fl no-record" style="padding-top:30px" >暂无数据</p>
      </#if>
      </#if>
                 		<!--个人信息分页 end -->
  </div>
                </div>       
       <script type="text/javascript">
			$(function(){
				var pageTotal = ${pageCreditorPack.pageTotal};
				var pageNo = ${pageCreditorPack.pageNo};
				
				$(".asseton").on("click",function(){
                    
					if(pageNo-1<1){ajaxPage1(1);}
					else{ajaxPage1(pageNo-1);}
                    return false;
				});
				$(".assetnext").on("click",function(){
                    
					if(pageNo+1>pageTotal){ajaxPage1(pageTotal);}
					else{ajaxPage1(pageNo+1);}
                    return false;
				});
			});
			function ajaxPage1(pageNo){
				var type='${type}';
			    var productNo ='${productDetail.ppProductno}';
				var params = {
					"currentPageNo": pageNo,
					"productNo": productNo,
					"refresh": Date.now()
				};
				showContentLoading();
				
				$.post(root + "/service/${creditorPackAjaxPageUrl}",
					params).done(function(data) {
						closeContentLoading();
						$("#assetCredit").html("");
		            	$(".baibao-pageye1").html(data);
		            	 $("#assetCredit").html(data);
		            	 var _Loantitle=$("#_Loantitle").html();
		               $("#loan_title").html(_Loantitle); 
					});
					
				/*$.ajax({
		            type:"POST",
		            url:root+"/service/${creditorPackAjaxPageUrl}?refresh="+new Date().getTime(),
		            data:params,
		            datatype:"html",
		            beforeSend:function(){//$("#msg").html("logining");
		            },
		            success:function(data){
		            	closeContentLoading();
		            	$("#assetCredit").html("");
		            	$(".baibao-pageye1").html(data);
		            },
		            complete:function(XMLHttpRequest, textStatus){
		               closeContentLoading();
		               $("#assetCredit").html(XMLHttpRequest.responseText);
		               var _Loantitle=$("#_Loantitle").html();
		               $("#loan_title").html(_Loantitle);
		            },
		           error:function(XMLResponse){alert(XMLResponse.responseText)}       
		        });*/
			}
            //佰宝聚利账户详情展开
            $(".listInfo").on('click', 'a', function () {
                var cont = $(this).html();
                if (cont == "关闭详情") {
                    closect(".detailedInfo", this);
                } else {
                    showct(".listInfo", this, ".detailedInfo");
                }

            })

            function closect(detailedInfo, th) {
                $(detailedInfo).hide();
                $(th).css({
                    "color": "#09afdf"
                }).html("展开详情");
            }

            function showct(listInfo, th, detailedInfo) {
                $(listInfo).find("a").css({
                    "color": "#09afdf"
                }).html("展开详情");
                $(th).css({
                    "color": "#333333"
                }).html("关闭详情");
                $(detailedInfo).hide();
                $(th).parent().parent().parent().find(detailedInfo).show();
            }
		</script>
        