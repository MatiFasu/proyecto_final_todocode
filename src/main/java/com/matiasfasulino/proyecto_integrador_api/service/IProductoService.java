
package com.matiasfasulino.proyecto_integrador_api.service;

import com.matiasfasulino.proyecto_integrador_api.model.Producto;
import java.util.List;

public interface IProductoService {
 
    public List<Producto> getProductos();
    
    public void saveProducto(Producto p);
    
    public void deleteProducto(Long id);
    
    public Producto findProducto(Long id);
    
    public void editProducto(Producto p);

    public List<Producto> getProductosFaltaStock();
    
}
