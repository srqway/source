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
<style type="text/css">
td {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
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
								<input type="text" class="form-control" name="startKey" placeholder="start key" 
									data-ng-model="criteria.startKey">
							</div>
							<div class="col-xs-2">
								<input type="number" class="form-control" name="limit" placeholder="limit"
									data-ng-model="criteria.limit" />
							</div>
							<div class="col-xs-2">
								<input type="submit" class="btn btn-success" value="submit" data-ng-click="submit()" />
							</div>
						</div>
					</form>
				</div>
				<div class="panel-body table-responsive">
					<table class="table" data-ng-show="webPageVos != null">
						<thead>
							<tr>
								<th title='key'>key</th>
								<th style="width: 300px;" title='title'>title</th>
								<th style="width: 300px;" title='base url'>base url</th>
								<th style="width: 50px;" title='status'>crawl status</th>
								<th title='prev fetch time'>prev fetch time</th>
								<th title='fetch time'>fetch time</th>
								<th title='fetch interval'>fetch interval</th>
								<th title='retries since fetch'>retries since fetch</th>
								<th title='repr url'>repr url</th>
								<th title='content'>content</th>
								<th title='content type'>content type</th>
								<th title='protocol status'>protocol status</th>
								<th title='modified time'>modified time</th>
								<th title='prev modified time'>prev modified time</th>
								<th title='batch id'>batch id</th>
								<th title='text'>text</th>
								<th title='parseStatus'>parseStatus</th>
								<th title='signature'>signature</th>
								<th title='prev signature'>prev signature</th>
								<th title='score'>score</th>
								<th title='headers'>headers</th>
								<th title='inlinks'>inlinks</th>
								<th title='outlinks'>outlinks</th>
								<th title='metadata'>metadata</th>
								<th title='markers'>markers</th>
							</tr>
						</thead>
						<tbody>
							<tr data-ng-repeat="webPageVo in webPageVos">
								<td style="max-width: 100px; min-width: 100px;" style="max-width: 100px; min-width: 100px;" title='{{webPageVo.key}}'>{{webPageVo.key}}</td>
								<td style="max-width: 300px; min-width: 300px;" title='{{webPageVo.title}}'>{{webPageVo.title}}</td>
								<td style="max-width: 500px; min-width: 500px;" title='{{webPageVo.baseUrl}}'>{{webPageVo.baseUrl}}</td>
								<td style="max-width: 150px; min-width: 150px;" title='{{webPageVo.crawlStatus}}'>{{webPageVo.crawlStatus}}</td>
								<td style="max-width: 200px; min-width: 200px;" title='{{webPageVo.prevFetchTime}}'>{{webPageVo.prevFetchTime}}</td>
								<td style="max-width: 200px; min-width: 200px;" title='{{webPageVo.fetchTime}}'>{{webPageVo.fetchTime}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.fetchInterval}}'>{{webPageVo.fetchInterval}}</td>
								<td style="max-width: 50px; min-width: 50px;" title='{{webPageVo.retriesSinceFetch}}'>{{webPageVo.retriesSinceFetch}}</td>
								<td style="max-width: 500px; min-width: 500px;" title='{{webPageVo.reprUrl}}'>{{webPageVo.reprUrl}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.content}}'>{{webPageVo.content}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.contentType}}'>{{webPageVo.contentType}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.protocolStatusVo | json}}'>{{webPageVo.protocolStatusVo | json}}</td>
								<td style="max-width: 200px; min-width: 200px;" title='{{webPageVo.modifiedTime}}'>{{webPageVo.modifiedTime}}</td>
								<td style="max-width: 200px; min-width: 200px;" title='{{webPageVo.prevModifiedTime}}'>{{webPageVo.prevModifiedTime}}</td>
								<td style="max-width: 200px; min-width: 200px;" title='{{webPageVo.batchId}}'>{{webPageVo.batchId}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.text}}'>{{webPageVo.text}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.parseStatusVo | json}}'>{{webPageVo.parseStatusVo | json}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.signature}}'>{{webPageVo.signature}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.prevSignature}}'>{{webPageVo.prevSignature}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.score}}'>{{webPageVo.score}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.headers | json}}'>{{webPageVo.headers | json}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.inlinks | json}}'>{{webPageVo.inlinks | json}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.outlinks | json}}'>{{webPageVo.outlinks | json}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.metadata | json}}'>{{webPageVo.metadata | json}}</td>
								<td style="max-width: 100px; min-width: 100px;" title='{{webPageVo.markers | json}}'>{{webPageVo.markers | json}}</td>
							</tr>
						</tbody>
					</table>
					<div class="alert alert-warning" role="alert" data-ng-show="webPageVos == null">
						<span class="glyphicon glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span>&nbsp;&nbsp;no data
					</div>
				</div>
				<div class="panel-footer" data-ng-show="message != null">
					{{message}}
				</div>
			</div>
		</div>
	</div>
	<br>
</body>
<script>
	var myApp = angular.module('myApp', [])
		.controller('MyController', ['$scope', '$http', function($scope, $http) {
			$scope.criteria = {};
			$scope.criteria.limit = 1;

			$scope.submit = function() {
				var config = {
					method : 'GET',
					url : 'query',
					params : $scope.criteria
				};
				$http(config).then(function(response) {
					$scope.message = 'status : ' + response.status;
					$scope.webPageVos = response.data;
				}, function(response) {
					$scope.message = 'status : ' + response.status;
				});
			};
		}]);
</script>
</html>