$(document)
		.ready(
				function() {

					var secQuestionsSelect = $(".loyalpoints-currency");
					var secQuestionsOptions = secQuestionsSelect
							.append("<option value='SEK Swedish crowns' selected='selected'></option>"
									+ "<option value='ARS'>ARS Argentinian pesos</option>"
									+ "<option value='AUD'>AUD Australian dollars</option>"
									+ "<option value='BRL'>BRL Brazillian Real</option>"
									+ "<option value='BGN'>BGN Bulgarian lev</option>"
									+ "<option value='CHF'>CHF Swiss francs</option>"
									+ "<option value='CNY'>CNY Chinese renminbi</option>"
									+ "<option value='CZK'>CZK Czech crowns</option>"
									+ "<option value='DKK'>DKK Danish crowns</option>"
									+ "<option value='EEK'>EEK Estonian crowns</option>"
									+ "<option value='EUR'>EUR Euro</option>"
									+ "<option value='GBP'>GBP British pounds</option>"
									+ "<option value='HKD'>HKD Hong Kong dollars</option>"
									+ "<option value='HRK'>HRK Croatian kune</option>"
									+ "<option value='LTL'>LTL Lithuanian litas</option>"
									+ "<option value='LVL'>LVL Latvian lats</option>"
									+ "<option value='NOK'>NOK Norwegian crowns</option>"
									+ "<option value='NZD'>NZD New Zealand dollars</option>"
									+ "<option value='PLN'>PLN Polish zloty</option>"
									+ "<option value='RON'>RON Romanian leu</option>"
									+ "<option value='SEK'>SEK Swedish crowns</option>"
									+ "<option value='SGD'>SGD Singapore dollars</option>"
									+ "<option value='TRY'>TRY Turkish lira</option>"
									+ "<option value='UAH'>UAH Ukraine hrynjas</option>"
									+ "<option value='USD'>USD US dollars</option>"
									+ "<option value='ZAR'>ZAR South African rands</option>");
					
					$
					.ajax({
						url : "http://localhost:8080/LoyalService/rest/loyalpoints/retrieveAll",
						type : "GET",
						dataType : "json",
						contentType : "application/json",
						success : function(resp) {
							console.log(resp);
							var loyalpoints = obj["loyalPoints"];
							$("#loyalpoints-loyal").val(loyalpoints);
							
							var currencyType = obj["currencyType"];
							$("#loyalpoints-currency").val(currencyType);
							
							var bet = obj["bet"];
							$("##loyalpoints-bet").val(bet);
						},
					});

					$("#ss-submitLoyalPoints")
							.on(
									"click",
									function(e) {
										var obj = {};
										obj["loyalPoints"] = $("#loyalpoints-loyal")
												.val();
										obj["currencyType"] = $(
												"#loyalpoints-currency").val();
										obj["bet"] = $("#loyalpoints-bet")
												.val();

										var JsonData = JSON.stringify(obj);
										alert(JsonData);

										$
												.ajax({
													url : "http://localhost:8080/LoyalService/rest/loyalpoints/update",
													type : "PUT",
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