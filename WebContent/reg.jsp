<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"
    %>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body{
	height: 90vh;
	display:grid;
	place-content: center;	
	font-family: 'Open Sans Condensed', 'sans-serif';
	
}
.btn{
	margin-top: 20px;
	display:flex;
	justify-content: center;
	cursor:pointer;
}
.sub{
	border: none;
	border-radius: 5%;
	font-family: 'Open Sans Condensed', 'sans-serif';
	padding: 10px;
	margin: 10px;
}
.red{
background-color: tomato;}
.green{
background-color:green;}

.input{
display:grid;
color: gray;
}
table, thead, td {
  border: 1px solid black;
  border-collapse: collapse;
  text-align:center;
}
</style>
<body>

<form action="regController" method="post" class="reg-form">
	<div class="input"><label>FIRSTNAME :</label><input type="text"  name="firstname" ><br>
	<label>LASTNAME : </label><input type="text"  name="lastname" ><br></div>
	<!--<label>Username:</label><input type="text"  name="username" ><br> 
	<label>password:  </label><input type="password"  name="password" ><br> -->
	<div class="btn">
		<button type="submit" class="sub green" name="submit" value=1 />ADD</button>
		<button type="submit" class="sub red" name="submit" value=2 />SEARCH</button>
	</div>
</form>


<table ">
<thead>
	<td>ID</td>
	<td>FIRSTNAME</td>
	<td>LASTNAME</td>
	<td></td>
	<td></td>
</thead>
<c:forEach var ="i" items = "${sessionScope.list}">
<tr><td>${i.id}</td>
<td>${i.fn}</td>
<td>${i.ln}</td>
<form action="regController" method="post"><input type="hidden" name="delete" value=${i.id}  />
	<td><button type="submit" class="sub red" name="submit" value=3>DELETE</button>
	<td><button type="submit" class="sub green" name="submit" value=4>EDIT</button></td>
	</form>
<%-- <td><a href = "regController?id=${i.id}&submit=4">Delete..</a></td>
<td><a href = "regController?id=${i.id}&submit=3">Update..</a></td> --%> 
</tr>
</c:forEach>
</table>

</body>
</html>