'use strict';
 
var App = angular.module('myApp',[]);


//$(document).ready(
//		function() {
//			$("#addTeamSubmit").click(function(){
//				var json = {
//						name : $("#addTeamName").val(),
//						city : $("#addTeamCity").val()
//				}
//				$.ajax({
//					type : "POST",
//					headers : {
//						'Accept' : 'application/json',
//						'Content-Type' : 'application/json'
//					},
//					url : "/wnycl/addNewTeam",
//					data : JSON.stringify(json),
//					dataType : "json",
//					timeout : 600000,
//					success : function(data) {
//						console.log(data);
//					},
//					error : function(e) {
//						console.log(e);
//					}
//				});
//				return false;
//			});
//			$(".teamMenuItem").click(
//					function() {
//						var json = {
//							tid : $(this).attr("id")
//						};
//						$.ajax({
//							type : "POST",
//							headers : {
//								'Accept' : 'application/json',
//								'Content-Type' : 'application/json'
//							},
//							url : "/wnycl/teaminfo",
//							data : JSON.stringify(json),
//							dataType : "json",
//							timeout : 600000,
//							success : function(data) {
//								var players = data;
//								$("#teamViewBody")[0].innerHTML = "";
//								$("#teamViewName")[0].innerHTML = players[0].teamname;
//								for (var i = 1; i < players.length; i++) {
//									var row = "<tr>" + "<td>"
//											+ players[i].firstname + "</tg>"
//											+ "<td>" + players[i].lastname
//											+ "</td>" + "<td>" + players[i].dob
//											+ "</td>" + "<td>"
//											+ players[i].email + "</td>"
//											+ "<td>" + players[i].phone
//											+ "</td>" + "</tr>";
//									$("#teamViewBody").append(row);
//								}
//								$(".teamView").show();
//
//							},
//							error : function(e) {
//								console.log(e);
//							}
//						});
//					});
//		});