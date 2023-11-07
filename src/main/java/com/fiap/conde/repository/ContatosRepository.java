package com.fiap.conde.repository;

import com.fiap.conde.model.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatosRepository extends JpaRepository<Contatos, Long> {
    Optional<Contatos> findBySindico_Id(Long sindicoId);
}
