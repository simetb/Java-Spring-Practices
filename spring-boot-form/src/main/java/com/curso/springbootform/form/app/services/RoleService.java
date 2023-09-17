package com.curso.springbootform.form.app.services;

import com.curso.springbootform.form.app.models.domains.Role;

import java.util.List;

public interface RoleService {

    public List<Role> listar();
    public Role obtenerPorId(Integer id);
}
