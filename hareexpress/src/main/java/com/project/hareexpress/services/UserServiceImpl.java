package com.project.hareexpress.services;

import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.domain.models.dto.SignUpDTO;
import com.project.hareexpress.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Role;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        Optional<User> optionalUser = userRepository.findById(currentUser.getId());

        if (!optionalUser.isPresent())
            throw new IllegalArgumentException("Usuário inexistente");

        return optionalUser.get();
    }

    @Override
    public User signUp(SignUpDTO signUpDTO) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (signUpDTO.getLogin().length()<5)
            throw new IllegalArgumentException("Login deve ter no mínimo 5 caracteres");

        if (userRepository.findFirstByLogin(signUpDTO.getLogin()) != null)
            throw new IllegalArgumentException("Login já em uso");

        if (!(signUpDTO.getEmail().contains("@") && signUpDTO.getEmail().contains(".")))
            throw new IllegalArgumentException("Email inválido");

        if (userRepository.findFirstByEmail(signUpDTO.getEmail()) != null)
            throw new IllegalArgumentException("Email já em uso");

        if (signUpDTO.getSenha().equals(""))
            throw new IllegalArgumentException("Senha inválida");

        if (signUpDTO.getConfirmarSenha().equals(""))
            throw new IllegalArgumentException("Confirmação de senha inválida");

        if (!signUpDTO.getSenha().equals(signUpDTO.getConfirmarSenha()) ) {
            throw new IllegalArgumentException("As senhas não coicidem");
        }

        User user = new User();
        user.setLogin(signUpDTO.getLogin());
        user.setEmail(signUpDTO.getEmail());
        user.setSenha(bCryptPasswordEncoder.encode(signUpDTO.getSenha()));
        user.setConfirmarSenha(bCryptPasswordEncoder.encode(signUpDTO.getConfirmarSenha()));

        User newUser = userRepository.save(user);

        return newUser;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    //    @Secured("ROLE_ADMIN")
    @Override
    public User updateUser(User user) {

        Optional<User> optionalUser = userRepository.findById(user.getId());

        if (!optionalUser.isPresent())
            throw new IllegalArgumentException("Usuário não encontrado");

        if (user.getLogin().equals(""))
            throw new IllegalArgumentException("Login inválido");

        if (!(optionalUser.get().getLogin().equals(user.getLogin())) && userRepository.findFirstByLogin(user.getLogin()) != null)
            throw new IllegalArgumentException("Login já existente");

        if (!(user.getEmail().contains("@") && user.getEmail().contains(".")))
            throw new IllegalArgumentException("Email inválido");

        if (!(optionalUser.get().getEmail().equals(user.getEmail())) && userRepository.findFirstByEmail(user.getEmail()) != null)
            throw new IllegalArgumentException("Email já existente");

        optionalUser.get().setLogin(user.getLogin());
        optionalUser.get().setEmail(user.getEmail());

        User updateUser = userRepository.save(optionalUser.get());

        return updateUser;
    }

    @Override
    public Boolean deleteUser(Integer userId) {
        Optional<User> deleteUser = userRepository.findById(userId);

        if (!deleteUser.isPresent()) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        userRepository.delete(deleteUser.get());

        return true;
    }



}
