package com.project.hareexpress.domain.interfaces;

import com.project.hareexpress.domain.models.Endereco;
import com.project.hareexpress.domain.models.Pessoa;

import java.util.List;

public interface IEnderecoService {

    List<Endereco> listEnderecos();
    Endereco createEndereco(Endereco endereco);
    Endereco updateEndereco(Endereco endereco);
    Boolean deleteEndereco(Integer enderecoId);

}
