package com.fiap.conde.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "historico_educacao")
@Getter
@Setter
public class HistoricoEducacao {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String curso;

    private String instituicao;

    private String duracao;

    @ManyToOne
    @JoinColumn(name="sindico_id")
    @JsonIgnore
    private Sindico sindico;
}
