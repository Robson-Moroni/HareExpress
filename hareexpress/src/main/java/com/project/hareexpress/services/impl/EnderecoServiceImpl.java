package com.project.hareexpress.services.impl;

import com.project.hareexpress.domain.models.Endereco;
import com.project.hareexpress.domain.repositories.EnderecoRepository;
import com.project.hareexpress.services.IEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements IEnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public List<Endereco> listEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco createEndereco(Endereco endereco) {
        if (endereco.getEndereco().equals(""))
            throw new IllegalArgumentException("Endereço inválido");

        if (endereco.getCidade().equals(""))
            throw new IllegalArgumentException("Cidade inválido");

        if (endereco.getCep().equals(""))
            throw new IllegalArgumentException("Cep inválido");

        if (endereco.getComplemento().equals(""))
            throw new IllegalArgumentException("Complemento inválido");

        if (endereco.getEstado().equals(""))
            throw new IllegalArgumentException("Estado inválido");

        if (endereco.getPais().equals(""))
            throw new IllegalArgumentException("País inválido");

        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco updateEndereco(Endereco endereco) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(endereco.getId());

        if (!optionalEndereco.isPresent())
            throw new IllegalArgumentException("Endereço inexistente");

        if (endereco.getCidade().equals(""))
            throw new IllegalArgumentException("Cidade inválido");

        if (endereco.getCep().equals(""))
            throw new IllegalArgumentException("Cep inválido");

        if (endereco.getComplemento().equals(""))
            throw new IllegalArgumentException("Complemento inválido");

        if (endereco.getEstado().equals(""))
            throw new IllegalArgumentException("Estado inválido");

        if (endereco.getPais().equals(""))
            throw new IllegalArgumentException("País inválido");

        return enderecoRepository.save(endereco);
    }

    @Override
    public Boolean deleteEndereco(Integer enderecoId) {

        Optional<Endereco> optionalEndereco = enderecoRepository.findById(enderecoId);

        if (!optionalEndereco.isPresent()) {
            throw new IllegalArgumentException("Endereço não encontrado");
        }

        enderecoRepository.delete(optionalEndereco.get());

        return true;
    }

}
