<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<jsp:include page="header.jsp"/>
<!-- COLUMN RIGHT -->
		<div id="col-right" class="col-right ">
			<div class="container-fluid primary-content">
				<!-- PRIMARY CONTENT HEADING -->
				<div class="primary-content-heading clearfix">
				<br>
					<h2>직원 신규 등록</h2>
					<ul class="breadcrumb pull-left">
					
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
				<div class="row">
					<div class="col-md-9">
						<!-- TICKET FORM -->
						<div class="widget">
							<div class="widget-header clearfix">
								<h3><i class="icon ion-compose"></i> <span>등록 양식</span></h3>
								<div class="btn-group widget-header-toolbar visible-lg">
									<a href="#" title="Expand/Collapse" class="btn btn-link btn-toggle-expand"><i class="icon ion-ios-arrow-up"></i></a>
									<a href="#" title="Remove" class="btn btn-link btn-remove"><i class="icon ion-ios-close-empty"></i></a>
								</div>
							</div>
							<div class="widget-content">
								<form class="form-horizontal form-ticket" role="form" action="/process_add_employee" method="post" onsubmit='return data_check()' name='f'>
									<fieldset>
										<legend>직원 정보</legend>
										<div class="form-group">
											<label for="이름" class="col-sm-3 control-label">이름</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="staff-name" name="staff_name" placeholder="이름">
											</div>
										</div>
										<div class="form-group">
											<label for="직책" class="col-sm-3 control-label">직책</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="staff-pos" name="staff_pos" placeholder="직책 (직원 / 점장 / 매니저)">
											</div>
										</div>
										<div class="form-group">
											<label for="계좌번호" class="col-sm-3 control-label">계좌번호</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="staff_acntno" name="staff_acntno" placeholder="계좌번호">
											</div>
										</div>
										<div class="form-group">
											<label for="은행" class="col-sm-3 control-label">은행</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="staff-acntbank" name="staff_acntbank" placeholder="은행이름">
											</div>
										</div>
										<div class="form-group">
											<label for="전화번호" class="col-sm-3 control-label">전화번호</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="staff-pnum" name="staff_pnum" placeholder="전화번호">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-3 col-sm-9">
												<button type="submit" class="btn btn-primary btn-block">신규 등록</button>
											</div>
										</div>
										
									</fieldset>
								</form>
							</div>
						</div>
						<!-- END TICKET FORM -->
<script>
function data_check(){
	var staff = document.f;
	var staff_name = staff.staff_name.value;
	var staff_pos = staff.staff_pos.value;
	var staff_acntno = staff.staff_acntno.value;
	var staff_acntbank = staff.staff_acntbank.value;
	var staff_pnum = staff.staff_pnum.value;
	var resign_flag = staff.resign_flag.value;
	
	if(staff_name==""){
	alert("이름을 입력하시오");
	return false;
	}
	if(staff_pos == ""){
	alert("직책을 입력하시오");
	return false;
	}
	if(staff_acntno == ""){
	alert("계좌번호를 입력하시오");
	return false;
	}
	if(staff_acntbank == ""){
	alert("은행이름을 입력하시오");
	return false;
	}
	if(staff_pnum == ""){
	alert("전화번호를 입력하시오");
	return false;
	}
	if(resign_flag == 'Y' || resign_flag == 'N') return true;
	else{
	alert("퇴사여부를 'N' 또는 'Y'로 넣으시오");
	return false;
	}
}
</script>
<jsp:include page="footer.jsp"/>