package com.project.hareexpress.domain.models.dto;

import lombok.Data;

@Data
public class SignUpDTO {

    private String login;
    private String email;
    private String senha;
    private String confirmarSenha;

}
