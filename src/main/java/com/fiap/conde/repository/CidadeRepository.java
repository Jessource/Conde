package com.fiap.conde.repository;

import com.fiap.conde.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findByUf_Uf(String uf);
}
