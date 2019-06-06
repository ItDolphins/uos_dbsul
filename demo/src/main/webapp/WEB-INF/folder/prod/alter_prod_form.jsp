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
            <h2>물품 정보 수정</h2>
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
        </div>
        <!-- end quick task modal -->
        <!-- END PRIMARY CONTENT HEADING -->
        <div class="row">
            <div class="col-md-9">
                <!-- TICKET FORM -->
                <div class="widget">
					<div class="widget-header clearfix">
						<h3><i class="icon ion-compose"></i> <span>물품 정보 수정</span></h3>
						<div class="btn-group widget-header-toolbar visible-lg">
							<a href="#" title="Expand/Collapse" class="btn btn-link btn-toggle-expand"><i class="icon ion-ios-arrow-up"></i></a>
							<a href="#" title="Remove" class="btn btn-link btn-remove"><i class="icon ion-ios-close-empty"></i></a>
						</div>
					</div>
					<div class="widget-content">
						<form class="form-horizontal form-ticket" role="form", action="/alter_prod" method="post" >
							<fieldset>
								<input type="hidden" name="prod_no" value=${prod.prod_no}>
								<legend>등록 양식</legend>
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">상품명</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="prod_name" name="prod_name" placeholder="상품명" value= ${prod.prod_name}>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">가격</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="prod_price" name="prod_price" placeholder="가격"value= ${prod.prod_price}>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">업체명</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="busi_name" name="busi_name" placeholder="업체명"value= ${prod.busi_name}>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">위험도</label>
									<div class="col-sm-9">
										<select id="dmg_risk" name="dmg_risk" class="select-ticket-priority">
											<option value="낮음">낮음</option>
											<option value="중간" >중간</option>
											<option value="높음" >높음</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">판매여부</label>
									<div class="col-sm-9">
										<select id="prod_code" name="prod_code" class="select-ticket-priority">
											<option value="Y">Y</option>
											<option value="N" >N</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-primary">양식 제출</button>
										<button type="button" class="btn btn-primary"  onclick="location.href = '/prod_manage'">취소</button>
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

<script>

</script>