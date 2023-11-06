package com.fiap.conde.controller;

import com.fiap.conde.model.Cidade;
import com.fiap.conde.model.Estado;
import com.fiap.conde.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {
    @Autowired
    private LocalidadeService localidadeService;

    @GetMapping("cidades")
    public ResponseEntity<?> findAllCidadesPorUf(@RequestParam String uf) {
        List<Cidade> cidades = localidadeService.findCidadesPorUf(uf);
        return ResponseEntity.ok(cidades);
    }

    @GetMapping("estados")
    public ResponseEntity<?> findAllEstados() {
        List<Estado> estados = localidadeService.findAllEstados();
        return ResponseEntity.ok(estados);
    }
}
