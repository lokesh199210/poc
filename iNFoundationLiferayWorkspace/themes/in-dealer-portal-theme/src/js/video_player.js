
function createSettings(entry_id){
	
	return {
		'targetId': 'video_player',
		'wid': '_2053502',
		'uiconf_id' : 32743792,
		'entry_id' : entry_id,
		'cache_st' : 1631811375
	};
}


function createCloseBtn(){
	
/*  var node = document.createElement('div'); 
	node.id = 'close_video_btn';	
	var textnode = document.createTextNode('Close');         
	node.appendChild(textnode);                              
	document.getElementById('video_player').appendChild(node);  */
	
}

$(document).ready(() => {
	
	var videoElements = document.querySelectorAll('.play-video');

	if(videoElements){
		videoElements.forEach( function(element){
			
			if(element){
					
				var entryId = element.dataset.entryid;
			
				
				
				var videoURL = element.dataset.videourl;
				
				console.log('Video URL for  video player -->' + videoURL);
				
				if(entryId || videoURL){
					
					element.addEventListener('click',function(){
					
						if(entryId){
							var settings = createSettings(entryId);
							
							console.log('Entry id video player -->' + entryId);
				
							console.log('Settings for video player -->' + settings);
							
							kWidget.embed(settings);
						}else{
							document.getElementById('video_player').src = videoURL;
						}
				
						document.getElementById('video_player').style.display = 'block';
						
						$('body').addClass('modal-open');
						$(".v_player").css("display", "block");
						
						setTimeout(function(){
							
							createCloseBtn();
						
							var videoCloseBtn = document.getElementById('close_video_btn');
							
							if(videoCloseBtn){
								videoCloseBtn.addEventListener('click',function(){
									document.getElementById('video_player').style.display = 'none';
									$('body').removeClass('modal-open');									
									$(".v_player").css("display", "none");		
									kWidget.destroy('video_player');
									
								});
								
							}
							
						},1200);
				
					});
					
				}
				
			}
			
		});
	}
});




