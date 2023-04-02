package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.domain.Categoria;
import com.TiendaM_IQ2023.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String inicio(Model model) {

        var categorias = categoriaService.getCategoria(false);
        model.addAttribute("categorias", categorias);

        return "/categoria/listado";
    }

    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria) {
        return "/categoria/modificar";
    }

    @GetMapping("//categoria/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificarCliente(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modificar";
    }

    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCliente(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }

}
