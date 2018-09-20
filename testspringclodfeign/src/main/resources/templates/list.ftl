<html>
<head>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<table border="8">
		<th>
			<td>ID</td>
			<td>Name</td>
			<td>Pwd</td>
			<td>action</td>
		</th>
		<#list list as user>
			<tr>
			<form action="/user/delete/${user.id }" method="POST">
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
				
				<td><button value="delete" />
					<input type="hidden"  name="_method" value="DELETE"></input>
				</td>
			</form>
			</tr>
		</#list>
	</table>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>