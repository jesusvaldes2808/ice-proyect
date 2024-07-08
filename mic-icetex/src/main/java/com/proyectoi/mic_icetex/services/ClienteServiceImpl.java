package com.proyectoi.mic_icetex.services;

import com.proyectoi.mic_icetex.dao.ClienteDAO;
import com.proyectoi.mic_icetex.model.Cliente;
import com.proyectoi.mic_icetex.model.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public Cliente postCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteDAO.findAll();
    }

    @Override
    public Cliente getCliente(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> getClienteByNombre(String nombre) {
//        return clienteDAO.getAllNombres(nombre);
        return null;
    }



    @Override
    public void deleteSolicitud(Integer id) {
        clienteDAO.deleteById(id);
    }
}
