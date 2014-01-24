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
					
					$.ajax({
						url : "http://localhost:8080/LoyalService/rest/level/retrieve/"+getJsonFromUrl(),
						type : "GET",
						dataType : "json",
						data : JsonData,
						contentType : "application/json",
						success : function(resp) {
							var name = resp.Data.name;
							$("#name").val(levelNumber);

							var providerID = resp.Data.providerID;
							$("#provider-select").val(providerID);

							var description = resp.Data.description;
							$("#description").val(description);
							var levelPoints = resp.Data.levelPoints;
							$("#level_number").val(levelPoints);

						}
					/*
					 * error:function(resp){ alert("Error while trying to create Level"); }
					 */

					});


					$("#ss-submitLoyalGifts")
							.on(
									"click",
									function(e) {
										
										alert("click activated");
										var obj = {};
										obj["name"] = $("#loyalGift_name")
												.val();
										obj["description"] = $(
												"#level-desc").val();
										obj["levelPoints"] = $("#level-points")
												.val();

										var JsonData = JSON.stringify(obj);
										alert(JsonData);

										$
												.ajax({
													url : "http://localhost:8080/LoyalService/rest/loyalgifts/update",
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