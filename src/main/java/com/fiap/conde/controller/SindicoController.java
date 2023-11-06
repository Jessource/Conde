package com.fiap.conde.controller;

import com.fiap.conde.model.Cidade;
import com.fiap.conde.model.Estado;
import com.fiap.conde.model.Sindico;
import com.fiap.conde.service.LocalidadeService;
import com.fiap.conde.service.SindicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("todos")
    public ResponseEntity<?> findAllSindicos() {
        List<Sindico> sindicos = sindicoService.findAllSindicos();
        return ResponseEntity.ok(sindicos);
    }

    @GetMapping("todos-por-cidade")
    public ResponseEntity<?> findAllSindicosPorCidade(@RequestParam String cidade) {
        List<Sindico> sindicos = sindicoService.findSindicosPorCidade(cidade);
        return ResponseEntity.ok(sindicos);
    }

    @GetMapping("buscar")
    public ResponseEntity<?> buscarPorNome(@RequestParam String nome){
        List<Sindico> sindicos = sindicoService.findSindicoPorNome(nome);
        return ResponseEntity.ok(sindicos);
    }


}
