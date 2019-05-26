<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<jsp:include page="../header.jsp"/>
<!-- COLUMN RIGHT -->
<div id="col-right" class="col-right ">
	<div class="container-fluid primary-content">
		<!-- PRIMARY CONTENT HEADING -->
		<div class="primary-content-heading clearfix">
			<br>
			<h2>근무 신규 등록</h2>
			<ul class="breadcrumb pull-left">
				<!-- quick task modal -->
				<div class="modal fade" id="quick-task-modal" tabindex="-1" role="dialog" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
								</button>
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
			</ul>
			<!-- end quick task modal -->
		</div>
		<!-- END PRIMARY CONTENT HEADING -->
		<div class="row">
			<div class="col-md-9">
				<!-- TICKET FORM -->
				<div class="widget">
					<div class="widget-header clearfix">
						<h3><i class="icon ion-compose"></i> <span>등록 양식</span></h3>
						<div class="btn-group widget-header-toolbar visible-lg">
							<a href="#" title="Expand/Collapse" class="btn btn-link btn-toggle-expand"><i
									class="icon ion-ios-arrow-up"></i></a>
							<!--a href="#" title="Remove" class="btn btn-link btn-remove"><i class="icon ion-ios-close-empty"></i--></a>
						</div>
					</div>
					<div class="widget-content">
						<form class="form-horizontal form-ticket" role="form" action="/process_add_work" method="post"
						      name='f'>
							<fieldset>
								<legend>근무 정보</legend>
								<div class="form-group">
									<label class="col-sm-3 control-label">출근 시간</label>
									<input type="hidden" id="work_no" name="work_no" value="${work.work_no}">
									<input type="hidden" id="staff_no" name="staff_no" value="${work.staff_no}">
									<input type="hidden" id="work_start_time" name="work_start_time" value="${work.work_start_time}">
									<input type="hidden" id="work_end_time" name="work_end_time" value="${work.work_end_time}">
									<div class="col-sm-9">
										<input type="date" id="startDate" value="" required="required"/>
										<input type="time" id="startTime" value="" required="required"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">퇴근 시간</label>
									<div class="col-sm-9">
										<input type="date" id="endDate" value="" required="required"/>
										<input type="time" id="endTime" value="" required="required"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<input type="submit" onclick="return submitting()"
										       class="btn btn-primary btn-block" value="신규 등록">
										<input type="button" class="btn btn-primary btn-block"
										       onclick="location.href = '/manage_work?staff_no='+${work.staff_no}" value="취소">
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
    window.onload = function () {
        var today = new Date();
        var yyyy = today.getFullYear();
        var date = today.getDate();
        var mm = today.getMonth() + 1;
        var hh = today.getHours();
        if (hh < 10) {
            hh = "0" + hh;
        }
        if (mm < 10) {
            mm = "0" + mm;
        }
        if (date < 10) {
            date = "0" + date;
        }
        today = yyyy + "-" + mm + "-" + date;
        document.getElementById("startDate").value = today;
        document.getElementById("startDate").setAttribute("max", today);
        document.getElementById("endDate").value = today;
        document.getElementById("endDate").setAttribute("max", today);
        document.getElementById("startTime").value = hh + ":00";
        document.getElementById("endTime").value = hh + ":00";
        today = "2018-12-31";
        document.getElementById("StartDate").setAttribute("min", today);
	    document.getElementById("endDate").setAttribute("min", today);
    }
    function submitting() {
        var date = document.getElementById("startDate").value;
        var time = document.getElementById("startTime").value;
        var dl = date + " " + time+":00";
        document.getElementById("work_start_time").value = dl;
        date = document.getElementById("endDate").value;
        time = document.getElementById("endTime").value;
        var dl = date + " " + time+":00";
        document.getElementById("work_end_time").value = dl;
        return true;
    }
</script>
<jsp:include page="../footer.jsp"/>