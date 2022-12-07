package com.project.hareexpress.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    private static  String urlCliente = "/templates/cliente/cliente_meusdados.html";

    @RequestMapping("/")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

}
