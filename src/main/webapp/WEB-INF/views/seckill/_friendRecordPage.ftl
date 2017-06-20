    <div class="op-conduct">
                    <div class="fl">
                        <span class="op-title">时间范围</span>
                        <input type="text" class="biao-time" value="${startTime }" id="startTime" onClick="WdatePicker({autoPickDate:'true',dateFmt:'yyyy-MM-dd'})"/>
                        <span class="op-title"> - </span>
                        <input type="text" class="biao-time" value="${endTime }" id="endTime" onClick="WdatePicker({autoPickDate:'true',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startTime\')}'})"/>
                    </div>
                    <div class="fl ml10">
                        <span class="op-title">用户手机号</span>
                        <input type="tel" class="user-mobile" value="${userMobile }" id="userMobile"/>
                    </div>
                    <a class="find-btn ml20" href="javascript:ajaxPage(1);">查 询</a>
                </div>
                <ul class="records-project">
                    <li class="project-title">
                    	<span>序号</span>
                    	<span>被邀请姓名</span>
                        <span>被邀请手机号</span>
                        <span>注册时间</span>
                        <span>邀请奖励金额</span>
	                </li>
                     
                  <#if paging.pageList?size!=0>
                  <#list paging.pageList as friend>
                    <li><span>${friend_index+1}</span>
                    	<span>
							<#if friend.pui_real_name !=null>
                				${friend.pui_real_name}
	                		<#else>
	                			****
	                		</#if>
						</span>
                        <span><a class="linkMobile" title="查看推荐投资奖励">${friend.pu_mobile}</a></span>
                        <span><#if friend.pui_registration_time?? >${friend.pui_registration_time?string('yyyy-MM-dd HH:mm:ss')}</#if></span>
                        <span><#if friend.puw_parvalue?? >${friend.puw_parvalue}元<#else>0元</#if></span>
                     </li>
                  </#list>
                 <#else>
                    <p class="no-text">暂无数据</p>
                 </#if>
                </ul>
                
			<div class="baibao-pageye">
			<ul class="clearfix">
			    <li><a href="javascript:void(0)" class="prev-on"><</a></li>
			    <#list paging.startPageNo..paging.endPageNo as page>
			    <li><a href="javascript:ajaxPage(${page})" <#if page==paging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>${page}</a></li>
			    </#list>
			    <li><a href="javascript:void(0)" class="prev-next">></a></li>
			</ul>
				<script type="text/javascript">
				$(function(){
					var pageTotal = ${paging.pageTotal};
					var pageNo = ${paging.pageNo};
					$(".prev-on").on("click",function(){
						if(pageNo-1<1){ajaxPage(1);}
						else{ajaxPage(pageNo-1);}
					});
					$(".prev-next").on("click",function(){
						if(pageNo+1>pageTotal){ajaxPage(pageTotal);}
						else{ajaxPage(pageNo+1);}
					});
					$(".linkMobile").on("click",function(){
						var temp=$.trim($(this).html());
						$("#tenderUserMobile").val(temp);
						$(".mkli").get(1).click();
						ajaxPage1(1);
					});
					});
				function ajaxPage(pageNo){
				var startTime =$("#startTime").val();
				var endTime =$("#endTime").val();
				var userMobile =$("#userMobile").val();
					var params = {"currentPageNo":pageNo,"startTime":startTime,"endTime":endTime,"userMobile":userMobile};
					$.ajax({
			            type:"POST",
			            url:root+"/service/${ajaxPageUrl}?refresh="+new Date().getTime(),
			            data:params,
			            datatype:"html",
			            beforeSend:function(){//$("#msg").html("logining");
			            },
			            success:function(data){
			            	 $("#friendRecord").html("");
			            },
			            complete:function(XMLHttpRequest, textStatus){
			               //alert(XMLHttpRequest.responseText);
			               //alert(textStatus);
			               $("#friendRecord").html(XMLHttpRequest.responseText);
			            },
			            error:function(){
			            	
			            }         
			        });
				}
				</script>
			</div>
