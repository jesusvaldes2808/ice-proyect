package com.proyectoi.mic_icetex.dao;


import com.proyectoi.mic_icetex.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

//    @Query("Select p from Cliente p Where p.nombres Like ':nombre%'")
//    public List<Cliente> getAllNombres(@Param("nombre") String nombre);
}
