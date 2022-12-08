package com.project.hareexpress.controllers;


import com.project.hareexpress.domain.models.Pedido;
import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.domain.models.dto.LoginDTO;
import com.project.hareexpress.domain.models.dto.SignUpDTO;
import com.project.hareexpress.services.AthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private AthenticationService authenticationService;


    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login");
        mv.addObject(new SignUpDTO());
        return mv;
    }

   @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ModelAndView login(SignUpDTO login, HttpServletRequest httpServletRequest) {

        ModelAndView mv = new ModelAndView();
         if(authenticationService.isAuthetatic(login)){
              Pedido pedido = new Pedido ();
              pedido.setEtapa(1);
              mv.setViewName("/cliente/solicitar_entrega1");
              mv.addObject(pedido);
            return mv;
        }
            mv.setViewName("login");
            mv.addObject("error", "acesso invalido");
            return mv;
        }
}
