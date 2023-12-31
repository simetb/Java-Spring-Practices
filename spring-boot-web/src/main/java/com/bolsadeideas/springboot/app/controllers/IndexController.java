package com.bolsadeideas.springboot.app.controllers;

import com.bolsadeideas.springboot.app.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@RestController Used to rest controllers
@Controller
@RequestMapping("/app")
public class IndexController {
//    Default GET in RequestMapping
//    @RequestMapping(value = "/index", method = RequestMethod.GET)

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;


    @GetMapping(value = {"/index","/home","/"})
    public String index(Model model /*ModelMap model*/ /*Map<String, Object> map*/){
        model.addAttribute("titulo", this.textoIndex);
//        map.put("titulo","Hola Spring Framework con Map!");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Temis");
        usuario.setApellido("Barreto");
        usuario.setEmail("temisbarreto@correo.com");
        model.addAttribute("usuario",  usuario);
        model.addAttribute("titulo", this.textoPerfil.concat(usuario.getNombre()));
        return "perfil";
    }

    // passing data to the view using ModelAndView Functionality
//    @GetMapping(value = {"/index","/home","/"})
//    public ModelAndView index(ModelAndView mv){
//        mv.addObject("titulo", "Hola Spring Framework con Mv!");
//        mv.setViewName("index");
//        return mv;
//    }

    @RequestMapping("/listar")
    public String listar(Model model){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(
                "temisbarreto@correo.com",
                "Temis",
                "Barreto"
        ));
        usuarios.add(new Usuario(
                "marcelgonzales@correo.com",
                "Marcel",
                "Gonzales"
        ));
        usuarios.add(new Usuario(
                "daniellopez@correo.com",
                "Daniel",
                "Lopez"
        ));
        model.addAttribute("titulo", this.textoListar);
        model.addAttribute("usuarios", usuarios);
        return "listar";
    }
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(
                "temisbarreto@correo.com",
                "Temis",
                "Barreto"
        ));
        usuarios.add(new Usuario(
                "marcelgonzales@correo.com",
                "Marcel",
                "Gonzales"
        ));
        usuarios.add(new Usuario(
                "daniellopez@correo.com",
                "Daniel",
                "Lopez"
        ));

        return usuarios;
    }

}
