package com.curso.excepciones;

public class GestionProductoException extends Exception{

	private String idProducto;

	public GestionProductoException(String idProducto, String message) {
		super(message);
		this.idProducto = idProducto;
	}

	public String getIdProducto() {
		return idProducto;
	}
	
	
}
