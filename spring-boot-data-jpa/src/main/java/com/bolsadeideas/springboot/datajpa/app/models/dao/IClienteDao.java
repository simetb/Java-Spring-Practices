package com.bolsadeideas.springboot.datajpa.app.models.dao;

import com.bolsadeideas.springboot.datajpa.app.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

//    public List<Cliente> findAll();
//
//    public void save(Cliente cliente);
//
//    public Cliente findOne(Long id);
//
//    public void delete(Long id);
}
