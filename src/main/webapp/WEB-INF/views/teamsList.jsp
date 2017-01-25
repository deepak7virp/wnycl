<div class="addTeamFormSection"
	ng-controller="TeamController as teamCtrl">
	<h4></h4>
	<div class="table-responsive">
		<table id="mytable" class="table table-bordred table-striped" style="width:auto;">
			<thead>
				<th>Name</th>
				<th>City</th>
				<th>Captain</th>
				<th>Action</th>
			</thead>
			<tbody>
				<tr class="teamdisplayRow" class="nounderline" ng-repeat="team in teams" id="{{team.name}}-{{team.teamid}}">
					<td><a ng-href="#/teamInfo/{{team.teamid}}" class="nounderline" >{{team.name}}</a></td>
					<td>{{team.city}}</td>
					<td>
						<span ng-if="team.captain">{{team.captain.firstname}}</span>
						<button ng-if="!team.captain && !rows[team.teamid].assignCaptainEnable" class="btn btn-default" type="button" ng-click="assignCaptain(team.teamid)" >Assign!</button>						
						<div ng-if="rows[team.teamid].assignCaptainEnable" class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							 	Choose a player 
							 	<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li ng-repeat="player in players">
									<a class="teamMenuItem" id="{{player.playerid}}" ng-click="assignPlayerAsCaptain(team.teamid,player.playerid)">{{player.firstname}} {{player.lastname}}</a>
								</li>
							</ul>
						</div>
					</td>
					<td>
						<span ng-if="rows[team.teamid].glyphs.edit" class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						<span ng-if="rows[team.teamid].glyphs.submit" class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						<span ng-if="rows[team.teamid].glyphs.cancel" class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</td>
				</tr>
				<tr class="teamAddRow" ng-show="addTeamClicked">
					<td><input type="text" class="form-control" data-ng-model="team.name" placeholder="Name"></td>
					<td>
						<div class="input-group">
					      <input type="text" class="form-control" data-ng-model="team.city" placeholder="City">
					    </div>
					</td>
					<td>
						<button class="btn btn-default" type="button" ng-click="createTeam(team)" >Add!</button>
						<button class="btn btn-default" type="button" ng-click="reset()" >Reset!</button>
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