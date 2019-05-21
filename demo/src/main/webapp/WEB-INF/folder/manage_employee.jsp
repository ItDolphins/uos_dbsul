<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:include page="header.jsp" />
<!-- COLUMN RIGHT -->
		<div id="col-right" class="col-right ">
			<div class="container-fluid primary-content">
				<!-- PRIMARY CONTENT HEADING -->
				<div class="primary-content-heading clearfix">
					<h2>Manage Employee</h2>
					<div class="sticky-content pull-right">
						<div class="btn-group btn-dropdown">
							<button type="button" class="btn btn-default btn-sm btn-favorites" data-toggle="dropdown"><i class="icon ion-android-star"></i> Favorites</button>
							<ul class="dropdown-menu dropdown-menu-right list-inline">
								<li><a href="#"><i class="icon ion-pie-graph"></i> <span>Statistics</span></a></li>
								<li><a href="#"><i class="icon ion-email"></i> <span>Inbox</span></a></li>
								<li><a href="#"><i class="icon ion-chatboxes"></i> <span>Chat</span></a></li>
								<li><a href="#"><i class="icon ion-help-circled"></i> <span>Help</span></a></li>
								<li><a href="#"><i class="icon ion-gear-a"></i> <span>Settings</span></a></li>
								<li><a href="#"><i class="icon ion-help-buoy"></i> <span>Support</span></a></li>
							</ul>
						</div>
						<button type="button" class="btn btn-default btn-sm btn-quick-task" data-toggle="modal" data-target="#quick-task-modal"><i class="icon ion-edit"></i> Quick Task</button>
					</div>
					<!-- quick task modal -->
					<div class="modal fade" id="quick-task-modal" tabindex="-1" role="dialog" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">Quick Task</h4>
								</div>
								<div class="modal-body">
									<form class="form-horizontal" role="form">
										<div class="form-group">
											<label for="task-title" class="control-label sr-only">Title</label>
											<div class="col-sm-12">
												<input type="text" class="form-control" id="task-title" placeholder="Title">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label sr-only">Description</label>
											<div class="col-sm-12">
												<textarea class="form-control" name="task-description" rows="5" cols="30" placeholder="Description"></textarea>
											</div>
										</div>
										<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
										<button type="button" class="btn btn-primary">Save Task</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					<!-- end quick task modal -->
				</div>
				<!-- END PRIMARY CONTENT HEADING -->
				<!-- SHOW HIDE COLUMNS -->
				<div class="widget">
					<div class="widget-header clearfix">
						<h3><i class="icon ion-ios-grid-view-outline"></i> <span>직원관리</span></h3>
						<div class="btn-group widget-header-toolbar visible-lg">
							<a href="#" title="Expand/Collapse" class="btn btn-link btn-toggle-expand"><i class="icon ion-ios-arrow-up"></i></a>
							<a href="#" title="Remove" class="btn btn-link btn-remove"><i class="icon ion-ios-close-empty"></i></a>
						</div>
					</div>
					<div class="widget-content">
						<div class="table-responsive">
							<table id="datatable-column-interactive" class="table table-sorting table-hover table-bordered colored-header datatable">
								<thead>
									<tr>
										<th>Browser</th>
										<th>Operating System</th>
										<th>Visits</th>
										<th>New Visits</th>
										<th>Bounce Rate</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Chrome</td>
										<td>Macintosh</td>
										<td>360</td>
										<td>82.78%</td>
										<td>87.77%</td>
									</tr>
									<tr>
										<td>Chrome</td>
										<td>Windows</td>
										<td>582</td>
										<td>87.24%</td>
										<td>90.12%</td>
									</tr>
									<tr>
										<td>Chrome</td>
										<td>Linux</td>
										<td>172</td>
										<td>45.21%</td>
										<td>48.81%</td>
									</tr>
									<tr>
										<td>Chrome</td>
										<td>iOS</td>
										<td>86</td>
										<td>35.23%</td>
										<td>44.21%</td>
									</tr>
									<tr>
										<td>Firefox</td>
										<td>Windows</td>
										<td>280</td>
										<td>63.12%</td>
										<td>89.34%</td>
									</tr>
									<tr>
										<td>Firefox</td>
										<td>Android</td>
										<td>236</td>
										<td>58.02%</td>
										<td>76.19%</td>
									</tr>
									<tr>
										<td>Internet Explorer</td>
										<td>Windows</td>
										<td>145</td>
										<td>45.23%</td>
										<td>94.65%</td>
									</tr>
									<tr>
										<td>Opera</td>
										<td>Windows</td>
										<td>328</td>
										<td>67.12%</td>
										<td>78.34%</td>
									</tr>
									<tr>
										<td>Opera</td>
										<td>Macintosh</td>
										<td>22</td>
										<td>87.21%</td>
										<td>79.81%</td>
									</tr>
									<tr>
										<td>Chrome</td>
										<td>iOS</td>
										<td>45</td>
										<td>23.21%</td>
										<td>34.67%</td>
									</tr>
									<tr>
										<td>Chrome</td>
										<td>Linux</td>
										<td>142</td>
										<td>46.61%</td>
										<td>49.72%</td>
									</tr>
									<tr>
										<td>Chrome</td>
										<td>iOS</td>
										<td>96</td>
										<td>45.43%</td>
										<td>46.11%</td>
									</tr>
									<tr>
										<td>Firefox</td>
										<td>Windows</td>
										<td>235</td>
										<td>23.42%</td>
										<td>77.44%</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- END SHOW HIDE COLUMNS -->
<jsp:include page="footer.jsp" />