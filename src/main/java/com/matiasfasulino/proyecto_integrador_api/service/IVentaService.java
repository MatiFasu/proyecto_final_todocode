
package com.matiasfasulino.proyecto_integrador_api.service;

import com.matiasfasulino.proyecto_integrador_api.dto.VentaClienteDTO;
import com.matiasfasulino.proyecto_integrador_api.model.Producto;
import com.matiasfasulino.proyecto_integrador_api.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    
    public List<Venta> getVentas();
    
    public void saveVenta(Venta venta);
    
    public void deleteVenta(Long id);
    
    public Venta findVenta(Long id);
    
    public void editVenta(Venta venta);

    public List<Producto> getProductosVenta(Long codigo_venta);

    public String getVentaDelDia(LocalDate fecha_venta);

    public VentaClienteDTO getVentaMayor();

    
}
