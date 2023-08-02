package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
//    Default GET in RequestMapping
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @GetMapping(value = {"/index","/home","/"})
    public String index(){
          return "index";
    }
}
