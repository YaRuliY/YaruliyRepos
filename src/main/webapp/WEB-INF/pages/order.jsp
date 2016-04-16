<!doctype html>
<html>
<head>
	<title>All Orders</title>
	<link rel="stylesheet" href="css/main.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.js"></script>
	<script>
		function getOrder(){
			$.post("/order/data.do", function(){ location.reload(); })
		}
		$(document).ready(function() {
			$.getJSON("/order/data.do",
					function(data){
						var table = document.getElementById("table");
						var header = table.createTHead();
						var headerRow = header.insertRow(0);
						headerRow.insertCell(0).innerHTML = "<b>ID</b>";
						headerRow.insertCell(1).innerHTML = "<b>Date</b>";;
						for (var i = 0; i < data.length; i++){
							var row = table.insertRow(i+1);
							row.insertCell(0).innerHTML = data[i][0];
							row.insertCell(1).innerHTML = data[i][1];
						}
					})
		});
	</script>
</head>
<body>
	<div id="main">
		<h1>All Orders</h1>
		<table id="table"></table>
		<div style="margin-top: 10px;">
			<button type="button" class="btn btn-default" onclick="window.location='insert'">Add User</button>
			<button type="button" class="btn btn-default" onClick="window.location='getter'">Refresh Table</button>
			<button type="button" class="btn btn-default" onClick="window.location='search'">Search User</button>
		</div>
	</div>
</body>
</html>