$(document)
		.ready(
				function() {
					var providerSelect = $(".provider-select");
					var providerSelectOptions = providerSelect
							.append("<option value='ALL' selected='selected'></option>"
									+ "<option value='ALL'>ALL</option>"
									+ "<option value='1'>Provider 1</option>"
									+ "<option value='2'>Provider 2</option>"
									+ "<option value='3'>Provider 3</option>");
					
					$.ajax({
						url : "http://localhost:8080/LoyalService/rest/level/retrieve/"+getJsonFromUrl(),
						type : "GET",
						dataType : "json",
						data : JsonData,
						contentType : "application/json",
						success : function(resp) {
							var name = resp.Data.name;
							$("#badge-name").val(name);

							var image = resp.Data.image;
							$("#badge-photo").val(image);

							var description = resp.Data.description;
							$("#badge-description").val(description);
							var badgeGift = resp.Data.gift;
							$("#badge-gift").val(badgeGift);

						}
					});


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
				});