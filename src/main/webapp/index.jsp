<html>
<head>
<style>
.button {
  font: bold 15px Arial;
  text-decoration: none;
  background-color: silver;
  color: #333333;
  padding: 2px 6px 2px 6px;
  border-top: 1px solid #CCCCCC;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;
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
  background-image: url("https://images.pexels.com/photos/1054218/pexels-photo-1054218.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
  background-size:cover; 
	 }
</style>
</head>
<body>
<div>
<fieldset>
<form action="/Devops_Example/api/login" method="POST">

	<label for="username">Username</label>
	<input type="text" name="username"> <br><br>
	<label for="password">Password</label>
	<input type="password" name="password"> <br><br>
	<input type="submit" class="button" value="Sign In">

</form>
</fieldset>
</div>
</body>
</html>
