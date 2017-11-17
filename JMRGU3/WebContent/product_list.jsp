<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student list</title>
</head>
<body>
<table border="1">
		<tr>
			<th>
			  <form action="ProductController">
			  		<input type="submit" name="btn_new"
			  		value="New "/>
			  </form>
			  <a href="ProductReport">Print report</a>
			</th>
			<td>IdProducto</td>
			<td>Precio</td>
			<td>Descripcion</td>
			<td>Existencia</td>
			<td>proveedor</td>
			
		</tr>
		 <c:forEach var="product" items="${products}">
		 	 <tr>
		 	 	<td>
		 	 		<form action="ProductController">
		 	 			<input type="hidden" name="id" value="${product.id}">
		 	 			<input type="submit" name="btn_edit" value="Edit"/>
		 	 			 <input type="submit" name="btn_delete" value="Delete"/>
		 	 		</form>
		 	 	</td>
		 	 	<td>${product.id}</td>
		 	 	<td>${product.precio}</td>
		 	 	<td>${product.descripcion}</td>
		 	 	<td>${product.existencia}</td>
		 	 	<td>${product.proveedor}</td>
		 	 </tr>	
		 </c:forEach>
	</table>
</body>
</html>