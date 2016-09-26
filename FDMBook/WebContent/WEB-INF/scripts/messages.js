

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
            var socket = new SockJS('/FDMBook/newMessage');
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
            	
                window.location = "/FDMBook/login"
            } 
            else { 
                connect();
                
                $.getJSON("messages", function (messages) {
                	
                    refreshMessages(messages)
                    
                    
                });
                
                var submitButton = $('#joinButton');
                if(typeof $.cookie("role")!=='undefined'){
					submitButton.prop("disabled", true);
					}
                
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
          
            $(function() {
            	
				$('form#joinForm').on('submit', function(e) {
					$.post('joinGame', $(this).serialize(), function(data) {

					}).error(function() {

					});
					
					
						
	                	  

						  
								submitButton.prop("disabled", true);
								joinGame();
								alert($.cookie("role"));
							
				     
					
				
					e.preventDefault();
				});
			});
            
           
            
            
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
            
            function joinGame() {
           	 $container = $('#test');
                $container[0].scrollTop = $container[0].scrollHeight;
               var author = JSON.parse($.cookie("currentUser")).username;
               stompClient.send("/app/newMessage", {}, JSON.stringify({ "messageSentByUser": "<span style='color:green;'>"+author +" has joined the game.</span>", "userWhoCreatedMessage": "SYSTEM", "timeStamp": formatAMPM(new Date())}));
               $container.animate({ scrollTop: $container[0].scrollHeight }, "slow");
           }
            
           
            
        })
        