package com.br.portifolio.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PessoaTest {

    @Test
    public void PessoaNomeTest() {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome("ricardo");

        assertEquals("ricardo", pessoa.getNome());
        assertTrue(pessoa.toString().contains(("Pessoa{")));

    }

}
