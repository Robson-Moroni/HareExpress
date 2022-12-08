package com.project.hareexpress.domain.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "pedido", schema = "hareexpress")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "endereco_entrega")
    private String entrega;

    @NotNull
    @Column(name = "endereco_retirada")
    private String retirada;

    @NotNull
    @Column(name = "id_solicitante")
    private String solicitante;

    @Column(name = "id_entregador")
    private String entregador;

    @NotNull
    @Column(name = "ds_pedido")
    private String pedido;

    @Transient
    private String complementoEntrega;

    @Transient
    private String complementoRetirada;

    @Transient
    private Integer etapa;




}
