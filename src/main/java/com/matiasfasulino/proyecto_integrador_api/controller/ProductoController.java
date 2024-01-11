
package com.matiasfasulino.proyecto_integrador_api.controller;

import com.matiasfasulino.proyecto_integrador_api.model.Producto;
import com.matiasfasulino.proyecto_integrador_api.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService prodServ;
    
    // Traer todos los Productos
    @GetMapping("/producto/traer")
    public List<Producto> getProdcutos() {
        return prodServ.getProductos();
    }
    
    // Traer Producto por id
    @GetMapping("/producto/traer/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto) {
        return prodServ.findProducto(codigo_producto);
    }
    
    // Traer Productos con cantidad disponible menor a 5
    @GetMapping("/producto/traer/falta_stock")
    public List<Producto> getProductos() {
        return prodServ.getProductosFaltaStock();
    }
    
    // Crear Producto
    @PostMapping("/producto/crear")
    public String saveProducto(@RequestBody Producto producto) {
        prodServ.saveProducto(producto);
        return "Producto creado correctamente!";
    }
    
    // Borrar Producto por id
    @DeleteMapping("/producto/borrar/{id}")
    public String deleteProducto(@PathVariable Long id) {
        prodServ.deleteProducto(id);
        return "Producto borrado correctamente!";
    }
    
    // Editar Producto
    @PutMapping("/producto/editar")
    public String editProducto(@RequestBody Producto producto) {
        prodServ.editProducto(producto);
        return "Producto editado correctamente!";
    }
    
}
