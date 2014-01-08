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
								url : "http://localhost:8080/LoyalService/rest/level/retrieveAll",
								type : "GET",
								dataType : "json",
								contentType : "application/json",
								success : function(resp) {
									console.log(resp);
									for (i = 0; i <= resp.Level.length; i++) {

										$("#level-table > tbody")
												.append(
														"<tr><td>"+resp.Level[i].levelID+"</td>" +
															"<td>"+resp.Level[i].levelPoints+"</td>"+
															"<td>0</td>"+
															"<td>"+resp.Level[i].descriptionEn+"</td>"+
																"</tr>");

									}

								},
							});
				}); /* End of Script */
