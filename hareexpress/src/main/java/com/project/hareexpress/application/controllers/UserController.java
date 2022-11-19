package com.project.hareexpress.application.controllers;

import com.project.hareexpress.domain.interfaces.IPessoaService;
import com.project.hareexpress.domain.interfaces.IUserService;
import com.project.hareexpress.domain.models.Pessoa;
import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.domain.models.dto.SignUpDTO;
import com.project.hareexpress.repositories.PessoaRepository;
import com.project.hareexpress.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private IUserService userService;

    @GetMapping("/list-users")
    public ModelAndView listUsers(ModelAndView model) {
        List<User> list = userService.listUsers();
        model.setViewName("users");
        model.addObject("users", list);
        return model;
    }




    // Adiciona novo usuário
    @RequestMapping(method = RequestMethod.POST, value = "/salvar")
    public String salvar(Pessoa pessoa, User user) {

        pessoaRepository.save(pessoa);
        userRepository.save(user);

        return "index";
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
