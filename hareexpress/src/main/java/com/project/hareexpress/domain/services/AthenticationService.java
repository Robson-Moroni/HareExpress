package com.project.hareexpress.domain.services;

import com.project.hareexpress.application.form.LoginForm;
import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.repositories.UserRepository;
import com.project.hareexpress.utils.Cryptography;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AthenticationService {

    @Autowired
    private UserRepository userRepository;


    public boolean isAuthetatic(LoginForm login){
       User user = userRepository.findFirstByEmail(login.getUsername());
       return Cryptography.matcherPassword(login.getSenha(), user.getSenha());
    }

}
