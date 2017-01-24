<div class="addTeamFormSection" ng-controller="TeamController as teamCtrl">
<script id="addTeamModal">
	
		<div class="modal-header">
			<h3>Add Modal</h3>
		</div>
		<div class="modal-body">
			<div class="form-group">
				<label for="addTeamName" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="addTeamName" name="name" placeholder="name" required="" ng-bind="addForm.teamname">
				</div>
			</div>
			<div class="form-group">
				<label for="addTeamCity" class="col-sm-2 control-label">City</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="addTeamCity" name="city" placeholder="City" required="" ng-bind="addForm.city">
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button class="btn btn-primary" ng-click="ok()">OK</button>
		    <button class="btn btn-warning" ng-click="cancel()">Cancel</button>
		</div>
	
	</script>
	<h4></h4>
	<div class="table-responsive">
		<table id="mytable" class="table table-bordred table-striped">
			<thead>
				<th>Name</th>
				<th>City</th>
				<th>Captain</th>
			</thead>
			<tbody>
				<tr class="teamdisplayRow" ng-repeat="team in teamCtrl.teams" id="{{team.name}}-{{team.teamid}}">
					<td>{{team.name}}</td>
					<td>{{team.city}}</td>
					<td>{{team.captain.firstname}}</td>
				</tr>
			</tbody>
		</table>
		<div class="clearfix"></div>
		<button type="button" class="btn btn-primary btn-sm pull-right" ng-click="openAddModal()">
			<b>Add Team</b>
		</button>
	</div>
	
</div>
