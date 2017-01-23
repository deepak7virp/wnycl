	<div class="modal fade" id="addTeammodal" tabindex="-1" role="dialog"
		aria-labelledby="add-modal-label" ng-controller="TeamController as teamCtrl">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form method="POST" class="form-horizontal" id="add-form">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidd	en="true">×</span>
						</button>
						<h4 class="modal-title" id="add-modal-label">Add New Team</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="addTeamName" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="addTeamName"
									name="name" placeholder="name" required="">
							</div>
						</div>
						<div class="form-group">
							<label for="addTeamCity" class="col-sm-2 control-label">City</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="addTeamCity"
									name="city" placeholder="City" required="">
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
