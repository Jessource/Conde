package com.fiap.conde.service;



import com.fiap.conde.model.Sindico;
import com.fiap.conde.repository.SindicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SindicoService {
    @Autowired
    private SindicoRepository sindicoRepository;


    public Sindico saveSindico(Sindico sindico) {
        return sindicoRepository.save(sindico);
    }
    public List<Sindico> findSindicosPorCidade(String cidade) {
        return sindicoRepository.findByCidade_Nome(cidade);
    }

    public List<Sindico> findSindicoPorNome(String nome){
        return sindicoRepository.findByNomeCompleto(nome);
    }

    public List<Sindico> findAllSindicos() {
        return sindicoRepository.findAll();
    }
}
