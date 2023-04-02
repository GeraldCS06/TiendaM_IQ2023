package com.TiendaM_IQ2023.service;

import com.TiendaM_IQ2023.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> getCategoria(boolean activos);

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria); //Para insertar o modificar si viene el id categoria o no

    public void delete(Categoria categoria);
}
