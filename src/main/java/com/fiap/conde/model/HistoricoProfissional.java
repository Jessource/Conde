package com.fiap.conde.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "historico_profissional")
@Getter
@Setter
public class HistoricoProfissional {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String condominio;

    private String duracao;

    @ManyToOne
    @JoinColumn(name="sindico_id")
    @JsonIgnore
    private Sindico sindico;
}
