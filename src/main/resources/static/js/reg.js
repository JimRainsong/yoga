function register(){
   /* alert($("form").serialize());
    $.ajax({
        url: "/yoga/venue/updata" ,
        type:"post",
        dataType: "json",//预期服务器返回的数据类型
        data: $("form").serialize(),
        success:function(data){
            data = eval("("+data+")");
            if(data.code==0){
               alert(data.message);
            }else{
                alert(data.message);
            }
        }
    })*/
    $("form").form("submit",{
        url: "/yoga/venue/updata",
      /*  method:"post",*/
        success:function(data){
            data = eval("("+data+")");
            if(data.code == 0){
                $.messager.alert("系统提示",data);
            }else{
                $.messager.alert("系统提示",data.message);
            }
        }
    })
}
