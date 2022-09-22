/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

/*
 * This function gets loaded when all the HTML, not including the portlets, is
 * loaded.
 */
AUI().ready(function () {});

/*
 * This function gets loaded after each and every portlet on the page.
 *
 * portletId: the current portlet's id
 * node: the Alloy Node object of the current portlet
 */
Liferay.Portlet.ready(function (_portletId, _node) {});

/*
 * This function gets loaded when everything, including the portlets, is on
 * the page.
 */
Liferay.on('allPortletsReady', function () {});

$(document).ready(function(){
	if(self === top){
		$('.control-menu-container').show();
	}else {
		$('.control-menu-container').hide();
	}
});

$(".btn_back").click(function() {
	$("html").animate({ scrollTop: 0 }, "slow");
});

function changeName(){
	if($("#collapseButton").html()=="View Less"){
		$("#collapseButton").html("View More");
		$(".btn.btn_custom.view_more_less").css("background-image", "url('/o/in-dealer-portal-theme/images/icons/arrow-down.svg')");
	}
	else{
		$("#collapseButton").html("View Less");
		$(".btn.btn_custom.view_more_less").css("background-image", "url('/o/in-dealer-portal-theme/images/icons/arrow-up-black.svg')");
	}
}