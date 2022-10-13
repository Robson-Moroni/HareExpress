package com.project.hareexpress.domain.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String endereco;
    private String numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;


}
