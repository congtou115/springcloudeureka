<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>数据总线 |IP白名单修改 </title>
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
	                <h3>IP白名单修改</h3>
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
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12">IP地址<span class="required">*</span></label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <input name="ip" type="text" value="${associate.ip.ipAddress}" class="form-control" placeholder="请输入IP地址">
	                        </div>
	                      </div>
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12">状态<span class="required">*</span></label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <select name="status" class="form-control">
	                            <option value="1" <#if associate.status=1>selected="selected"</#if>>有效</option>
	                            <option value="0" <#if associate.status=0>selected="selected"</#if>>无效</option>
	                          </select>
	                        </div>
	                      </div>
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12">选择服务（可多选）<span class="required">*</span></label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <select class="select2_multiple form-control" multiple="multiple" required name="serviceIds">
	                          	<#if services??>
	                          		<#list services as server>
		                          		<option value="${server.serviceId}" 
			                          		<#if relationServices??>
			                          			<#list relationServices as service>
			                          				<#if service=server.serviceName>
			                          					selected="selected"
			                          				</#if>
			                          			</#list>
			                          		</#if>
			                          		<#if associate.service.serviceId=server.serviceId>
			                          			disabled = "disabled"
			                          		</#if>
		                          		>${server.serviceName}</option>
	                          		</#list>
	                          	<#else>
	                          		<option value="-1">无可用数据</option>
	                          	</#if>
	                          </select>
	                          <label for="message">本次修改只作用于选中的服务，未选中的服务将不做任何更改。</label>
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
      	<!-- page content -->
      	<#include "foot_nav.ftl"> 
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
	<script >
		function dosubmit(){
			$.ajax({
				url:"/manager/ip/${associate.associateId}",
				data:$("form").serialize(),
				type:"put",
				dataType:"json",
				success:function(data){
					alert(data)
				}
			})	
		}
		$("#submit").click(dosubmit);
	</script>
</html>