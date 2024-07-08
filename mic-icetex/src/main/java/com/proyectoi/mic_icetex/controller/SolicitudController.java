package com.proyectoi.mic_icetex.controller;

import com.proyectoi.mic_icetex.model.Solicitud;
import com.proyectoi.mic_icetex.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping("solicitudes")
    public ResponseEntity<List<Solicitud>> getSolicitudService() {
        try{
            List<Solicitud> body = solicitudService.consultarSolicitudes();
            return new ResponseEntity<>(body, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("crearSolicitud")
    public ResponseEntity<Solicitud> crearSolicitud(@RequestBody Solicitud solicitud) {
        try {
            Solicitud body = solicitudService.guardarSolicitud(solicitud);
            return new ResponseEntity<>(body, HttpStatus.CREATED);
        }catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("solicitud/{id}")
    public ResponseEntity<Solicitud> getSolicitud(@PathVariable Integer id) {
        try {
            Solicitud body = solicitudService.consultarSolicitud(id);
            return new ResponseEntity<>(body, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("solicitudCliente/{id}")
    public ResponseEntity<Solicitud> getSolicitudCliente(@PathVariable Integer id) {
        try {
            Solicitud body = solicitudService.ConsultarSolicitudByIdCliente(id);
            return new ResponseEntity<>(body, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("deleteSolicit/{id}")
    public ResponseEntity<String> deleteSolicitud(@PathVariable Integer id) {
        try {
            solicitudService.eliminarSolicitud(id);
            return new ResponseEntity<>("Solicitud eliminada exitosamente", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
