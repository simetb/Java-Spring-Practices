package com.curso.springbootform.form.app.services;

import com.curso.springbootform.form.app.models.domains.Pais;

import java.util.List;

public interface PaisService {

    public List<Pais> listar();
    public Pais obtenerPorId(Integer id);


}
