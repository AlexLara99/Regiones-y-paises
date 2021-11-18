package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.domain.Pais;
import com.curso.service.RegionPaisService;



@Controller
public class RegionesController {

	@Autowired
	private RegionPaisService regionPaisService;
	
	@GetMapping("/region")
	public String list(Model model) {

        model.addAttribute("regiones",regionPaisService.listaRegion());

        return "regiones";
    }
	
	@GetMapping("/region/pais")
	public String listaPaises(
			@RequestParam("id") int idRegion,
			Model model) {

        model.addAttribute("paises",regionPaisService.listaPaisPorRegion(idRegion));

        return "paises";
    }
	@GetMapping("/region/pais/nuevo")
	public String irNuevoPais(
			@RequestParam("id") int idRegion,
			Model model) {
		
		Pais nuevoPais = new Pais();
		nuevoPais.getRegion().setRegionId(idRegion);
   	 	model.addAttribute("nuevoPais", nuevoPais);
       

        return "nuevo-pais";
    }
	
}
