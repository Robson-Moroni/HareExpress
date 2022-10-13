package com.project.hareexpress.application.controllers;

import com.project.hareexpress.domain.interfaces.IPessoaService;
import com.project.hareexpress.domain.models.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private IPessoaService pessoaService;

    @GetMapping("/list-pessoas")
    public ModelAndView listPessoa(ModelAndView model) {
        List<Pessoa> list = pessoaService.listPessoas();
        model.setViewName("novaPessoa");
        model.addObject("pessoa", list);
        return model;
    }

    @PostMapping("/ceate-pessoa")
    public ModelAndView createPessoa(ModelAndView model, @RequestBody Pessoa pessoa) {
        Pessoa pessoas = pessoaService.createPessoa(pessoa);
        model.setViewName("novaPessoa");
        model.addObject("pessoa", pessoas);
        return model;
    }

    @PostMapping("/update-pessoa")
    public ModelAndView updatePessoa(ModelAndView model, @RequestBody Pessoa pessoa) {
        Pessoa pessoas = pessoaService.updatePessoa(pessoa);
        model.setViewName("novaPessoa");
        model.addObject("pessoa", pessoas);
        return model;
    }

    @DeleteMapping("/delete-pessoa")
    public ModelAndView deletePessoa(ModelAndView model, @RequestParam("id") Integer pessoaId) {
        Boolean pessoa = pessoaService.deletePessoas(pessoaId);
        model.setViewName("novaPessoa");
        model.addObject("pessoa", pessoa);
        return model;
    }

}
