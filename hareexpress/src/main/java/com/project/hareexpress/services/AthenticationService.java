package com.project.hareexpress.services;


import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.domain.models.dto.SignUpDTO;
import com.project.hareexpress.domain.repositories.UserRepository;
import com.project.hareexpress.utils.Cryptography;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AthenticationService {

    @Autowired
    private UserRepository userRepository;

    public boolean isAuthetatic(SignUpDTO login){
       User user = userRepository.findFirstByEmail(login.getEmail());
       return Cryptography.matcherPassword(login.getSenha(), user.getSenha());
    }

}
