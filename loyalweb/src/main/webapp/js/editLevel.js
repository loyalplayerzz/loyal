$(document).ready(function() {
	$.ajax({
		url : "http://localhost:8080/loyalservice/rest/level/retrieve/"+getJsonFromUrl(),
		type : "GET",
		dataType : "json",
		//data : JsonData,
		contentType : "application/json",
		success : function(resp) {
			var levelID = resp.Level.levelID;
			$("#level_id").val(levelID);

			var providerID = resp.Level.providerID;
			$("#provider-select").val(providerID);

			var description = resp.Level.description;
			$("#description").val(description);
			var levelPoints = resp.Level.levelPoints;
			$("#level_number").val(levelPoints);

		}
	/*
	 * error:function(resp){ alert("Error while trying to create Level"); }
	 */

	});

	$("#ss-submit").on("click", function(e) {
		var obj = {};
		obj["levelID"] = $("#level_id").val();
		obj["description"] = $("#description").val();
		obj["levelPoints"] = $("#level_number").val();
		obj["image"] = $("#level-image").val();
		var JsonData = JSON.stringify(obj);

		$.ajax({
			url : getHostURL()+"/level/update",
			type : "PUT",
			dataType : "json",
			data : JsonData,
			contentType : "application/json",
			success : function(resp) {
				window.location.href = "level.html";
			},
		});
		window.location.href = "level.html";
	});
});

/* End of Script */

function getJsonFromUrl() {

	var query = location.search.substr(1);
	var data = query.split("&");
	//var result = {};
	for ( var i = 0; i < data.length; i++) {
		var item = data[i].split("=");
		if (item[0] == "levelID") {
			levelName = item[1];
		}
	}
	return levelName;
}

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