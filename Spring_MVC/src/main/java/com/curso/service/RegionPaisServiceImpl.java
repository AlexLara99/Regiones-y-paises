package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.domain.Pais;
import com.curso.domain.Region;
import com.curso.domain.repository.RegionPaisRepository;
@Service
public class RegionPaisServiceImpl implements RegionPaisService {

	@Autowired
	RegionPaisRepository regionPaisRepository;
	
	@Override
	public List<Region> listaRegion() {
		
		return regionPaisRepository.listaRegiones();
	}

	@Override
	public List<Pais> listaPaisPorRegion(int idRegion) {
		
		return regionPaisRepository.listaPaisPorRegion(idRegion);
	}

}
