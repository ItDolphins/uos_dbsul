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
			<h2>발주 처리</h2>
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
		<div class="col-md-6">
			<div class="widget">
				<h3 class="widget-header clearfix">
					<h3>
						<i class="icon ion-ios-grid-view-outline" style="padding:0px 0px 0px 10px;"></i>
						<span>발주 요청 목록</span>
					</h3>
					<div class="widget-content">
						<div class="table-responsive">
							<table id="datatable-column-interactive" style="border-right: #ccc 1px solid"
							       class="table table-sorting table-hover table-bordered colored-header datatable">
								<thead>
								<tr>
									<th>발주번호</th>
									<th>지점</th>
									<th>일자</th>
									<th>상태</th>
									<th>발주 물품</th>
								</tr>
								</thead>
								<c:choose>
									<c:when test="${fn:length(orderList) > 0}">
										<c:forEach items="${orderList}" var="row">
											<tr>
												<td>${row.order_no}</td>
												<td>${row.store_no}</td>
												<td>${row.order_date}</td>
												<td>${row.order_state}</td>
												<form action="/lookup_orderprod">
													<td><input type="hidden" name="order_no" value="${row.order_no}">
														<input type="submit" class="btn btn-primary btn-block"
														       value="발주표">
													</td>
												</form>
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
		<div class="col-md-6">
			<div class="widget">
				<h3 class="widget-header clearfix">
					<h3>
						<i class="icon ion-ios-grid-view-outline" style="padding:0px 0px 0px 10px;"></i>
						<span>발주 확인 목록</span>
					</h3>
					<div class="widget-content">
						<div class="table-responsive">
							<table id="order-table" style="border-right: #ccc 1px solid"
							       class="table table-sorting table-hover table-bordered colored-header datatable">
								<thead>
								<tr>
									<th>번호</th>
									<th>이름</th>
									<th>수량</th>
								</tr>
								</thead>
								<tbody id="orderList">
								</tbody>
							</table>
						</div>
					</div>
				</h3>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<input type="button" class="btn btn-primary btn-block" value="발주 처리" onclick="javascript:transfer()"/>
					<!--input type="button" class="btn btn-primary btn-block" onclick="location.href = '/manage_order'"
					       value="취소"-->
				</div>
			</div>
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

        var order_no = td.eq(0).text();
        var store_no = td.eq(1).text();
        var order_date = td.eq(2).text();


        var flag = true;
        $("#orderList tr").each(function () {
            var x = $(this).find('td').eq(0).html();
            if (x == order_no) {
                flag = false;
                return true;
            }
        })

        if (flag) {
            str += '<tr>';
            str += '<td >' + order_no + '</td>';
            str += '<td >' + store_no + '</td>';
            str += '<td >' + order_date + '</td>';
            str += '</tr>';

            $("#orderList").append(str);
        }
    });
    $("#orderList ").on("click", "tr" , function () {
            $(this).remove();
    });


    function tableToJson(table) { // 변환 함수
        var data = [];
        var header

        header = "order_no";

        for (var i = 1; i < table.rows.length; i++) {

            var tableRow = table.rows[i];
            var rowData = {};
            rowData[header] = tableRow.cells[0].innerHTML;

            data.push(rowData);
        }

        return data;
    }

    function transfer(e) {
        var jsonObj = tableToJson(document.getElementById("order-table"));
        $.ajax({
            type: "POST",
            url: "/req_order_process",
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(jsonObj),
            success: function () {
                window.location.href = "/add_busireq";
            },
	        error:function(request,status,error){

                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
    }
</script>
<!-- END SHOW HIDE COLUMNS -->
<jsp:include page="../footer.jsp"/>
