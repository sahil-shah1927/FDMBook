$('.login-tab').click(function() {
	
	$('.login-tab').addClass('active');
	$('.register-tab').removeClass('active');
	$('.login-form').removeClass('display-none');
	$('.register-form').addClass('display-none');
})
$('.register-tab').click(function() {
	$('.login-tab').removeClass('active');
	$('.register-tab').addClass('active');

	$('.login-form').addClass('display-none');
	$('.register-form').removeClass('display-none');
})