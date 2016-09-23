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

<script>
var scrolled = false;
function updateScroll(){
    if(!scrolled){
        var element = document.getElementById("test");
        element.scrollTop = element.scrollHeight;
    }
}

$("#test").bind('scroll', function(){
    scrolled=true;
});
    
    

function joinMessage() {
    $container = $('#test');
    $container[0].scrollTop = $container[0].scrollHeight;
    var message = $("#messageText").val();
    var author = JSON.parse($.cookie("currentUser")).username;
    stompClient.send("/app/newMessage", {}, JSON.stringify({ "messageSentByUser": "<span style='color:green;'>"+author +" has joined the room.</span>", "userWhoCreatedMessage": "SYSTEM", "timeStamp": formatAMPM(new Date())}));
    $("#messageText").val("")
    $container.animate({ scrollTop: $container[0].scrollHeight }, "slow");
}    


function leaveMessage() {
    $container = $('#test');
    $container[0].scrollTop = $container[0].scrollHeight;
    var message = $("#messageText").val();
    var author = JSON.parse($.cookie("currentUser")).username;
    stompClient.send("/app/newMessage", {}, JSON.stringify({ "messageSentByUser": "<span style='color:orange;'>"+author +" has left the room.</span>", "userWhoCreatedMessage": "SYSTEM", "timeStamp": formatAMPM(new Date())}));
    $("#messageText").val("")
    $container.animate({ scrollTop: $container[0].scrollHeight }, "slow");
}  

function formatAMPM(date) {
	  var hours = date.getHours();
	  var minutes = date.getMinutes();
	  var ampm = hours >= 12 ? 'pm' : 'am';
	  hours = hours % 12;
	  hours = hours ? hours : 12; // the hour '0' should be '12'
	  minutes = minutes < 10 ? '0'+minutes : minutes;
	  var strTime = hours + ':' + minutes + ' ' + ampm;
	  return strTime;
	}
    
    

    
        var stompClient = null;
        function connect() {
            var socket = new SockJS('${pageContext.request.contextPath}/newMessage');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                stompClient.subscribe('/topic/newMessage', function(message){
                	
                    refreshMessages(JSON.parse(JSON.parse(message.body).content));
                    
                });
            });
            
           
//             		 setTimeout(function(){
//                       	joinMessage()},100);
            	
           
            }
        
        
        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
        }
        function refreshMessages(messages) {
            $(".media-list").html("");
            
            $.each(messages, function(i, message) {
            	
            	
            	if (typeof message !=='object' ){
            		var json=JSON.parse(message);
            		$(".media-list").append('<li class="media"><div class="media-body"><div class="media"><div class="media-body">'
                            + json.messageSentByUser + '<br/><small class="text-muted">' + json.userWhoCreatedMessage + ' | ' + json.timeStamp + '</small><hr/></div></div></div></li>');
            	} else{
            		$(".media-list").append('<li class="media"><div class="media-body"><div class="media"><div class="media-body">'
                            + message.messageSentByUser + '<br/><small class="text-muted">' + message.userWhoCreatedMessage + ' | ' + message.timeStamp + '</small><hr/></div></div></div></li>');
                	
            	}
            });
            updateScroll();

        }
        
       
       
        
        $(function(){
            if (JSON.parse($.cookie("currentUser")).username == null) {
            	
                window.location = "${pageContext.request.contextPath}/login"
            } 
            else { 
                connect();
                
                $.getJSON("messages", function (messages) {
                	
                    refreshMessages(messages)
                    
                    
                });
                $("#sendMessage").on("click", function() {
                    sendMessage()
                    
                    
                });
                $('#messageText').keyup(function(e){
                    if(e.keyCode == 13)
                    {
                        sendMessage();
                    }
                });
             } 
            
            
            
            function detectRefresh(){
            	
            	   if(window.opener.title == undefined){
            	 isRefresh = true;
            	 alert("refresh")
            	 
            	   };
            	 
            	
            	 isRefresh = false;
            	 leaveMessage();
            	 alert(isRefresh)
            	 } 
            	 
            
//             window.addEventListener("beforeunload", function (e) {
//            		detectRefresh();
//             	leaveMessage();
//             	});
            
//             window.addEventListener("unload", function (e) {
//            		detectRefresh();
            
//             	});
            
            function sendMessage() {
            	 $container = $('#test');
                 $container[0].scrollTop = $container[0].scrollHeight;
                var message = $("#messageText").val();
                var author = JSON.parse($.cookie("currentUser")).username;
                stompClient.send("/app/newMessage", {}, JSON.stringify({ "messageSentByUser": message, "userWhoCreatedMessage": author, "timeStamp": formatAMPM(new Date())}));
                $("#messageText").val("")
                $container.animate({ scrollTop: $container[0].scrollHeight }, "slow");
            }
        })
    </script>
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
					<form action="joinGame" method="POST">
						<input type="hidden" name="username"
							value="${LoggedInUser.username}">
						<button class="btn btn-primary" type="submit" name="joinGameBtn">
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