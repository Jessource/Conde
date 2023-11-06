package com.fiap.conde.repository;


import com.fiap.conde.model.ProcessoJuridico;
import com.fiap.conde.model.Sindico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProcessoJuridicoRepository extends JpaRepository<ProcessoJuridico, Long> {
    List<ProcessoJuridico> findBySindico_Id(Long sindicoId);
}
