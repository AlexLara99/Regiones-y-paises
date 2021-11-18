package com.curso.domain.repository;

import com.curso.domain.Producto;
import java.util.logging.Logger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class EnMemoriaProductoRepository  implements ProductoRepository{

    private List<Producto> listaDeProductos = new ArrayList<Producto>();
    private Logger log = Logger.getLogger("EnMemoriaProductoRepository");
    
    //contructor
    
    public EnMemoriaProductoRepository() {
    log.info("........... instanciando EnMemoriaProductoRepository");
    Producto iphone = new Producto("P1234","iPhone 5s", new BigDecimal(500));
    iphone.setDescripcion("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
    iphone.setCategoria("Smart Phone");
    iphone.setFabricante("Apple");
    iphone.setUnidadesEnStock(1000);
    
    Producto laptop_dell = new Producto("P1235","Dell Inspiron", new BigDecimal(700));
    laptop_dell.setDescripcion("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
    laptop_dell.setCategoria("Laptop");
    laptop_dell.setFabricante("Dell");
    laptop_dell.setUnidadesEnStock(1000);
    
    Producto laptop_accer = new Producto("P1239","Accer guapo", new BigDecimal(700));
    laptop_accer.setDescripcion("Accer portatil to guapo con cosas de intel");
    laptop_accer.setCategoria("Laptop");
    laptop_accer.setFabricante("Accer");
    laptop_accer.setUnidadesEnStock(1000);
    
    Producto tablet_Nexus = new Producto("P1236","Nexus 7", new BigDecimal(300));
    tablet_Nexus.setDescripcion("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
    tablet_Nexus.setCategoria("Tablet");
    tablet_Nexus.setFabricante("Google");
    tablet_Nexus.setUnidadesEnStock(1000);
    
    listaDeProductos.add(iphone);
    listaDeProductos.add(laptop_dell);
    listaDeProductos.add(laptop_accer);
    listaDeProductos.add(tablet_Nexus);
        
    }

    @Override
    public List<Producto> getAllProductos() {
        return listaDeProductos;
    }

	@Override
	public Producto getProductoPorId(String idProducto) {
		
		Producto pEncontrado = null;
		for(Producto p: listaDeProductos) {
			if(p.getIdProducto().equals(idProducto)){
				pEncontrado = p;
				break;
			}
		}
		return pEncontrado;
	}
	
	@Override
	public List<Producto> getProductosPorCategoria(String categoria){
		
		ArrayList<Producto> pCategoria = new ArrayList<Producto>();
		
		for(Producto p: listaDeProductos) {
			if(p.getCategoria().compareTo(categoria) == 0){
				pCategoria.add(p);
				
			}
		}
		
		return pCategoria;
		
	}

	@Override
	public void introducirProducto(Producto nuevoProducto) {
		listaDeProductos.add(nuevoProducto);
		
	}

	@Override
	public void modificarProducto(Producto modificarProducto) {
		int contador = 0;
		for(Producto p: listaDeProductos) {
			
			if(p.getIdProducto().compareTo(modificarProducto.getIdProducto()) == 0) {
				//listaDeProductos.remove(contador);
				listaDeProductos.set(contador,modificarProducto);
				break;
			}
			contador++;
		}
		
	}


	@Override
	public void borrarProducto(Producto producto) {
		// TODO Auto-generated method stub
		
	}
    
    
    
}