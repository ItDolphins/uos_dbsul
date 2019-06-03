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
            <h2>반품 폐기 등록</h2>
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
                        <h3><i class="icon ion-compose"></i> <span>등록 양식</span></h3>
                        <div class="btn-group widget-header-toolbar visible-lg">
                            <a href="#" title="Expand/Collapse" class="btn btn-link btn-toggle-expand"><i
                                    class="icon ion-ios-arrow-up"></i></a>
                            <!--a href="#" title="Remove" class="btn btn-link btn-remove"><i class="icon ion-ios-close-empty"></i--></a>
                        </div>
                    </div>
                    <div class="widget-content">
                        <form class="form-horizontal form-ticket" role="form" action="/otherRls_process"
                              method="post" name='f'>
                            <fieldset>
                                <legend>반품 폐기 정보</legend>
                                <div class="form-group">
                                    <label for="prod_no" class="col-sm-3 control-label">상품 번호</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="prod_no" name="prod_no"
                                               required="required"
                                               placeholder="상품 번호">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="expdate" class="col-sm-3 control-label">유통기한</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="expdate" name="expdate"
                                               required="required" placeholder="yyyy-mm-dd 형태로 입력">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="rls_qnt" class="col-sm-3 control-label">갯수</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="rls_qnt" name="rls_qnt"
                                               required="required"
                                               placeholder="갯수">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="rls_code" class="col-sm-3 control-label">반품 폐기 코드</label>
                                    <div class="col-sm-9">
                                        <select id="ticket-priority" name="rls_code" class="select-ticket-priority">
                                        	<option value="B-1">유통기한 폐기</option>
                                        	<option value="B-2">파손으로 인한 폐기</option>
                                        	<option value="C-1">불량으로 인한 반품</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-3 col-sm-9">
                                        <input type="submit"
                                               class="btn btn-primary btn-block" value="반품 폐기">
                                        <input type="button" class="btn btn-primary btn-block"
                                               onclick="location.href = '/home'" value="취소">
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
<!-- END TICKET FORM -->
<jsp:include page="../footer.jsp"/>