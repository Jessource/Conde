package com.fiap.conde.model;

import lombok.Data;

@Data
public class SindicoDTO {
    private Long id;
    private String nomeCompleto;
    private String resumo;
    private Cidade cidade;
    private double classificacao;
}
