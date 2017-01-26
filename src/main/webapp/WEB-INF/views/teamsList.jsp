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
				<tr class="teamdisplayRow" class="nounderline" ng-repeat="t in teams" id="{{t.name}}-{{t.teamid}}">
					<td>
						<input ng-if="!rows[t.teamid].glyphs.edit" type="text" class="form-control" data-ng-model="team.name" placeholder="Name">
						<a ng-if="rows[t.teamid].glyphs.edit" ng-href="#/teamInfo/{{t.teamid}}" class="nounderline" >{{t.name}}</a>
					</td>
					<td>
						<input ng-if="!rows[t.teamid].glyphs.edit" type="text" class="form-control" data-ng-model="team.city" placeholder="City">
						<span ng-if="rows[t.teamid].glyphs.edit">
							{{t.city}}
						</span>
					</td>
					<td>
						<span ng-if="t.captain">{{t.captain.firstname}}</span>
						<span ng-if="!t.captain && rows[t.teamid].glyphs.edit">N/A</span>
						<div ng-if="!rows[t.teamid].glyphs.edit" class="dropdown">
							  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							    Players
							    <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							    <li ng-repeat="player in players">
									<a class="teamMenuItem" id="{{player.playerid}}" ng-click="assignPlayerAsCaptain(team.teamid,player.playerid)">{{player.firstname}} {{player.lastname}}</a>
								</li>
							  </ul>
						</div>
					</td>
					<td>
						<span ng-if="rows[t.teamid].glyphs.edit" class="glyphicon glyphicon-pencil" ng-click="edit(t)" aria-hidden="true"></span>
						<span ng-if="rows[t.teamid].glyphs.submit" class="glyphicon glyphicon-ok" ng-click="submit()" aria-hidden="true"></span>
						<span ng-if="rows[t.teamid].glyphs.cancel" class="glyphicon glyphicon-remove" ng-click="cancel()" aria-hidden="true"></span>
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