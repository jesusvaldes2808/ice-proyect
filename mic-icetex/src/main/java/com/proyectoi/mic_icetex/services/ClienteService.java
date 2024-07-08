package com.proyectoi.mic_icetex.services;

import com.proyectoi.mic_icetex.model.Cliente;
import com.proyectoi.mic_icetex.model.Solicitud;

import java.util.List;

public interface ClienteService {

    Cliente postCliente(Cliente cliente);
    List<Cliente> getClientes();
    Cliente getCliente(Integer id);
    List<Cliente> getClienteByNombre(String nombre);
    void deleteSolicitud(Integer id);
}
