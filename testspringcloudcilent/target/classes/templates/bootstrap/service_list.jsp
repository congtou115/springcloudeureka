<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>1</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>数据总线 |服务列表 </title>
    <link href="/bootstrap/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header>
	<h3>接口列表</h3>
</header>
<div>
	<table>
		<thead>
			<tr>
				<!-- <th>服务编码</th> -->
				<th>所属公司</th>
				<th>项目名称</th>
				<th>接口名称</th>
				<th>接口URL</th>
				<th>状态</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty list}">
					<c:forEach items="${scenicAreaList}" var="data" varStatus="vs" >
						<tr>
							<input value="vs.ServiceId">
							<!-- <td></td> -->
							<td>${vs.AffiliatedCompany}</td>
							<td>${vs.EntryName}</td>
							<td>${vs.InterfaceName}</td>
							<td>${vs.RequestURL}</td>
							<td>${vs.State}</td>
							<td>${vs.CreationTime}</td>
							<td>${vs.ModifiedTime}</td>
							<td>
								<input type="button" value="详情">
								<input type="button" value="修改">
								<input type="button" value="注销">
								<input type="button">
								<input type="button">
							</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</tbody>
	</table>
</div>
</body>
<script src="/bootstrap/vendors/iCheck/icheck.min.js"></script>
	<!-- Datatables -->
	<script src="/bootstrap/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
	<script src="/bootstrap/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script src="/bootstrap/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script src="/bootstrap/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script src="/bootstrap/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script src="/bootstrap/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script src="/bootstrap/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
	<script src="/bootstrap/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
	<script src="/bootstrap/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
	<script src="/bootstrap/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
	<script src="/bootstrap/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
	<script src="/bootstrap/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
	<script src="/bootstrap/vendors/jszip/dist/jszip.min.js"></script>
	<script src="/bootstrap/vendors/pdfmake/build/pdfmake.min.js"></script>
	<script src="/bootstrap/vendors/pdfmake/build/vfs_fonts.js"></script>
</html>