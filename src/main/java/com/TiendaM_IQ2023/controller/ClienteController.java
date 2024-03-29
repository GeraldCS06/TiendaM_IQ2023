package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.domain.Cliente;
import com.TiendaM_IQ2023.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {

        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);

        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/modificar";
    }

    @GetMapping("//cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
}
