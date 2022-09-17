package com.br.portifolio.entity;

public enum ClassificacaoProjetoEnum {

    baixo_risco("Baixo risco"),
    medio_risco("Medio risco"),
    aalto_risco("Alto risco");

    public final String valor;
    private ClassificacaoProjetoEnum(String valor){
        this.valor = valor;
    }
}
