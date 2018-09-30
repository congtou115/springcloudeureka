<script src="https://cdnjs.cloudflare.com/ajax/libs/prettify/r298/run_prettify.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.9/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.9/js/bootstrap-dialog.min.js"></script>
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
