package com.fiap.conde.service;



import com.fiap.conde.model.ProcessoJuridico;
import com.fiap.conde.model.Sindico;
import com.fiap.conde.repository.ProcessoJuridicoRepository;
import com.fiap.conde.repository.SindicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SindicoService {
    @Autowired
    private SindicoRepository sindicoRepository;

    @Autowired
    private ProcessoJuridicoRepository processoJuridicoRepository;


    public Sindico saveSindico(Sindico sindico) {
        return sindicoRepository.save(sindico);
    }

    public List<Sindico> findSindico(String cidade, String nome) {
        if (cidade != null) {
            return findSindicosPorCidade(cidade);
        }
        if (nome != null) {
            return findSindicoPorNome(nome);
        }
        return findAllSindicos();
    }
    public List<Sindico> findSindicosPorCidade(String cidade) {
        return sindicoRepository.findByCidade_Nome(cidade);
    }
    public List<Sindico> findSindicoPorNome(String nome){
        return sindicoRepository.findByNomeCompletoContaining(nome);
    }
    public List<Sindico> findAllSindicos() {
        return sindicoRepository.findAll();
    }
    public List<ProcessoJuridico> findAllProcessoPorSindico(Long sindicoId) {
        return processoJuridicoRepository.findBySindico_Id(sindicoId);
    }
}
