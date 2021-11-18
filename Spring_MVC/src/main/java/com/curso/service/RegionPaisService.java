package com.curso.service;

import java.util.List;

import com.curso.domain.Pais;
import com.curso.domain.Region;

public interface RegionPaisService {

	public List<Region> listaRegion();
	public List<Pais> listaPaisPorRegion(int idRegion);
}
