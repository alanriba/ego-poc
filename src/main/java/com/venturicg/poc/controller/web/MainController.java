package com.venturicg.poc.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    // Esta es la página principal de carga
    @RequestMapping("/")
    public String principal() {
        return "principal";
    }

    @RequestMapping("/paises")
    public String paises() {
        return "paises";
    }

    @RequestMapping("/personas")
    public String personas() {
        return "personas";
    }
}