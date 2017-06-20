/**
 * Created by chen on 2015/8/31.
 */
define(function(require, exports, module) {//1.require——模块加载函数，用于记载依赖模块。
                                            //2.exports——接口点，将数据或方法定义在其上则将其暴露给外部调用。
                                            //3.module——模块的元数据。
    var data1 = 1; //私有数据

    var func1 = function() { //私有方法
        alert(data1);
    };

    exports.data2 = 2; //公共数据

    exports.func2 = function() { //公共方法
        return data1;
    };

});