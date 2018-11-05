$(function(){
	var phoneNumber = $("phoneNumber").val();
	var password = $("password").val();
	
	$("button").on('click',function(){
		if(phoneNumber == '' || password == ''){
			$('info').html("");
			$('info').html("账号密码不为空");
			return ;
		}
		if(phoneNumber.length != 11 || password >=30){
			$('info').html("");
			$('info').html("账号密码验证失败");
			return ;
		}
		$.ajax({
         type: "POST",
         url: "/login",
         data: {
         	phoneNumber : phoneNumber,
         	password : password
         },
         contentType: "application/json",
         success: function(data){
         	if(data.code == 0){
         		$('info').html("");
				$('info').html("账号密码验证错误");
				return ;
         	}
         	if(data.code == 1){
         		windows.localhost.href("homepage");
         		return ;
         	}
         }

   		});
	})

})