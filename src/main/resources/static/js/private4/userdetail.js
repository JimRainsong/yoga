function userdetail(){
    $.ajax({
        url:'/yoga/user/userDetail',
        type:'post',
        dataType:'json',
        data:{
            oper:'detail'
        },
        success:function(data){
            alert(data);
            $("#g_name").html(data.netName);
            $("#g_price").html(data.balance+' 元');
            $("#g_description").html(data.phoneNumber);
            $("#g_count").html(data.qq);
            $("#g_img").attr('src',data.headImg);
            $("#g_realname").html(data.realName);
            $("#level").html(data.level);
            $("#sex").html(data.sex);



        }


    });

}
userdetail();