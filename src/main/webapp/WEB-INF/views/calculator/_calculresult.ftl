<div class="clearfix cal-sydesc mt20 ">
    <h2 class="J_tit ml20" style="border:none">收益描述</h2>
    <ul>
        <li><span class="fl">出借金额</span> <span class="fr">${cjje }元</span></li>
        <li style="padding-right:241px;"><span class="fl">应收利息</span> <span class="fr">${yslx }元</span></li>
        <li style="padding:0px;width:200px;"><span class="fr pr10">您将在<em class="red">${jkqx }</em><#if hkfs=='2'>天<#else>个月</#if>后收回全部本息</span></li>
    </ul>
</div>
<div class="clearfix cal-sydesc mt20 ">
    <h2 class="J_tit ml20" style="border:none">本息回收时间表</h2>
    <table class="time-table">
        <tr class="head-color">
            <th class="text-center" style="width:19%">期数</th>
            <th class="text-center" style="width:26%">本金（元）</th>
            <th class="text-center" style="width:26%">利息（元）</th>
            <th class="text-center" style="width:29%">本息（元）</th>
        </tr>
        <#list result as map>
        	<#if map_index%2==0>
        		<tr class="text-center color-time-tr2">
    		<#else>
    			<tr class="text-center color-time-tr1">
        	</#if>
        		<td>${map.periodsNum}</td>
		        <td>${map.capital?string(',##0.00')}</td>
		        <td>${map.interest?string(',##0.00')}</td>
		        <td>${map.capitalInt?string(',##0.00')}</td>
		    </tr>
        </#list>
    </table>
</div>


