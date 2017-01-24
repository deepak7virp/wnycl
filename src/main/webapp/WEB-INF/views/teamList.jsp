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
				<tr class="teamdisplayRow" class="nounderline" ng-repeat="team in teams" id="{{team.name}}-{{team.teamid}}">
					<td><a ng-href="#/teamInfo/{{team.teamid}}" class="nounderline" >{{team.name}}</a></td>
					<td>{{team.city}}</td>
					<td>{{team.captain.firstname}}</td>
				</tr>
				<tr class="teamAddRow" ng-show="addTeamClicked">
					<td><input type="text" class="form-control" data-ng-model="team.name" placeholder="Name"></td>
					<td>
						<div class="input-group">
					      <input type="text" class="form-control" data-ng-model="team.city" placeholder="City">
					      <span class="input-group-btn">
					        <button class="btn btn-default" type="button" ng-click="createTeam(team)" >Add!</button>
					      </span>
					    </div>
					</td>
					<td>
						
    				</td>
				</tr>
			</tbody>
		</table>
		<div class="clearfix"></div>
		<button type="button" class="btn btn-primary btn-sm pull-right">
			<b ng-click="addClick()">Add Team</b>	
		</button>
	</div>
</div>