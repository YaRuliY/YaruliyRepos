<!doctype html>
<html>
<head>
	<title>All Users</title>
	<link rel="stylesheet" href="css/main.css">
	<script type="text/javascript" src="css/http_code.jquery.com_jquery-1.11.3.js"></script>
	<script>
		function deleteUserByID(id){
			confirm("Delete User with ID: "+id);
			$.post("/delete.do", {id: id}, function(){ location.reload(); })
		}
		$(document).ready(function() {
			$.getJSON("/getter/data.do",
					function(data){
						var table = document.getElementById("table");
						var header = table.createTHead();
						var headerRow = header.insertRow(0);
						headerRow.insertCell(0).innerHTML = "<b>ID</b>";
						headerRow.insertCell(1).innerHTML = "<b>Name</b>";
						headerRow.insertCell(2).innerHTML = "<b>Last Name</b>";
						headerRow.insertCell(3).innerHTML = "<b>Gender</b>";
						headerRow.insertCell(4).innerHTML = "<b>City</b>";
						for (var i = 0; i < data.length; i++){
							var row = table.insertRow(i+1);
							row.insertCell(0).innerHTML = data[i][0];
							row.insertCell(1).innerHTML = data[i][2];
							row.insertCell(2).innerHTML = data[i][3];
							row.insertCell(3).innerHTML = data[i][4];
							row.insertCell(4).innerHTML = data[i][1];
							row.insertCell(data[i].length).innerHTML =
									"<input type=\"button\" value=\"D\" onclick=\"deleteUserByID(" + data[i][0] + ")\"/>"+
									"<input type=\"button\" value=\"E\" onClick=\"window.location=" + "'edit?id=" + data[i][0] + "'"+"\"/>";
						}
					})
		});
	</script>
</head>
<body>
	<div id="main">
		<h1>All Users</h1>
		<table id="table"></table>
		<div>
			<button type="button" class="btn btn-default" onclick="window.location='insert'">Add User</button>
			<button type="button" class="btn btn-default" onClick="window.location='getter'">Refresh Table</button>
			<button type="button" class="btn btn-default" onClick="window.location='search'">Search User</button>
		</div>
	</div>
</body>
</html>