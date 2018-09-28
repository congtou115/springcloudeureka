<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>2</title>
</head>
<body>
<header>
	<h3>接口信息</h3>
</header>
<div>
	<table>
		<tr class="center">
			<td>所属公司：</td>
			<td><input type="text"></td>
		</tr>
		<tr class="center">
			<td>项目名称：</td>
			<td><input type="text"></td>
		</tr>
		<tr class="center">
			<td>接口名称：</td>
			<td><input type="text"></td>
		</tr>
		<tr class="center">
			<td>请求URL：</td>
			<td><input type="text"></td>
		</tr>
		<tr class="center">
			<td>请求方式：</td>
			<td><input type="text"></td>
		</tr>
		<tr class="center">
			<td>请求参数：</td>
			<td>
				<table>
					<thead>
						<tr>
							<th class="center">参数名</th>
							<th class="center">必选</th>
							<th class="center">参数类型</th>
							<th class="center">说明</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty list}">
								<c:forEach items="${scenicAreaList}" var="data" varStatus="vs" >
									<tr>
										<input>
										<input>
										<td></td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</tbody>
				</table>
			</td>
		</tr>
		<tr class="center">
			<td>返回示例：</td>
			<td></td>
		</tr>
		<tr class="center">
			<td>返回参数：</td>
			<td>
				<table>
					<thead>
						<tr>
							<th class="center">参数名</th>
							<th class="center">参数类型</th>
							<th class="center">说明</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty list}">
								<c:forEach items="${scenicAreaList}" var="data" varStatus="vs" >
									<tr>
										<input>
										<input>
										<td></td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</tbody>
				</table>
			</td>
		</tr>
		<tr class="center">
			<td colspan="2">
				<input>
			</td>
		</tr>
	</table>
</div>
</body>
</html>