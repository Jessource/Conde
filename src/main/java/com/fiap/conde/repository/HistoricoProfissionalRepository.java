package com.fiap.conde.repository;

import com.fiap.conde.model.HistoricoProfissional;

import com.fiap.conde.model.ProcessoJuridico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoProfissionalRepository extends JpaRepository<HistoricoProfissional, Long> {
    List<HistoricoProfissional> findBySindico_Id(Long sindicoId);
}
