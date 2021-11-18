package com.curso.service;

import java.util.List;

import com.curso.domain.Producto;
import com.curso.excepciones.GestionProductoException;

public interface ProductoService {

	public List<Producto> getAllProduct();
	public Producto getProductoPorId(String productoId);
	public List<Producto> productosPorCategoria(String categoria);
	public void crearProducto(Producto nuevoProducto) throws GestionProductoException;
	public void modificarProducto(Producto modificarProducto);
	public void borrarProducto(Producto producto);
	
	public void cambiarPrecio(List<Producto> productos, double nuevoPrecio) throws GestionProductoException;
}
