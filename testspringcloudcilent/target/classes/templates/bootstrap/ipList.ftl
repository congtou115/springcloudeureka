<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentelella Alela! | </title>
	<#include "headerjs.ftl"> 
	<!-- Datatables -->
    <link href="/bootstrap/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
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
		                <h3>IP白名单列表 <small><#if service??>服务${service.serviceName}配置的<#else>全部</#if>IP白名单列表</small></h3>
		              </div>
		              <div class="title_right">
		                    <span class="input-group-btn">
		                      <a href="/manager/toAddIp<#if service??>/${service.serviceId}</#if>" type="button" class="btn btn-default ">添加IP白名单</a>
		                    </span>
		              </div>
		            </div>
		            <div class="clearfix"></div>
		            <div class="row">
		            	<div class="col-md-12 col-sm-12 col-xs-12">
			                <div class="x_panel">
			                  <div class="x_content">
			                   <!-- <p class="text-muted font-13 m-b-30">
			                      DataTables has most features enabled by default, so all you need to do to use it with your own tables is to call the construction function: <code>$().DataTable();</code>
			                    </p> -->
			                    <table id="datatable" class="table table-striped table-bordered">
			                      <thead>
			                        <tr>
			                          <th>编号</th>
			                          <th>服务名称</th>
			                          <th>IP地址</th>
			                          <th>状态</th>
			                          <th>操作</th>
			                        </tr>
			                      </thead>
			                      <tbody>
		                      		<#list ipList as ip>
										<tr>
											<td>${ip.associateId}</td>
											<td>${ip.service.serviceName}</td>
											<td>
												${ip.ip.ipAddress}
											</td>
											<td>
												
												<#if ip.status == 1> 有效
													<#else> 无效
												</#if>
											</td>
											<td>
												<a  href="/manager/ip/${ip.associateId}" role="button">修改</a>
												<a  href="javascript:void(0)" role="button" onclick="delIp(${ip.associateId},${ip.service.serviceId})">删除</a>
											</td>
										</tr>
									</#list>
			                      </tbody>
			                    </table>
			                  </div>
			                </div>
			              </div>
		            </div>
          		</div>
    		</div>
      	<!-- page content -->
      	<#include "foot_nav.ftl"> 
      </div>
    </div>
    <#include "footjs.ftl"> 
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
	<script >
		var table = $("#datatable");
		$(function(){
			var datatable ;
			if($.fn.DataTable.isDataTable( table )){//检查是否初始化过
				datatable = table.DataTable();
				datatable.destroy();//删除后以便重新配置
			}
			datatable = table.dataTable({
			    //pagingType: "full_numbers",
				"language":{
					"emptyTable": "无可用数据",
					"info":　"第_PAGE_页（共_PAGES_页）",
					"infoEmpty": "没有记录可以显示",
					"infoFiltered": " - 从 _MAX_ 记录中过滤",
					"lengthMenu": "每页显示 _MENU_ 条记录",
					"loadingRecords": "请等待，数据正在加载中......",
		            "processing": "正在处理中。。。",
		            "search": "过滤搜索:",
					"paginate": {
			          "first": "首页",
			          "last": "最后一页",
			          "next": "下一页",
			          "previous": "前一页"
			        }
				}
			});
			
		})
	</script>
</html>