$(document)
		.ready(
				function() {
					var levelSelect = $(".level-option");
					var levelSelectList = levelSelect
							.append("<option value='1' selected='selected'></option>"
									+ "<option value='1'>Level 1</option>"
									+ "<option value='2'>Level 2</option>"
									+ "<option value='3'>Level 3</option>"
									+ "<option value='4'>Level 4</option>"
									+ "<option value='5'>Level 5</option>");

					$("#ss-submitLoyalGifts")
							.on(
									"click",
									function(e) {
										
										alert("click activated");
										var obj = {};
										obj["name"] = $("#name")
												.val();
										obj["description"] = $(
												"#level-desc").val();
										obj["levelPoints"] = $("#level-points")
												.val();

										var JsonData = JSON.stringify(obj);
										alert(JsonData);

										$
												.ajax({
													url : getHostURL()+"/loyalgifts/create",
													type : "POST",
													dataType : "json",
													data : JsonData,
													contentType : "application/json",
													success : function(resp) {
														window.location.href = "loyalPoints.html";
													},
												});

										window.location.href = "loyalpoints.html";
									});

				});

function getHostURL(){
	var loc = window.location.protocol;
    /*Store the environment host that the application is in*/
    hostUri = window.location.host;

    /*split the path and store in an array*/
    var pathArray = window.location.pathname.split('/');

    /*Retrieve the URI to be passed and store in a variable*/
    var contextURI = pathArray[1];

    /*Following would be the root URL for DEAMockWeb*/
    var restBaseUrl = loc + "//" + hostUri + "/" + "loyalservice/rest";
    
    return restBaseUrl;
}