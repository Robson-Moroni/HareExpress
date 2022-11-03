package com.project.hareexpress.application.controllers;

import com.project.hareexpress.application.form.LoginForm;
import com.project.hareexpress.domain.services.AthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private AthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(LoginForm login, HttpServletRequest httpServletRequest) {

    if(authenticationService.isAuthetatic(login)){
        return new ModelAndView("/cadastrar_escolha_cliente_entregador");
    }
        return new ModelAndView( "login");
    }
}
