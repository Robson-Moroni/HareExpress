package com.project.hareexpress.domain.models.dto;

import com.project.hareexpress.domain.models.Role;
import com.project.hareexpress.domain.models.User;
import lombok.Data;

import java.util.List;

@Data
public class MeDTO {

    public MeDTO() {

    }

    public MeDTO(User user) {
        id = user.getId();
        login = user.getLogin();
        email= user.getEmail();
        roles = user.getRoles();
    }

    private Integer id;
    private String login;
    private String nome;
    private String email;
    private List<Role> roles;

}