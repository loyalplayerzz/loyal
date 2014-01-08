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
										obj["levelNumber"] = $("#level_number")
												.val();
										obj["description"] = $(
												"#level-desc").val();
										obj["levelPoints"] = $("#level-points")
												.val();

										var JsonData = JSON.stringify(obj);
										alert(JsonData);

										$
												.ajax({
													url : "http://localhost:8080/LoyalService/rest/loyalgifts/create",
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