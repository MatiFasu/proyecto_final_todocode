
package com.matiasfasulino.proyecto_integrador_api.service;

import com.matiasfasulino.proyecto_integrador_api.model.Producto;
import com.matiasfasulino.proyecto_integrador_api.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository prodRepo;
    
    @Override
    public List<Producto> getProductos() {
        return prodRepo.findAll();
    }

    @Override
    public void saveProducto(Producto p) {
        prodRepo.save(p);
    }

    @Override
    public void deleteProducto(Long id) {
        prodRepo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        return prodRepo.findById(id).orElse(null);
    }

    @Override
    public void editProducto(Producto p) {
        this.saveProducto(p);
    }

    @Override
    public List<Producto> getProductosFaltaStock() {
        List<Producto> productosFaltaStock = new ArrayList<Producto>();
        List<Producto> listaProductos = this.getProductos();
        
        for(Producto p: listaProductos) {
            if( p.getCantidad_disponible()<5 ) {
                productosFaltaStock.add(p);
            }
        }
        
        return productosFaltaStock;
    }

}
