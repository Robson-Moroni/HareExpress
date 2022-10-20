package com.project.hareexpress.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/cadastrar")
    public String cadastrar(){
        return "cadastro_escolha_cliente_entregador";
    }

    @RequestMapping("/cadastrar_entregador")
    public String cadastrarEntregador(){
        return "cadastro_entregador";
    }

    @RequestMapping("/cadastrar_entregador_endereco")
    public String cadastrarEntregadorEndereco(){
        return "cadastro_entregador_endereco";
    }

    @RequestMapping("/cadastrar_entregador_veiculo")
    public String cadastrarEntregadorVeiculo(){
        return "cadastro_entregador_veiculo";
    }

    @RequestMapping("/entregador_finalizado")
    public String entregadorFinalizado(){
        return "entregador_finalizado";
    }




}
