<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<jsp:include page="../header.jsp" />
<!-- COLUMN RIGHT -->
<div id="col-right" class="col-right ">
	<div class="container-fluid primary-content">
		<!-- PRIMARY CONTENT HEADING -->
		<div class="primary-content-heading clearfix">
			<h2>이벤트 관리</h2>
			
		</div>
		<!-- SHOW HIDE COLUMNS -->
		<form action="/alter_pr_event_form" accept-charset="utf-8" name='pr_event_form' method="get" >
		<div class="widget">
			<h3 class="widget-header clearfix"></h3>
			<h3>
				<i class="icon ion-ios-grid-view-outline"
					style="padding: 0px 0px 0px 10px;"></i> <span>증정 이벤트 정보</span>
				<div class="sticky-content pull-right" style="margin-top:10px; margin-right:30px">
					<button type="submit"  class="btn btn-default btn-lg"
							        id="selectBtn">정보수정
					</button>
					<button type="button" onclick="location.href= '/pr_event_add_form'"  
							        class="btn btn-default btn-lg"
							        id="selectBtn2">새 증정 이벤트 등록
					</button>
				</div>
			
			</h3>
			
			
			<div class="widget-content">
				<div class="table-responsive">
					<table id="datatable-column-interactive"
						class="table table-sorting table-hover table-bordered colored-header datatable">
						<thead>
							<tr>
								<th style="width:10px"></th>
								<th>번호</th>
								<th>이벤트 상품</th>
								<th>이벤트 이름</th>
								<th>시작기간</th>
								<th>종료기간</th>
								<th>증정 상품</th>
							</tr>
						</thead>
						<c:choose>
							<c:when test="${fn:length(eventPrList) > 0}">
								<tbody>
									<c:forEach items="${eventPrList}" var="row">
										<tr>
											<td><input type="radio" name="present_no" value="${row.present_no}"
													           class="checkSelect" required="required"></td>
											<td>${row.present_no}</td>
											<td>${row.event_prod}</td>
											<td>${row.event_name}</td>
											<td>${row.event_start_day}</td>
											<td>${row.event_end_day}</td>
											<td>${row.present_prod}</td>
										</tr>
									</c:forEach>
								</tbody>
							</c:when>
						</c:choose>
					</table>
				</div>
			</div>
		</div>
		</form>
		
		<!-- SHOW HIDE COLUMNS -->
		<form action="/alter_dc_event_form" accept-charset="utf-8" name='dc_event_form' method="get" >
		<div class="widget">
			<h3 class="widget-header clearfix"></h3>
			<h3>
				<i class="icon ion-ios-grid-view-outline"
					style="padding: 0px 0px 0px 10px;"></i> <span>할인 이벤트 정보</span>
				<div class="sticky-content pull-right" style="margin-top:10px; margin-right:30px">
					<button type="submit"  class="btn btn-default btn-lg"
							        id="selectBtn3">정보수정
					</button>
					<button type="button" onclick="location.href= '/dc_event_add_form'"  
							        class="btn btn-default btn-lg"
							        id="selectBtn4">새 할인 이벤트 등록
					</button>
				</div>
			</h3>
			
			
			<div class="widget-content">
				<div class="table-responsive">
					<table id="datatable-column-interactive2"
						class="table table-sorting table-hover table-bordered colored-header datatable">
						<thead>
							<tr>
								<th style="width:10px"></th>
								<th>번호</th>
								<th>이벤트 상품명</th>
								<th>이벤트 이름</th>
								<th>시작기간</th>
								<th>종료기간</th>
								<th>할인율</th>
							</tr>
						</thead>
						<c:choose>
							<c:when test="${fn:length(eventDcList) > 0}">
								<tbody>
									<c:forEach items="${eventDcList}" var="row">
										<tr>
											<td><input type="radio" name="dc_no" value="${row.dc_no}"
													           class="checkSelect" required="required"></td>
											<td>${row.dc_no}</td>
											<td>${row.event_prod}</td>
											<td>${row.event_name}</td>
											<td>${row.event_start_day}</td>
											<td>${row.event_end_day}</td>
											<td>${row.dc_rate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</c:when>
						</c:choose>
					</table>
				</div>
			</div>
		</div>
		</form>
		
	</div>
</div>
<!-- END SHOW HIDE COLUMNS -->
<jsp:include page="../footer.jsp" />


