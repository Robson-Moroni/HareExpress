package com.project.hareexpress.application.controllers;

import com.project.hareexpress.domain.interfaces.IEnderecoService;
import com.project.hareexpress.domain.models.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private IEnderecoService enderecoService;

    @GetMapping("/list-endereco")
    public ModelAndView listEndereco(ModelAndView model) {
        List<Endereco> list = enderecoService.listEnderecos();
        model.setViewName("endereco");
        model.addObject("endereco", list);
        return model;
    }

    @PostMapping("/ceate-endereco")
    public ModelAndView createEndereco(ModelAndView model, @RequestBody Endereco endereco) {
        Endereco enderecos = enderecoService.createEndereco(endereco);
        model.setViewName("endereco");
        model.addObject("enderecos", enderecos);
        return model;
    }

    @PostMapping("/update-endereco")
    public ModelAndView updatePessoa(ModelAndView model, @RequestBody Endereco endereco) {
        Endereco enderecos = enderecoService.updateEndereco(endereco);
        model.setViewName("endereco");
        model.addObject("enderecos", enderecos);
        return model;
    }

    @DeleteMapping("/delete-endereco")
    public ModelAndView deleteEndereco(ModelAndView model, @RequestParam("id") Integer enderecoId) {
        Boolean endereco = enderecoService.deleteEndereco(enderecoId);
        model.setViewName("endereco");
        model.addObject("enderecos", endereco);
        return model;
    }

}
