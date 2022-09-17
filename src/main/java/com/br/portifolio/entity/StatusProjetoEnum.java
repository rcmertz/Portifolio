package com.br.portifolio.entity;

public enum StatusProjetoEnum {

    em_analise("Em analise"),
    analise_realizada("Analise realizada"),
    analise_aprovada("Analise aprovada"),
    planejado("Planejado"),
    em_andamento("Em andamento"),
    encerrado("Encerrado"),
    cancelado("Cancelado");

    public final String valor;
        private StatusProjetoEnum(String valor){
            this.valor = valor;
        }
    }
