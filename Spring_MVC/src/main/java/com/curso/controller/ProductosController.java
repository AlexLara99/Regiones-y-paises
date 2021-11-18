package com.curso.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;
import com.curso.excepciones.GestionProductoException;
import com.curso.service.ProductoService;
import com.curso.service.ProductoServiceImpl;

@Controller
@RequestMapping("comercio")
public class ProductosController {

	@Autowired
	private ProductoService productoService;
    
     @RequestMapping("/productos")
     public String list(Model model) {

        model.addAttribute("productos", 
        		productoService.getAllProduct());

        return "productos";
    }
     
     @GetMapping(path="/productos/{categoria}")
     public String categorias(
    		 @PathVariable("categoria") String categoria
    		 ,Model model) {

    	 
    	 model.addAttribute("productos", productoService.productosPorCategoria(categoria));
    	 return "productos";
    }
     // ******************************* NUEVO ***********************************************
     @GetMapping(value="/productos/nuevo")
     public String getCrearNuevoProductoFormulario(Model model) {
    	 Producto nuevoProducto =new Producto();
    	 nuevoProducto.setDescripcion("nuevo");
    	 model.addAttribute("nuevoProducto", nuevoProducto);
    	 return "crear-producto";
     }
     
     @PostMapping(value="/productos/nuevo")
     public String procesarCrearNuevoProductoFormulario(
    		 @ModelAttribute("nuevoProducto")
    		 @Valid Producto nuevoProducto,
    		 BindingResult bindingResult) throws GestionProductoException {
    	
    	 if(bindingResult.hasErrors()) {
    		 return "crear-producto";
    	 }
    	 
    	 productoService.crearProducto(nuevoProducto);
    	 System.out.println("producto nuevo " + nuevoProducto.getDescripcion());
    	 return "redirect:/comercio/productos";
     }
     // *************************** MODIFICAR *************************************
     
     
     //@GetMapping(value="/productos/modificar/{idProducto}")
     @GetMapping(value="/productos/modificar")
     public String cargarModificadorProducto(
    		 //@PathVariable("idProducto") String idProducto
    		 @RequestParam("id") String idProducto,
    		 Model model) {
    	 
    	 model.addAttribute("producto",productoService.getProductoPorId(idProducto));
    	 return "modificar-producto";
     }
     
     
     
     @PostMapping(value="/productos/modificar/{idProducto}")
     public String procesarModificacionProducto(
    		 @ModelAttribute("producto")
    		 @Valid Producto producto,
    		 BindingResult bindingResult) throws GestionProductoException {
    	 if(bindingResult.hasErrors()) {
    		 return "modificar-producto";
    	 }
    	 productoService.modificarProducto(producto);
    	 return "redirect:/comercio/productos";
     }
     
     //***************************** BORRAR *********************************
     
     @GetMapping(value="/productos/borrar")
     public String borrarProducto(
    		 //@PathVariable("idProducto") String idProducto
    		 @RequestParam("id") String idProducto,
    		 Model model) {
    	 
    	 //Producto p = productoService.getProductoPorId(idProducto);
    	 productoService.borrarProducto(productoService.getProductoPorId(idProducto));

    	 return "redirect:/comercio/productos";
     }
     
     
     
     @ExceptionHandler(GestionProductoException.class)
     public ModelAndView handleError(
     HttpServletRequest req,
     GestionProductoException exception) {

         ModelAndView mav = new ModelAndView();
         mav.addObject("idProductoNoEncontrado", exception.getIdProducto());
         mav.addObject("claveMensage", exception.getMessage());
         mav.setViewName("producto-exception");
         return mav;

     }
     
     
}
