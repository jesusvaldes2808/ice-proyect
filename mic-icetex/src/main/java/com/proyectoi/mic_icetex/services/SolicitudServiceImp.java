package com.proyectoi.mic_icetex.services;

import com.proyectoi.mic_icetex.dao.SolicitudDAO;
import com.proyectoi.mic_icetex.model.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServiceImp implements SolicitudService {

    @Autowired
    private SolicitudDAO solicitudDAO;

    @Override
    public Solicitud consultarSolicitud(Integer idSolicitud) {
        System.out.println("Consultando solicitud");

        return this.solicitudDAO.findById(idSolicitud).orElse(null);
    }

    @Override
    public List<Solicitud> consultarSolicitudes() {
        return solicitudDAO.findAll();
    }

    @Override
    public Solicitud guardarSolicitud(Solicitud solicitud) {
            return solicitudDAO.save(solicitud);
    }

    @Override
    public Solicitud actualizarSolicitud(Solicitud solicitud) {
        Optional<Solicitud> solicitudExistente = solicitudDAO.findById(solicitud.getSolicitudId());
        if (solicitudExistente.isPresent()) {
            Solicitud solicitudActualizada = solicitudExistente.get();
            solicitudActualizada.setCorreo(solicitud.getCorreo());
            solicitudActualizada.setCorreoAux(solicitud.getCorreoAux());
            solicitudActualizada.setEstado(solicitud.getEstado());
            solicitudActualizada.setEstadoDos(solicitud.getEstadoDos());
            solicitudActualizada.setClaveDocumentos(solicitud.getClaveDocumentos());
            solicitudActualizada.setClavePortal(solicitud.getClavePortal());
            solicitudActualizada.setClaveCorreo(solicitud.getClaveCorreo());
            solicitudActualizada.setAnotacion(solicitud.getAnotacion());
            solicitudActualizada.setPrecioCobrado(solicitud.getPrecioCobrado());
            solicitudActualizada.setAbono(solicitud.getAbono());
            return solicitudDAO.save(solicitudActualizada);
        } else {
            throw new RuntimeException("La solicitud con ID " + solicitud.getSolicitudId() + " no existe.");
        }
    }


    @Override
    public String eliminarSolicitud(Integer idSolicitud) {
        Solicitud solicitud = this.consultarSolicitud(idSolicitud);
        solicitudDAO.delete(solicitud);
        return "Solicitud eliminado" + solicitud;
    }

    @Override
    public Solicitud ConsultarSolicitudByIdCliente(Integer id) {
        return this.solicitudDAO.findSolicitudByClienteId(id);
    }

}



