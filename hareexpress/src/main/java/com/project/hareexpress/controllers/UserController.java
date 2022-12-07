package com.project.hareexpress.controllers;

import com.project.hareexpress.domain.repositories.UserRepository;
import com.project.hareexpress.services.IUserService;
import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.domain.models.dto.SignUpDTO;
import com.project.hareexpress.utils.Cryptography;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository userRepository;

    private static final String URL_CADASTRO_USUARIO= "/cadastro_usuario/";
    private static final String URL_LOGIN= "/login/";

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView mv = new ModelAndView(URL_CADASTRO_USUARIO + "cadastro_usuario");
        mv.addObject(new User());
        return mv;
    }

    @RequestMapping(value = "/saveUser", method= RequestMethod.POST)
    public String save(@Valid User user) {

        if(Objects.nonNull(user)){

            String passwordCryptography = Cryptography.encoderPassword(user.getPassword());

            user.setSenha(passwordCryptography);

            userRepository.save(user);
        }

        return "login";
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
