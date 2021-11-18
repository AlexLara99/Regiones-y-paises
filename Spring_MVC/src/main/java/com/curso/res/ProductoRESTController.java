package com.curso.res;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.domain.Producto;
import com.curso.excepciones.GestionProductoException;
import com.curso.service.ProductoService;

@RestController
public class ProductoRESTController {

	@Autowired
	private ProductoService service;
	
	/**
	 * devuelve la lista de todos los productos
	 */
	
	@GetMapping("/rest/productos")
	public List<Producto> listaProductos(){
		
		return service.getAllProduct();
	}
	
	@PostMapping("/rest/productos")
	public void nuevoProducto(
			@RequestBody Producto producto) throws GestionProductoException {
	
		service.crearProducto(producto);

	}
	
	@GetMapping("/rest/productos/{id}") 
	public Producto getProducto(@PathVariable String id) throws GestionProductoException {
	
		Producto producto = service.getProductoPorId(id);
		if(producto==null) {
		
			throw new GestionProductoException(id,"Error producto no encontrado");
		}
		return producto;
	}
	
	@PutMapping("rest/productos/{id}")
	public void modificarProducto (
			@RequestBody Producto productoModificado,
			@PathVariable String id) throws GestionProductoException {
		
		service.modificarProducto(productoModificado);
	}
	
	@DeleteMapping("rest/productos/{id}")
	public void borrarProducto(@PathVariable String id) throws GestionProductoException{
		Producto p = service.getProductoPorId(id);
		service.borrarProducto(p);
	}
}
