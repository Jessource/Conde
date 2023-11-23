package com.fiap.conde.service;



import com.fiap.conde.model.*;
import com.fiap.conde.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SindicoService {
    @Autowired
    private SindicoRepository sindicoRepository;

    @Autowired
    private ProcessoJuridicoRepository processoJuridicoRepository;

    @Autowired
    private HistoricoProfissionalRepository historicoProfissionalRepository;

    @Autowired
    private HistoricoEducacaoRepository historicoEducacaoRepository;

    @Autowired
    private ContatosRepository contatosRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Sindico saveSindico(Sindico sindico) {
        return sindicoRepository.save(sindico);
    }

    public List<Sindico> findSindico(String nome) {
        if (nome != null) {
            return sindicoRepository.findByNomeCompletoIgnoreCaseContainingOrCidade_NomeIgnoreCaseContaining(nome, nome);
        }
        return findAllSindicos();
    }

    public Sindico findSindicoById(Long id) {
        return sindicoRepository.findById(id).orElse(null);
    }

    public List<Sindico> findAllSindicos() {
        return sindicoRepository.findAll();
    }

    public BigDecimal mediaAvaliacaoSindico(Long sindicoId) {
        return avaliacaoRepository.mediaAvaliacaoSindico(sindicoId);
    }

    public Avaliacao saveFormAvaliacao(AvaliacaoDTO avaliacao){
        Optional<Sindico> sindico = sindicoRepository.findById(avaliacao.getSindico_id());
        if (sindico.isPresent()) {
            Avaliacao av = new Avaliacao();
            av.setSindico(sindico.get());
            av.setClassificacao(avaliacao.getClassificacao());
            av.setTitulo(avaliacao.getTitulo());
            av.setComentario(avaliacao.getComentario());
            return avaliacaoRepository.save(av);
        }
        return null;
//        return avaliacaoRepository.save(avaliacao);
    }
}
