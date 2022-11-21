package com.project.hareexpress.controllers;

import com.project.hareexpress.services.IPessoaService;
import com.project.hareexpress.domain.models.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private IPessoaService pessoaService;


    @PostMapping("/create")
    public ModelAndView createPessoa(ModelAndView model, @RequestBody Pessoa pessoa) {
        Pessoa pessoas = pessoaService.createPessoa(pessoa);
        model.setViewName("novaPessoa");
        model.addObject("login", pessoas);
        return model;
    }

    @PostMapping("/update")
    public ModelAndView updatePessoa(ModelAndView model, @RequestBody Pessoa pessoa) {
        Pessoa pessoas = pessoaService.updatePessoa(pessoa);
        model.setViewName("novaPessoa");
        model.addObject("pessoa", pessoas);
        return model;
    }

    @DeleteMapping("/delete")
    public ModelAndView deletePessoa(@RequestParam("id") Integer pessoaId) {
        ModelAndView mv = new ModelAndView("novaPessoa");
        Boolean pessoa = pessoaService.deletePessoas(pessoaId);
        mv.setViewName("novaPessoa");
        mv.addObject("pessoa", pessoa);
        return mv;
    }

}
