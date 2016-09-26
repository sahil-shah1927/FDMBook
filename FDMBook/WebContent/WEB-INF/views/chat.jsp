<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8" />
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="scripts/jquery-cookie.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.4.0/jquery.timeago.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.0.0/sockjs.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

<script src="scripts/messages.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet" />

<style type="text/css">
.fixed-panel {
	min-height: 500px;
	max-height: 500px;
	overflow: auto;
}

.fixed-panel ul li {
	overflow-wrap: break-word;
}
</style>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<div class="container">
		<div class="row " style="padding-top: 40px;">

			<br />
			<div class="col-md-12" style="margin-bottom:.5em;">
				<div class="join-game-btn" style="display:inline-block">
					<form id="joinForm" action="joinGame" method="POST">
						<input type="hidden" name="username"
							value="${LoggedInUser.username}">
						<button id="joinButton" class="btn btn-primary" type="submit" name="joinGameBtn">
							Join Game</button>


					</form>
				</div>
				<div class="spect-game-btn" style="display:inline-block">
					<form action="spectGame" method="POST">
						<input type="hidden" name="username"
							value="${LoggedInUser.username}">
						<button class="btn btn-success" type="submit" name="spectGameBtn">
							Spectate</button>


					</form>
				</div>
				
			</div>
			<div class="col-md-12">
				<div class="panel panel-info">
					<div class="panel-heading">
						<strong><span class="glyphicon glyphicon-list"></span>
							Chat History</strong>
					</div>
					<div id="test" class="panel-body fixed-panel">
						<ul class="media-list">
						</ul>
					</div>
					<div class="panel-footer">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Enter Message" id="messageText"
								autofocus="autofocus" /> <span class="input-group-btn">
								<button class="btn btn-info" type="button" id="sendMessage"
									name="message">
									SEND <span class="glyphicon glyphicon-send"></span>
								</button>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>