package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

 
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String mostrarHome(Model model) {
    	model.addAttribute("saludo","Bienvenidooo a nuestra tienda online");
    	model.addAttribute("linea1", "Los mejores productos");
        return "inicio";
    }
    
    @RequestMapping(path = "/saludo", method = RequestMethod.GET)
    public String mostrarSaludo() {
        return "hola";
    }

}
