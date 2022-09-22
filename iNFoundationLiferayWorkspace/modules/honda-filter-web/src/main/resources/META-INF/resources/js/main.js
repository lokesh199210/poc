


let applyCategoryFilter = categoryId =>{
	
	var currentURL = window.location.href;
	
	currentURL = currentURL + (currentURL.indexOf('?')>=0 ?'&':'?') +'category=' + categoryId;
	
	window.location.href = currentURL;
	
	
};

let applyMtaFilter = model => {
	var currentURL = window.location.href;
	var url = new URL(currentURL);
	
	if(getParamFromURL('mta')){
		url.searchParams.set('mta', model);
		currentURL = url.href;
	}else{
		currentURL = currentURL + (currentURL.indexOf('?')>=0 ?'&':'?') +'mta=' + model;
	}
	
	window.location.href = currentURL;
		
};

let applyKeywordFilter = model => {
	var currentURL = window.location.href;
	var url = new URL(currentURL);
	
	if(getParamFromURL('q')){
		url.searchParams.set('q', model);
		currentURL = url.href;
	}else{
		currentURL = currentURL + (currentURL.indexOf('?')>=0 ?'&':'?') +'q=' + model;
	}
	
	window.location.href = currentURL;
		
};

let getParamFromURL = param =>{
	var currentURL = window.location.href;
	var url = new URL(currentURL);
	return url.searchParams.get(param);
	
};