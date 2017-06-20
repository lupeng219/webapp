    <div class="op-conduct" style="margin-top:12px;">
                    <div class="fl">
                        <span class="op-title">时间范围</span>
                        <input type="text" class="biao-time" value="${tenderStartTime }" id="tenderStartTime" onClick="WdatePicker({autoPickDate:'true',dateFmt:'yyyy-MM-dd'})" />
                        <span class="op-title"> - </span>
                        <input type="text" class="biao-time" value="${tenderEndTime }" id="tenderEndTime" onClick="WdatePicker({autoPickDate:'true',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'tenderStartTime\')}'})" />
                    </div>
                    <div class="fl ml10">
                        <span class="op-title">用户手机号</span>
                        <input type="tel" class="user-mobile" value="${tenderUserMobile }" id="tenderUserMobile"/>
                    </div>
                    <a class="find-btn ml20" href="javascript:ajaxPage1(1);">查 询</a>
                </div>
                <ul class="records-project reward">
                    <li class="project-title">
                        <span>序号</span>
                        <span>邀请手机号</span>
                        <span>标题</span>
                        <span>期数</span>
                        <span>利息</span>
                        <span>奖励比例</span>
                        <span>可奖励金额</span>
                        <span>发放时间</span>
                        <span>状态</span>
	                </li>
                      <#if tenderPaging.pageList??>
                     <#if tenderPaging.pageList?size!=0>
                  <#list tenderPaging.pageList as tender>
                    <li><span>${tender_index+1}</span>
                        <span>${tender.pu_mobile}</span>
                        <span><a class="linkMobile" href="${basePath}/service/productList/productDetails?productNo=${tender.pp_productNo}&type=1" title="${tender.pp_loanTitle}">${tender.pp_loanTitle}</a></span>
                        <span>${tender.puwa_project_term}</span>
                        <span><#if tender.ptp_interest??>${tender.ptp_interest?string('0.00')}</#if> 元</span>
                        <span><#if tender.ptp_interest??>${tender.ptp_interest?string('0.00')}*8%</#if></span>
                        <span>${tender.puw_parvalue} 元</span>
                        <span>${tender.puw_getTime}</span>
                        <span><#if tender.puw_state=='3'>
                                                  已发放
                        <#else>
                                                  未发放
                        </#if></span>
                     </li>
                  </#list>
                 <#else>
                    <p class="no-text">暂无数据</p>
                 </#if>
                 <#else>
                   <p class="no-text">暂无数据</p>
                      </#if>
                 
                </ul>
			<div class="baibao-pageye">
			<ul class="clearfix">
			    <li><a href="javascript:void(0)" class="prev-on"><</a></li>
			    <#list tenderPaging.startPageNo..tenderPaging.endPageNo as page>
			    <li><a href="javascript:ajaxPage1(${page})" <#if page==tenderPaging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>${page}</a></li>
			    </#list>
			    <li><a href="javascript:void(0)" class="prev-next">></a></li>
			</ul>
				<script type="text/javascript">
				$(function(){
					var pageTotal = ${tenderPaging.pageTotal};
					var pageNo = ${tenderPaging.pageNo};
					$(".prev-on").on("click",function(){
						if(pageNo-1<1){ajaxPage1(1);}
						else{ajaxPage1(pageNo-1);}
					});
					$(".prev-next").on("click",function(){
						if(pageNo+1>pageTotal){ajaxPage1(pageTotal);}
						else{ajaxPage1(pageNo+1);}
					});
					});
				function ajaxPage1(pageNo){
				var startTime =$("#tenderStartTime").val();
				var endTime =$("#tenderEndTime").val();
				var userMobile =$("#tenderUserMobile").val();
					var params = {"currentPageNo":pageNo,"startTime":startTime,"endTime":endTime,"userMobile":userMobile};
					$.ajax({
			            type:"POST",
			            url:root+"/service/${tenderAjaxPageUrl}?refresh="+new Date().getTime(),
			            data:params,
			            datatype:"html",
			            beforeSend:function(){//$("#msg").html("logining");
			            },
			            success:function(data){
			            	 $("#friendTenderRecord").html("");
			            },
			            complete:function(XMLHttpRequest, textStatus){
			               //alert(XMLHttpRequest.responseText);
			               //alert(textStatus);
			               $("#friendTenderRecord").html(XMLHttpRequest.responseText);
			            },
			            error:function(){
			            	
			            }         
			        });
				}
				</script>
			</div>
