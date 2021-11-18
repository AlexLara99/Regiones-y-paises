package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.service.PedidoService;
import com.curso.service.PedidoServiceImpl;


@Controller
@RequestMapping("comercio")
public class PedidosController {

	//servicio
	@Autowired
	private PedidoService service;
	
	//@RequestMapping(path="/pedido/{idProducto}/{cantidad}", method = RequestMethod.GET) 
	@GetMapping(path="/productos/pedir") //para mappear con los get
	public String pedido(
			@RequestParam("id") String idProducto,
   		 	Model model) {
		
		//lamar al servicio que hace el pedido
		//int cant = Integer.parseInt(cantidades);
		service.generarPedido(idProducto , 1);
		
		return "redirect:/comercio/productos";
	}
	
}
