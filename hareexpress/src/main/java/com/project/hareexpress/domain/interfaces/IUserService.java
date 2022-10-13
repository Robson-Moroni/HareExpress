package com.project.hareexpress.domain.interfaces;

import com.project.hareexpress.domain.models.Pessoa;
import com.project.hareexpress.domain.models.User;

import java.util.List;

public interface IUserService {

    List<User> listUsers();
//    User createUser(User user);
    User updateUser(User user);
    Boolean deleteUser(Integer userId);

}
