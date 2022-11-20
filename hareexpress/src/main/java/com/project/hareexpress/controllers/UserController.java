package com.project.hareexpress.controllers;

import com.project.hareexpress.services.IUserService;
import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.domain.models.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/list-users")
    public ModelAndView listUsers(ModelAndView model) {
        List<User> list = userService.listUsers();
        model.setViewName("users");
        model.addObject("users", list);
        return model;
    }

    @GetMapping("/get-current-user")
    public ModelAndView getCurrentUser(ModelAndView model) {
        User users = userService.getCurrentUser();
        model.setViewName("user");
        model.addObject("users", users);
        return model;
    }

    @PostMapping("/sign-up")
    public ModelAndView signUp(ModelAndView model, @RequestBody SignUpDTO signUpDTO) {
        User users = userService.signUp(signUpDTO);
        model.setViewName("user");
        model.addObject("users", users);
        return model;
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
