<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Form</title>
</head>
<body>
	<form action="ProductController">
		<label>Price:</label><br />
		<input type="number" name="precio" value="${product.precio}" /><br />
		
		<label>Description:</label><br />
		<input type="text" name="descripcion" value="${product.descripcion}" /><br />
		
		<label>Existence:</label><br />
		<input type="number" name="existencia" value="${product.existencia}" /><br />
		
		<label>proveedor:</label><br />
		<input type="text" name="proveedor" value="${product.proveedor}" /><br />
		<br />
		<input type="submit" name="btn_save" value="Save" />	
	</form>
</body>
</html>