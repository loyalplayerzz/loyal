$(document)
		.ready(
				function() {
					badgeName = "";
					badgeDescription = "";
					gift = "";
					algo = "";

					getJsonFromUrl();
					var providerSelect = $(".provider-select");
					var providerSelectOptions = providerSelect
							.append("<option value='ALL' selected='selected'></option>"
									+ "<option value='ALL'>ALL</option>"
									+ "<option value='1'>Provider 1</option>"
									+ "<option value='2'>Provider 2</option>"
									+ "<option value='3'>Provider 3</option>");

					var algoSelect = $(".algorithm");
					var algoSelectOptions = algoSelect
							.append("<option value='1'>Algo 1</option>"
									+ "<option value='2'>Algo 2</option>");

					var algoSelect = $(".badge-gift");
					var algoSelectOptions = algoSelect
							.append("<option value='1'>Badge 1</option>"
									+ "<option value='2'>Badge 2</option>");

					$("#ss-BadgeNext").on(
							"click",
							function(e) {
								var badgeName = $("#badge-name").val();
								var badgeDescription = $("#badge-description")
										.val();
								var gift = $("#badge-gift").val();
								var algo = $("#algorithm").val();
								var link = "";

								if (algo == 1) {
									link = "createBadge2.html";
								} else if (algo == 2) {
									link = "createBadge3.html";
								}

								window.location.href = link + "?badgeName="
										+ badgeName + "&badgeDescription="
										+ badgeDescription + "&gift=" + gift
										+ "&algo=" + algo;
							});

					$("#ss-submitBadge")
							.on(
									"click",
									function(e) {
										var obj = {};
										obj["badge-name"] = $("#badge-name")
												.val();
										obj["badge-description"] = $(
												"#badge-description").val();
										obj["bet"] = $("#loyalpoints-bet")
												.val();

										var JsonData = JSON.stringify(obj);
										alert(JsonData);

										$
												.ajax({
													url : "http://localhost:8080/LoyalService/rest/loyalpoints/create",
													type : "POST",
													dataType : "json",
													data : JsonData,
													contentType : "application/json",
													success : function(resp) {
														window.location.href = "loyalPoints.html";
													},
												});

										$
												.ajax({
													url : "http://localhost:8080/LoyalService/rest/loyalpoints/create",
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

					$("#ss-submitBadge3")
							.on(
									"click",
									function(e) {
										var obj = {};
										obj["badge-name"] = $("#badge-name")
												.val();
										obj["badge-description"] = $(
												"#badge-description").val();
										obj["bet"] = $("#loyalpoints-bet")
												.val();

										var JsonData = JSON.stringify(obj);
										alert(JsonData);

										$
												.ajax({
													url : "http://localhost:8080/LoyalService/rest/loyalpoints/create",
													type : "POST",
													dataType : "json",
													data : JsonData,
													contentType : "application/json",
													success : function(resp) {
														window.location.href = "loyalPoints.html";
													},
												});

										$
												.ajax({
													url : "http://localhost:8080/LoyalService/rest/loyalpoints/create",
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

function getJsonFromUrl() {

	var query = location.search.substr(1);
	var data = query.split("&");
	var result = {};
	for ( var i = 0; i < data.length; i++) {
		var item = data[i].split("=");
		if (item[0] == "badgeName") {
			badgeName = item[1];
		} else if (item[0] == "badgeDescription") {
			badgeDescription = item[1];
		} else if (item[0] == "gift") {
			gift = item[1];
		} else if (item[0] == "algo") {
			algo = item[1];
		}
	}
	return result;
}
