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
            <h2>할인 이벤트 수정</h2>
            <ul class="breadcrumb pull-left">

              
            </ul>
        </div>
        <div class="row">
            <div class="col-md-9">
                <!-- TICKET FORM -->
                <div class="widget">
					<div class="widget-header clearfix">
						<h3><i class="icon ion-compose"></i> <span>할인 이벤트 수정</span></h3>
						<div class="btn-group widget-header-toolbar visible-lg">
							<a href="#" title="Expand/Collapse" class="btn btn-link btn-toggle-expand"><i class="icon ion-ios-arrow-up"></i></a>
							<a href="#" title="Remove" class="btn btn-link btn-remove"><i class="icon ion-ios-close-empty"></i></a>
						</div>
					</div>
					<div class="widget-content">
						<form class="form-horizontal form-ticket" role="form", action="/alter_dc_event" method="post" >
							<fieldset>
								<input type="hidden" name="dc_no" value=${event.dc_no}>
								<legend>등록 양식</legend>
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">이벤트명</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="event_name" name="event_name" placeholder="이벤트명" value=${event.event_name}>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">이벤트 상품</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="event_prod" name="event_prod" placeholder="이벤트 상품" value=${event.event_prod}>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">시작기간</label>
									<div class="col-sm-9">
										<input type="date" class="form-control" id="event_start_day" name="event_start_day" placeholder="시작기간" value=${event.event_start_day}>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">종료기간</label>
									<div class="col-sm-9">
										<input type="date" class="form-control" id="event_end_day" name="event_end_day" placeholder="종료기간" value=${event.event_end_day}>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">할인율</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="dc_rate" name="dc_rate" placeholder="이벤트 상품" value=${event.dc_rate}>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-primary">양식 제출</button>
										<button type="button" class="btn btn-primary"  onclick="location.href = '/event_manage'">취소</button>
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