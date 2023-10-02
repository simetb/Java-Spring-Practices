package com.bolsadeideas.springboot.error.app.services;

import com.bolsadeideas.springboot.error.app.models.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicesImp implements UsuarioService {

    private List<Usuario> lista;

    public UsuarioServicesImp() {
        this.lista = new ArrayList<>();
        this.lista.add(new Usuario(1,"Andres","Guzman"));
        this.lista.add(new Usuario(2,"Pepa","Garcia"));
        this.lista.add(new Usuario(3,"Lalo","Mena"));
        this.lista.add(new Usuario(4,"Luci","Fernandez"));
        this.lista.add(new Usuario(5,"Pato","Gonzales"));
        this.lista.add(new Usuario(6,"Paco","Rodriguez"));
        this.lista.add(new Usuario(7,"Juan","Gomez"));
    }

    @Override
    public List<Usuario> listar() {
        return null;
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        Usuario resultado = null;

        for(Usuario u: this.lista){
            if(u.getId().equals(id)){
                resultado = u;
                break;
            }
        }

        return resultado;
    }

    @Override
    public Optional<Usuario> obtenerPorIdOptional(Integer id) {
        Usuario usuario = this.obtenerPorId(id);
        return Optional.ofNullable(usuario);
    }
}
