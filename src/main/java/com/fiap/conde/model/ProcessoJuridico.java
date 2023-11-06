package com.fiap.conde.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "processo_juridico")
@Getter
@Setter
public class ProcessoJuridico {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;

    @ManyToOne
    @JoinColumn(name="sindico_id")
    @JsonIgnore
    private Sindico sindico;
}
