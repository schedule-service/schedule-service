package com.gw.jb.scheduleservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class EntidadeGenerica {

    /**
     * Identificador do objeto
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * Flag para deletar objeto
     */
    @Column(name = "deletado")
    private boolean deletado;

    /**
     * Data de criação do objeto
     */
    @Column(name = "data_criacao")
    private Date dataCriacao;

    /**
     * Data de atualização objeto
     */
    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;

    /**
     * Método para inserir data de cadastrado
     */
    @PrePersist
    public void prePersist() {
        this.dataCriacao = new Date();
    }

    /**
     * Método para fazer update data atualização
     */
    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = new Date();
    }

}
