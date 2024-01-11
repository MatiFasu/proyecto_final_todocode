
package com.matiasfasulino.proyecto_integrador_api.service;

import com.matiasfasulino.proyecto_integrador_api.dto.VentaClienteDTO;
import com.matiasfasulino.proyecto_integrador_api.model.Cliente;
import com.matiasfasulino.proyecto_integrador_api.model.Producto;
import com.matiasfasulino.proyecto_integrador_api.model.Venta;
import com.matiasfasulino.proyecto_integrador_api.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }

    @Override
    public List<Producto> getProductosVenta(Long codigo_venta) {
        Venta v = this.findVenta(codigo_venta);
        return v.getListaProductos();
    }

    @Override
    public String getVentaDelDia(LocalDate fecha_venta) {
        List<Venta> ventas = this.getVentas();
        
        int cant_ventas = 0;
        int monto = 0;
        
        for(Venta v: ventas) {
            if( v.getFecha_venta().equals(fecha_venta) ) {
                monto += v.getTotal();
                cant_ventas++;
            }
        }       
        
        return "Monto: " + Integer.toString(monto) + ", Cant de Ventas: " + Integer.toString(cant_ventas);
    }

    @Override
    public VentaClienteDTO getVentaMayor() {
        VentaClienteDTO vc = new VentaClienteDTO();
        List<Venta> ventas = this.getVentas();
        
        double monto = 0;
        
        for(Venta v: ventas) {
            if( v.getTotal()>monto ) {
                monto = v.getTotal();
                Cliente c = v.getUnCliente();
                double cantProductos = v.getListaProductos().size();
                
                vc.setCodigo_venta(v.getCodigo_venta());
                vc.setNombre_cliente(c.getNombre());
                vc.setApellido_cliente(c.getApellido());
                vc.setTotal(v.getTotal());
                vc.setCant_productos(cantProductos);
            }
        }
        
        return vc;
    }

    
    
    
}
