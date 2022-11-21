package com.project.hareexpress.services;

import com.project.hareexpress.domain.models.Pessoa;
import com.project.hareexpress.domain.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements IPessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> listPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa createPessoa(Pessoa pessoa) {
        if (pessoa.getNome().equals(""))
            throw new IllegalArgumentException("Nome de pessoa inválido");

        if (pessoa.getTelefone().equals(""))
            throw new IllegalArgumentException("Telefone de pessoa inválido");

        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa updatePessoa(Pessoa pessoa) {

        if (pessoa.getNome().equals(""))
            throw new IllegalArgumentException("Nome de pessoa inválido");

        if (pessoa.getTelefone().equals(""))
            throw new IllegalArgumentException("Telefone de pessoa inválido");

        return pessoaRepository.save(pessoa);
    }

    @Override
    public Boolean deletePessoas(Integer pessoaId) {
        Optional<Pessoa> deletePessoa = pessoaRepository.findById(pessoaId);

        if (!deletePessoa.isPresent()) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }

        pessoaRepository.delete(deletePessoa.get());

        return true;
    }

}
