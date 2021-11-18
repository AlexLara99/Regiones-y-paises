package com.curso.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Producto;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
@Qualifier("JPAProductoRepository")
public class JPAProductoRepository implements ProductoRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Producto> getAllProductos() {
		Query query = em.createNamedQuery("Producto.findAll");
		return query.getResultList();
	}

	@Override
	public Producto getProductoPorId(String idProducto) {
	
		Producto p = em.find(Producto.class, idProducto);
		return p;
	}

	@Override
	public List<Producto> getProductosPorCategoria(String categoria) {
		Query query = em.createNamedQuery("Producto.findByCategoria");
		query.setParameter("categoria", categoria);
		return query.getResultList();
	}

	@Override
	public void introducirProducto(Producto nuevoProducto) {
		em.persist(nuevoProducto);
		
	}

	@Override
	public void modificarProducto(Producto modificarProducto) {
		em.merge(modificarProducto);
		
	}

	@Override
	public void borrarProducto(Producto producto) {
		//em.remove(producto);
		em.remove(em.contains(producto) ? producto : em.merge(producto));
	}

}
