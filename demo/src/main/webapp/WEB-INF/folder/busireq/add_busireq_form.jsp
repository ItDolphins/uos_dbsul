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
			<h2>업체 요청 처리</h2>
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
					<span>처리 요망</span>
				</h3>
				<div class="widget-content">
					<div class="table-responsive">
						<table id="datatable-column-interactive" style="border-right: #ccc 1px solid"
						       class="table table-sorting table-hover table-bordered colored-header datatable">
							<thead>
							<tr>
								<th>요청번호</th>
								<th>발주번호</th>
								<th>업체 확인 여부</th>
								<th>요청 일자</th>
								<th>배송 일자</th>
								<th>배송 상태</th>
								<th>물품 번호</th>
								<th>물품 이름</th>
								<th>요청 수량</th>
							</tr>
							</thead>
							<c:choose>
								<c:when test="${fn:length(busireqList) > 0}">
									<c:forEach items="${busireqList}" var="row">
										<tr>
											<td>${row.req_no}</td>
											<td>${row.order_no}</td>
											<td>${row.busi_conf_flag}</td>
											<td>${row.order_date}</td>
											<td>${row.deliv_date}</td>
											<td>${row.deliv_state}</td>
											<td>${row.prod_no}</td>
											<td>${row.prod_name}</td>
											<td>${row.req_qnt}</td>
										</tr>
									</c:forEach>
								</c:when>
							</c:choose>
						</table>
					</div>
				</div>
			</h3>
		</div>
	</div>
	<div class="widget">
		<h3 class="widget-header clearfix">
			<h3>
				<i class="icon ion-ios-grid-view-outline" style="padding:0px 0px 0px 10px;"></i>
				<span>업체 요청 처리</span>
			</h3>
			<div class="widget-content">
				<div class="table-responsive">
					<table id="order-table" style="border-right: #ccc 1px solid"
					       class="table table-sorting table-hover table-bordered colored-header datatable">
						<thead>
						<tr>
							<th>요청번호</th>
							<th>발주번호</th>
							<th>업체 확인 여부</th>
							<th>요청 일자</th>
							<th>배송 일자</th>
							<th>배송 상태</th>
							<th>물품 번호</th>
							<th>물품 이름</th>
							<th>요청 수량</th>
						</tr>
						</thead>
						<tbody id="reqList">
						</tbody>
					</table>
				</div>
			</div>
		</h3>
	</div>
	<div class="form-group">
		<div>
			<input type="button" class="btn btn-primary btn-block" value="업체 요청 처리"
			       onclick="javascript:transfer('배송요청전','/delivReq')"/>
			<input type="button" class="btn btn-primary btn-block" value="업체 발송 확인"
			       onclick="javascript:transfer('배송요청중','/delivStart')"/>
			<input type="button" class="btn btn-primary btn-block" value="업체 발송 완료"
			       onclick="javascript:transfer('배송시작','/wrhs_process')"/>
		</div>
	</div>
</div>
<script>
    $("#datatable-column-interactive tbody tr").click(function () {
        var str = "";

        var tr = $(this);
        var tdArr = new Array();
        var td = tr.children();

        td.each(function (i) {
            tdArr.push(td.eq(i).text());
        });

        var deliv_state = td.eq(5).text();
        if (deliv_state == "배송완료")
            return;


        var req_no = td.eq(0).text();
        var order_no = td.eq(1).text();
        var busi_conf_flag = td.eq(2).text();
        var order_date = td.eq(3).text();
        var deliv_date = td.eq(4).text();
        var prod_no = td.eq(6).text();
        var prod_name = td.eq(7).text();
        var req_qnt = td.eq(8).text();


        var flag = true;
        $("#reqList tr").each(function () {
            var x = $(this).find('td').eq(0).html();
            if (x == req_no) {
                flag = false;
                return true;
            }
        })

        if (flag) {
            str += '<tr>';
            str += '<td >' + req_no + '</td>';
            str += '<td >' + order_no + '</td>';
            str += '<td >' + busi_conf_flag + '</td>';
            str += '<td >' + order_date + '</td>';
            str += '<td >' + deliv_date + '</td>';
            str += '<td >' + deliv_state + '</td>';
            str += '<td >' + prod_no + '</td>';
            str += '<td >' + prod_name + '</td>';
            str += '<td >' + req_qnt + '</td>';
            str += '</tr>';

            $("#reqList").append(str);
        }
    });
    $("#reqList ").on("click", "tr", function () {
        $(this).remove();
    });


    function tableToJson(table, state) { // 변환 함수
        var data = [];
        var headers = [];

        headers[0] = "req_no";

        for (var i = 1; i < table.rows.length; i++) {

            var tableRow = table.rows[i];
            var rowData = {};

            if (tableRow.cells[5].innerHTML !== state)
                continue;
            rowData[headers[0]] = tableRow.cells[0].innerHTML;
            data.push(rowData);
        }

        return data;
    }

    function transfer(state, target) {
        var jsonObj = tableToJson(document.getElementById("order-table"), state);
        $.ajax({
            type: "POST",
            url: target,
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(jsonObj),
            success: function () {
                window.location.href = "/add_busireq_form";
            },
            error: function (request, status, error) {

                alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    }
</script>
<!-- END SHOW HIDE COLUMNS -->
<jsp:include page="../footer.jsp"/>
