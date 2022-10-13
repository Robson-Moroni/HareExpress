package com.project.hareexpress.application.controllers;

import com.project.hareexpress.domain.interfaces.IPessoaService;
import com.project.hareexpress.domain.interfaces.IUserService;
import com.project.hareexpress.domain.models.Pessoa;
import com.project.hareexpress.domain.models.User;
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

    @GetMapping("/list-users")
    public ModelAndView listUsers(ModelAndView model) {
        List<User> list = userService.listUsers();
        model.setViewName("users");
        model.addObject("users", list);
        return model;
    }

    @PostMapping("/ceate-user")
    public ModelAndView createUser(ModelAndView model, @RequestBody User user) {
        User users = userService.createUser(user);
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
