
package com.matiasfasulino.proyecto_integrador_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaClienteDTO {
    
    private Long codigo_venta;
    private Double total;
    private Double cant_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public VentaClienteDTO() {
    }

    public VentaClienteDTO(Long codigo_venta, Double total, Double cant_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cant_productos = cant_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
    
    
    
}
