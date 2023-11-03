package com.bolsadeideas.springboot.datajpa.app.models.service;

import com.bolsadeideas.springboot.datajpa.app.models.entity.Cliente;
import com.bolsadeideas.springboot.datajpa.app.models.dao.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteService clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        // TODO Auto-generated method stub
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);

    }

    @Override
    public Cliente findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

//    @Override
//    @Transactional(readOnly = true)
//    public Cliente findOne(Long id) {
//        // TODO Auto-generated method stub
//        return clienteDao.findById(id).orElse(null);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Long id) {
//        clienteDao.deleteById(id);
//
//    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }
}
