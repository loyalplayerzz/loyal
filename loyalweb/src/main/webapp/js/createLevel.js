$(document).ready(function(){
	
	$("#ss-submit").on("click", function(e){
	var obj = {};
	obj["levelID"]= $("#level_id").val();
	obj["descriptionEn"]=$("#desc_en").val();
	obj["descriptionSV"]=$("#desc_sv").val();
	obj["levelPoints"]=$("#level_number").val();
	obj["image"] = $("#level-image").val();
	var JsonData = JSON.stringify(obj);
	
	$.ajax({
		url: "http://localhost:8080/LoyalService/rest/level/create",
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
