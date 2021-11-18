package com.curso.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;
import com.curso.excepciones.GestionProductoException;

@Service
@Transactional(propagation = Propagation.REQUIRED,
				rollbackFor = GestionProductoException.class)

public class ProductoServiceImpl implements ProductoService {

	@Autowired
	@Qualifier("JPAProductoRepository")
    private ProductoRepository productoRepositorio;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Producto> productosPorCategoria(String categoria) {
		
		return productoRepositorio.getProductosPorCategoria(categoria);
	}

	@Override
	public void crearProducto(Producto nuevoProducto) throws GestionProductoException {
		//busco si existe
		if(productoRepositorio.getProductoPorId(nuevoProducto.getIdProducto()) != null) {
			throw new GestionProductoException(nuevoProducto.getIdProducto(),"Ya existe este producto con la id");
		}
		productoRepositorio.introducirProducto(nuevoProducto);
		
	}

	@Override
	public void modificarProducto(Producto modificarProducto) {
		productoRepositorio.modificarProducto(modificarProducto);
		
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Producto> getAllProduct() {
		
		return productoRepositorio.getAllProductos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Producto getProductoPorId(String productoId) {
		// TODO Auto-generated method stub
		return productoRepositorio.getProductoPorId(productoId);
	}

	@Override
	public void borrarProducto(Producto producto) {
		
		productoRepositorio.borrarProducto(producto);
		
	}

	@Override
	public void cambiarPrecio(List<Producto> productos, double nuevoPrecio) throws GestionProductoException {

		for(Producto p : productos) {
			if(p.getPrecioUnitario().doubleValue() > nuevoPrecio) {
				throw new GestionProductoException(p.getIdProducto(), "No se pudo cambiar el precio ya que el nuevo "
						+ "no puede ser menor");
			}
			p.setPrecioUnitario(new BigDecimal(nuevoPrecio));
		}
		
	}

}
