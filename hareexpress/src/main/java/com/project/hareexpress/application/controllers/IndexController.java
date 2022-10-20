package com.project.hareexpress.application.controllers;

import com.project.hareexpress.domain.interfaces.IUserService;
import com.project.hareexpress.domain.models.Pessoa;
import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.domain.models.dto.SignUpDTO;
import com.project.hareexpress.domain.services.PessoaServiceImpl;
import com.project.hareexpress.domain.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    public PessoaServiceImpl pessoaService;
    @Autowired
    public IUserService userService;



    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("user");
        return mv;
    }

    @RequestMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView("cadastro_escolha_cliente_entregador");
        mv.addObject("pessoa", pessoaService.listPessoas().get(0));
        return mv;
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

    @RequestMapping("/cadastrar_escolha_fisico_juridico")
    public String cadastrarPessoaFisicaJuridica(){
        return "cadastro_escolha_fisico_juridico";
    }

    @RequestMapping("/cadastrar_pessoa_fisica")
    public String cadastrarPessoaFisica(){
        return "cadastro_pessoa_fisica";
    }

    @RequestMapping("/cadastrar_pessoa_fisica_endereco")
    public String cadastrarPessoaFisicaEndereco(){
        return "cadastro_pessoa_fisica_endereco";
    }

    
    @RequestMapping("/usuario_finalizado")
    public String usuarioFinalizado(){
        return "usuario_finalizado";
    }


    @RequestMapping("/cadastrar_pessoa_juridica")
    public String cadastrarPessoaJuridica(){
        return "cadastro_pessoa_juridica";
    }

    @RequestMapping("/cadastrar_pessoa_juridica_endereco")
    public String cadastrarPessoaJuridicaEndereco(){
        return "cadastro_pessoa_juridica_endereco";
    }



}
