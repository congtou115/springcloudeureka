<link href="/bootstrap/bootstrap3-dialog/css/bootstrap-dialog.min.css" rel="stylesheet">
<script src="/bootstrap/bootstrap3-dialog/js/bootstrap-dialog.min.js"></script>
<script >
	function showAlert(msg,func,param,title){
		var defaultTitle = "提示信息";
		if(title){
			defaultTitle = title;
		}
		BootstrapDialog.show({
	            title: defaultTitle,
	            message: msg,
	            buttons: [{
	                label: '取消',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }, {
	                label: '确定',
	                action: function(dialog) {
	                    if(func){
	                    	if(param){
	                    		func.call(this,param)
	                    	}else{
	                    		func.call(this)
	                    	}
	                    }
	                    dialog.close();
	                }
	            }]
	        });
		
	}
</script>
