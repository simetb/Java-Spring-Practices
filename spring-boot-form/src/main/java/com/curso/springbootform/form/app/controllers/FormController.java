package com.curso.springbootform.form.app.controllers;

import com.curso.springbootform.form.app.editors.NombreMayusculaEditor;
import com.curso.springbootform.form.app.editors.PaisPropertyEditor;
import com.curso.springbootform.form.app.editors.RolesEditor;
import com.curso.springbootform.form.app.models.domains.Pais;
import com.curso.springbootform.form.app.models.domains.Role;
import com.curso.springbootform.form.app.models.domains.Usuario;
import com.curso.springbootform.form.app.services.PaisService;
import com.curso.springbootform.form.app.services.RoleService;
import com.curso.springbootform.form.app.validation.UsuarioValidador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.annotation.SessionScope;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("user")
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisEditor;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolesEditor rolesEditor;


    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(validador);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,"fechaNacimiento", new CustomDateEditor(dateFormat,true));

        binder.registerCustomEditor(String.class,"nombre" ,new NombreMayusculaEditor());
        binder.registerCustomEditor(Pais.class,"pais" ,paisEditor);
        binder.registerCustomEditor(Role.class,"roles" ,rolesEditor);
    }
    @ModelAttribute("genero")
    public List<String> genero(){
        return Arrays.asList("Hombre", "Mujer");
    }

    @ModelAttribute("listaRoles")
    public List<Role> listaRoles(){
        return this.roleService.listar();
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString(){
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");

        return roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap(){
        Map<String,String> roles = new HashMap<String,String>();
        roles.put("ROLE_ADMIN","Administrador");
        roles.put("ROLE_USER","Usuario");
        roles.put("ROLE_MODERATOR","Moderador");
        return roles;
    }


    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises(){
        return paisService.listar();
    }

    @ModelAttribute("paises")
    public List<String> paises(){
        return Arrays.asList("España", "Mexico", "Chile", "Argentina","Peru","Colombia","Venezuela");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap(){
       Map<String,String> paises = new HashMap<String,String>();
        paises.put("ES","España");
        paises.put("MX","Mexico");
        paises.put("CL","Chile");
        paises.put("PR","Peru");
        paises.put("AR","Argentina");
        paises.put("CO","Colombia");
        paises.put("VZ","Venezuela");
        return paises;
    }


    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setIdentificador("123.123.123-k");

        model.addAttribute("titulo", "Formulario de usuarios");
        model.addAttribute("user",usuario);
        usuario.setHabilitar(true);
        usuario.setValorSecreto("Algun valor secreto");
        usuario.setPais(new Pais(3,"CL","Chile"));
        usuario.setRoles(Arrays.asList(new Role(2,"Usuario","ROLE_USER")));
        usuario.setRoles(Arrays.asList(new Role(3,"Moderador","ROLE_MODERATOR")));
        return "form";
    }


    @PostMapping("/form")
    public String procesar(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model)
//                           @RequestParam(name = "username") String username,
//                           @RequestParam String password,
//                           @RequestParam String email)
    {
//        validador.validate(usuario, result);
//        Usuario usuario = new Usuario();
//
//        usuario.setEmail(email);
//        usuario.setPassword(password);
//        usuario.setUsername(username);


        if (result.hasErrors()){
            model.addAttribute("titulo", "Resultado del formulario");
//            Map<String,String> errores = new HashMap<>();
//            result.getFieldErrors().forEach(err ->
//                    errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage())
//                    )
//            );
//            model.addAttribute("error",errores);
            return "form";
        }
        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String ver(@SessionAttribute(name = "user", required = false) Usuario usuario,Model model, SessionStatus status) {
        if(usuario == null){
            return "redirect:/form";
        }

        model.addAttribute("titulo", "Resultado del formulario");
        status.setComplete();
        return "resultado";
    }


}
