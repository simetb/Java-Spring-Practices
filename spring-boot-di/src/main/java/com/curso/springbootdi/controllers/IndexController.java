package com.curso.springbootdi.controllers;

import com.curso.springbootdi.models.service.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("miServicioSimple")
    private IServicio servicio;

    @GetMapping({"/","","/index",})
    public String index(Model model){
        model.addAttribute("objeto",servicio.operacion());
        return "index";
    }


//    @Autowired // El autowired se puede omitir
//    public IndexController(IServicio servicio) {
//        this.servicio = servicio;
//    }

//    @Autowired
//    public void setServicio(IServicio servicio) {
//        this.servicio = servicio;
//    }
}
