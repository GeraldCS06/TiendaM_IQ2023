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
        log.info("Ahora desde MVC");

        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);

        return "index";
    }
}
