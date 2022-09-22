var allowScrolling=true;
var index=0;
var matchedElements=[];
var portlet_namespace ;
var socketProtocol = 'ws://';
var textFile = null;

$(document).ready(function(){
	
	(function(){
		
		if(window.location.protocol === 'https:')
			socketProtocol = 'wss://'

		var element = document.getElementById(portlet_namespace+'genLogFile');
		  
		if(element){
			  
			element.addEventListener('click',event =>{
				  
				logTxt = $('#log-container').html().replace(/<[^>]*>/g,'');
				  
				$('#'+portlet_namespace + 'genLogFile').attr('href',makeTextFile(logTxt));
			});
			  
		}
		
		element = document.getElementById(portlet_namespace+'searchBtn');

		if(element){
			
			element.addEventListener('click',event =>{
				
				//highlight logic
				
				var myHilitor = new Hilitor('log-container');
				myHilitor.apply($('#' + portlet_namespace + 'searchText').val());
				
				//highlight1stinstance & Change its color.
				matchedElements=$('div em');
				$('div em:first').css('background-color','#FF9632');
				$('#log-container').scrollTo($('div em:first'));
				index=0;
			});
		}
		
		if($('.fa.icon-angle-up')){
			//up down logic
			$('.fa.icon-angle-up').on('click',function(e){
				index--;
				if(index<0){
					index=0;
				}
				$('div em').css('background','#FFFF00');
				$('#log-container').scrollTo(matchedElements[index]);
				$(matchedElements[index]).css('background-color','#FF9632');
			});
			
		}
			
		if($('.fa.icon-angle-up')){
			$('.fa.icon-angle-down').on('click',function(e){
				index++;
				if(index>matchedElements.length){
					index=matchedElements.length;
				}
				$('div em').css('background','#FFFF00');
				$('#log-container').scrollTo(matchedElements[index]);
				$(matchedElements[index]).css('background-color','#FF9632');
			});
		}

		
	     
		window.onbeforeunload = function(event){
	        return confirm('Refreshing the page will terminate the session, Are you sure ?');
	    };
		    
	    
	    element = document.getElementById(portlet_namespace+'scrollUnscroll');

	    // Scroll Lock Unlock Logic
	    
		if(element){
			element.addEventListener('click',function(event){
				  
				if(this.textContent.trim()=='Lock ScrollBar'){
					this.textContent='Unlock ScrollBar';
					allowScrolling=false;
				}else{
					this.textContent='Lock ScrollBar';
					allowScrolling=true;
				}
			});
		}
		
	}());

});

//download as txtfile logic 

var makeTextFile =  text => {

	var data = new Blob([text], {type: 'text/plain'});

	// If we are replacing a previously generated file we need to  manually revoke the object URL to avoid memory leaks.
    if (textFile)
    	window.URL.revokeObjectURL(textFile);
    
    textFile = window.URL.createObjectURL(data);

    return textFile;
};

//socket logic 

var wsocket;     

var connect = () =>{
   	  	
	wsocket = new WebSocket(socketProtocol+window.location.host+'/o/echo');
	wsocket.onopen = onOpen;
   	wsocket.onmessage = onMessage;
       	
   	// Disable start
   	$('#'+portlet_namespace+'start').attr('disabled',true);
 };
 
 var onMessage = evt => {
	 $('#log-container').append('<div>'+evt.data+'</div>');
        
	 if(allowScrolling)
    	$('#log-container').animate({scrollTop: $('#log-container').prop('scrollHeight')}, 500);
	 
 };
 
 var onOpen = evt => {
	 
	 var logLevel= $('#'+portlet_namespace+'logLevelDropDown').val();
	 if(!logLevel)
		 logLevel = 'INFO';
	 
	 console.log('logLevel --------->' + logLevel);
	 wsocket.send(logLevel);
   	 console.log('CONNECTED');
   	 
 };
 
 var disconnect = () => {
	 if (wsocket) 
      wsocket.close();
	
	 // Enable start
     $('#'+portlet_namespace+'start').attr('disabled',false);
 };
 
 var getAppropriateLoggers = () =>{
	 
	 disconnect();
     connect();
	 
 };
 
 var clearLogs = () => {
	 $('#log-container').html('');
 };