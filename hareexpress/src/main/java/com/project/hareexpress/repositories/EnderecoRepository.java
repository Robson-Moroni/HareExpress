package com.project.hareexpress.repositories;

import com.project.hareexpress.domain.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
