package com.bolsadeideas.springboot.datajpa.app.models.service;

import com.bolsadeideas.springboot.datajpa.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.datajpa.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Transactional
    @Override
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findOne(Long id) {
        return clienteDao.findOne(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        clienteDao.delete(id);
    }
}
