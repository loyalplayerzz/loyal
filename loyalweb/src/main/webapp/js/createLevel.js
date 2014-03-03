$(document).ready(function(){
	
	$("#ss-submit").on("click", function(e){
	var obj = {};
	obj["levelID"]= $("#level_id").val();
	obj["description"]=$("#description").val();
	obj["levelPoints"]=$("#level_number").val();
	obj["image"] = $("#level-image").val();
	var JsonData = JSON.stringify(obj);
	
	$.ajax({
		url: getHostURL()+"/level/create",
		type:"POST",
		dataType:"json",
		data: JsonData,
		contentType:"application/json",
		success: function(resp){
			window.location.href = "level.html";
		},
		/*error:function(resp){
			alert("Error while trying to create Level");
		}*/
		
	});
	
	window.location.href = "level.html";
	
	});
	
});												/*End of Script*/											

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