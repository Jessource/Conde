package com.fiap.conde.repository;

import com.fiap.conde.model.HistoricoEducacao;
import com.fiap.conde.model.HistoricoProfissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoEducacaoRepository extends JpaRepository<HistoricoEducacao, Long> {
    List<HistoricoEducacao> findBySindico_Id(Long sindicoId);

}
