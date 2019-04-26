<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursement Home</title>
<style>
h2 {text-align:center;
	color:red;
	}
div {
  position: relative;
  top: 30%;
  display: inline-block;
	 }
fieldset {
  border: 4px solid gray;
  background-color: white;
		 }
 body {
  text-align:center;
  background-image: url("mtnbg.jpeg");
  background-size:cover; 
	 }
 table, td, th {
  border: 1px solid black;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th {
  text-align: left;
}
</style>
</head>
<body>

<h2>Welcome to Your Reimbursement Home, <%= session.getAttribute("currentUser") %>!</h2>

<div>
<fieldset>
<form action="/Devops_Example/api/todos" method="POST">
	
	<label for="title">Reason</label>
	<input type="text" name="title"><br><br>
	<label for="description">Amount</label>
	<input type="text" name="description"> <br><br>
	<input type="submit" value="Submit Reimbursement">

</form>
</fieldset>
<br><br><br>

<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Reason for Reimbursement</th>
			<th>Amount of Reimbursement</th>
		</tr>
	</thead>
	<tbody id="todoTable"></tbody>
</table>
</div>
<script>
window.onload = () => {
	console.log("loaded");
	populateTodosTable();
}

const populateTodosTable = () => {
	console.log("Inside populate todos table");
	const xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			let todos = JSON.parse(xhr.responseText);
			console.log(todos);
			addTodosToTable(todos);
		}
	}
	
	xhr.open("GET", "http://localhost:8088/Devops_Example/api/todos");
	xhr.send();
}

function addTodosToTable(todos) {
	for (let todo of todos) {
		let tdId = document.createElement("td");
		let tdTitle = document.createElement("td");
		let tdDescription = document.createElement("td");
		
		tdId.textContent = todo.id;
		tdTitle.textContent = todo.title;
		tdDescription.textContent = todo.description;
		
		let row = document.createElement("tr");
		
		row.appendChild(tdId);
		row.appendChild(tdTitle);
		row.appendChild(tdDescription);
		
		document.getElementById("todoTable").appendChild(row);
	}
}
</script>
</body>
</html>