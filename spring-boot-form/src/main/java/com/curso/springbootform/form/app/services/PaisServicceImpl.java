package com.curso.springbootform.form.app.services;

import com.curso.springbootform.form.app.models.domains.Pais;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisServicceImpl implements PaisService{

    private List<Pais> lista;

    public PaisServicceImpl() {

        this.lista = Arrays.asList(
                new Pais(1,"ES","España"),
                new Pais(2, "MX", "Mexico"),
                new Pais(3, "CL","Chile"),
                new Pais(4,"PR","Peru"),
                new Pais(5,"AR", "Argentina"),
                new Pais(6,"CO","Colombia"),
                new Pais(7,"VZ","Venezuela")
        );
    }

    @Override
    public List<Pais> listar() {
        return lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado = null;
        for(Pais pais: this.lista){
            if(id == pais.getId()){
                resultado = pais;
                break;
            }
        }
        return resultado;
    }
}
