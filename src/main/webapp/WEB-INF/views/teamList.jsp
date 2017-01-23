<div class="addTeamFormSection"
	ng-controller="TeamController as teamCtrl">
	<h4></h4>
	<div class="table-responsive">
		<table id="mytable" class="table table-bordred table-striped">
			<thead>
				<th>Name</th>
				<th>City</th>
				<th>Captain</th>
			</thead>
			<tbody>
				<tr class="teamdisplayRow" class="nounderline" ng-repeat="team in teamCtrl.teams" id="{{team.name}}-{{team.teamid}}">
					<td><a ng-href="#/teamInfo/{{team.teamid}}" class="nounderline" >{{team.name}}</a></td>
					<td>{{team.city}}</td>
					<td>{{team.captain.firstname}}</td>
				</tr>
			</tbody>
		</table>
		<div class="clearfix"></div>
		<button type="button" class="btn btn-primary btn-sm pull-right"
			data-toggle="modal" data-target="#addTeammodal">
			<b ng-href="#/team/AddTeam">Add Team</b>	
		</button>
	</div>
</div>