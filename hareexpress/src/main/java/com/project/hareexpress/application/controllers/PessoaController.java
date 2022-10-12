package com.project.hareexpress.application.controllers;

import com.project.hareexpress.domain.interfaces.IPessoaService;
import com.project.hareexpress.domain.models.Pessoa;
import com.project.hareexpress.domain.services.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private IPessoaService pessoaService;

    @GetMapping("/list-pessoas")
    public String listpessoas(Model model) {
        List<Pessoa> list = pessoaService.listPessoas();
        model.addAttribute("pessoas", list);
        return "listpessoa";

    }





//    @GetMapping("/list-pessoa")
//    public String listPessoa(Model model)
//    {
//        List<Pessoa> list = pessoaService.getAllPessoa();
//
//        model.addAttribute("pessoa", list);
//        return "list-pessoa";
//    }

//    @RequestMapping(path = {"/update", "/update/{id}"})
//    public String updatePessoaById(Model model, @PathVariable("id") Optional<Integer> id)
//    {
//        if (id.isPresent()) {
//            Pessoa pessoa = pessoaService.getPessoaById(id.get());
//            model.addAttribute("pessoa", pessoa);
//        } else {
//            model.addAttribute("pessoa", new Pessoa());
//        }
//        return "add-update-pessoa";
//    }
//
//    @RequestMapping(path = "/delete/{id}")
//    public String deletePessoaById(Model model, @PathVariable("id") Integer id)
//    {
//        pessoaService.deletePessoaById(id);
//        return "redirect:/";
//    }
//
//    @RequestMapping(path = "/createPessoa", method = RequestMethod.POST)
//    public String createOrUpdatePessoa(Pessoa pessoa)
//    {
//        pessoaService.createOrUpdatePessoa(pessoa);
//        return "redirect:/";
//    }

}
