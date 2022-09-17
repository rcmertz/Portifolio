package com.br.portifolio.entity;

import com.br.portifolio.service.PessoaService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PessoaTest {

    @Test
    public void PessoaNomeTest() {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome("");

        assertEquals("ricardo", pessoa.getNome());
        assertTrue(pessoa.toString().contains(("Pessoa{")));

    }

    @Test
    public void isNomeNotNull() {
        Pessoa pessoa = new Pessoa();
        PessoaService pessoaService = new PessoaService();

        pessoa.setNome("");
        assertTrue(pessoaService.isNomeNotNull(pessoa));
    }

}
