package com.bolsadeideas.springboot.datajpa.app.models.dao;

import com.bolsadeideas.springboot.datajpa.app.models.entity.Cliente;
import com.bolsadeideas.springboot.datajpa.app.models.service.IClienteService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

    List<Cliente> findAll();
}
