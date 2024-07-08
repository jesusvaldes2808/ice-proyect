package com.proyectoi.mic_icetex.controller;

import com.proyectoi.mic_icetex.model.Cliente;
import com.proyectoi.mic_icetex.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins="*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("clientes")
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes = clienteService.getClientes();
         return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Integer id) {
        try{
            Cliente body = clienteService.getCliente(id);
            System.out.println(body);
            return new ResponseEntity<>(body, HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("crearCliente")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente body = clienteService.postCliente(cliente);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    @GetMapping("buscarCliente")
    public ResponseEntity<List<Cliente>> buscarCliente(@RequestParam String nombre) {

        return new ResponseEntity<>(clienteService.getClienteByNombre(nombre), HttpStatus.OK);
    }


    @DeleteMapping("borrarCliente/{id}")
    public ResponseEntity<String> borrarCliente(@PathVariable Integer id) {
        try {
            clienteService.deleteSolicitud(id);
            String messaje = "Se ha borrado con exito";
            return  new ResponseEntity<>(messaje, HttpStatus.OK);
        }catch (Exception e) {
            String messaje = "No se pudo borrar el cliente";
            return new ResponseEntity<>(messaje, HttpStatus.OK);
        }


    }
}
