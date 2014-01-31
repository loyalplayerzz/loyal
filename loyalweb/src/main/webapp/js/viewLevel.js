$(document)
		.ready(
				function() {

					var obj = {};
					obj["levelID"] = $("#level_id").val();
					obj["descriptionEn"] = $("#desc_en").val();
					obj["descriptionSV"] = $("#desc_sv").val();
					obj["levelPoints"] = $("#level_number").val();
					obj["image"] = "true";
					var JsonData = JSON.stringify(obj);

					$
							.ajax({
								url : "http://localhost:8080/loyalservice/rest/level/retrieveAll",
								type : "GET",
								dataType : "json",
								contentType : "application/json",
								success : function(resp) {
									console.log(resp);
									for (i = 0; i < resp.Level.length; i++) {
										var levelKey = resp.Level[i].levelID;
										var editURL = "/loyalweb/editLevel.html?levelID="+levelKey
										
										$("#level-table > tbody")
												.append(
														"<tr><td><a href = "+editURL+"> "+levelKey+"</a></td>" +
															"<td>"+resp.Level[i].levelPoints+"</td>"+
															"<td>0</td>"+
															"<td>"+resp.Level[i].description+"</td>"+
																"</tr>");

									}

								},
							});
				}); /* End of Script */
