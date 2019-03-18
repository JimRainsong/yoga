function detail(){
    $.ajax({
        url:'/yoga/manager/venueDetail',
        type:'post',
        dataType:'json',
        data:{
            oper:'detail'
        },
        success:function(data){
            $("#g_name").html(data.venueName);
            $("#g_price").html(data.venueMoney+' 元');
            $("#g_description").html(data.venueDetails);
            $("#g_count").html(data.venueAddress);
            $("#g_img").attr('src',data.venueImg);
            $("#g_brand").html(data.qq);



        }


    });

}
detail();