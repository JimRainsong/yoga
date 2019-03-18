function detail(){
	$.ajax({
		url:'/yoga/teacher/teaDetail',
		type:'post',
		dataType:'json',
		data:{
			oper:'detail'
		},
		success:function(data){
			alert(data);

			$("#g_name").html(data.teacherName);
			$("#g_price").html(data.teacherMoney+' 元');
			$("#g_description").html(data.teacherPhone);
			$("#g_count").html(100);
			$("#g_img").attr('src',data.teacherImg);
			$("#g_brand").html(data.teacherQq);
			
			
			
		}
		
		
	});
	
}
detail();