
package com.matiasfasulino.proyecto_integrador_api.controller;

import com.matiasfasulino.proyecto_integrador_api.dto.VentaClienteDTO;
import com.matiasfasulino.proyecto_integrador_api.model.Producto;
import com.matiasfasulino.proyecto_integrador_api.model.Venta;
import com.matiasfasulino.proyecto_integrador_api.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    @Autowired
    private IVentaService ventaServ;
    
    // Traer todas las Ventas
    @GetMapping("/venta/traer")
    public List<Venta> getVentas() {
        return ventaServ.getVentas();
    }
    
    // Traer Venta por id
    @GetMapping("/venta/traer/{codigo_venta}")
    public Venta getVenta(@PathVariable Long codigo_venta) {
        return ventaServ.findVenta(codigo_venta);
    }
    
    // Obtener lista de productos de una determinada venta
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductosVenta(@PathVariable Long codigo_venta) {
        return ventaServ.getProductosVenta(codigo_venta);
    }
    
    // Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
    @GetMapping("/ventas/{fecha_venta}")
    public String getVentaDelDia(@PathVariable LocalDate fecha_venta) {
        return ventaServ.getVentaDelDia(fecha_venta);
    }
    
    // Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el
    // apellido del cliente de la venta con el monto más alto de todas.
    @GetMapping("/ventas/mayor_venta")
    public VentaClienteDTO getVentaMayor() {
        return ventaServ.getVentaMayor();
    }
    
    // Crear Venta
    @PostMapping("/venta/crear")
    public String saveVenta(@RequestBody Venta venta) {
        ventaServ.saveVenta(venta);
        return "Venta creado correctamente!";
    }
    
    // Borrar Venta por id
    @DeleteMapping("/venta/borrar/{id}")
    public String deleteVenta(@PathVariable Long id) {
        ventaServ.deleteVenta(id);
        return "Venta borrado correctamente!";
    }
    
    // Editar Venta
    @PutMapping("/venta/editar")
    public String editVenta(@RequestBody Venta venta) {
        ventaServ.editVenta(venta);
        return "Venta editado correctamente!";
    }
    
}
