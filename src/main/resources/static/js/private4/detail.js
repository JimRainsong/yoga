function detail(){
	$.ajax({
		url:'/yoga/teacher/teaDetail',
		type:'post',
		dataType:'json',
		data:{
			oper:'detail'
		},
		success:function(data){
			$("#g_name").html(data.teacherName);
			$("#g_sex").html(data.teacherSex);
			$("#g_price").html(data.teacherMoney);
			$("#g_phone").html(data.teacherPhone);
			$("#g_img").attr('src',data.teacherImg);
			$("#g_qq").html(data.teacherQq);
		}


	});

}
detail();