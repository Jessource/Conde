package com.fiap.conde.service;

import com.fiap.conde.model.Cidade;
import com.fiap.conde.model.Estado;
import com.fiap.conde.repository.CidadeRepository;
import com.fiap.conde.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;


    public List<Cidade> findCidadesPorUf(String uf) {
        return cidadeRepository.findByUf_Uf(uf);
    }

    public List<Estado> findAllEstados() {
        return estadoRepository.findAll();
    }
}
