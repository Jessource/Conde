package com.fiap.conde.controller;

import com.fiap.conde.model.Cidade;
import com.fiap.conde.model.Estado;
import com.fiap.conde.model.ProcessoJuridico;
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
}
