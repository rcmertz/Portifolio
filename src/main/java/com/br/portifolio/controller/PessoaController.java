package com.br.portifolio.controller;
import com.br.portifolio.entity.Pessoa;
import com.br.portifolio.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.awt.print.Pageable;

    @Controller
    @CrossOrigin
    @RequestMapping("/api/pessoa")
    public class PessoaController {

        @Autowired
        PessoaService pessoaService;
        @GetMapping("/{idPessoa}")
        public ResponseEntity<Pessoa> findById(@PathVariable("idPessoa") Long idPessoa) {
            return ResponseEntity.ok().body(this.pessoaService.findById(idPessoa));
        }

        @GetMapping
        public ResponseEntity<Page<Pessoa>> listByAllPage(Pageable pageable) {
            return ResponseEntity.ok().body(this.pessoaService.listAll(pageable));
        }

        @PostMapping
        public ResponseEntity<?> insert(@RequestBody Pessoa pessoa) {
            try {
                this.pessoaService.insert(pessoa);
                return ResponseEntity.ok().body("sucesso.");
            }catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PutMapping("/{idPessoa}")
        public ResponseEntity<?> update(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa) {
            try {
                this.pessoaService.update(idPessoa, pessoa);
                return ResponseEntity.ok().body("sucesso.");
            }catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
}
