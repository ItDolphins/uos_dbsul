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
			<h2>회원 정보 수정</h2>
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
						<form class="form-horizontal form-ticket" role="form" action="/process_alter_member"
						      method="post" name='f'>
							<fieldset>
								<legend>회원 정보</legend>
								<div class="form-group">
									<label for="member_no" class="col-sm-3 control-label">번호</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" value=${member.member_no} disabled>
									</div>
								</div>
								<div class="form-group">
									<label for="member_name" class="col-sm-3 control-label">이름</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="member_name"
										       name="member_name" required="required" value=${member.member_name}>
									</div>
								</div>
								<div class="form-group">
									<label for="member_gend" class="col-sm-3 control-label">성</label>
									<div class="col-sm-9">
										<input type="radio" name="member_gend" value="M">남성</input>
										<input type="radio" name="member_gend" value="F">여성</input>
									</div>
								</div>
								<div class="form-group">
									<label for="member_birth" class="col-sm-3 control-label">생일</label>
									<div class="col-sm-9">
										<input type="date" class="form-control" id="member_birth"
										       name="member_birth" required="required" value=${member.member_birth}>
									</div>
								</div>
								<div class="form-group">
									<label for="member_mileage" class="col-sm-3 control-label">마일리지</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="member_mileage"
										       name="member_mileage" required="required" value=${member.member_mileage}>
									</div>
								</div>
								<div class="form-group">
									<label for="member_class" class="col-sm-3 control-label">등급</label>
									<div class="col-sm-9">
										<input type="radio" name="member_class" value="아이언">아이언</input>
										<input type="radio" name="member_class" value="브론즈">브론즈</input>
										<input type="radio" name="member_class" value="실버">실버</input>
										<input type="radio" name="member_class" value="골드">골드</input>
									</div>
								</div>
								<div class="form-group" style="display:none">
									<label for="member_no" class="col-sm-3 control-label">번호</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" name="member_no" value=${member.member_no}>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<input type="submit"
										       class="btn btn-primary btn-block" value="정보 수정">
										<input type="button" class="btn btn-primary btn-block"
										       onclick="location.href = '/manage_member'" value="취소">
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