package com.fiap.conde.repository;

import com.fiap.conde.model.Avaliacao;
import com.fiap.conde.model.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findBySindico_Id(Long sindicoId);

    @Query(value = "SELECT " +
            "AVG(a.classificacao) as media " +
            "FROM avaliacao a " +
            "WHERE a.sindico_id=?1 " +
            "GROUP BY a.sindico_id", nativeQuery = true)
    BigDecimal mediaAvaliacaoSindico(Long sindicoId);

}
