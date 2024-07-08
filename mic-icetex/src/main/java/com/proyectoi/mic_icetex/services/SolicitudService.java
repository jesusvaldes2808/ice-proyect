package com.proyectoi.mic_icetex.services;

import com.proyectoi.mic_icetex.model.Solicitud;

import java.util.List;

public interface SolicitudService {

    Solicitud consultarSolicitud(Integer idSolicitud);
    List<Solicitud> consultarSolicitudes();
    Solicitud guardarSolicitud(Solicitud solicitud);
    Solicitud actualizarSolicitud(Solicitud solicitud);
    String eliminarSolicitud(Integer idSolicitud);
    Solicitud ConsultarSolicitudByIdCliente(Integer id);


}
