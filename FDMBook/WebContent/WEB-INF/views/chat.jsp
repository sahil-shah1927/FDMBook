<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <title></title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="scripts/jquery-cookie.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.4.0/jquery.timeago.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.0.0/sockjs.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

    <script>
    
   
    
        var stompClient = null;
        function connect() {
            var socket = new SockJS('/FDMafia/newMessage');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                stompClient.subscribe('/topic/newMessage', function(message){
                	
                    refreshMessages(JSON.parse(JSON.parse(message.body).content));
   
                });
            });
        }
        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
        }
        function refreshMessages(messages) {
            $(".media-list").html("");
            
            for (var i=0; i<messages.length;i++){
            	
            	var message = messages[i];
            	if (typeof message !=='object' ){
            		var json=JSON.parse(message);
            		$(".media-list").append('<li class="media"><div class="media-body"><div class="media"><div class="media-body">'
                            + json.messageSentByUser + '<br/><small class="text-muted">' + json.userWhoCreatedMessage + ' | ' + json.timeStamp + '</small><hr/></div></div></div></li>');
            	} else{
            		$(".media-list").append('<li class="media"><div class="media-body"><div class="media"><div class="media-body">'
                            + message.messageSentByUser + '<br/><small class="text-muted">' + message.userWhoCreatedMessage + ' | ' + message.timeStamp + '</small><hr/></div></div></div></li>');
                	
            	}

            	
            }

        }
        $(function(){
           /*  if (typeof $.cookie("realtime-chat-nickname") === 'undefined') {
            	
                window.location = "/FDMafia/chat"
            } 
            else { */
                connect();
            
                $.getJSON("/FDMafia/messages", function (messages) {
                	
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
            /* } */
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
            
            function joinMessage() {
                $container = $('.media-list');
                $container[0].scrollTop = $container[0].scrollHeight;
                var message = $("#messageText").val();
                var author = $.cookie("realtime-chat-nickname");
                stompClient.send("/app/newMessage", {}, JSON.stringify({ "messageSentByUser": "kishan" +" has join the room.", "userWhoCreatedMessage": "SYSTEM", "timeStamp": formatAMPM(new Date())}));
                $("#messageText").val("")
                $container.animate({ scrollTop: $container[0].scrollHeight }, "slow");
            }
            
            function sendMessage() {
                $container = $('.media-list');
                $container[0].scrollTop = $container[0].scrollHeight;
                var message = $("#messageText").val();
                var author = $.cookie("realtime-chat-nickname");
                stompClient.send("/app/newMessage", {}, JSON.stringify({ "messageSentByUser": message, "userWhoCreatedMessage": message.userWhoCreatedMessage, "timeStamp": formatAMPM(new Date())}));
                $("#messageText").val("")
                $container.animate({ scrollTop: $container[0].scrollHeight }, "slow");
            }
        })
    </script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"/>
    
    <style type="text/css">
        .fixed-panel {
        min-height: 500px;
        max-height: 500px;
        }
        .media-list {
        overflow: scroll;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row " style="padding-top:40px;">
        <h3 class="text-center">Realtime Chat Application with Spring Boot, Websockets, and MongoDB </h3>
        <br/><br/>

        <div class="col-md-12">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <strong><span class="glyphicon glyphicon-list"></span> Chat History</strong>
                </div>
                <div class="panel-body fixed-panel">
                    <ul class="media-list">
                    </ul>
                </div>
                <div class="panel-footer">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Enter Message" id="messageText" autofocus=""/>
                                    <span class="input-group-btn">
                                        <button class="btn btn-info" type="button" id="sendMessage" name="message">SEND <span class="glyphicon glyphicon-send"></span></button>
                                    </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>