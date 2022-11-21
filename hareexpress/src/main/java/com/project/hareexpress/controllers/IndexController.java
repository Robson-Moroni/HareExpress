package com.project.hareexpress.controllers;

import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.services.IUserService;
import com.project.hareexpress.services.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
