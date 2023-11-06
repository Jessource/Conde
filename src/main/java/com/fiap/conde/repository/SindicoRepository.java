package com.fiap.conde.repository;

import com.fiap.conde.model.Sindico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SindicoRepository extends JpaRepository<Sindico, Long> {
    List<Sindico> findByCidade_Nome(String cidade);
    List<Sindico> findByNomeCompleto(String nome);
    List<Sindico> findByNomeCompletoAndCidade_Nome(String nome, String cidade);

}
