package com.fiap.conde.controller;

import com.fiap.conde.model.*;
import com.fiap.conde.service.LocalidadeService;
import com.fiap.conde.service.SindicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sindico")
public class SindicoController {
    @Autowired
    private SindicoService sindicoService;

    @PostMapping("criar")
    public ResponseEntity<?> SaveSindico(@RequestBody Sindico formularioSindico) {
        Sindico sindico = sindicoService.saveSindico(formularioSindico);
        return ResponseEntity.ok(sindico);
    }

    @PostMapping("criar-avaliacao")
    public ResponseEntity<?> SaveAvalicao(@RequestBody Avaliacao formularioAvaliacao) {
        Avaliacao avaliacao = sindicoService.saveFormAvaliacao(formularioAvaliacao);
        return ResponseEntity.ok(avaliacao);
    }

    @GetMapping()
    public ResponseEntity<?> findAllSindicos(@RequestParam(required = false) String nome,
                                             @RequestParam(required = false) String cidade) {
        List<Sindico> sindicos = sindicoService.findSindico(cidade, nome);
        return ResponseEntity.ok(sindicos);
    }

    @GetMapping("{id}/processos-juridicos")
    public ResponseEntity<?> buscarProcessosJuridicosSindico(@PathVariable(name = "id") Long sindicoId){
        List<ProcessoJuridico> processoJuridicos = sindicoService.findAllProcessoPorSindico(sindicoId);
        return ResponseEntity.ok(processoJuridicos);
    }
    @GetMapping("{id}/contatos")
    public ResponseEntity<?> buscarContatosSindico(@PathVariable(name = "id") Long sindicoId){
        Contatos contatos = sindicoService.findByContatosPorSindico(sindicoId);
        return ResponseEntity.ok(contatos);

    }


    @GetMapping("{id}/historico-profissional")
    public ResponseEntity<?> buscarHistoricoProfissionalSindico(@PathVariable(name="id") Long sindicoId){
        List <HistoricoProfissional> historicoProfissional = sindicoService.findAllHistoricoProfissionalPorSindico(sindicoId);
        return ResponseEntity.ok(historicoProfissional);
    }
    @GetMapping("{id}/historico-educacao")
    public ResponseEntity<?> buscarHistoricoEducacaoSindico(@PathVariable(name="id") Long sindicoId){
        List <HistoricoEducacao> historicoEducacao = sindicoService.findAllHistoricoEducacaoPorSindico(sindicoId);
        return ResponseEntity.ok(historicoEducacao);
    }
    @GetMapping("todas-avaliacoes")
    public List<Avaliacao> getAllAvaliacoes(){
        return sindicoService.findAll();
    }

    @GetMapping("{id}/avaliacoes")
    public ResponseEntity<?> buscarAvaliacaoSindico(@PathVariable(name="id") Long sindicoId){
        List <Avaliacao> avaliacao = sindicoService.findAllAvaliacaoPorSindico(sindicoId);
        return ResponseEntity.ok(avaliacao);
    }

    @GetMapping("{id}/media-avaliacoes")
    public ResponseEntity<?> mediaAvaliacoesSindico(@PathVariable(name="id") Long sindicoId){
        BigDecimal mediaAvaliacao = sindicoService.mediaAvaliacaoSindico(sindicoId);
        return ResponseEntity.ok(mediaAvaliacao);
    }
}
