package com.curso.res;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.curso.excepciones.GestionProductoException;

public class ProductoRestServiceAdvise {

	@ResponseBody
	@ExceptionHandler(GestionProductoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String productoNoEncontrado(GestionProductoException ex) {
		
		return "{msg: '" + ex.getMessage() + " id producto: "
				+ ex.getIdProducto() + " '}";
		
	}
}
