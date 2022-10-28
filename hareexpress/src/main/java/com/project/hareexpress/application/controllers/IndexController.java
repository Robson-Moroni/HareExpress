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
    public ModelAndView ModelAndView(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
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
        return mv;
    }

    @RequestMapping("/cadastrar_entregador")
    public ModelAndView cadastrarEntregador(){
        ModelAndView mv = new ModelAndView("cadastro_entregador");
        return mv;
    }

    @RequestMapping("/cadastrar_entregador_endereco")
    public ModelAndView cadastrarEntregadorEndereco(){
        ModelAndView mv = new ModelAndView("cadastro_entregador_endereco");
        return mv;
    }

    @RequestMapping("/cadastrar_entregador_veiculo")
    public ModelAndView cadastrarEntregadorVeiculo(){
        ModelAndView mv = new ModelAndView("cadastro_entregador_veiculo");
        return mv;
    }

    @RequestMapping("/entregador_finalizado")
    public ModelAndView entregadorFinalizado(){
        ModelAndView mv = new ModelAndView("entregador_finalizado");
        return mv;
    }

    @RequestMapping("/cadastrar_escolha_fisico_juridico")
    public ModelAndView cadastrarPessoaFisicaJuridica(){
        ModelAndView mv = new ModelAndView("cadastro_escolha_fisico_juridico");
        return mv;
    }

    @RequestMapping("/cadastrar_pessoa_fisica")
    public ModelAndView cadastrarPessoaFisica(){
        ModelAndView mv = new ModelAndView("cadastro_pessoa_fisica");
        return mv;
    }

    @RequestMapping("/cadastrar_pessoa_fisica_endereco")
    public ModelAndView cadastrarPessoaFisicaEndereco(){
        ModelAndView mv = new ModelAndView("cadastro_pessoa_fisica_endereco");
        return mv;
    }

    
    @RequestMapping("/usuario_finalizado")
    public ModelAndView usuarioFinalizado(){
        ModelAndView mv = new ModelAndView("usuario_finalizado");
        return mv;
    }


    @RequestMapping("/cadastrar_pessoa_juridica")
    public ModelAndView cadastrarPessoaJuridica(){
        ModelAndView mv = new ModelAndView("cadastro_pessoa_juridica");
        return mv;
    }

    @RequestMapping("/cadastrar_pessoa_juridica_endereco")
    public ModelAndView cadastrarPessoaJuridicaEndereco(){
        ModelAndView mv = new ModelAndView("cadastro_pessoa_juridica_endereco");
        return mv;
    }

}
