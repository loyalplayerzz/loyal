$(document)
		.ready(
				function() {

					var obj = {};
					obj["name"] = $("#level_id").val();
					obj["giftType"] = $("#desc_en").val();
					obj["description"] = $("#desc_sv").val();
					obj["levelPoints"] = $("#level_number").val();
					obj["image"] = "true";
					var JsonData = JSON.stringify(obj);

					$
							.ajax({
								url : getHostURL+"/loyalgift/retrieveAll",
								type : "GET",
								dataType : "json",
								contentType : "application/json",
								success : function(resp) {
									console.log(resp);
									for (i = 0; i < resp.Level.length; i++) {
										var loyalgiftID = resp.LoyalGifts[i].id;
										var editURL = "/loyalweb/editLoyalGifts.html?loyalGiftID="+loyalgiftID;
										
										$("#level-table > tbody")
												.append(
														"<tr><td><a href = "+editURL+"> "+resp.LoyalGifts[i].name+"</a></td>" +
															"<td>"+resp.LoyalGifts[i].giftType+"</td>"+
															"<td>"+resp.LoyalGifts[i].description+"</td>"+
															"<td>"+resp.LoyalGifts[i].levelPoints+"</td>"+
															"<td>"+resp.LoyalGifts[i].image+"</td>"+
															"<td>"+resp.LoyalGifts[i].levelPoints+"</td>"+
																"</tr>");

									}

								},
							});
				}); /* End of Script */

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