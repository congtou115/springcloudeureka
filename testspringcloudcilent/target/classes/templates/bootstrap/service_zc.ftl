<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gentelella Alela! | </title>
	<#include "headerjs.ftl"> 
	<link href="/bootstrap/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="/bootstrap/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
    <!-- Select2 -->
    <link href="/bootstrap/vendors/select2/dist/css/select2.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="/bootstrap/vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="/bootstrap/vendors/starrr/dist/starrr.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="/bootstrap/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
  </head>
  <body class="nav-md">
  	<#assign nav = 101>
    <div class="container body">
      <div class="main_container">
      	<#include "left_nav.ftl"> 
      	<!-- page content -->
      		<div class="right_col" role="main">
	          <div class="">
	          <div class="page-title">
	              <div class="title_left">
	                <h3>添加接口信息</h3>
	              </div>
				  <div class="title_leftt" style="display:;">
	                <h3>修改接口信息</h3>
	              </div>
	            </div>
			<div>
				<form action="">
					<table>
						<tr class="center">
							<td>所属公司：</td>
							<td><input type="text" name=""></td>
						</tr>
						<tr class="center">
							<td>项目名称：</td>
							<td><input type="text" name=""></td>
						</tr>
						<tr class="center">
							<td>接口名称：</td>
							<td><input type="text" name=""></td>
						</tr>
						<tr class="center">
							<td>请求URL：</td>
							<td><input type="text" name=""></td>
						</tr>
						<tr class="center">
							<td>请求方式：</td>
							<td>
								<select>
									<option>GET</option>
									<option>POST</option>
								</select>
							</td>
						</tr>
						<tr class="center">
							<td>请求参数类型：</td>
							<td>
								<select>
									<option>JSON</option>
									<option>XML</option>
								</select>
							</td>
						</tr>
						<tr class="center">
							<td>请求参数：</td>
							<td>
								<table id="request_t">
									<tr>
										<th>参数名</th>
										<th>必选</th>
										<th>参数类型</th>
										<th>说明</th>
									</tr><span onclick="tjrqp();"><b>+</b></span>
								</table>
							</td>
						</tr>
						<tr class="center">
							<td>返回示例：</td>
							<td>
								<input name="">
							</td>
						</tr>
						<tr class="center">
							<td>返回参数：</td>
							<td>
								<table id="return_t">
									<tr>
										<th>参数名</th>
										<th>参数类型</th>
										<th>说明</th>
									</tr><span onclick="tjrtp();"><b>+</b></span>
								</table>
							</td>
						</tr>
						<tr class="center">
							<td colspan="2">
								<input value="返回" type="button">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
      	<!-- page content -->
      	<#include "foot_nav.ftl"> 
      </div>
    </div>
    </div>
    <#include "footjs.ftl"> 
<script src="/bootstrap/vendors/iCheck/icheck.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="/bootstrap/vendors/moment/min/moment.min.js"></script>
    <script src="/bootstrap/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="/bootstrap/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
    <script src="/bootstrap/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
    <script src="/bootstrap/vendors/google-code-prettify/src/prettify.js"></script>
    <!-- jQuery Tags Input -->
    <script src="/bootstrap/vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
    <!-- Switchery -->
    <script src="/bootstrap/vendors/switchery/dist/switchery.min.js"></script>
    <!-- Select2 -->
    <script src="/bootstrap/vendors/select2/dist/js/select2.full.min.js"></script>
    <!-- Parsley -->
    <script src="/bootstrap/vendors/parsleyjs/dist/parsley.min.js"></script>
    <!-- Autosize -->
    <script src="/bootstrap/vendors/autosize/dist/autosize.min.js"></script>
    <!-- jQuery autocomplete -->
    <script src="/bootstrap/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
    <!-- starrr -->
    <script src="/bootstrap/vendors/starrr/dist/starrr.js"></script>
</body>

<script type="text/javascript">
function tjrqp() {
	var table1 = document.getElementById('request_t');
	var addtr = $("<tr>"+
			"<td><input type='text' name='rpName' /></td>"+
			"<td><input type='text' name='rMandatory' /></td>"+
			"<td><input type='text' name='rpType' /></td>"+
			"<td><input type='text' name='rExplain' /></td>"+
			"<td><span onclick='deleteTrRow(this);'><b>-</b></span></td>"+
			"</tr>");
	addtr.appendTo(table1); 
}
function deleteTrRow(tr){
	$(tr).parent().parent().remove();
}
function tjrtp() {
	var table1 = document.getElementById('return_t');
	var addtr = $("<tr>"+
			"<td><input type='text' name='rpName' /></td>"+
			"<td><input type='text' name='rpType' /></td>"+
			"<td><input type='text' name='rExplain' /></td>"+
			"<td><span onclick='deleteTrRow(this);'><b>-</b></span></td>"+
			"</tr>");
	addtr.appendTo(table1); 
}
</script>
</html>