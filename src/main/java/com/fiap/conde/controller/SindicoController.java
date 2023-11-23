package com.fiap.conde.controller;

import com.fiap.conde.model.*;
import com.fiap.conde.service.LocalidadeService;
import com.fiap.conde.service.SindicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sindico")
public class SindicoController {
    @Autowired
    private SindicoService sindicoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("criar-avaliacao")
    public ResponseEntity<?> SaveAvalicao(@RequestBody AvaliacaoDTO formularioAvaliacao) {
        Avaliacao avaliacao = sindicoService.saveFormAvaliacao(formularioAvaliacao);
        return ResponseEntity.ok(avaliacao);
    }

    @GetMapping()
    public ResponseEntity<?> findAllSindicos(@RequestParam(required = false) String nome) {
        List<SindicoDTO> sindicos = sindicoService.findSindico(nome).stream().map(sindico -> modelMapper.map(sindico, SindicoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(sindicos);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findSindicoPorId(@PathVariable(name = "id") Long sindicoId) {
        Sindico sindico = sindicoService.findSindicoById(sindicoId);
        return ResponseEntity.ok(sindico);
    }

    @GetMapping("{id}/media-avaliacoes")
    public ResponseEntity<?> mediaAvaliacoesSindico(@PathVariable(name="id") Long sindicoId){
        BigDecimal mediaAvaliacao = sindicoService.mediaAvaliacaoSindico(sindicoId);
        return ResponseEntity.ok(mediaAvaliacao);
    }
}
