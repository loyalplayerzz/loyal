$(document).ready(function() {
	$.ajax({
		url : getHostURL()+"/player/retrieve/"+getJsonFromUrl(),
		type : "GET",
		dataType : "json",
		//data : JsonData,
		contentType : "application/json",
		success : function(resp) {
			var user_id = resp.Player.userID;
			$("#user_id").val(user_id);

			var player_name = resp.Player.playerName;
			$("#player_name").val(player_name);

			var level = resp.Player.level;
			$("#level").val(level);
			
			var level_awarded_date = resp.Player.levelAwardedDate;
			$("#level_awarded_date").val(level_awarded_date);
			
			var loyal_points = resp.Player.loyalPoints;
			$("#loyal_points").val(loyal_points);
			
			var loyalPointsAwardedDate = resp.Player.loyalPointsAwardedDate;
			$("#loyalpoints_awarded_date").val(loyalPointsAwardedDate);

		}
	/*
	 * error:function(resp){ alert("Error while trying to create Level"); }
	 */

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