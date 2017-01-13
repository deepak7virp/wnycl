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
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
</head>
<body ng-app='myApp'>
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
						<li><a class="teamMenuItem" id="addModifyTeam" href="<c:url value='/listTeams'/>">Add/Modify Team</a></li>
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
	
	<c:if test="${displayTeamInfo}">
		<div class="teamView" style="display:none;">
			<h2 id="teamViewName"></h2>
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
	</c:if>
		
	<c:if test="${displayTeams}">
		<div class="addTeamFormSection" ng-controller='TeamController as teamCtrl'>
			<h4></h4>
	        <div class="table-responsive">
	        	<table id="mytable" class="table table-bordred table-striped">
					<thead>
	                	<th>Name</th>
	                    <th>City</th>
	                    <th>Captain</th>
	                </thead>
	    			<tbody>
	    				<tr class="teamDisplayRow" data-ng-repeat="team in teamCtrl.teams" id="team.name-team.id">
	    					<td>{{team.name}}</td>
	    					<td>{{team.city}}</td>
	    					<td>{{team.captain}}</td>
	    				</tr>
<%-- 	    				<c:forEach var="team" items="${teams}" varStatus="t"> --%>
<%-- 							<tr class="teamdisplayRow" id="${team.name}-${team.teamid}"> --%>
<%-- 		    					<td>${team.name}</td> --%>
<%-- 		    					<td>${team.city}</td> --%>
<%-- 		    					<c:choose> --%>
<%-- 								    <c:when test="${team.captain != null}"> --%>
<%-- 								    	<td>${team.captain.firstname} ${team.captain.lastname}</td>     --%>
<%-- 								    </c:when>     --%>
<%-- 								    <c:otherwise> --%>
<!-- 								        <td>Not Assigned</td> -->
<%-- 								    </c:otherwise> --%>
<%-- 								</c:choose> --%>
<!-- 		    				</tr>	 -->
<%-- 						</c:forEach> --%>
	    			</tbody>
	    		</table>
	        	<div class="clearfix"></div>
	        	<button type="button" class="btn btn-primary btn-sm pull-right" data-toggle="modal" data-target="#addTeammodal">
	        		<b>Add Team</b>
	        	</button>
	        </div>
		</div>
	</c:if>
	
	<div class="modal fade" id="addTeammodal" tabindex="-1" role="dialog" aria-labelledby="add-modal-label">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
		    	<form method="POST" class="form-horizontal" id="add-form">
			    	<div class="modal-header">
			        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
			        	<h4 class="modal-title" id="add-modal-label">Add New Team</h4>
			      	</div>
			      	<div class="modal-body">
			        	<div class="form-group">
					    	<label for="addTeamName" class="col-sm-2 control-label">Name</label>
					    	<div class="col-sm-10">
					      		<input type="text" class="form-control" id="addTeamName" name="name" placeholder="name" required="">
					    	</div>
					  	</div>
					  	<div class="form-group">
					    	<label for="addTeamCity" class="col-sm-2 control-label">City</label>
					    	<div class="col-sm-10">
					      		<input type="text" class="form-control" id="addTeamCity" name="city" placeholder="City" required="">
					    	</div>
					  	</div>
				  	</div>
			      	<div class="modal-footer">
			        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        	<button type="submit" id="addTeamSubmit" class="btn btn-primary">Save</button>
			      	</div>
		      	</form>
		    </div>
		</div>
	</div>
	
	<div class="addPlayerFormSection" style="display:none;"></div>
	
	<div class="addTourFormSection" style="display:none;"></div>
	
	<div class="addVenueFormSection" style="display:none;"></div>
	
	<div class="scheduleTourFormSection" style="display:none;"></div>
	
	
	<div class="footer"></div>

	<script src="<c:url value='/js/app.js'/>"></script>
	<script src="<c:url value='/js/service/team_service.js' />"></script>
    <script src="<c:url value='/js/controller/team_controller.js' />"></script>
</body>
</html>