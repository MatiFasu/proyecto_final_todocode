
package com.matiasfasulino.proyecto_integrador_api.repository;

import com.matiasfasulino.proyecto_integrador_api.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long>{
    
}
