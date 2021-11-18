package com.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;

@Service

public class PedidoServiceImpl implements PedidoService{

	@Autowired
	@Qualifier("JPAProductoRepository")
    private ProductoRepository productoRepositorio;
	
	public void generarPedido(String idProducto, int numPedidos) {
		
		Producto producto = productoRepositorio.getProductoPorId(idProducto);
		producto.setUnidadesEnStock(producto.getUnidadesEnStock() - numPedidos);
		producto.setUnidadesEnPedido(producto.getUnidadesEnPedido() + 1);
		productoRepositorio.modificarProducto(producto);
		
	}
	
}
