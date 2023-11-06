package com.fiap.conde.repository;

import com.fiap.conde.model.Contatos;
import com.fiap.conde.model.HistoricoEducacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatosRepository  extends JpaRepository<Contatos, Long> {
    List<Contatos> findBySindico_Id(Long sindicoId);
}
