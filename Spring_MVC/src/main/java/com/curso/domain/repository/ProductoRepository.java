
package com.curso.domain.repository;

import com.curso.domain.Producto;
import java.util.List;

public interface ProductoRepository {
    List <Producto> getAllProductos();
    Producto getProductoPorId(String idProducto);
    List<Producto> getProductosPorCategoria(String categoria);
    void introducirProducto(Producto nuevoProducto);
    void modificarProducto(Producto modificarProducto);
    void borrarProducto(Producto producto);
}
