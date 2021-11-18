<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Bienvenida</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${saludo } </h1>
				<p> ${linea1 } </p>
				<a href="region" class="btn btn-primary btn-lg active" role="button">Ver las regiones</a>
			</div>
		</div>
	</section>
	
	<nav>
	
		<a href="comercio/productos" class="btn btn-primary btn-lg active" role="button">Productos</a>
		<a href="comercio/productos/nuevo" class="btn btn-primary btn-lg active" role="button">Nuevo Producto</a>
	</nav>
	
</body>
</html>
