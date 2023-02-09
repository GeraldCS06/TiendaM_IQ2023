package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.dao.ClienteDao;
import com.TiendaM_IQ2023.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    ClienteDao clienteDao;
    
    @GetMapping("/")
    public String inicio(Model model) {
     //   log.info("Ahora desde MVC");
      //  model.addAttribute("Mensaje", "Hola desde el controlador");

      //  Cliente cliente = new Cliente("Gerald", "Calderon Serrano", "geraldesteban06@gmail.com", "83342258");
      //  model.addAttribute("objetoCliente", cliente);

       // Cliente cliente2 = new Cliente("Laura", "Serrano Zuñiga", "lau1211@hotmail.com", "84300455");
       // Cliente cliente3 = new Cliente("Emerson", "Barrantes Luna", "Emer1710@hotmail.com", "55778899");

       var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        return "index";
    }

}
