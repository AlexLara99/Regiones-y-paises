package com.curso.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Pais;
import com.curso.domain.Region;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
@Qualifier("RegionPaisRepositoryImpl")
public class RegionPaisRepositoryImpl implements RegionPaisRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Region> listaRegiones() {
		Query query = em.createNamedQuery("Region.findAll");
		return query.getResultList();
	}

	@Override
	public List<Pais> listaPaisPorRegion(int idRegion) {
		Query query = em.createNamedQuery("Pais.findByRegion");
		query.setParameter("idRegion", idRegion);
		return query.getResultList();
	}

}
