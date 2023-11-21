package com.fiap.conde.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoDTO {
    private String titulo;
    private String comentario;
    private double classificacao;
    private Long sindico_id;

    public Long getSindico_id() {
        return sindico_id;
    }
    public void setSindico_id(Long sindico_id) {
        this.sindico_id = sindico_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }
}
