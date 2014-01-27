$(document)
		.ready(
				function() {

					$
							.ajax({
								url : "http://localhost:8080/loyalservice/rest/loyalpoints/retrieveAll",
								type : "GET",
								dataType : "json",
								contentType : "application/json",
								success : function(resp) {
									console.log(resp);
									for (i = 0; i <= resp.LoyalPoints.length; i++) {

										$("#loyalPoints-table > tbody")
												.append(
														"<tr><td>"+resp.LoyalPoints[i].bet+"</td>" +
															"<td>"+resp.LoyalPoints[i].currencyType+"</td>"+
															"<td>"+resp.LoyalPoints[i].loyalPoints+"</td>"+
																"</tr>");

									}

								},
							});
				}); /* End of Script */
