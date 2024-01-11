
package com.matiasfasulino.proyecto_integrador_api.repository;

import com.matiasfasulino.proyecto_integrador_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    
}
