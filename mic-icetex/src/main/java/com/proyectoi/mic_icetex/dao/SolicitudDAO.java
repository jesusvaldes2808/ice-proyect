package com.proyectoi.mic_icetex.dao;

import com.proyectoi.mic_icetex.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudDAO extends JpaRepository<Solicitud, Integer> {

    public Solicitud findSolicitudByClienteId(Integer id);
}
