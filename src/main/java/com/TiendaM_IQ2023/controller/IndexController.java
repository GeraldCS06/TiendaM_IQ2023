package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.domain.Cliente;
import com.TiendaM_IQ2023.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/")
    public String inicio(Model model) {
        //   log.info("Ahora desde MVC");
        //  model.addAttribute("Mensaje", "Hola desde el controlador");

        //  Cliente cliente = new Cliente("Gerald", "Calderon Serrano", "geraldesteban06@gmail.com", "83342258");
        //  model.addAttribute("objetoCliente", cliente);
        // Cliente cliente2 = new Cliente("Laura", "Serrano Zuñiga", "lau1211@hotmail.com", "84300455");
        // Cliente cliente3 = new Cliente("Emerson", "Barrantes Luna", "Emer1710@hotmail.com", "55778899");
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "index";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
        return "modificarCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/";
    }

    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }

    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/";
    }
}
