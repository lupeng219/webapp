  <div class="body-color">
        <div class="container">
        <div class="aboutus-con">
            <p class="ui-desc-title">网站公告</p>
            <ul class="wzgg-ui">
              <#if paging.pageList?size!=0>
              <#list paging.pageList as active>
                  <li>
                    <p class="decoration"></p>
                    <a href="${basePath}/service/aboutUs/noticeDesc?noticeId=${active.articleID}">${active.articleTitle}</a>
                    <span><#if active.articlePushTime??>${active.articlePushTime?string('yyyy-MM-dd HH:mm:ss')}</#if></span>
                </li>
              </#list>
              <#else>
              	<li>
                    <p class="decoration"></p>
                    <a href="aboutUs-noticedesc.html">暂无公告</a>
                    <span></span>
                </li>
              </#if>
            </ul>
            <div class="clearfix">
           		<#include "./common/common_paging.ftl" />  
            </div>
        </div>
    </div>
    </div>