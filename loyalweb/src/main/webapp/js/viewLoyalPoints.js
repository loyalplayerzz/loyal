$(document)
		.ready(
				function() {

					$
							.ajax({
								url : getHostURL() + "/loyalpoints/retrieveAll",
								type : "GET",
								dataType : "json",
								contentType : "application/json",
								success : function(resp) {
									console.log(resp);
									for (i = 0; i < resp.LoyalPoints.length; i++) {
										var loyalPointsKey = resp.LoyalPoints[i].loyalPointsID;
										var editURL = "/loyalweb/editLoyalPoints.html?loyalPointsID="+loyalPointsKey
										$("#loyalPoints-table > tbody")
												.append(
														"<tr><td><a href = "+editURL+"> "+resp.LoyalPoints[i].bet+"</a></td>" +
															"<td>"+resp.LoyalPoints[i].currencyType+"</td>"+
															"<td>"+resp.LoyalPoints[i].loyalPoints+"</td>"+
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