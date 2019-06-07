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
			<h2>매출</h2>
			<div class="sticky-content pull-right">
				<div class="btn-group btn-dropdown">
					<button type="button" class="btn btn-default btn-sm btn-favorites"
					        data-toggle="dropdown">
						<i class="icon ion-android-star"></i> Favorites
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
				<button type="button" class="btn btn-default btn-sm btn-quick-task"
				        data-toggle="modal" data-target="#quick-task-modal">
					<i class="icon ion-edit"></i> Quick Task
				</button>
			</div>
			<!-- quick task modal -->
			<div class="modal fade" id="quick-task-modal" tabindex="-1"
			     role="dialog" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
							        aria-hidden="true">&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">Quick Task</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label for="task-title" class="control-label sr-only">Title</label>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="task-title"
										       placeholder="Title">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label sr-only">Description</label>
									<div class="col-sm-12">
										<textarea class="form-control" name="task-description"
										          rows="5" cols="30" placeholder="Description"></textarea>
									</div>
								</div>
								<button type="button" class="btn btn-default"
								        data-dismiss="modal">Close
								</button>
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
			<h3 class="widget-header clearfix"></h3>
			<h3>
				<i class="icon ion-ios-grid-view-outline"
				   style="padding: 0px 0px 0px 10px;"></i> <span>매출 내역</span>
			</h3>
			<div class="widget-content">
				<form class="form-horizontal form-ticket" role="form", action="/calculate_sales" method="post" >
					<fieldset>
						<legend>등록 양식</legend>
						<div class="form-group">
							<label for="sales_date" class="col-sm-3 control-label">매출 일자</label>
							<div class="col-sm-9">
								<input type="date" class="form-control" id="sales_date" name="sales_date" placeholder="매출 일자" required="required">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-9">
								<button type="submit" class="btn btn-primary">매출 계산
									<input type="hidden" class="form-control" id="store_no" name="store_no" value="${store_no}">
								</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
			<div class="widget-content">
				<div class="table-responsive">
					<table id="datatable-column-interactive"
					       class="table table-sorting table-hover table-bordered colored-header datatable">
						<thead>
						<tr>
							<th>매출일자</th>
							<th>매출액</th>
						</tr>
						</thead>
						<c:choose>
							<c:when test="${fn:length(salesList) > 0}">
								<c:forEach items="${salesList}" var="row">
									<fmt:formatDate value="${row.sales_date}" pattern="yyyMM" var="mon"/>
									<fmt:formatDate value="${row.sales_date}" pattern="yyyy-MM-dd" var="sales_date"/>
									<c:if test="${mon - thisMon eq 0 }">
										<tr>
											<td>${sales_date}</td>
											<td>${row.sales_amt}</td>
										</tr>
									</c:if>
								</c:forEach>
							</c:when>
						</c:choose>
					</table>
				</div>
			</div>
		</div>
		<div class="widget">
			<h3 class="widget-header clearfix"></h3>
			<h3>
				<i class="icon ion-ios-grid-view-outline"
				   style="padding: 0px 0px 0px 10px;"></i> <span>매출 내역</span>
			</h3>
			<div class="widget-content">
				<div class="table-responsive">
					<table id="datatable-column-interactive2"
					       class="table table-sorting table-hover table-bordered colored-header datatable">
						<thead>
						<tr>
							<th>매출일자</th>
							<th>매출액</th>
						</tr>
						</thead>
						<c:choose>
							<c:when test="${fn:length(salesList) > 0}">
								<c:forEach items="${salesList}" var="row">
									<fmt:formatDate value="${row.sales_date}" pattern="yyyMM" var="mon"/>
									<fmt:formatDate value="${row.sales_date}" pattern="yyyy-MM-dd" var="sales_date"/>
									<c:if test="${mon - thisMon ne 0 }">
										<tr>
											<td>${sales_date}</td>
											<td>${row.sales_amt}</td>
										</tr>
									</c:if>
								</c:forEach>
							</c:when>
						</c:choose>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END SHOW HIDE COLUMNS -->
<script>
    window.onload = function () {
        var today = new Date();
        var yyyy = today.getFullYear();
        var date = today.getDate();
        var mm = today.getMonth() + 1;
        if (mm < 10) {
            mm = "0" + mm;
        }
        if (date < 10) {
            date = "0" + date;
        }
        today = yyyy + "-" + mm + "-" + date;
        document.getElementById("sales_date").value = today;
        document.getElementById("sales_date").setAttribute("max", today);
        today = "2018-12-31";
        document.getElementById("sales_date").setAttribute("min", today);
    }
</script>
<script src="/resources/js/queen-table2.js"></script>
<jsp:include page="../footer.jsp"/>


