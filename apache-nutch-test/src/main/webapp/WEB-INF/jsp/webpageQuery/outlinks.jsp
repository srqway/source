<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>outlinks</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="/apache-nutch-test/javascript/bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/apache-nutch-test/javascript/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<script
	src="/apache-nutch-test/javascript/jquery-2.1.4/jquery-2.1.4.min.js"></script>
<script
	src="/apache-nutch-test/javascript/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div style='padding: 10px; background: #fff;'>
		<table class="table table-bordered"
			style="table-layout: fixed; width: 100%;">
			<caption>
				<a href='${entity.f.baseUrl}' target="_blank"><strong>${entity.f.baseUrl}</strong></a>
			</caption>
			<tbody>
				<c:forEach var="v" varStatus="status" items="${entity.ol.urlMap}">
					<tr>
						<th class="info" style="width: 30px;">${status.index}</th>
						<td class="success"
							style="width: 200px; cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"
							title="${v.value}">${v.value}</td>
						<td class="danger"
							style="cursor: help; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"
							title="${v.key}"><a href='${v.key}' target="_blank">${v.key}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>