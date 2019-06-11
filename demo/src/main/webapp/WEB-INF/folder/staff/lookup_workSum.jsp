<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<fmt:formatDate value="${now}" pattern="yyyyMM" var="thisMon"/>
<jsp:include page="../header.jsp"/>
<!-- COLUMN RIGHT -->
<div id="col-right" class="col-right ">
	<div class="container-fluid primary-content">
		<!-- PRIMARY CONTENT HEADING -->
		<div class="primary-content-heading clearfix">
			<h2>Manage Employee</h2>
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
		<div class="widget">
			<h3 class="widget-header clearfix">
				<h3>
					<i class="icon ion-ios-grid-view-outline" style="padding:0px 0px 0px 10px;"></i>
					<fmt:formatDate value="${workSum.yearMonth}" pattern="yyyy" var="year"/>
					<fmt:formatDate value="${workSum.yearMonth}" pattern="MM" var="month"/>
					<span>${year}년 ${month}월 근무 통계</span>
					<div class="sticky-content pull-right" style="margin-top:10px; margin-right:30px">
							<button type="button" onclick="location.href= '/manage_work?staff_no='+${staff.staff_no}"
							        class="btn btn-default btn-lg"
							        id="selectBtn3">뒤로
							</button>
					</div>
				</h3>
				<div class="widget-content">
					<div class="table-responsive">
						<table id="datatable-column-interactive-menu" style="border-right: #ccc 1px solid"
						       class="table table-sorting table-hover table-bordered colored-header datatable">
							<thead>
							<tr>
								<th>이름</th>
								<th>직책</th>
								<th>계좌번호</th>
								<th>전화번호</th>
								<th>직원번호</th>
								<th>퇴사여부</th>
							</tr>
							</thead>
							<tbody>
							<td>${staff.staff_name}</td>
							<td>${staff.staff_pos}</td>
							<td>${staff.staff_acntno}</td>
							<td>${staff.staff_pnum}</td>
							<td>${staff.staff_no}</td>
							<td>${staff.resign_flag}</td>
							</tbody>
						</table>
					</div>
				</div>
				<div class="widget-content">
					<div class="table-responsive">
						<table id="datatable-column-interactive-menu2" style="border-right: #ccc 1px solid"
						       class="table table-sorting table-hover table-bordered colored-header datatable">
							<thead>
							<tr>
								<th>총근무시간</th>
								<th>총월급</th>
								<th>주간근무시간</th>
								<th>주간임금</th>
								<th>야간근무시간</th>
								<th>야간임금</th>
							</tr>
							</thead>
							<tbody>
							<td>${workSum.worktimeSum}</td>
							<td>${workSum.salarySum}</td>
							<td>${workSum.dayWorktimeSum}</td>
							<td>${workSum.daySalarySum}</td>
							<td>${workSum.nightWorktimeSum}</td>
							<td>${workSum.nightSalarySum}</td>
							</tbody>
						</table>
					</div>
				</div>
			</h3>
		</div>
	</div>
</div>

<!-- END SHOW HIDE COLUMNS -->
<jsp:include page="../footer.jsp"/>