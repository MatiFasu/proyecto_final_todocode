package com.matiasfasulino.proyecto_integrador_api.repository;

import com.matiasfasulino.proyecto_integrador_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{
    
}
