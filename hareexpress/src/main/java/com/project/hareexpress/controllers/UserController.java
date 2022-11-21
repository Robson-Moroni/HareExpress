package com.project.hareexpress.controllers;

import com.project.hareexpress.services.IUserService;
import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.domain.models.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    private static final String URL_CADASTRO_USUARIO= "/cadastro_usuario/";

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView mv = new ModelAndView(URL_CADASTRO_USUARIO + "cadastro_usuario");
        mv.addObject(new User());
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid User user) {
     ModelAndView mv = new ModelAndView();
     userService.save(user);
     return mv;
    }



    @PostMapping("/update-user")
    public ModelAndView updateUser(ModelAndView model, @RequestBody User user) {
        User users = userService.updateUser(user);
        model.setViewName("user");
        model.addObject("users", users);
        return model;
    }

    @DeleteMapping("/delete-user")
    public ModelAndView deleteUser(ModelAndView model, @RequestParam("id") Integer userId) {
        Boolean users = userService.deleteUser(userId);
        model.setViewName("user");
        model.addObject("users", users);
        return model;
    }
}
