package com.curso.domain.repository;

import java.util.List;

import com.curso.domain.Pais;
import com.curso.domain.Region;

public interface RegionPaisRepository {

	
	List<Region> listaRegiones();
	List<Pais> listaPaisPorRegion(int idRegion);
	
}
