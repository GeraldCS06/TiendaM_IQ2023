package com.TiendaM_IQ2023.service;

import com.TiendaM_IQ2023.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    public List<Articulo> getArticulo(boolean activos);

    public Articulo getArticulo(Articulo articulo);

    public void save(Articulo articulo); //Para insertar o modificar si viene el id categoria o no

    public void delete(Articulo articulo);
}
