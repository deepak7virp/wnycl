<div class="addTourFormSection"
	ng-controller="TourController as tourCtrl">
	<h4></h4>
	<div class="table-responsive">
		<table id="mytable" class="table table-bordred table-striped" style="width:auto;">
			<thead>
				<th>Name</th>
				<th>Location</th>
				<th>Start</th>
				<th>End</th>
				<th>Teams</th>
				<th>Players</th>
			</thead>
			<tbody>
				<tr class="tourdisplayRow" class="nounderline" ng-repeat="t in tours" id="{{t.name}}-{{t.tourid}}">
					<td>
						<input ng-if="!rows[t.tourid].glyphs.edit" type="text" class="form-control" data-ng-model="tour.name" placeholder="Name">
						<a ng-if="rows[t.tourid].glyphs.edit" ng-href="#/tourInfo/{{t.tourid}}" class="nounderline" >{{t.name}}</a>
					</td>
					<td>
						<input ng-if="!rows[t.tourid].glyphs.edit" type="text" class="form-control" data-ng-model="tour.venue.name" placeholder="Location">
						<span ng-if="rows[t.tourid].glyphs.edit">
							{{t.venue.name}}
						</span>
					</td>
					<td>
						<input ng-if="!rows[t.tourid].glyphs.edit" type="text" class="form-control" data-ng-model="tour.startdate" placeholder="Start Date">
						<span ng-if="rows[t.tourid].glyphs.edit">
							{{t.startdate}}
						</span>
					</td>
					<td>
						<input ng-if="!rows[t.tourid].glyphs.edit" type="text" class="form-control" data-ng-model="tour.enddate" placeholder="End Date">
						<span ng-if="rows[t.tourid].glyphs.edit">
							{{t.enddate}}
						</span>
					</td>
					<td>
						<input ng-if="!rows[t.tourid].glyphs.edit" type="text" class="form-control" data-ng-model="tour.teamcount" placeholder="Team Count">
						<span ng-if="rows[t.tourid].glyphs.edit">
							{{t.teamcount}}
						</span>
					</td>
					<td>
						<input ng-if="!rows[t.tourid].glyphs.edit" type="text" class="form-control" data-ng-model="tour.playercount" placeholder="Player Count">
						<span ng-if="rows[t.tourid].glyphs.edit">
							{{t.playercount}}
						</span>
					</td>
					<td>
						<span ng-if="rows[t.tourid].glyphs.edit" class="glyphicon glyphicon-pencil" ng-click="edit(t)" aria-hidden="true"></span>
						<span ng-if="rows[t.tourid].glyphs.submit" class="glyphicon glyphicon-ok" ng-click="submit()" aria-hidden="true"></span>
						<span ng-if="rows[t.tourid].glyphs.cancel" class="glyphicon glyphicon-remove" ng-click="cancel()" aria-hidden="true"></span>
					</td>
				</tr>
<!-- 				<tr class="tourAddRow" ng-show="addTourClicked"> -->
<!-- 					<td><input type="text" class="form-control" data-ng-model="tour.name" placeholder="Name"></td> -->
<!-- 					<td><input type="text" class="form-control" data-ng-model="tour.name" placeholder="Name"></td> -->
<!-- 					<td><input type="text" class="form-control" data-ng-model="tour.name" placeholder="Name"></td> -->
<!-- 					<td><input type="text" class="form-control" data-ng-model="tour.name" placeholder="Name"></td> -->
<!-- 					<td><input type="text" class="form-control" data-ng-model="tour.name" placeholder="Name"></td> -->
<!-- 					<td> -->
<!-- 						<div class="input-group"> -->
<!-- 					      <input type="text" class="form-control" data-ng-model="team.city" placeholder="City"> -->
<!-- 					    </div> -->
<!-- 					</td> -->
<!-- 					<td> -->
<!-- 						<button class="btn btn-default" type="button" ng-click="createTeam(team)" >Add!</button> -->
<!-- 						<button class="btn btn-default" type="button" ng-click="reset()" >Reset!</button> -->
<!--     				</td> -->
<!-- 				</tr> -->
			</tbody>
		</table>
		<div class="clearfix"></div>
		<button type="button" class="btn btn-primary btn-sm pull-right">
			<b ng-click="addClick()">Add Tour</b>	
		</button>
	</div>
</div>