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
	<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.min.css'/>">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
</head>
<body ng-app="myApp">

	<div class="container-fluid" ng-controller="TeamController as teamCtrl">
		<div class="collapse navbar-collapse">
			<ul class="nav nav-tabs navbar-left">
				<li role="presentation" class="active"><a href="#/home">Home</a></li>
				<li role="presentation" class="dropdown"><a
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false"> Teams <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu">
					
						<li ng-repeat="team in teamCtrl.teams"><a class="teamMenuItem" id="{{team.teamid}}" href="#/teamInfo/{{team.teamid}}">{{team.name}}</a></li>
						<li><a class="teamMenuItem" id="addModifyTeam" href="#/listTeams">Add/Modify Team</a></li>
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
	<div ng-view></div>
	



<!-- 	<div class="modal fade" id="addTeammodal" tabindex="-1" role="dialog" -->
<!-- 		aria-labelledby="add-modal-label"> -->
<!-- 		<div class="modal-dialog" role="document"> -->
<!-- 			<div class="modal-content"> -->
<!-- 				<form method="POST" class="form-horizontal" id="add-form"> -->
<!-- 					<div class="modal-header"> -->
<!-- 						<button type="button" class="close" data-dismiss="modal" -->
<!-- 							aria-label="Close"> -->
<!-- 							<span aria-hidden="true">×</span> -->
<!-- 						</button> -->
<!-- 						<h4 class="modal-title" id="add-modal-label">Add New Team</h4> -->
<!-- 					</div> -->
<!-- 					<div class="modal-body"> -->
<!-- 						<div class="form-group"> -->
<!-- 							<label for="addTeamName" class="col-sm-2 control-label">Name</label> -->
<!-- 							<div class="col-sm-10"> -->
<!-- 								<input type="text" class="form-control" id="addTeamName" -->
<!-- 									name="name" placeholder="name" required=""> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="form-group"> -->
<!-- 							<label for="addTeamCity" class="col-sm-2 control-label">City</label> -->
<!-- 							<div class="col-sm-10"> -->
<!-- 								<input type="text" class="form-control" id="addTeamCity" -->
<!-- 									name="city" placeholder="City" required=""> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="modal-footer"> -->
<!-- 						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
<!-- 						<button type="submit" id="addTeamSubmit" class="btn btn-primary">Save</button> -->
<!-- 					</div> -->
<!-- 				</form> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->

	<div class="footer"></div>

	
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.js"></script>
    <script src="<c:url value='/js/app.js'/>"></script>  
      <script src="<c:url value='/js/service/team_service.js' />"></script>
      <script src="<c:url value='/js/controller/team_controller.js' />"></script>
</body>
</html>