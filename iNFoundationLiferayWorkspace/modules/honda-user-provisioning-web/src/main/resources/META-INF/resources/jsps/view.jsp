<%@ include file="init.jsp" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<section class="container-fluid">
	<div class="container-admin">
		<div class="user-setup-card">
			<div class="top-label-heading">
				USER SETUP FORM
			</div>
			<div class="p-4"> 
				<div class="row">
					<div class="col-md-8">
						<form method="post" action="<%=userProvisioningActionURL%>" id="userSetupForm">
							<div class="mt-3 border-bottoms">
								<div class="">
									<label class="user-label"> User ID </label>
								</div>
								<div class="d-flex">	
									<input class="user-input" type="text" id="userId" name="userId" placeholder="Enter User ID">
									<input type="button" class="btn ml-md-4 btn_light" value="Authenticate" onclick="authenticateUser();">
								</div>
							</div>
							<div class="mt-3">
								<div class="">
									<label class="user-label"> First Name </label>
								</div>
								<div class="">	
									<input class="user-input" type="text" id="firstName" name="firstName" readonly>
								</div>
							</div>
							<div class="mt-3">
								<div class="">
									<label class="user-label"> Last Name </label>
								</div>
								<div class="">	
									<input class="user-input" type="text" id="lastName" name="lastName" readonly>
								</div>
							</div>						
							<div class="mt-3">
								<div class="">
									<label class="user-label"> Email ID </label>
								</div>
								<div class="">	
									<input class="user-input" type="text" id="emailId" name="emailId">
								</div>
							</div>						
							<div class="mt-3">
								<div class="">	
									<label class="user-label"> Job Title </label>
								</div>	
								<div class="">	
									<input class="user-input" type="text" id="jobTitle" name="jobTitle" readonly>
								</div>
							</div>						
							<div class="mt-3">
								<div class="">
									<label class="user-label"> Division </label>
								</div>
								<div class="">	
									<input class="user-input" type="text" id="division" name="division" readonly>
								</div>
							</div>							
							<div class="mt-3">
								<div class="">
									<label class="user-label"> Department </label>
								</div>
								<div class="">	
									<input class="user-input" type="text" id="department" name="department" readonly>
								</div>
							</div>							
							<div class="mt-3 text-right">
								<span class="">
					        		<input type="button" class="btn btn_light" value="Cancel" onclick="cancel();">  
					      		</span>
					      		<span class="">
					        		<button type="submit" class="btn btn_cmp btn ml-3"> Complete Setup </button>
					      		</span>
							</div>
						</form>
					</div>
					<div class="col-md-4">
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
	
	
<script>
var userProvisionResourceURL = '${userProvisioningResourceURL}';

function authenticateUser() {
	console.log("Inside authenticateUser method !!");
	
	var userId = $("#userId").val();
	console.log("User Id entered by User is " + userId);
	
	$.ajax ({
		url: userProvisionResourceURL,  
		method: "POST",
		dataType: 'text',
		data: {
			userId: userId,             
		},
		
		success: function(data) {																
			console.log("In Success of authenticateUser method !!");     
			
			console.log("JSON Object received is " + data);
			
			var json = data; 
			var obj = JSON.parse(json);
			
			$("#firstName").val(obj.firstName);
			$("#lastName").val(obj.lastName);
			$("#emailId").val(obj.emailId);
			$("#jobTitle").val(obj.jobTitle);
			$("#division").val(obj.division);
			$("#department").val(obj.department);
		},
		failure: function() {
			console.log("In Error of authenticateUser method !!");	
		}	
	});	
}

function cancel() {
	console.log("Inside cancel method !!");
	document.getElementById("userSetupForm").reset();
}
</script>
	
			
		