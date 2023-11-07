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

    public List <HistoricoEducacao> findAllHistoricoEducacaoPorSindico(Long sindicoId){
        return historicoEducacaoRepository.findBySindico_Id(sindicoId);
    }

    public List <HistoricoProfissional> findAllHistoricoProfissionalPorSindico(Long sindicoId){
        return historicoProfissionalRepository.findBySindico_Id(sindicoId);
    }
    public List <Avaliacao> findAllAvaliacaoPorSindico(Long sindicoId){
        return avaliacaoRepository.findBySindico_Id(sindicoId);

    }
   public List<Avaliacao> findAll(){
        return  avaliacaoRepository.findAll();
   }

    public Contatos findByContatosPorSindico(Long sindicId){
        Optional<Contatos> contatos = contatosRepository.findBySindico_Id(sindicId);
        return contatos.orElse(null);
    }

    public BigDecimal mediaAvaliacaoSindico(Long sindicoId) {
        return avaliacaoRepository.mediaAvaliacaoSindico(sindicoId);
    }
    public Avaliacao saveFormAvaliacao(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }


}
