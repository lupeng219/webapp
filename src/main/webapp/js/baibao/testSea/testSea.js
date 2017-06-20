/**
 * Created by chen on 2015/8/31.
 */
/*seajs.config({//******************可在子页面中单独定义sea的属性********************
    alias : {
        "j": "jquery.min.js",
        "c" : "jquery.cookie.pack.js"
    }
});*/
define(/*[ "j", "c" ],*/function(require/*j, c*/) {
        var fn = {
            init : function() {//*****************执行初始化行为******************
                //引入其他模板文件
                var myModule = require('testSea/testSeaModule');
                var tempData=myModule.func2();
                alert(tempData);
                // 绑定
                biz.bind();
            }
        };
        var biz = {
            bind : function() {
                $("#seaTest").on("click", biz.event.testSea);
            },
            event : {
                testSea : function() {
                    alert("seaTest ok");
                }
            }
        };
        return fn;
});