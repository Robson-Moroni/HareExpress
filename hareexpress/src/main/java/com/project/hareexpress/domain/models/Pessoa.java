package com.project.hareexpress.domain.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String telefone;

    public Pessoa get() {
        return null;
    }


//    @OneToOne
//    @JoinColumn(name = "endereco_id")
//    private Endereco endereco;

}
