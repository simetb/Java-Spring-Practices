package com.curso.springbootform.form.app.controllers;

import com.curso.springbootform.form.app.models.domains.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario de usuarios");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model)
//                           @RequestParam(name = "username") String username,
//                           @RequestParam String password,
//                           @RequestParam String email)
    {
//        Usuario usuario = new Usuario();
//
//        usuario.setEmail(email);
//        usuario.setPassword(password);
//        usuario.setUsername(username);

        model.addAttribute("titulo", "Resultado del formulario");

        if (result.hasErrors()){
            Map<String,String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err ->
                    errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage())
                    )
            );
            model.addAttribute("error",errores);
            return "form";
        }
        model.addAttribute("usuario", usuario);
        return "resultado";
    }




}
