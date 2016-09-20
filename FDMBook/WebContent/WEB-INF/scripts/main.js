$('.login-tab').click(function() {
	
	$('.login-tab').addClass('active');
	$('.register-tab').removeClass('active');
	$('#login-register-form').attr('action', 'login');
	$('.login-register-submit').attr('value', 'Log in')
})
$('.register-tab').click(function() {
	$('.login-tab').removeClass('active');
	$('.register-tab').addClass('active');
	$('#login-register-form').attr('action', 'register');
	$('.login-register-submit').attr('value', 'Register')
})