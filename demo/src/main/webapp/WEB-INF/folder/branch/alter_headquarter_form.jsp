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
			<br>
			<h2>지점 정보 수정</h2>
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
						<h3><i class="icon ion-compose"></i> <span>수정 양식</span></h3>
						<div class="btn-group widget-header-toolbar visible-lg">
							<a href="#" title="Expand/Collapse" class="btn btn-link btn-toggle-expand"><i
									class="icon ion-ios-arrow-up"></i></a>
							<!--a href="#" title="Remove" class="btn btn-link btn-remove"><i class="icon ion-ios-close-empty"></i--></a>
						</div>
					</div>
					<div class="widget-content">
						<form class="form-horizontal form-ticket" role="form" action="/process_alter_branch"
						      method="post" name='f'>
							<fieldset>
								<legend>지점 정보</legend>
								<div class="form-group">
									<label for="staff_name" class="col-sm-3 control-label">이름</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="store_name"
										       name="store_name" required="required" value=${store.store_name}>
									</div>
								</div>
								<div class="form-group">
									<label for="store_addr" class="col-sm-3 control-label">주소</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="store_addr"
										       name="store_addr" required="required" value=${store.store_addr}>
									</div>
								</div>
								<div class="form-group">
									<label for="store_pnum" class="col-sm-3 control-label">전화번호</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="store_pnum"
										       name="store_pnum" required="required" value=${store.store_pnum}>
									</div>
								</div>
								<div class="form-group">
									<label for="store_postno" class="col-sm-3 control-label">우편번호</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="store_postno"
										       name="store_postno" required="required" value=${store.store_postno}>
									</div>
								</div>
								<div class="form-group" style="display:none">
									<label for="staff_pnum" class="col-sm-3 control-label">본사 관리자 번호</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="admin_no"
										       name="admin_no" required="required" value=${store.admin_no}>
									</div>
								</div>
								<div class="form-group" style="display:none">
									<label for="staff_no" class="col-sm-3 control-label">지점 번호</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="store_no"
										       name="store_no" required="required" value=${store.store_no}>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<input type="submit"
										       class="btn btn-primary btn-block" value="정보 수정">
										<input type="button" class="btn btn-primary btn-block"
										       onclick="location.href = '/manage_branch'" value="취소">
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
<jsp:include page="../footer.jsp"/>