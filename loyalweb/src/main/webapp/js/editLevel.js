$(document).ready(function() {
	$.ajax({
		url : "http://localhost:8080/LoyalService/rest/level/retrieve/"+getJsonFromUrl(),
		type : "GET",
		dataType : "json",
		data : JsonData,
		contentType : "application/json",
		success : function(resp) {
			var levelID = resp.Data.levelID;
			$("#level_id").val(levelID);

			var providerID = resp.Data.providerID;
			$("#provider-select").val(providerID);

			var description = resp.Data.description;
			$("#description").val(description);
			var levelPoints = resp.Data.levelPoints;
			$("#level_number").val(levelPoints);

		},
	/*
	 * error:function(resp){ alert("Error while trying to create Level"); }
	 */

	});

	$("#ss-submit").on("click", function(e) {
		var obj = {};
		obj["levelID"] = $("#level_id").val();
		obj["descriptionEn"] = $("#desc_en").val();
		obj["descriptionSV"] = $("#desc_sv").val();
		obj["levelPoints"] = $("#level_number").val();
		obj["image"] = $("#level-image").val();
		var JsonData = JSON.stringify(obj);

		$.ajax({
			url : "http://localhost:8080/LoyalService/rest/level/update",
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
	var result = {};
	for ( var i = 0; i < data.length; i++) {
		var item = data[i].split("=");
		if (item[0] == "levelID") {
			badgeName = item[1];
		}
	}
	return result;
}