<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<table border="8">
		<th>
			<td>serviceID</td>
			<td>instances</td>
			<td>operations</td>
		</th>
		<#list services as service>
			<tr>
				<td>${service.serviceId}</td>
				<td>
					
				</td>
				<td>查看白名单</td>
			</tr>
		</#list>
	</table>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>