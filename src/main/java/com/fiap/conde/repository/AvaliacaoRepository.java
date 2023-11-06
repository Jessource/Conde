package com.fiap.conde.repository;

import com.fiap.conde.model.Avaliacao;
import com.fiap.conde.model.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findBySindico_Id(Long sindicoId);

}
