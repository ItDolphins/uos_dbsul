<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<jsp:include page="../header.jsp"/>
<!-- COLUMN RIGHT -->
<div id="col-right" class="col-right ">
	<div class="container-fluid primary-content">
		<!-- PRIMARY CONTENT HEADING -->
		<div class="primary-content-heading clearfix">
			<h2>Alter Employee</h2>
			<div class="sticky-content pull-right">
				<div class="btn-group btn-dropdown">
					<button type="button" class="btn btn-default btn-sm btn-favorites" data-toggle="dropdown"><i
							class="icon ion-android-star"></i> Favorites
					</button>
					<ul class="dropdown-menu dropdown-menu-right list-inline">
						<li><a href="#"><i class="icon ion-pie-graph"></i> <span>Statistics</span></a></li>
						<li><a href="#"><i class="icon ion-email"></i> <span>Inbox</span></a></li>
						<li><a href="#"><i class="icon ion-chatboxes"></i> <span>Chat</span></a></li>
						<li><a href="#"><i class="icon ion-help-circled"></i> <span>Help</span></a></li>
						<li><a href="#"><i class="icon ion-gear-a"></i> <span>Settings</span></a></li>
						<li><a href="#"><i class="icon ion-help-buoy"></i> <span>Support</span></a></li>
					</ul>
				</div>
				<button type="button" class="btn btn-default btn-sm btn-quick-task" data-toggle="modal"
				        data-target="#quick-task-modal"><i class="icon ion-edit"></i> Quick Task
				</button>
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
                                        <textarea class="form-control" name="task-description" rows="5" cols="30"
                                                  placeholder="Description"></textarea>
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
		<form action="/alter_employee_form" accept-charset="utf-8" name='staff_form' method="get">
			<div class="widget">
				<h3 class="widget-header clearfix">
					<h3>
						<i class="icon ion-ios-grid-view-outline" style="padding:0px 0px 0px 10px;"></i>
						<span>정보 수정</span>
						<div class="sticky-content pull-right" style="margin-top:10px; margin-right:30px">
							<button type="submit" class="btn btn-default btn-lg" id="selectBtn">정보수정</button>
							<button type="button" onclick="location.href= '/manage_employee' "
							        class="btn btn-default btn-lg" id="selectBtn2">취소
							</button>
						</div>
					</h3>
					<!--div class="btn-group widget-header-toolbar visible-lg">
						<a href="#" title="Expand/Collapse" class="btn btn-link btn-toggle-expand">
							<i class="icon ion-ios-arrow-up"></i>
						</a>
						<a href="#" title="Remove" class="btn btn-link btn-remove">
							<i class="icon ion-ios-close-empty"></i>
						</a>
					</div-->
					<div class="widget-content">
						<div class="table-responsive">
							<table id="datatable-column-interactive"
							       class="table table-sorting table-hover table-bordered colored-header datatable">
								<thead>
								<tr>
									<th style="width:10px"></th>
									<th>이름</th>
									<th>직책</th>
									<th>은행</th>
									<th>계좌번호</th>
									<th>전화번호</th>
									<th>직원번호</th>
								</tr>
								</thead>
								<c:choose>
									<c:when test="${fn:length(staffList) > 0}">
										<c:forEach items="${staffList}" var="row">
											<c:if test="${row.resign_flag eq 'N'}">
												<tr>
													<td><input type="radio" name="radio_button" value="${row.staff_no}"
													           class="checkSelect" required="required"></td>
													<td>${row.staff_name}</td>
													<td>${row.staff_pos}</td>
													<td>${row.staff_acntbank}</td>
													<td>${row.staff_acntno}</td>
													<td>${row.staff_pnum}</td>
													<td>${row.staff_no}</td>
												</tr>
											</c:if>
										</c:forEach>
									</c:when>
								</c:choose>
							</table>
						</div>
					</div>
				</h3>
			</div>
			<div class="widget">
				<h3 class="widget-header clearfix">
					<div class="btn-group widget-header-toolbar visible-lg" align="right">
						<a title="Expand/Collapse" class="btn-group widget-header-toolbar visible-lg">
							<i class="icon ion-ios-arrow-down" data-toggle="collapse" data-target="#wg"></i>
						</a>
						<a title="Remove" class="btn btn-link btn-remove">
							<i class="icon ion-ios-close-empty"></i>
						</a>
					</div>
					<h3>
						<i class="icon ion-ios-grid-view-outline" style="padding:0px 0px 0px 10px;"></i>
						<span>퇴직원</span>
						<div class="widget-content"></div>
					</h3>
					<div id="wg" class="collapse">
						<div class="table-responsive">
							<table id="datatable-column-interactive2" style="border-right: #ccc 1px solid"
							       class="table table-sorting table-hover table-bordered colored-header datatable">
								<thead>
								<tr>
									<th style="width:10px"></th>
									<th>이름</th>
									<th>직책</th>
									<th>은행</th>
									<th>계좌번호</th>
									<th>전화번호</th>
									<th>직원번호</th>
								</tr>
								</thead>
								<c:choose>
									<c:when test="${fn:length(staffList) > 0}">
										<c:forEach items="${staffList}" var="row">
											<c:if test="${row.resign_flag eq 'Y'}">
												<tr>
													<td><input type="radio" name="radio_button" value="${row.staff_no}"
													           class="checkSelect" required="required"></td>
													<td>${row.staff_name}</td>
													<td>${row.staff_pos}</td>
													<td>${row.staff_acntbank}</td>
													<td>${row.staff_acntno}</td>
													<td>${row.staff_pnum}</td>
													<td>${row.staff_no}</td>
												</tr>
											</c:if>
										</c:forEach>
									</c:when>
								</c:choose>
								</tbody>
							</table>
						</div>
					</div>
				</h3>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript" src="/js/Submitting.js"></script>

<!-- END SHOW HIDE COLUMNS -->
<jsp:include page="../footer.jsp"/>