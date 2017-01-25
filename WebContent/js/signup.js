

$("#signup").click(function(e){

	$("#form_signup").attr('method',"POST");
	$("#action").val("signup");
	$("#form_signup").submit();
});

$("#goLogin").click(function(e){
	$("#form_signup").attr('method',"GET");
	$("#action").val("go_login");
	$("#form_signup").submit();
});