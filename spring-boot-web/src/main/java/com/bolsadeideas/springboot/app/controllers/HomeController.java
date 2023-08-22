package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        // Redirecciona a la vista especificada haciendo un reinicio de los parametros
//        return "redirect:/app/index";

        // Redirecciona a la vista especificada pero sin hacer un reinicio de los parametros (la ruta se mantiene estatica)
        return "forward:/app/index";

    }
}
