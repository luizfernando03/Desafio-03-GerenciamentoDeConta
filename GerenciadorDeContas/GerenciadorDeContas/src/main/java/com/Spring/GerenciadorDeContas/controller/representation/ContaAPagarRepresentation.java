package com.Spring.GerenciadorDeContas.controller.representation;

import com.Spring.GerenciadorDeContas.model.Status;
import com.Spring.GerenciadorDeContas.model.Tipo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ContaAPagarRepresentation {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long Id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Status status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Tipo tipo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate dataDeVencimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dataDePagamento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double Valor;

}
