package com.project.hareexpress.domain.interfaces;

import com.project.hareexpress.domain.models.Pessoa;
import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.domain.models.dto.SignUpDTO;

import java.util.List;

public interface IUserService {

    List<User> listUsers();
    User updateUser(User user);
    Boolean deleteUser(Integer userId);
    User getCurrentUser();
    User signUp(SignUpDTO signUpDTO);

}
