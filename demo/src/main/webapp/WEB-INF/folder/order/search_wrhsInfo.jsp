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
			<h2>입고 조회</h2>
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
					<span>이번 달 입고</span>
				</h3>
				<!--div class="btn-group widget-header-toolbar visible-lg">
					<a href="#" title="Expand/Collapse" class="btn btn-link btn-toggle-expand">
						<i class="icon ion-ios-arrow-up"></i>
					</a>
					<a href="#" title="Remove" class="btn btn-link btn-remove">
						<i class="icon ion-ios-close-empty"></i>
					</a>
				</div-->
			</h3>
			<div class="widget-content">
				<div class="table-responsive">
					<table id="datatable-column-filter8" style="border-right: #ccc 1px solid"
					       class="table table-sorting table-hover table-bordered colored-header datatable">
						<thead>
						<tr>
							<th>입고번호</th>
							<th>요청번호</th>
							<th>주문번호</th>
							<th>입고일자</th>
							<th>유통기한</th>
							<th>상품번호</th>
							<th>상품이름</th>
							<th>요청수량</th>
						</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${fn:length(wrhsInfoList) > 0}">
								<c:forEach items="${wrhsInfoList}" var="row">
									<fmt:formatDate value="${row.wrhs_date}" pattern="yyyMM" var="mon"/>
									<fmt:formatDate value="${row.wrhs_date}" pattern="yyyy-MM-dd" var="wrhs_date"/>
									<c:if test="${mon - thisMon eq 0 }">
										<tr>
											<td>${row.wrhs_no}</td>
											<td>${row.req_no}</td>
											<td>${row.order_no}</td>
											<td>${wrhs_date}</td>
											<td>${row.expdate}</td>
											<td>${row.prod_no}</td>
											<td>${row.prod_name}</td>
											<td>${row.req_qnt}</td>
										</tr>
									</c:if>
								</c:forEach>
							</c:when>
						</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="widget">
			<h3 class="widget-header clearfix" style="background-color: white">
				<div class="btn-group widget-header-toolbar visible-lg">
					<a href="#" title="Expand/Collapse" class="btn btn-link btn-toggle-expand">
						<i class="icon ion-ios-arrow-up"></i>
					</a>
					<a href="#" title="Remove" class="btn btn-link btn-remove">
						<i class="icon ion-ios-close-empty"></i>
					</a>
				</div>
				<h3>
					<i class="icon ion-ios-grid-view-outline" style="padding:0px 0px 0px 10px;"></i>
					<span>이전 입고</span>
					<div class="widget-content"></div>
				</h3>
				<div class="widget-content">
					<div class="table-responsive">
						<table id="datatable-column-filter7" style="border-right: #ccc 1px solid"
						       class="table table-sorting table-hover table-bordered colored-header datatable">
							<thead>
							<tr>
								<th>입고번호</th>
								<th>요청번호</th>
								<th>주문번호</th>
								<th>입고일자</th>
								<th>유통기한</th>
								<th>상품번호</th>
								<th>상품이름</th>
								<th>요청수량</th>
							</tr>
							</thead>
							<tbody>
							<c:choose>
								<c:when test="${fn:length(wrhsInfoList) > 0}">
									<c:forEach items="${wrhsInfoList}" var="row">
										<fmt:formatDate value="${row.wrhs_date}" pattern="yyyMM" var="mon"/>
										<fmt:formatDate value="${row.wrhs_date}" pattern="yyyy-MM-dd" var="wrhs_date"/>
										<c:if test="${mon - thisMon ne 0 }">
											<tr>
												<td>${row.wrhs_no}</td>
												<td>${row.req_no}</td>
												<td>${row.order_no}</td>
												<td>${wrhs_date}</td>
												<td>${row.expdate}</td>
												<td>${row.prod_no}</td>
												<td>${row.prod_name}</td>
												<td>${row.req_qnt}</td>
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
	</div>
</div>
<!-- END SHOW HIDE COLUMNS -->
<jsp:include page="../footer.jsp"/>