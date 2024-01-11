
package com.matiasfasulino.proyecto_integrador_api.service;

import com.matiasfasulino.proyecto_integrador_api.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    public List<Cliente> getClientes();
    
    public void saveCliente(Cliente c);
    
    public void deleteCliente(Long id);
    
    public Cliente findCliente(Long id);
    
    public void editCliente(Cliente c);
    
}
