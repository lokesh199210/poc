<%


String ddmStructureName = journalEditArticleDisplayContext.getDDMStructure().getName(locale);

System.out.println("ddmStructureName---------------->"+ddmStructureName);

%>


<script>

var inputs, index;
var videoValueElement ;
var titleElement ;
var dateElement ;
var lastDateElement ;
var isValid = true;
inputs = document.getElementsByTagName('input');
for (index = 0; index < inputs.length; ++index) {
	if((inputs[index].id).indexOf('<portlet:namespace />videoValue') >= 0){
		videoValueElement = inputs[index];
	}else if((inputs[index].id).indexOf('<portlet:namespace />title') >= 0){
		titleElement = inputs[index];
	}else if((inputs[index].id).indexOf('<portlet:namespace />date') >= 0 && ((inputs[index].id).indexOf('Day') < 0 && 
			(inputs[index].id).indexOf('Month') < 0 && (inputs[index].id).indexOf('Year') < 0)){
		dateElement = inputs[index];
	}else if((inputs[index].id).indexOf('<portlet:namespace />date') >= 0){
		lastDateElement = inputs[index];
	}else if((inputs[index].id).indexOf('<portlet:namespace />videoSelection') >= 0 ){
		if(inputs[index]){
			inputs[index].addEventListener('click',function(){
				console.log(this.value);
				validateVideoValue(videoValueElement);
				if(isValid)
					validateDateValue(dateElement);
				
				if(isValid)
					validateTitleValue(titleElement);
				
				if(this.value === 'noVideo'){
					videoValueElement.value = '';
					if(isValid)
						enableAllButtons();
				}
			});
		};
	}
}

var disableAllButtons = () => {
	document.querySelectorAll('button').forEach(elem => {
	  	elem.disabled = true;
	});
};

var enableAllButtons = () => {
	document.querySelectorAll('button').forEach(elem => {
	  	elem.disabled = false;
	});
};

var createErrorMsgDiv = (element,errorMsg) => {
	
	var parent = element.parentElement;
	
	if(parent.classList.contains('has-success'))
		parent.classList.remove('has-success');
	
	parent.classList.add('has-error');
	var node = document.createElement('div');
	node.className = 'form-validator-stack help-block';
	
	var node2 = document.createElement('div');
	node2.className = 'required';
	
	var textnode = document.createTextNode(errorMsg); 
	node2.appendChild(textnode);        // Create a text node
	node.appendChild(node2);  
	
	parent.appendChild(node);
	
	element.classList.add('error-field');
	
};

var createDateErrorMsgDiv = (element,errorMsg) => {
	
	var parent = element.parentElement;
	var rootParent = parent.parentElement;
	
	if(rootParent.classList.contains('has-success'))
		rootParent.classList.remove('has-success');
	
	rootParent.classList.add('has-error');
	
	var node = document.createElement('div');
	node.className = 'form-validator-stack help-block';
	
	var node2 = document.createElement('div');
	node2.className = 'required';
	
	var textnode = document.createTextNode(errorMsg); 
	node2.appendChild(textnode);        // Create a text node
	node.appendChild(node2);  
	
	parent.appendChild(node);
	
	element.classList.add('error-field');
	
};

var removeErrorMsgDiv = element => {
	
	if(element.nextElementSibling)
		element.nextElementSibling.remove();
	
	if(element && element.classList.contains('error-field'))
		element.classList.remove('error-field');
	
	if(element.parentElement && element.parentElement.classList.contains('has-error'))
		element.parentElement.classList.remove('has-error');
	
};

var removeDateErrorMsgDiv = element => {
	
	if(element.nextElementSibling)
		element.nextElementSibling.remove();
	
	if(element && element.classList.contains('error-field'))
		element.classList.remove('error-field');
	
	if(element.parentElement.parentElement && element.parentElement.parentElement.classList.contains('has-error'))
		element.parentElement.classList.remove('has-error');
	
};

if(dateElement){
	dateElement.addEventListener('focusout',()=>{
		
		setTimeout(()=>{
			validateDateValue(dateElement);
			if(isValid)
				validateVideoValue(videoValueElement);	
			
			if(isValid)
				validateTitleValue(titleElement);
		},600);
		
	});
}

if(videoValueElement){
	videoValueElement.addEventListener('change',()=>{
		validateVideoValue(videoValueElement);
		if(isValid)
			validateDateValue(dateElement);
		
		if(isValid)
			validateTitleValue(titleElement);
	});
};

var validateDateValue = dateElement => {
	isValid = true;
	removeDateErrorMsgDiv(lastDateElement);
	var datep = dateElement.value;
	console.log(datep);
	var todayDate = new Date();
	var inputDate = new Date(datep);
	
	if(inputDate.setHours(0,0,0,0) !== todayDate.setHours(0,0,0,0)){
		if((Date.parse(datep)-Date.parse(todayDate))<0){
			disableAllButtons();
			createDateErrorMsgDiv(dateElement,'Publish date cannot be past date.');
			isValid = !isValid;
		}else {
			if(isValid)
				enableAllButtons();
		}
	}
	
};

var validateVideoValue = videoValueElement => {
	isValid = true;
	var videoSelectionCheckBox ;
	removeErrorMsgDiv(videoValueElement);
	for (index = 0; index < inputs.length; ++index) {
		if((inputs[index].id).indexOf('<portlet:namespace />videoSelection') >= 0 && inputs[index].checked){
			videoSelectionCheckBox = inputs[index];
		}
	}
	
	if(videoSelectionCheckBox.value === 'videoId'){
		validatrKalturaId(videoValueElement);
	}else if(videoSelectionCheckBox.value === 'videoURL'){
		isValidHttpUrl(videoValueElement);
	}
};

var validateTitleValue = titleELement => {
	isValid = true;
	removeErrorMsgDiv(titleELement);
	var format = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
	
	if(format.test(titleELement.value)){
		setTimeout(()=>{
			disableAllButtons();
			createErrorMsgDiv(titleELement,'Please enter valid title');
			isValid = !isValid;
		},600);
		
	}else {
		if(isValid)
			enableAllButtons();
	}
	
};

if(titleElement){
	titleElement.addEventListener('keypress',event => {
   		var regex = new RegExp('^[a-zA-Z0-9 ]+$');
    	var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    	if (!regex.test(key)) {
       		event.preventDefault();
       		return false;
    	}
	});
	
	titleElement.addEventListener('change',event => {
		validateTitleValue(titleElement);

		if(isValid)
			validateVideoValue(videoValueElement);
		
		if(isValid)
			validateDateValue(dateElement);
		
	});
	
};

var isValidHttpUrl = videoValueElement => {
	var str = videoValueElement.value;
	var response = str.match(/(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)/g);
  	isValid = true;
  	if(response){
    	 if(isValid)
 			enableAllButtons();
  	}else{
  		disableAllButtons();
  		createErrorMsgDiv(videoValueElement,'Please enter valid video URL');
    	isValid = !isValid	
  	}
};

var validatrKalturaId = videoValueElement =>{
	
	var videoId = videoValueElement.value;
	isValid = true;
	
	if(!videoId){
		disableAllButtons();
		createErrorMsgDiv(videoValueElement,'Please enter valid video id')
		isValid = !isValid;
	}else{
		var url = 'http://staging.media.services.honda.com/GetVideoDetails.ashx?partnerID=2053502&entryname='+videoId+'&ReturnType=JSON';

		fetch(url,{
			method: 'POST',
		}).then(response => response.json())
		.then(json => {
			if(!json || !(json.xml.result.objects)){
				disableAllButtons();
				createErrorMsgDiv(videoValueElement,'Please enter valid video id');
				isValid = !isValid;
			}else{
				 if(isValid)
					enableAllButtons();
			}	
		});
		
	}
	
};



</script>


