/**
 * Created by chen on 2015/3/6.
 */
var alertObj = new Object();
var confirmObj = new Object();
var fatherStyle = {//弹窗的样式
    zIndex: 9999,
    width: "100%",
    height: "100%",
    margin:"0",
    padding:"0",
    fontSize:"1rem",
    fontFamily:'"Microsoft Yahei", "微软雅黑", Arial, "Hiragino Sans GB", "宋体"',
    border: "none",
    position: "fixed",
    top: "0",
    left: "0",
    overflow: "hidden"
};
var generalStyle = {//弹窗的样式
    zIndex: 2,
    width: "90%",
    maxWidth: "500px",
    minHeight: "80px",
    margin:"0",
    padding:"0",
    marginLeft: "auto",
    marginRight: "auto",
    position: "absolute",
    left: "0",
    right: "0",
    top:"40%",
    borderRadius:"5px",
    webkitBorderRadius: "5px",
    mozBorderRadius: "5px",
    background:"#fff",
    textAlign: "center"
};
var backStyle={//遮罩层的样式
    zIndex: 1,
    width: "100%",
    height: "100%",
    margin:"0",
    padding:"0",
    background: "rgba(0, 0, 0, 0.4)",
    position: "absolute",
    top: "0",
    left: "0"
};
var txtStyle = {//弹窗中p标签的样式
    margin: "0.8rem 1rem",
    padding: "0",
    color: "#797979",
    fontSize: "1rem",
    lineHeight: "1.3rem",
    textAlign: "center",
    overflowY: "auto",
    overflowX: "hidden"
};
var btnStyle = {//弹窗中确认按钮的样式
    background:"rgb(174, 222, 244)",
    color:"#fff",
    border:"none",
    fontSize:"0.9rem",
    borderRadius:"5px",
    webkitBorderRadius: "4px",
    mozBorderRadius: "4px",
    padding:"0.5rem 1.3rem",
    margin:"0.9rem auto",
    cursor:"pointer",
    innerHTML: "确&nbsp;定"
};
var emptyStyle = {//弹窗中确认按钮的样式
    innerHTML: "&nbsp;&nbsp;"
};
var cancelStyle = {//弹窗中确认按钮的样式
    background:"rgb(203, 208, 210)",
    color:"#fff",
    border:"none",
    fontSize:"0.9rem",
    borderRadius:"5px",
    webkitBorderRadius: "4px",
    mozBorderRadius: "4px",
    padding:"0.5rem 1.3rem",
    margin:"0.9rem auto",
    cursor:"pointer",
    innerHTML: "取&nbsp;消"
};
var myFunction="";
var cancelFunction="";
alertObj = {
    fatherSet:fatherStyle,
    generalSet: generalStyle,
    txtSet: txtStyle,
    btnSet: btnStyle,
    backDivASet: backStyle,
    isExist: false
};
confirmObj={
    fatherSet:fatherStyle,
    generalSet: generalStyle,
    txtSet: txtStyle,
    btnSet: btnStyle,
    emptySet: emptyStyle,
    cancelSet: cancelStyle,
    backDivASet: backStyle,
    isExist: false
};
function createComponent(){
    var component = document.createElement(arguments[0]);
    var styles = arguments[1];
    for (var property in styles) {
        if (styles[property] != null) {
            try{
                component.style[property] = styles[property];
            }catch(err){
                document.write(err.name+":"+property+"<br/>");//set property error!
            }
        }
    }
    return component;
};
alertObj.show = function(){
    if(!this.isExist){
        this.isExist = true;
        var bodyObj = document.body;
        var fatherObj = createComponent("div", this.fatherSet);
        fatherObj.id="commonAlertTk";
        var generalObj = createComponent("div", this.generalSet);
        generalObj.id="commonAlertContent";
        var txtObj = createComponent("p", this.txtSet);
        txtObj.innerHTML = arguments[0];
        var btnObj = createComponent("button", this.btnSet);
        btnObj.innerHTML = this.btnSet.innerHTML;
        btnObj.onclick = function() {
            bodyObj.removeChild(fatherObj);
            if(alertObj.isExist){
                alertObj.isExist = false;
            }
            if(myFunction){
                myFunction();
            }
        };
        var backObj = createComponent("div", this.backDivASet);
        generalObj.appendChild(txtObj);
        generalObj.appendChild(btnObj);
        fatherObj.appendChild(generalObj);
        fatherObj.appendChild(backObj);
        bodyObj.appendChild(fatherObj);
    }
};
confirmObj.show = function(){
    if(!this.isExist){
        this.isExist = true;
        var bodyObj = document.body;
        var fatherObj = createComponent("div", this.fatherSet);
        fatherObj.id="commonAlert";
        var generalObj = createComponent("div", this.generalSet);
        generalObj.id="commonAlertContent";
        var txtObj = createComponent("p", this.txtSet);
        txtObj.innerHTML = arguments[0];
        var btnObj = createComponent("button", this.btnSet);
        btnObj.innerHTML = this.btnSet.innerHTML;
        var emptyObj = createComponent("span", this.emptySet);
        emptyObj.innerHTML = this.emptySet.innerHTML;
        var cancelObj = createComponent("button", this.cancelSet);
        cancelObj.innerHTML = this.cancelSet.innerHTML;
        btnObj.onclick = function() {
            bodyObj.removeChild(fatherObj);
            if(confirmObj.isExist){
            	confirmObj.isExist = false;
            }
            if(myFunction){
                myFunction();
            }
        };
        cancelObj.onclick = function() {
            bodyObj.removeChild(fatherObj);
            if(confirmObj.isExist){
            	confirmObj.isExist = false;
            }
            if(cancelFunction){
                cancelFunction();
            }
        };
        var backObj = createComponent("div", this.backDivASet);
        generalObj.appendChild(txtObj);
        generalObj.appendChild(btnObj);
        generalObj.appendChild(emptyObj);
        generalObj.appendChild(cancelObj);
        fatherObj.appendChild(generalObj);
        fatherObj.appendChild(backObj);
        bodyObj.appendChild(fatherObj);
    }
};
function myShow(s,v) {
    alertObj.show(s);
    var tk=document.getElementById("commonAlertContent"),
        bodyHeight=document.documentElement.clientHeight;
    tk.style.top=(bodyHeight-tk.offsetHeight)/2+"px";
    if(v){
        myFunction=v;
    }else{
        myFunction="";
    }
};
function myConfirm(s,v,k){
    confirmObj.show(s);
    var tk=document.getElementById("commonAlertContent"),
        bodyHeight=document.documentElement.clientHeight;
    tk.style.top=(bodyHeight-tk.offsetHeight)/2+"px";
    if(v){
        myFunction=v;
    }else{
        myFunction="";
    }
    if(k){
        cancelFunction=k;
    }else{
        cancelFunction="";
    }
};