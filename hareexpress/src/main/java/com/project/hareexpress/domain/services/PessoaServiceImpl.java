package com.project.hareexpress.domain.services;

import com.project.hareexpress.domain.interfaces.IPessoaService;
import com.project.hareexpress.domain.models.Pessoa;
import com.project.hareexpress.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


//    public List<Pessoa> getAllPessoa() {
//        List<Pessoa> result = (List<Pessoa>) pessoaRepository.findAll();
//
//        if(result.size() > 0) {
//            return result;
//        } else {
//            return new ArrayList<Pessoa>();
//        }
//    }
//
//    public Pessoa getPessoaById(Integer id) throws IllegalArgumentException{
//        Optional<Pessoa> employee = pessoaRepository.findById(id);
//
//        if(employee.isPresent()) {
//            return employee.get();
//        } else {
//            throw new IllegalArgumentException("Nenhuma pessoa encontrada com esse id");
//        }
//    }
//
//    public void deletePessoaById(Integer id) throws IllegalArgumentException{
//        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
//
//        if(pessoa.isPresent())
//        {
//            pessoaRepository.deleteById(id);
//        } else {
//            throw new IllegalArgumentException("Nenhuma pessoa encontrada com esse id");
//        }
//    }
//
//    public Pessoa createOrUpdatePessoa(Pessoa pessoa) {
//
//        if(pessoa.getId()  == null)
//        {
//            pessoa = pessoaRepository.save(pessoa);
//
//            return pessoa;
//        }
//        else
//        {
//            Optional<Pessoa> pessoas = pessoaRepository.findById(pessoa.getId());
//
//            if(pessoas.isPresent())
//            {
//                Pessoa newPessoa = pessoa.get();
//                newPessoa.setNome(pessoa.getNome());
//                newPessoa.setTelefone(pessoa.getTelefone());
//
//
//                newPessoa = pessoaRepository.save(newPessoa);
//
//                return newPessoa;
//            } else {
//                pessoa = pessoaRepository.save(pessoa);
//
//                return pessoa;
//            }
//        }
//    }


}
