
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet"
              href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Products</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>
                    	Paises
                    </h1>
                    <p>Todos los paises de tu region seleccionada!</p>
                </div>
            </div>
        </section>

        <section class="container">
            <div class="row">
                <c:forEach items="${paises}" var="paises">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${paises.nombre}</h3>
                            
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <a href="region/pais/nuevo${paises.regionId}" class="btn btn-primary btn-lg active" role="button">Añadir nuevo pais</a>
            </div>
        </section>
    </body>
</html>
