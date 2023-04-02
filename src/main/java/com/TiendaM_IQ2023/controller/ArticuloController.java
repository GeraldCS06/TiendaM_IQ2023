package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.domain.Articulo;
import com.TiendaM_IQ2023.service.ArticuloService;
import com.TiendaM_IQ2023.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticuloController {

    @Autowired
    ArticuloService articuloService;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {

        var articulos = articuloService.getArticulo(false);
        model.addAttribute("articulos", articulos);

        return "/articulo/listado";
    }

    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model) {
        var categoria = categoriaService.getCategoria(true);
        model.addAttribute("categoria", categoria);
        return "/articulo/modificar";
    }

    @GetMapping("//articulo/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        var categoria = categoriaService.getCategoria(true);
        model.addAttribute("categoria", categoria);

        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";
    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }

}
