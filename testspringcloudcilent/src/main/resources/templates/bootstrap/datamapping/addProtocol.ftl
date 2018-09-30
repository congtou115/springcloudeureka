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
	<#include "../headerjs.ftl"> 
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
    <style  type="text/css">
    	.form-group .control-label{text-align: left;}
    </style>
    <#include "../footjs.ftl">
  </head>

  <body class="nav-md">
  	<#assign nav = 202>
    <div class="container body">
      <div class="main_container">
      	<#include "../left_nav.ftl"> 
      	<!-- page content -->
      		<div class="right_col" role="main" style="min-height: 951px;">
	          <div class="">
	            <div class="page-title">
	              <div class="title_left">
	                <h3>添加数据映射</h3>
	              </div>
	            </div>
	            <div class="clearfix"></div>
                <div class="row">
	              <div class="col-md-12 col-sm-12 col-xs-12">
	                <div class="x_panel">
	                  <div class="x_content">
	                    <br />
	                    <form class="form-horizontal form-label-left">
						  <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12">选择服务<span class="required">*</span></label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <select id="service" name="serviceId" class="form-control">
	                            <option value="-1">请选择服务</option>
	                            <#if services??>
	                            	<#list services as server>
	                            		<option value="${server.serviceId}" <#if service?? && service.serviceId == server.serviceId>
	                            		selected = "selected"</#if>>${server.serviceName}</option>
	                            	</#list>
	                            </#if>
	                          </select>
	                        </div>
	                      </div>
	                      
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12">选择接口<span class="required">*</span></label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <select id="api" name="apiId" class="form-control">
	                            <option value="-1">请选择接口</option>
	                          </select>
	                        </div>
	                      </div>
	                      
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12">选择调用方<span class="required">*</span></label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <select name="customerId" class="form-control">
	                            <option value="-1">请选择调用方</option>
	                            <#if services??>
	                            	<#list services as server>
	                            		<option value="${server.serviceId}">${server.serviceName}</option>
	                            	</#list>
	                            </#if>
	                          </select>
	                        </div>
	                      </div>
	                      <div class="page-title">
		              <div class="title_left">
		                <h3>数据映射列表 <small>展示接口配置的映射信息</small></h3>
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
			                          <th>服务提供者</th>
			                          <th>服务接口地址</th>
			                          <th>服务调用方</th>
			                          <th>有效状态</th>
			                          <th>操作</th>
			                        </tr>
			                      </thead>
			                      <tbody>
			                      	<#if list??>
			                      		<#list list as protocol>
											<tr>
												<td>${protocol.id}</td>
												<td>${protocol.api.service.serviceName}</td>
												<td>
													${protocol.api.apiUrl}
												</td>
												<td>${protocol.customer.serviceName}</td>
												<td>
												<#if protocol.status == 1> 有效
													<#else> 无效
												</#if>
												</td>
												<td>
													<a  href="data-mapping/detail/${protocol.id}" role="button">详情</a>
													<a  href="data-mapping/toUpdate/${protocol.id}" role="button">修改</a>
													<a  href="javascript:void(0)" onclick="modifyStatus(${protocol.id})" role="button">
														<#if protocol.status == 1> 设为无效
															<#else> 设为有效
														</#if>
													</a>
												</td>
											</tr>
										</#list>
									</#if>
			                      </tbody>
			                    </table>
			                  </div>
			                </div>
			              </div>
		            </div>
	                      
	                      <div class="ln_solid"></div>
	                      <div class="form-group">
	                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
	                          <button type="reset" class="btn btn-primary">重置</button>
	                          <button type="button" id="submit" class="btn btn-success">提交保存</button>
	                        </div>
	                      </div>
	
	                    </form>
	                  </div>
	                </div>
	              </div>
	            </div>
	           </div>
	          </div>
	    <!-- 引入弹框 -->
	    <#include "../dialog.ftl"> 	
	    <!-- 引入弹框 -->
      	<!-- page content -->
      	<#include "../foot_nav.ftl"> 
      </div>
    </div>
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
	<script >
		var param = {};
		function dosubmit(){
			$.ajax({
				url:"/manager/ip",
				data:$("form").serialize(),
				type:"post",
				dataType:"json",
				success:function(data){
					alert(data)
				}
			})	
		}
		$("#submit").click(dosubmit);
		
		$("#service").change(function(){
			var $this = $(this);
			var serviceId = $this.val();
			param["serviceId"] = serviceId;
			if(serviceId == -1){//没有选服务，清空api下拉选
				clearApi();
				return;
			}
			//根据serviceId去获取对应的接口列表
			cascadeApiInfo(serviceId);			
			
			
		});
		
		//清空api下拉选
		function clearApi(){
			$("#api").html('<option value="-1">请选择接口</option>');
		}
		
		//根据serviceId级联获取api信息
		function cascadeApiInfo(serviceId){
			$.ajax({
				url:"/data-mapping/apiList/"+serviceId,
				type:"get",
				dataType:"json",
				success:function(data){
					if(data.code == 500){//后台报错了
						clearApi();
						whowAlert(data.info);
						return;
					}
					//如果结果不为空，就遍历结果放到下拉选中
					var $api = $("#api")
					$api.empty();
					if(data.length > 0){
						$.each(data,function(i,n){
							$api.append('<option value="'+n.apiId+'">'+n.apiUrl+'</option>');	
						});
					}else{
						clearApi();
					}
				}
			})	
		}
		
		
	</script>
</html>