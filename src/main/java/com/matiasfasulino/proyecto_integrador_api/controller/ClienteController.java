
package com.matiasfasulino.proyecto_integrador_api.controller;

import com.matiasfasulino.proyecto_integrador_api.model.Cliente;
import com.matiasfasulino.proyecto_integrador_api.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    private IClienteService clienteServ;
    
    // Traer todos los cliente
    @GetMapping("/cliente/traer")
    public List<Cliente> getClientes() {
        return clienteServ.getClientes();
    }
    
    // Traer Cliente por id
    @GetMapping("/cliente/traer/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente) {
        return clienteServ.findCliente(id_cliente);
    }
    
    // Crear Cliente
    @PostMapping("/cliente/crear")
    public String saveCliente(@RequestBody Cliente cliente) {
        clienteServ.saveCliente(cliente);
        return "Cliente creado correctamente!";
    }
    
    // Borrar Cliente por id
    @DeleteMapping("/cliente/borrar/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteServ.deleteCliente(id);
        return "Cliente borrado correctamente!";
    }
    
    // Editar Cliente
    @PutMapping("/cliente/editar")
    public String editCliente(@RequestBody Cliente cliente) {
        clienteServ.editCliente(cliente);
        return "Cliente editado correctamente!";
    }
    
}
