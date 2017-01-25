<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>" >
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
				<li role="presentation" class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					 	Teams 
					 	<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li ng-repeat="team in teams"><a class="teamMenuItem" id="{{team.teamid}}" ng-href="#/teamInfo/{{team.teamid}}">{{team.name}}</a></li>
						<li><a class="teamMenuItem" id="addModifyTeam" ng-href="#/listTeams">Add/Modify Team</a></li>
					</ul>
				</li>
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
	

	<div class="footer"></div>

	
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.js"></script>
    <script src="<c:url value='/js/app.js'/>"></script>  
    <script src="<c:url value='/js/service/team_service.js' />"></script>
    <script src="<c:url value='/js/controller/team_controller.js' />"></script>
    <script src="<c:url value='/js/service/player_service.js' />"></script>
    <script src="<c:url value='/js/controller/player_controller.js' />"></script>
</body>
</html>