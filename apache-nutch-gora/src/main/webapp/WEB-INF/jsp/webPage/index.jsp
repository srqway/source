<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html data-ng-app="myApp" data-ng-strict-di>
<head>
<meta charset="UTF-8">
<title>web page index</title>
<link
	href='<c:url value="/bower_components/bootstrap/dist/css/bootstrap.min.css"></c:url>'
	rel="stylesheet">
<script
	src='<c:url value="/bower_components/angular/angular.min.js"></c:url>'></script>
</head>
<body data-ng-controller="MyController">
	<div class="row">
		<div class="col-xs-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<form class="form-horizontal" role="form">
						<div class="row">
							<div class="col-xs-8">
								<input type="text" class="form-control" name="startKey" data-ng-model="criteria.startKey"
									placeholder="start key">
							</div>
							<div class="col-xs-2">
								<input type="number" class="form-control" name="limit" data-ng-model="criteria.limit" />
							</div>
							<div class="col-xs-2">
								<button type="submit" class="btn btn-default">submit</button>
							</div>
						</div>
					</form>
				</div>
				<div class="panel-body">
					picture
				</div>
				<div class="panel-footer table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>col 1</th>
								<th>col 2</th>
								<th>col 3</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>data 1-1 : very very very very long text.</td>
								<td>data 1-2 : very very very very long text.</td>
								<td>data 1-3 : very very very very long text.</td>
							</tr>
							<tr>
								<td>data 2-1</td>
								<td>data 2-2</td>
								<td>data 2-3</td>
							</tr>
							<tr>
								<td>data 3-1</td>
								<td>data 3-2</td>
								<td>data 3-3</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<br>
	{{criteria | json}}
</body>
<script>
	var myApp = angular.module('myApp', [])
		.controller('MyController', ['$scope', function($scope) {

		}]);
</script>
</html>