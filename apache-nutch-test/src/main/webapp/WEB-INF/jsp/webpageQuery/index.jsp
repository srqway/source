<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>webpage query</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="/apache-nutch-test/javascript/jquery-ui-1.11.4.custom/jquery-ui.min.css">
<link rel="stylesheet"
	href="/apache-nutch-test/javascript/bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/apache-nutch-test/javascript/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="/apache-nutch-test/javascript/DataTables-1.10.7/media/css/jquery.dataTables.css">
<link rel="stylesheet"
	href="/apache-nutch-test/javascript/DataTables-1.10.7/integration/jqueryui/dataTables.jqueryui.css">
<link rel="stylesheet"
	href="/apache-nutch-test/javascript/colorbox-master/example5/colorbox.css">
<style type="text/css">
#navheader, #result-div, .marginDiv {
	margin: 15px;
}
</style>
<script src="/apache-nutch-test/javascript/jquery-2.1.4/jquery-2.1.4.min.js"></script>
<script src="/apache-nutch-test/javascript/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<script
	src="/apache-nutch-test/javascript/DataTables-1.10.7/media/js/jquery.dataTables.js"></script>
<script src="/apache-nutch-test/javascript/colorbox-master/jquery.colorbox-min.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		var height = $(window).height() - 200;
		$('#table_id').DataTable({
			"info" : false,
			"ordering" : false,
			// 			"order" : [ [ 2, "desc" ] ],
			"paging" : false,
			"scrollY" : height + "px",
			"scrollX" : true,
			"scrollXInner" : "200%",
			"scrollCollapse" : true,
			"jQueryUI" : true,
			"language" : {
				"search" : "篩選:",
				"emptyTable" : "查無資料",
				"info" : "顯示 _START_ 到 _END_ 筆 / 共 _TOTAL_ 筆",
				"infoEmpty" : "",
				"sInfoFiltered" : "(篩選前共 _MAX_ 筆)",
				"lengthMenu" : '顯示 _MENU_ 筆',
				"zeroRecords" : "無符合資料",
				"paginate" : {
					"first" : "第一筆",
					"sLast" : "最後一筆",
					"sNext" : "下一筆",
					"sPrevious" : "前一筆"
				}
			}
		});
		$("#get").on("click", function() {
			var startRowKey = $("#startRowKey").val().trim();
			if (startRowKey.length != 0) {
				$("#rowKey").val(startRowKey);
			}
			$(".scan").each(function() {
				$(this).hide();
			});
			$(".get").each(function() {
				$(this).show();
			});
		});
		$("#scan").on("click", function() {
			var rowKey = $("#rowKey").val().trim();
			if (rowKey.length != 0) {
				$("#startRowKey").val(rowKey);
			}
			$(".get").each(function() {
				$(this).hide();
			});
			$(".scan").each(function() {
				$(this).show();
			});
		});
		$("#clearScan").on("click", function() {
			$("#startRowKey").val("");
			$("#pageSize").val("");
		});
		$("#clearGet").on("click", function() {
			$("#rowKey").val("");
		});
		$("#pageSize").keydown(function(event) {
			var keyCode = event.which;
			if ((keyCode >= 48 && keyCode <= 57) || keyCode == 8) {
			} else {
				event.preventDefault();
			}
		});
		$(document).bind('cbox_load', function() {
			setTimeout($.colorbox.next, 1500);
		});
		$(".inline").colorbox({
			inline : true,
			width : "80%",
			transition : "none"
		});

	});
</script>
<body>
	<nav id="navheader" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" data-target="#navContent"
					data-toggle="collapse" class="navbar-toggle">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="javascript:void(0);" class="navbar-brand scan"
					<c:if test='${queryType == null || queryType == "get"}'>style="display: none;"</c:if>><strong>Scan</strong>
				</a>
				<a href="javascript:void(0);" class="navbar-brand get"
					<c:if test='${queryType == "scan"}'>style="display: none;"</c:if>><strong>Get</strong>
				</a>
			</div>
			<div id="navContent" class="collapse navbar-collapse">
				<form role="search" class="navbar-form navbar-left get"
					method="post" action='get'
					<c:if test='${queryType == "scan"}'>style="display: none;"</c:if>>
					<input type="hidden" name="queryType" value="get">
					<div class="row">
						<div class="col-xs-12">
							<input id="rowKey" name="rowKey"
								value='<c:out value="${rowKey}"></c:out>' type="text"
								placeholder="" class="form-control" style="width: 800px;">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button id="clearGet" type="button" class="btn btn-warning"
								title="清除">
								<span class="glyphicon glyphicon-erase "></span>
							</button>
							&nbsp;&nbsp;
							<button type="submit" class="btn btn-success" title="送出">
								<span class="glyphicon glyphicon-search "></span>
							</button>
						</div>
					</div>
				</form>
				<form role="search" class="navbar-form navbar-left scan"
					method="post" action='scan'
					<c:if test='${queryType == null || queryType != "scan"}'>style="display: none;"</c:if>>
					<input type="hidden" name="queryType" value="scan">
					<div class="row">
						<div class="col-xs-12">
							<input id="startRowKey" name="startRowKey"
								value='<c:out value="${startRowKey}"></c:out>' type="text"
								placeholder="" class="form-control" style="width: 800px;">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>筆數
								： </strong> <input id="pageSize" name="pageSize"
								value='<c:out value="${pageSize}"></c:out>' type="text"
								placeholder="10" class="form-control" style="width: 50px;">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="input-group">
								<button id="clearScan" type="button" class="btn btn-warning"
									title="清除">
									<span class="glyphicon glyphicon-erase "></span>
								</button>
								&nbsp;&nbsp;
								<button type="submit" class="btn btn-success" title="送出">
									<span class="glyphicon glyphicon-search "></span>
								</button>
							</div>
						</div>
					</div>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li id="scan" class="get"
						<c:if test='${queryType == "scan"}'>style="display: none;"</c:if>><a
						class="glyphicon glyphicon-log-out" href="javascript:void(0);"
						style="color: rgb(51, 122, 183);">Scan</a></li>
					<li id="get" class="scan"
						<c:if test='${queryType == null || queryType != "scan"}'>style="display: none;"</c:if>><a
						class="glyphicon glyphicon-log-out" href="javascript:void(0);"
						style="color: rgb(51, 122, 183);">Get</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<br />
	<br />
	<br />
	<div id="result-div">
		<c:choose>
			<c:when test='${isQuery == true}'>
				<c:choose>
					<c:when test='${entities != null && entities.size() > 0}'>
						<table id="table_id" class="display"
							style="table-layout: fixed; width: 60%;">
							<thead>
								<tr>
									<th style="width: 1px;">#</th>
									<th style="width: 30px;">Row Key</th>
									<th style="width: 80px;">Title</th>
									<th style="width: 5px;">Parse Status</th>
									<th style="width: 30px;">Signature</th>
									<th style="width: 30px;">Prev Signature</th>
									<th style="width: 30px;">Base Url</th>
									<th style="width: 5px;">Status</th>
									<th style="width: 30px;">Prev Fetch Time</th>
									<th style="width: 30px;">Fetch Time</th>
									<th style="width: 5px;">Fetch Interval</th>
									<th style="width: 30px;">Retries Since Fetch</th>
									<th style="width: 30px;">Repr Url</th>
									<th style="width: 30px;">Content Type</th>
									<th style="width: 5px;">Protocol Status</th>
									<th style="width: 30px;">Modified Time</th>
									<th style="width: 30px;">Prev Modified Time</th>
									<th style="width: 30px;">Batch Id</th>
									<th style="width: 30px;">Score</th>
									<th style="width: 30px;">Headers</th>
									<th style="width: 30px;">Inlinks</th>
									<th style="width: 30px;">Outlinks</th>
									<th style="width: 30px;">Metadata</th>
									<th style="width: 30px;">Markers</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="v" varStatus="status" items="${entities}">
									<tr>
										<td align="right">${status.index}</td>
										<td title='${v.rowKey}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.rowKey}</td>
										<td title='${v.p.title}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.p.title}</td>
										<td
											title='${v.p.parseStatus}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.p.parseStatus}</td>
										<td title='${v.p.signature}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.p.signature}</td>
										<td
											title='${v.p.prevSignature}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.p.prevSignature}</td>
										<td
											style="cursor: pointer; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"><a
											href='${v.f.baseUrl}' target="_blank">${v.f.baseUrl}</a></td>
										<td title='${v.f.status}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.f.status}</td>
										<td
											title='<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${v.f.prevFetchTime}"/>'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${v.f.prevFetchTime}"/></td>
										<td
											title='<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${v.f.fetchTime}"/>'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${v.f.fetchTime}"/></td>
										<td
											title='${v.f.fetchInterval}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.f.fetchInterval}</td>
										<td
											title='${v.f.retriesSinceFetch}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.f.retriesSinceFetch}</td>
										<td title='${v.f.reprUrl}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.f.reprUrl}</td>
										<td
											title='${v.f.contentType}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.f.contentType}</td>
										<td
											title='${v.f.protocolStatus}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.f.protocolStatus}</td>
										<td
											title='<fmt:formatDate pattern="yyyy/MM/dd" value="${v.f.modifiedTime}"/>'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"><fmt:formatDate pattern="yyyy/MM/dd" value="${v.f.modifiedTime}"/></td>
										<td
											title='<fmt:formatDate pattern="yyyy/MM/dd" value="${v.f.prevModifiedTime}"/>'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"><fmt:formatDate pattern="yyyy/MM/dd" value="${v.f.prevModifiedTime}"/></td>
										<td title='${v.f.batchId}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.f.batchId}</td>
										<td title='${v.s.score}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.s.score}</td>
										<td title='${v.h.string}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.h.string}</td>
										<td title='${v.il.string}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${v.il.string}</td>
										<td
											style="cursor: pointer; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"><a
											class='inline' href='#ol_${status.index}'>${v.ol.firstUrl}</a></td>
										<td title='${status.mtdt.string}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${status.mtdt.string}</td>
										<td title='${status.mk.string}'
											style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${status.mk.string}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<div class="alert alert-warning" role="alert">
							<span class="glyphicon glyphicon glyphicon-exclamation-sign"
								aria-hidden="true"></span>&nbsp;&nbsp;查無資料
						</div>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<div class="alert alert-info" role="alert">
					<span class="glyphicon glyphicon glyphicon-info-sign"
						aria-hidden="true"></span>&nbsp;&nbsp;請輸入查詢關鍵字
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div style='display: none'>
		<c:forEach var="v" varStatus="status" items="${entities}">
			<div id='ol_${status.index}'
				style='padding: 10px; background: #fff;'>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th class="danger" colspan="2"><a
								href='${v.f.baseUrl}' target="_blank">${v.f.baseUrl}</a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="subV" varStatus="subStatus" items="${v.ol.urlList}">
							<tr>
								<th class="info">${subStatus.index}</th>
								<td class="active"><a href='${v}' target="_blank">${v}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</div>
</body>
</html>