$(function(){
	$("#name").focus();
});

function login(){
	var reg = /^\w{3,10}$/;
    var username = $("#name").val();
    var password = $("#pwd").val();
    if(!reg.test(username)){
        alert("请输入3到10位数字,字母或下划线")
        $("#name").val("");
        return;
    }
    if(!reg.test(password)){
        alert("请输入3到10位数字,字母或下划线")
        $("#pwd").val("");
        return;
    }

    $("#loginbutton").val("正在登录...");
    $("#loginbutton").attr("disabled","disabled");

    var url = "user/login.do";
    //登錄
    $.ajax({
        type:"post",
        url:url,
        data:{"userName":username,"password":password},
        dataType:"json",
        success:function(data){
            if(data.state&&data.data&&data.data.length!=0){
                if(data.data[0].promise==0){
                    alert("你没有权限登录");
                    $("#name").val("");
                    $("#pwd").val("");
                    $("#loginbutton").val("登录");
                    $("#loginbutton").removeAttr("disabled");
                    return;
                }
                console.log(data.data[0].worktype!=0);
                var wname = getCookie("welleplususername");
                if(wname==null){
                    addCookie("welleplususername",username,60);
                }else{
                    SetCookie("welleplususername",username);
                }

                var wrole = getCookie("welleplusrole");
                if(wrole==null){
                    addCookie("welleplusrole",data.data[0].role,60);
                }else{
                    SetCookie("welleplusrole",data.data[0].role);
                }

                var wrid = getCookie("welleplusrid");
                if(wrid==null){
                    addCookie("welleplusrid",data.data[0].rid,60);
                }else{
                    SetCookie("welleplusrid",data.data[0].rid);
                }

                var wuid = getCookie("welleplusuid");
                if(wuid==null){
                    addCookie("welleplusuid",data.data[0].id,60);
                }else{
                    SetCookie("welleplusuid",data.data[0].id);
                }

                var wname = getCookie("welleplusname");
                if(wuid==null){
                    addCookie("welleplusname",data.data[0].name,60);
                }else{
                    SetCookie("welleplusname",data.data[0].name);
                }
//                console.log(data);


                window.location.href = "main.html";
//                window.location.href = 'http://www.baidu.com';
            }else if(data.state&&data.data&&data.data.length==0){
                alert("密码或用户名错误");
                $("#loginbutton").val("登录");
                $("#loginbutton").removeAttr("disabled");
            }else{
                alert("登录失败");
                $("#loginbutton").val("登录");
                $("#loginbutton").removeAttr("disabled");
            }
        },
        error:function(){
            alert("登录失败");
            $("#name").val("");
            $("#pwd").val("");
            $("#loginbutton").val("登录");
            $("#loginbutton").removeAttr("disabled");
        }
    });
}

$("#mybody").keyup(function(){
    if(event.keyCode == 13){
    	login();
    }
});
$("#loginbutton").click(function(){
	login();
});

