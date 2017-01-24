<div class="addPlayerFormSection" ng-controller="PlayerController as playerCtrl">
	<h4></h4>
	<div class="table-responsive">
		<table id="mytable" class="table table-bordred table-striped">
			<thead>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date of Birth</th>
				<th>Email</th>
				<th>Phone</th>				
			</thead>
			<tbody>
				<tr class="playerdisplayRow" ng-repeat="player in playerCtrl.players" id="{{player.teamid}}">
					<td>{{player.firstname}}</td>
					<td>{{player.lastname}}</td>
					<td>{{player.dob | date: 'MM-dd-yyyy'}}</td>
					<td>{{player.email}}</td>
					<td>{{player.phone}}</td>					
				</tr>
			</tbody>
		</table>
		<div class="clearfix"></div>
		<button type="button" class="btn btn-primary btn-sm pull-right"
			data-toggle="modal" data-target="#addPlayermodal">
			<b>Add Player</b>
		</button>
	</div>
</div>