<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>WNY Cricket League</title>

<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">

<!-- Optional theme -->
<link rel="stylesheet"
	href="<c:url value='/css/bootstrap-theme.min.css'/>">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="collapse navbar-collapse">
			<ul class="nav nav-tabs navbar-left">
				<li role="presentation" class="active"><a href="#">Home</a></li>
				<li role="presentation" class="dropdown"><a
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false"> Teams <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<c:forEach items="${teams}" var="team">
							<li><a class="teamMenuItem" id="${team.teamid }" href="#">${team.name}</a></li>
						</c:forEach>

					</ul></li>
				<li role="presentation"><a href="#">Tournament</a></li>
				<li role="presentation"><a href="#">Gallery</a></li>
				<li role="presentation"><a href="#">News</a></li>
				<li role="presentation"><a href="#">About Us</a></li>

			</ul>

			<ul class="nav navbar-nav navbar-right">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><b>Login</b></a></li>
			</ul>
		</div>

	</div>

	<div class="teamView" style="display:none;">
		<table class="table" >
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>dob</th>
					<th>email</th>
					<th>phone</th>
				</tr>
			</thead>
			<tbody id="teamViewBody">
				
			</tbody>
		</table>
	</div>
	<div class="footer"></div>

	<script>
		$(document).ready(function() {
			$(".teamMenuItem").click(function() {
				var json = {
					tid : $(this).attr("id")
				};
				console.log(JSON.stringify(json));
				$.ajax({
					type : "POST",
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					url : "/wnycl/teaminfo",
					data : JSON.stringify(json),
					dataType : "json",
					timeout : 600000,
					success : function(data) {
						var players = data;
						for(var i=0;i<players.length;i++){
							var row = "<tr>"+
										"<td>"+players[i].firstname+"</tg>"+
										"<td>"+players[i].lastname+"</td>"+
										"<td>"+players[i].dob+"</td>"+
										"<td>"+players[i].email+"</td>"+
										"<td>"+players[i].phone+"</td>"+
									   "</tr>";
							$("#teamViewBody").append(row);
						}
						$(".teamView").show();
						
					},
					error : function(e) {
						console.log(e);
					}
				});
			});
		});
	</script>
</body>
</html>